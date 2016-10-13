CREATE DATABASE faculty;

CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(255) NOT NULL,
  `avg_score` double DEFAULT NULL,
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

INSERT INTO students(name,group_id) VALUES ('Ivanov',1);
INSERT INTO students(name,group_id) VALUES ('Petrov',2);
INSERT INTO students(name,group_id) VALUES ('Cidorov',3);

INSERT INTO groups(name) VALUES ('first');
INSERT INTO groups(name) VALUES ('second');
INSERT INTO groups(name) VALUES ('third');

INSERT INTO teachers(name, experience, subject_id) VALUES ('Ivanenko', 5, 1);
INSERT INTO teachers(name, experience, subject_id ) VALUES ('Petrenko', 10, 2);
INSERT INTO teachers(name, experience, subject_id ) VALUES ('Cidorenko', 15, 3);

INSERT INTO subjects(name,description) VALUES ('mathematics', 'study mathematics');
INSERT INTO subjects(name,description) VALUES ('programming', 'study java');
INSERT INTO subjects(name,description) VALUES ('economy', 'study');