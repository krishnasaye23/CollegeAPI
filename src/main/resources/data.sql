CREATE TABLE if not exists department
(
    dept_id integer NOT NULL PRIMARY KEY,
    dept_name varchar(25) NOT NULL,
    hod varchar(25),
    FOREIGN KEY (Student_id) REFERENCES Students(student_id),
    FOREIGN KEY (Teacher_id) REFERENCES Teachers(teacher_id)
);
CREATE TABLE if not exists clubs
(
    club_id integer NOT NULL PRIMARY KEY,
    club_name varchar(25) NOT NULL,
    president varchar(25),
    vice_president varchar(25),
    about varchar(100),
    FOREIGN KEY (Student_id) REFERENCES Students(student_id)
    );
CREATE TABLE if not exists Students
(
    student_id integer NOT NULL,
    student_name varchar(25),
    batch int,
    sect varchar(20),
    dob date,
    gender varchar(10),
    Dept_id integer not null,
    CONSTRAINT Students PRIMARY KEY (student_id),
    FOREIGN KEY (Dept_id) REFERENCES department(dept_id)
);
CREATE TABLE if not exists Teachers
(
    teacher_id integer NOT NULL,
    teacher_name varchar(25),
    sect varchar(20),
    dob date,
    gender varchar(10),
    Dept_id integer not null,
    CONSTRAINT Teachers PRIMARY KEY (teacher_id),
    FOREIGN KEY (Dept_id) REFERENCES department(dept_id)
);
