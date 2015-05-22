-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2015 at 12:50 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

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
-- Table structure for table `asda`
--

CREATE TABLE IF NOT EXISTS `asda` (
  `ID` int(11) unsigned NOT NULL,
  `ShopID` varchar(200) DEFAULT NULL,
  `Name` varchar(200) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sains`
--

CREATE TABLE IF NOT EXISTS `sains` (
  `ID` int(11) unsigned NOT NULL,
  `ShopID` varchar(200) DEFAULT NULL,
  `Name` varchar(200) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
  `UserID` int(11) NOT NULL,
  `UserName` text NOT NULL,
  `UserEmail` varchar(20) NOT NULL,
  `UserPassword` varchar(40) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Age` int(11) NOT NULL,
  `Height` double NOT NULL,
  `Weight` double NOT NULL,
  `Gender` text NOT NULL,
  `Exercise` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `portion_sizes`
--
ALTER TABLE `portion_sizes`
  MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sains`
--
ALTER TABLE `sains`
  MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tesco`
--
ALTER TABLE `tesco`
  MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
