-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2022 at 10:14 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `exoticfishstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `freshwaterfish`
--

CREATE DATABASE `exoticfishstore`;

CREATE TABLE `freshwaterfish` (
  `FishID` varchar(255) NOT NULL,
  `FishName` varchar(255) NOT NULL,
  `FishSize` double NOT NULL,
  `FishSpeed` int(11) NOT NULL,
  `FishAlgaeTolerance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `freshwaterfish`
--

INSERT INTO `freshwaterfish` (`FishID`, `FishName`, `FishSize`, `FishSpeed`, `FishAlgaeTolerance`) VALUES
('FI001', 'Piranha', 0.2, 25, 50),
('FI002', 'Saw Fish', 4, 40, 30),
('FI003', 'Cat Fish', 2, 15, 70),
('FI004', 'Araipama', 2.5, 5, 40),
('FI005', 'Arowana', 0.5, 10, 0),
('FI006', 'Nessie', 100, 100, 100);

-- --------------------------------------------------------

--
-- Table structure for table `saltwaterfish`
--

CREATE TABLE `saltwaterfish` (
  `FishID` varchar(255) NOT NULL,
  `FishName` varchar(255) NOT NULL,
  `FishSize` double NOT NULL,
  `FishSpeed` int(11) NOT NULL,
  `FishDepthTolerance` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `saltwaterfish`
--

INSERT INTO `saltwaterfish` (`FishID`, `FishName`, `FishSize`, `FishSpeed`, `FishDepthTolerance`) VALUES
('FI007', 'Great White Shark', 6.5, 50, 'Bathypelagic'),
('FI008', 'Clown Fish', 0.1, 5, 'Epipelagic'),
('FI009', 'Whale Shark', 10, 20, 'Abyssopelagic'),
('FI010', 'Sun Fish', 3.5, 10, 'Mesopelagic'),
('FI011', 'Coelacanth', 4.5, 35, 'Abyssopelagic'),
('FI012', 'Kraken', 100, 75, 'Abyssopelagic');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `TransactionID` int(255) NOT NULL,
  `UserEmail` varchar(255) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `FishID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `freshwaterfish`
--
ALTER TABLE `freshwaterfish`
  ADD PRIMARY KEY (`FishID`);

--
-- Indexes for table `saltwaterfish`
--
ALTER TABLE `saltwaterfish`
  ADD PRIMARY KEY (`FishID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`TransactionID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `TransactionID` int(255) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
