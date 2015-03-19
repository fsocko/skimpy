-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2015 at 05:38 PM
-- Server version: 5.6.20-log
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `skimpy`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
`UserID` int(11) NOT NULL,
  `UserName` text NOT NULL,
  `UserEmail` varchar(20) NOT NULL,
  `UserPassword` varchar(20) NOT NULL,
  `Age` int(3) NOT NULL,
  `Height` float NOT NULL,
  `Weight` float NOT NULL,
  `Gender` text NOT NULL,
  `Exercise` float NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`UserID`, `UserName`, `UserEmail`, `UserPassword`, `Age`, `Height`, `Weight`, `Gender`, `Exercise`) VALUES
(1, 'TestUser', 'test123@test.com', '', 14, 165, 60, 'F', 1),
(2, 'Harry', 'harry@hotmail.com', '', 18, 189, 88, 'M', 3),
(3, 'Jacob', 'jake@yahoo.com', '', 20, 178, 97, 'M', 5),
(4, 'Mathias', 'mathias@yahoo.co.uk', '', 45, 195, 100, 'M', 1),
(5, 'Jerry', 'jerrymc@hotmail.com', '', 23, 170, 67, 'M', 2),
(6, 'Jane', 'jane@yahoo.com', '', 35, 155, 45, 'F', 4),
(25, 'Alina Uyazina', 'qwee@qwew.we', '', 24, 159, 53, 'F', 3),
(26, 'Alina Uyazina', 'qwee@qwew.we', '', 24, 159, 53, 'F', 3),
(27, 'Alina Uyazina', 'diff@qwew.we', '123456', 24, 159, 53, 'F', 3),
(28, 'Alina Uyazina', 'diff@qwew.we', '123456', 24, 159, 53, 'F', 3),
(29, 'Alina Uyazina', 'qwee@qwew.we', '123456', 24, 159, 53, 'F', 3),
(30, 'Alina Uyazina', 'qwee@qwew.we', 'another', 24, 159, 53, 'F', 3),
(31, 'Alina Uyazina', 'qwee@qwew.we', 'another', 24, 159, 53, 'F', 3),
(32, 'Alina Uyazina', 'qwee@qwew.we', 'password', 24, 159, 53, 'F', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
 ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
