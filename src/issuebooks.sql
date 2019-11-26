SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `new`
--
-- Table structure for table `issuebooks`
--

CREATE TABLE IF NOT EXISTS `issuebooks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookcallno` varchar(50) NOT NULL,
  `studentid` int NOT NULL,
  `studentname` varchar(50) NOT NULL,
  `studentcontact` varchar(20) NOT NULL,
  `issueddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8;
