SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

-- Database: `new`

-- Table structure for table `student`

CREATE TABLE IF NOT EXISTS 'student' (
  'studentid' int NOT NULL AUTO_INCREMENT,
  'studentname' varchar(100) NOT NULL,
  'password' varchar(100) NOT NULL,
  'email' varchar(100) NOT NULL,
  'studentcontact' int NOT NULL,
  'fine' boolean NOT NULL,
  PRIMARY KEY ('id')
 ) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
 