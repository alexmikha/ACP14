CREATE DATABASE faculty;

CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(25) NOT NULL,
  `group_id` int,
  FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
);

CREATE TABLE `study` (
  `group_id` int(11),
  `subject_id` int(11),
  FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `descr` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `exper` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subject_id` (`subject_id`),
  FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO students(name,group_id) VALUES ('Ivanov', 1);
INSERT INTO students(name,group_id) VALUES ('Petrov', 2);
INSERT INTO students(name,group_id) VALUES ('Cidorov', 3);

INSERT INTO groups(name) VALUES ('first');
INSERT INTO groups(name) VALUES ('second');
INSERT INTO groups(name) VALUES ('third');

INSERT INTO teachers(name, exper, subject_id) VALUES ('Ivanenko', 5, 1);
INSERT INTO teachers(name, exper, subject_id ) VALUES ('Petrenko', 10, 2);
INSERT INTO teachers(name, exper, subject_id ) VALUES ('Cidorenko', 15, 3);

INSERT INTO subjects(name,descr) VALUES ('mathematics', 'study mathematics');
INSERT INTO subjects(name,descr) VALUES ('programming', 'study java');
INSERT INTO subjects(name,descr) VALUES ('economy', 'study economy');
INSERT INTO subjects(name,descr) VALUES ('physics', 'study physics');
INSERT INTO subjects(name,descr) VALUES ('philosophy', 'study philosophy');