-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2015 at 05:48 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `food_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tesco_scraped`
--

CREATE TABLE IF NOT EXISTS `tesco_scraped` (
`ID` int(11) NOT NULL,
  `shopID` varchar(150) DEFAULT NULL,
  `Name` varchar(150) DEFAULT NULL,
  `Units` varchar(20) DEFAULT NULL,
  `Mass` double DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `PricePUnit` double DEFAULT NULL,
  `FoodCat` text
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=100 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tesco_scraped`
--
ALTER TABLE `tesco_scraped`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tesco_scraped`
--
ALTER TABLE `tesco_scraped`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=100;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
