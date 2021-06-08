CREATE TABLE if not exists department
(
    dept_id integer NOT NULL PRIMARY KEY,
    dept_name varchar(25) NOT NULL,
    hod varchar(25),
    FOREIGN KEY (Student_id) REFERENCES students(student_id),
    FOREIGN KEY (Teacher_id) REFERENCES Teachers(teacher_id),
    FOREIGN KEY (Asc_id) REFERENCES Dept_Association(asc_id)
);
CREATE TABLE if not exists clubs
(
    club_id integer NOT NULL PRIMARY KEY,
    club_name varchar(25) NOT NULL,
    president varchar(25),
    vice_president varchar(25),
    about varchar(100),
    FOREIGN KEY (Student_id) REFERENCES students(student_id)
    );
CREATE TABLE if not exists dept_association
(
    asc_id integer NOT NULL PRIMARY KEY,
    asc_name varchar(50) NOT NULL,
    president varchar(25),
    vice_president varchar(25),
    Dept_id integer not null,
    FOREIGN KEY (Dept_id) REFERENCES Department(dept_id),
    FOREIGN KEY (Student_id) REFERENCES students(student_id)
    );
CREATE TABLE if not exists students
(
    student_id integer NOT NULL,
    student_name varchar(25),
    batch int,
    sect varchar(20),
    dob date,
    gender varchar(10),
    Dept_id integer not null,
    Club_id integer,
    Asc_id integer,
    CONSTRAINT Students PRIMARY KEY (student_id),
    FOREIGN KEY (Dept_id) REFERENCES department(dept_id),
    FOREIGN KEY (Club_id) REFERENCES department(club_id),
    FOREIGN KEY (Asc_id) REFERENCES department(asc_id)
);
CREATE TABLE IF NOT EXISTS students_details
(
    id integer,
    father_name varchar(20),
    mother_name varchar(20),
    email varchar(25),
    cgpa double,
    contactno varchar(20),
    student_id integer NOT NULL PRIMARY KEY,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
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
