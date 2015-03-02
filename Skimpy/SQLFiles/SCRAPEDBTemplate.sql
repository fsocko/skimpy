-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 25, 2015 at 12:20 AM
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
-- Table structure for table `sains_scraped`
--

CREATE TABLE IF NOT EXISTS `sains_scraped` (
`ID` int(11) unsigned NOT NULL,
  `ShopID` varchar(200) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Unit` varchar(5) DEFAULT NULL,
  `Mass` double DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `PPUPrice` double DEFAULT NULL,
  `PPUUnit` varchar(5) DEFAULT NULL,
  `FoodCat` varchar(100) DEFAULT NULL,
  `SuperMarket` char(2) DEFAULT NULL,
  `Calories` double DEFAULT NULL,
  `Protein` double DEFAULT NULL,
  `Carbs` double DEFAULT NULL,
  `Sugars` double DEFAULT NULL,
  `Fats` double DEFAULT NULL,
  `Saturates` double DEFAULT NULL,
  `Salt` double DEFAULT NULL,
  `Fibre` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Indexes for table `sains_scraped`
--
ALTER TABLE `sains_scraped`
 ADD PRIMARY KEY (`ID`);


--
-- AUTO_INCREMENT for table `sains_scraped`
--
ALTER TABLE `sains_scraped`
MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
