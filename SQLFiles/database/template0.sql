-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2015 at 05:36 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `skimpytest2`
--

-- --------------------------------------------------------

--
-- Table structure for table `asda`
--

CREATE TABLE IF NOT EXISTS `asda` (
`ID` int(11) unsigned NOT NULL,
  `ShopID` varchar(200) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Unit` varchar(5) DEFAULT NULL,
  `Mass` double DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `PPUPrice` double DEFAULT NULL,
  `PPUUnit` varchar(5) DEFAULT NULL,
  `FoodCat` varchar(100) DEFAULT NULL,
  `FoodCat2` varchar(100) DEFAULT NULL,
  `SuperMarket` char(2) DEFAULT NULL,
  `Calories` double DEFAULT NULL,
  `Proteins` double DEFAULT NULL,
  `Carbs` double DEFAULT NULL,
  `Sugars` double DEFAULT NULL,
  `Fats` double DEFAULT NULL,
  `Saturates` double DEFAULT NULL,
  `Salt` double DEFAULT NULL,
  `Fibre` double DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8393 ;

-- --------------------------------------------------------

--
-- Table structure for table `portion_sizes`
--

CREATE TABLE IF NOT EXISTS `portion_sizes` (
`ID` int(11) unsigned NOT NULL,
  `FoodCat` varchar(50) NOT NULL,
  `Item` varchar(600) NOT NULL,
  `Mass` double DEFAULT NULL,
  `Unit` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `sains`
--

CREATE TABLE IF NOT EXISTS `sains` (
`ID` int(11) unsigned NOT NULL,
  `ShopID` varchar(200) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Unit` varchar(5) DEFAULT NULL,
  `Mass` double DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `PPUPrice` double DEFAULT NULL,
  `PPUUnit` varchar(5) DEFAULT NULL,
  `FoodCat` varchar(100) DEFAULT NULL,
  `FoodCat2` varchar(100) DEFAULT NULL,
  `SuperMarket` char(2) DEFAULT NULL,
  `Calories` double DEFAULT NULL,
  `Proteins` double DEFAULT NULL,
  `Carbs` double DEFAULT NULL,
  `Sugars` double DEFAULT NULL,
  `Fats` double DEFAULT NULL,
  `Saturates` double DEFAULT NULL,
  `Salt` double DEFAULT NULL,
  `Fibre` double DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17958 ;

-- --------------------------------------------------------

--
-- Table structure for table `tesco`
--

CREATE TABLE IF NOT EXISTS `tesco` (
`ID` int(11) unsigned NOT NULL,
  `ShopID` varchar(200) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Unit` varchar(5) DEFAULT NULL,
  `Mass` double DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `PPUPrice` double DEFAULT NULL,
  `PPUUnit` varchar(5) DEFAULT NULL,
  `FoodCat` varchar(100) DEFAULT NULL,
  `FoodCat2` varchar(100) DEFAULT NULL,
  `SuperMarket` char(2) DEFAULT NULL,
  `Calories` double DEFAULT NULL,
  `Proteins` double DEFAULT NULL,
  `Carbs` double DEFAULT NULL,
  `Sugars` double DEFAULT NULL,
  `Fats` double DEFAULT NULL,
  `Saturates` double DEFAULT NULL,
  `Salt` double DEFAULT NULL,
  `Fibre` double DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17438 ;

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
`UserID` int(11) NOT NULL,
  `UserName` text NOT NULL,
  `UserEmail` varchar(20) NOT NULL,
  `UserPassword` varchar(20) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Age` int(11) NOT NULL,
  `Height` double NOT NULL,
  `Weight` double NOT NULL,
  `Gender` text NOT NULL,
  `Exercise` int(50) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=48 ;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`UserID`, `UserName`, `UserEmail`, `UserPassword`, `DateOfBirth`, `Age`, `Height`, `Weight`, `Gender`, `Exercise`) VALUES
(1, 'TestUser', 'test123@test.com', '', '0000-00-00', 0, 15, 60, 'F', NULL),
(2, 'Harry', 'harry@hotmail.com', '', '0000-00-00', 0, 1894, 8812, 'M', NULL),
(3, 'Jacob', 'jake@yahoo.com', '', '0000-00-00', 0, 178, 97, 'M', NULL),
(4, 'Mathias', 'mathias@yahoo.co.uk', '', '0000-00-00', 0, 195, 100, 'M', NULL),
(5, 'Jerry', 'jerrymc@hotmail.com', '', '0000-00-00', 0, 170, 67, 'M', NULL),
(6, 'Jane', 'jane@yahoo.com', '', '0000-00-00', 0, 155, 45, 'F', NULL),
(25, 'Alina Uyazina', 'qwee@qwew.we', '', '0000-00-00', 0, 159, 53, 'F', NULL),
(26, 'Alina Uyazina', 'qwee@qwew.we', '', '0000-00-00', 0, 159, 53, 'F', NULL),
(27, 'Alina Uyazina', 'diff@qwew.we', '123456', '0000-00-00', 0, 159, 53, 'F', NULL),
(28, 'Alina Uyazina', 'diff@qwew.we', '123456', '0000-00-00', 0, 159, 53, 'F', NULL),
(29, 'Alina Uyazina', 'qwee@qwew.we', '123456', '0000-00-00', 0, 159, 53, 'F', NULL),
(30, 'Alina Uyazina', 'qwee@qwew.we', 'another', '0000-00-00', 0, 159, 53, 'F', NULL),
(31, 'Alina Uyazina', 'qwee@qwew.we', 'another', '0000-00-00', 0, 159, 53, 'F', NULL),
(32, 'Alina Uyazina', 'qwee@qwew.we', 'password', '0000-00-00', 0, 159, 53, 'F', NULL),
(33, 'Alina Uyazina', 'alina@gmail.com', 'hello', '0000-00-00', 0, 159, 53, 'F', NULL),
(34, 'Sarah', 'sarah@btvs.com', 'nice', '0000-00-00', 0, 164, 48, 'F', NULL),
(35, 'Skimpy', 'skimpy@foxtrot.com', 'skimpy', '1994-12-04', 20, 180, 80, 'M', 4),
(39, 'fps', 'fps@skimpy.com', 'ass1ass2ass3', '1993-09-28', 2012, 180, 80, 'M', 1),
(40, 'testing', 'testmail@mail.com', '1234qwer', '1995-01-04', 20, 188, 70, 'M', 2),
(41, 'Ruaraidh Macfarlane', 'ruaraidh2@gmail.com', '1234qwer', '1994-01-04', 0, -1, -1, 'M', -1),
(42, 'testdate', 'testdate@test.com', '1234qwer', '2005-11-04', 20, -1, -1, 'M', -1),
(43, 'Buzz Lightyear', 'null', 'null', '1979-08-20', 35, -1, -1, 'F', -1),
(44, 'Totoro', 'null', 'totoro', '1973-09-06', 41, -1, -1, 'F', -1),
(45, 'Chicken Man', 'chicken@man.com', 'chick', '1965-02-02', 50, -1, -1, 'F', -1),
(46, 'John Smith', 'js@email.com', 'pass', '2012-05-07', 2, -1, -1, 'M', -1),
(47, 'Joe Average', 'ja@email.com', '1234qwer', '1989-07-08', 25, -1, -1, 'M', -1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asda`
--
ALTER TABLE `asda`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `portion_sizes`
--
ALTER TABLE `portion_sizes`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sains`
--
ALTER TABLE `sains`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tesco`
--
ALTER TABLE `tesco`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
 ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asda`
--
ALTER TABLE `asda`
MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8393;
--
-- AUTO_INCREMENT for table `portion_sizes`
--
ALTER TABLE `portion_sizes`
MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sains`
--
ALTER TABLE `sains`
MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17958;
--
-- AUTO_INCREMENT for table `tesco`
--
ALTER TABLE `tesco`
MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17438;
--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=48;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
