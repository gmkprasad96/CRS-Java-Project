/*
MySQL Data Transfer
Source Host: localhost
Source Database: crsdb
Target Host: localhost
Target Database: crsdb
Date: 11/23/2021 10:33:00 AM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(32) NOT NULL auto_increment,
  `course_code` varchar(255) NOT NULL,
  `course_name` varchar(255) NOT NULL,
  `course_isoffered` char(12) NOT NULL,
  `course_instructor` varchar(255) NOT NULL,
  `course_semester` int(32) NOT NULL,
  PRIMARY KEY  (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for gradecard
-- ----------------------------
DROP TABLE IF EXISTS `gradecard`;
CREATE TABLE `gradecard` (
  `gradecard_id` int(32) NOT NULL auto_increment,
  `gradecard_semester` int(32) NOT NULL,
  `gradecard_cpi` double(32,0) NOT NULL,
  `gradecard_student_id` int(32) NOT NULL,
  PRIMARY KEY  (`gradecard_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `notification_id` int(32) NOT NULL auto_increment,
  `student_id` int(32) NOT NULL,
  `payment_mode` varchar(255) NOT NULL,
  `amount` double(32,0) NOT NULL,
  PRIMARY KEY  (`notification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `payment_id` int(32) NOT NULL auto_increment,
  `payment_mode` varchar(255) NOT NULL,
  `payment_amount` double(32,0) NOT NULL,
  `payment_student_id` int(32) NOT NULL,
  PRIMARY KEY  (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for professor
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `professor_id` int(32) NOT NULL auto_increment,
  `professor_department` varchar(255) NOT NULL,
  `professor_designation` varchar(255) NOT NULL,
  `professor_doj` date NOT NULL,
  PRIMARY KEY  (`professor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(32) NOT NULL auto_increment,
  `role_name` varchar(255) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(32) NOT NULL auto_increment,
  `student_branch` varchar(255) NOT NULL,
  `student_batch` int(32) NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `student_approval_status` varchar(255) NOT NULL,
  PRIMARY KEY  (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for studentcoursemapping
-- ----------------------------
DROP TABLE IF EXISTS `studentcoursemapping`;
CREATE TABLE `studentcoursemapping` (
  `student_id` int(32) NOT NULL,
  `course_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `login_username` varchar(255) NOT NULL,
  `login_password` varchar(255) NOT NULL,
  `login_role_id` int(32) NOT NULL,
  `login_id` int(32) NOT NULL auto_increment,
  PRIMARY KEY  (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'c1', 'java', 'Y', 'Amit', '1');
INSERT INTO `course` VALUES ('2', 'c2', 'java', 'N', 'Pooja', '2');
INSERT INTO `course` VALUES ('3', 'c3', 'python', 'N', 'bobby', '3');
INSERT INTO `course` VALUES ('4', 'c4', 'azure', 'N', 'Prasad', '3');
INSERT INTO `course` VALUES ('5', 'c5', 'html', 'N', 'gmk', '4');
INSERT INTO `course` VALUES ('8', 'c6', 'MySQL', 'N', 'krishna', '2');
INSERT INTO `gradecard` VALUES ('1', '3', '7', '1');
INSERT INTO `notification` VALUES ('1', '37', 'debitcard', '500');
INSERT INTO `notification` VALUES ('2', '1', 'debit card', '500');
INSERT INTO `notification` VALUES ('3', '1', 'debit card', '500');
INSERT INTO `payment` VALUES ('1', 'debitcard', '500', '37');
INSERT INTO `payment` VALUES ('2', 'debitcard', '500', '37');
INSERT INTO `payment` VALUES ('3', 'debitcard', '500', '37');
INSERT INTO `payment` VALUES ('4', 'debit card', '500', '1');
INSERT INTO `payment` VALUES ('5', 'debit card', '500', '1');
INSERT INTO `professor` VALUES ('1', 'cse', 'na', '2021-11-01');
INSERT INTO `professor` VALUES ('2', 'cse', 'na', '2021-11-23');
INSERT INTO `role` VALUES ('1', 'Admin');
INSERT INTO `role` VALUES ('2', 'Student');
INSERT INTO `role` VALUES ('3', 'Professor');
INSERT INTO `student` VALUES ('1', 'computer', '1', 'Mariam', 'Y');
INSERT INTO `student` VALUES ('2', 'Electronics', '1', 'Alice', 'Pending');
INSERT INTO `student` VALUES ('3', 'Computer', '2', 'Bobby', 'Pending');
INSERT INTO `student` VALUES ('4', 'EXTC', '2', 'Seeta', 'Pending');
INSERT INTO `studentcoursemapping` VALUES ('1', 'c1');
INSERT INTO `user` VALUES ('admin', 'admin', '1', '1');
INSERT INTO `user` VALUES ('professor', 'professor', '3', '2');
INSERT INTO `user` VALUES ('student', 'student', '2', '3');
INSERT INTO `user` VALUES ('prasad', '1234', '2', '4');
INSERT INTO `user` VALUES ('bobby', '1234', '2', '5');
INSERT INTO `user` VALUES ('krishna', '1234', '2', '6');
INSERT INTO `user` VALUES ('gmk', '1234', '2', '7');
INSERT INTO `user` VALUES ('gmkadmin', '12345', '1', '8');
