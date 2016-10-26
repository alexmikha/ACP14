CREATE DATABASE faculty_hibernate;

CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(255) NOT NULL,
  `avg` double DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `study` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) NOT NULL,
  PRIMARY KEY (`group_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `study_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `study_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(255) NOT NULL,
  `expiriance` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `teachers_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO students(studentName,group_id) VALUES ('Ivanov',1);
INSERT INTO students(studentName,group_id) VALUES ('Petrov',2);
INSERT INTO students(studentName,group_id) VALUES ('Cidorov',3);

INSERT INTO groups(groupName) VALUES ('first');
INSERT INTO groups(groupName) VALUES ('second');
INSERT INTO groups(groupName) VALUES ('third');

INSERT INTO teachers(teacherName, exper, subject_id) VALUES ('Ivanenko', 5, 1);
INSERT INTO teachers(teacherName, exper, subject_id ) VALUES ('Petrenko', 10, 2);
INSERT INTO teachers(teacherName, exper, subject_id ) VALUES ('Cidorenko', 15, 3);

INSERT INTO subjects(subjectName,descrip) VALUES ('mathematics', 'study mathematics');
INSERT INTO subjects(subjectName,descrip) VALUES ('programming', 'study java');
INSERT INTO subjects(subjectName,descrip) VALUES ('economy', 'study');