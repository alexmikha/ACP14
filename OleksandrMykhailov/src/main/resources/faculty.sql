CREATE DATABASE faculty;

CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(25) NOT NULL,
  `group_id` int,
  FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
);

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `name` varchar(25) NOT NULL,
  `descr` varchar(25)
);

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(25) NOT NULL,
  `exper` int(11) NOT NULL,
  `subject_id` int,
  FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
);

CREATE TABLE `study` (
  `group_id` int,
  `subject_id` int,
  FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
);

CREATE TABLE marks(
  `student_id` int,
  `subject_id` int,
  `mark` int,
  FOREIGN KEY (`student_id`) REFERENCES students(`id`),
  FOREIGN KEY (`subject_id` )REFERENCES subjects(`id`)
);


INSERT INTO groups(name) VALUES ('first');
INSERT INTO groups(name) VALUES ('second');
INSERT INTO groups(name) VALUES ('third');

INSERT INTO students(name,group_id) VALUES ('Ivanov',1);
INSERT INTO students(name,group_id) VALUES ('Petrov',2);
INSERT INTO students(name,group_id) VALUES ('Cidorov',3);

INSERT INTO teachers(name, exper, subject_id) VALUES ('Ivanenko', 5, 1);
INSERT INTO teachers(name, exper, subject_id ) VALUES ('Petrenko', 10, 2);
INSERT INTO teachers(name, exper, subject_id ) VALUES ('Cidorenko', 15, 3);
INSERT INTO teachers(name, exper, subject_id ) VALUES ('Orlenko', 20, 3);
INSERT INTO teachers(name, exper, subject_id ) VALUES ('Philepenko', 20, 2);

INSERT INTO subjects(name,descr) VALUES ('mathematics', 'study mathematics');
INSERT INTO subjects(name,descr) VALUES ('programming', 'study java');
INSERT INTO subjects(name,descr) VALUES ('economy', 'study economy');
INSERT INTO subjects(name,descr) VALUES ('physics', 'study physics');
INSERT INTO subjects(name,descr) VALUES ('philosophy', 'study philosophy');