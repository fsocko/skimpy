-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 25, 2015 at 06:10 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `product`
--

-- --------------------------------------------------------

--
-- Table structure for table `product_info`
--

CREATE TABLE IF NOT EXISTS `product_info` (
  `ProductID` varchar(10) NOT NULL,
  `ProductName` varchar(30) NOT NULL,
  `FoodGroupID` varchar(10) NOT NULL,
  `Supermarket` varchar(20) NOT NULL,
  `Price` float NOT NULL,
  `Calories` float NOT NULL,
  `Proteins` float NOT NULL,
  `Sugars` float NOT NULL,
  `Fats` float NOT NULL,
  `Saturates` float NOT NULL,
  `Salt` float NOT NULL,
  `Fibre` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_info`
--

INSERT INTO `product_info` (`ProductID`, `ProductName`, `FoodGroupID`, `Supermarket`, `Price`, `Calories`, `Proteins`, `Sugars`, `Fats`, `Saturates`, `Salt`, `Fibre`) VALUES
('P001', 'Lettuce', 'F001', 'ASDA', 0.98, 15, 7.7, 0.1, 2, 1.5, 1, 1.3),
('P002', 'French Fries', 'F002', 'ASDA', 3.5, 312, 5, 1.2, 4, 3, 1, 3),
('P003', 'BBQ Stuffed Crust ', 'F003', 'Morrisons', 1.25, 200, 4.5, 1.3, 2, 1.6, 1, 4),
('P004', 'Bread', 'F004', 'Sainsbury''s', 2, 100, 4, 2, 1.3, 0.4, 1, 4.5),
('P005', 'Rubicon Passion Fruit', 'F005', 'Tesco', 1, 500, 4.5, 5, 0.1, 0.7, 1, 4.6),
('P006', 'Digestive Biscuit', 'F006', 'Tesco', 1, 73, 4, 1.2, 1, 0.9, 1.9, 6.7),
('P007', 'Toilet Roll', 'F007', 'ASDA', 4.5, 0, 0, 0, 0, 0, 0, 0),
('P008', 'Chicken Drumsticks', 'F008', 'Sainsbury''s', 4.5, 200, 73, 0.1, 30, 7.9, 0.8, 4.7),
('P009', 'Milk', 'F009', 'Morrisions', 0.98, 42, 4.9, 1, 4, 0.9, 1.5, 5),
('P010', 'Lamb', 'F010', 'Morrisons', 4.7, 294, 30, 5, 19.9, 5, 4.5, 8.9),
('P011', 'Lettuce', 'F001', 'Tesco', 0.75, 15, 7.7, 0.1, 2, 0, 1, 1.3),
('P012', 'French Fries', 'F002', 'Sainsbury''s', 3.75, 312, 5, 1.2, 4, 3, 1, 2),
('P013', 'Lettuce', 'F001', 'Morrisons', 0.68, 15, 7.7, 0.1, 2, 0, 1, 1.3),
('P014', 'BBQ Stuffed Crust', 'F003', 'ASDA', 1.5, 250, 4.5, 1.3, 2, 1.6, 2, 1),
('P015', 'Bread', 'F004', 'ASDA', 1.5, 150, 5, 2, 1.3, 0.4, 1, 4.5),
('P016', 'Rubicon Passion Fruit', 'F005', 'Sainsbury''s', 1.25, 200, 4.5, 5, 0.1, 0, 1, 3.5),
('P017', 'Digestive Biscuit', 'F006', 'Morrisons', 0.98, 73, 4, 1.2, 1.3, 0.9, 1.9, 6.7),
('P018', 'Milk', 'F009', 'Tesco', 1, 42, 4.9, 1, 4, 0.9, 1.5, 5),
('P019', 'Lamb', 'F010', 'Sainsbury''s', 5.5, 294, 30, 5, 19.9, 5, 4.5, 8.9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product_info`
--
ALTER TABLE `product_info`
 ADD PRIMARY KEY (`ProductID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
