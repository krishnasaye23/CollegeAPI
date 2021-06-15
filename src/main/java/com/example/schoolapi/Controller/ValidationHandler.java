package com.example.schoolapi.Controller;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {
    private static final Logger local_logger = LoggerFactory.getLogger(ValidationHandler.class);
    public static final String ERROR_MESSAGE_TEMPLATE = "message: %s %n requested uri: %s";

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                      HttpHeaders headers, HttpStatus status, WebRequest request) {

            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) ->{

                String fieldName = ((FieldError) error).getField();
                String message = error.getDefaultMessage();
                errors.put(fieldName, message);
            });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException exception,
            HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        return getExceptionResponseEntity(exception, status, request,
                Collections.singletonList(exception.getLocalizedMessage()));
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException exception, WebRequest request) {
        final List<String> validationErrors = exception.getConstraintViolations().stream().
                map(violation ->
                        violation.getPropertyPath() + " : " + violation.getMessage())
                .collect(Collectors.toList());
        return getExceptionResponseEntity(exception, HttpStatus.BAD_REQUEST, request, validationErrors);
    }
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        ResponseStatus responseStatus =
                exception.getClass().getAnnotation(ResponseStatus.class);
        final HttpStatus status =
                responseStatus!=null ? responseStatus.value():HttpStatus.INTERNAL_SERVER_ERROR;
        final String localizedMessage = exception.getLocalizedMessage();
        final String path = request.getDescription(false);
        String message = (StringUtils.isNotEmpty(localizedMessage) ? localizedMessage:status.getReasonPhrase());
        logger.error(String.format(ERROR_MESSAGE_TEMPLATE, message, path), exception);
        return getExceptionResponseEntity(exception, status, request, Collections.singletonList(message));
    }
    private ResponseEntity<Object> getExceptionResponseEntity(final Exception exception,
                                                              final HttpStatus status,
                                                              final WebRequest request,
                                                              final List<String> errors) {
        final Map<String, Object> body = new LinkedHashMap<>();
        final String path = request.getDescription(false);
        body.put("TIMESTAMP ", Instant.now());
        body.put("STATUS ", status.value());
        body.put("ERRORS ", errors);
        body.put("TYPE ", exception.getClass().getSimpleName());
        body.put("PATH ", path);
        body.put("MESSAGE ", getMessageForStatus(status));
        final String errorsMessage = CollectionUtils.isNotEmpty(errors) ?
                errors.stream().filter(StringUtils::isNotEmpty).collect(Collectors.joining(","))
                : status.getReasonPhrase();
        local_logger.error("errors {} for path {}", errorsMessage, path);
        return new ResponseEntity<>(body, status);
    }
        private String getMessageForStatus(HttpStatus status) {
            switch (status) {
                case UNAUTHORIZED:
                    return "ACCESS_DENIED";
                case BAD_REQUEST:
                    return "INVALID_REQUEST";
                default:
                    return status.getReasonPhrase();
            }
        }
    }
