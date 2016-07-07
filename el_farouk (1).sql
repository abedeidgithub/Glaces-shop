-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 29, 2016 at 12:25 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `el_farouk`
--

-- --------------------------------------------------------

--
-- Table structure for table `glass_office`
--

CREATE TABLE IF NOT EXISTS `glass_office` (
`id` int(11) NOT NULL,
  `office` varchar(50) COLLATE utf8_bin NOT NULL,
  `date` date NOT NULL,
  `num` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(30) COLLATE utf8_bin NOT NULL,
  `amount` int(10) NOT NULL,
  `lens_price` int(10) NOT NULL,
  `price` int(10) NOT NULL,
  `total` int(11) NOT NULL,
  `payed` int(50) NOT NULL,
  `reset` int(30) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=19 ;

--
-- Dumping data for table `glass_office`
--

INSERT INTO `glass_office` (`id`, `office`, `date`, `num`, `type`, `amount`, `lens_price`, `price`, `total`, `payed`, `reset`) VALUES
(15, 'asfsdf', '2015-12-18', '20', 'dsfds', 10, 20, 30, 200, 200, 0),
(16, 'asfsdf', '2015-12-18', '30', 'dsfds', 10, 20, 30, 200, 200, 0),
(17, 'مكتب', '2016-01-28', '5', 'نوع', 10, 30, 30, 300, 300, 0),
(18, 'مكتب', '2016-01-28', '6', 'نوع', 10, 30, 30, 300, 300, 0);

-- --------------------------------------------------------

--
-- Table structure for table `makhazen`
--

CREATE TABLE IF NOT EXISTS `makhazen` (
`id` int(11) NOT NULL,
  `num` varchar(255) COLLATE utf8_bin NOT NULL,
  `amount` int(10) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=22 ;

--
-- Dumping data for table `makhazen`
--

INSERT INTO `makhazen` (`id`, `num`, `amount`) VALUES
(11, '10', 0),
(12, '1', 0),
(13, '50', 7),
(14, '500', 10),
(15, '400', 10),
(16, '20', 1),
(17, '30', 1),
(18, '60', 9),
(19, '80', 0),
(20, '5', 5),
(21, '6', 4);

-- --------------------------------------------------------

--
-- Table structure for table `masrofat`
--

CREATE TABLE IF NOT EXISTS `masrofat` (
`ID` int(11) NOT NULL,
  `value` double NOT NULL,
  `masaryInfo` varchar(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `masrofat`
--

INSERT INTO `masrofat` (`ID`, `value`, `masaryInfo`, `date`) VALUES
(1, 10, 'كهربا', '2016-01-16'),
(2, 10, 'مياه', '2016-01-27'),
(3, 5, 'شاي', '2016-01-28');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
`id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `bayan` varchar(50) COLLATE utf8_bin NOT NULL,
  `date` varchar(15) COLLATE utf8_bin NOT NULL,
  `phone` varchar(255) COLLATE utf8_bin NOT NULL,
  `d_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date1` date DEFAULT NULL,
  `num_shamp` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price_shamp` double DEFAULT NULL,
  `office` varchar(11) COLLATE utf8_bin NOT NULL,
  `num_lens` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price_lens` int(11) DEFAULT NULL,
  `total` int(10) NOT NULL,
  `payed` int(10) NOT NULL,
  `reset` double NOT NULL,
  `rtdsph` double DEFAULT NULL,
  `rtdcyl` double DEFAULT NULL,
  `rtdaxis` double DEFAULT NULL,
  `rtrsph` double DEFAULT NULL,
  `rtrcyl` double DEFAULT NULL,
  `rtraxis` double DEFAULT NULL,
  `ltrsph` double DEFAULT NULL,
  `ltrcyl` double DEFAULT NULL,
  `ltraxis` double DEFAULT NULL,
  `ltdsph` double DEFAULT NULL,
  `ltdaxis` double DEFAULT NULL,
  `ltdcyl` double DEFAULT NULL,
  `jpdd` double DEFAULT NULL,
  `jpdr` double DEFAULT NULL,
  `type_lens` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=34 ;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `name`, `bayan`, `date`, `phone`, `d_name`, `date1`, `num_shamp`, `price_shamp`, `office`, `num_lens`, `price_lens`, `total`, `payed`, `reset`, `rtdsph`, `rtdcyl`, `rtdaxis`, `rtrsph`, `rtrcyl`, `rtraxis`, `ltrsph`, `ltrcyl`, `ltraxis`, `ltdsph`, `ltdaxis`, `ltdcyl`, `jpdd`, `jpdr`, `type_lens`) VALUES
(26, 'أحمد', 'بيان', '2016-01-28', '01225522656', 'دكتور', '2016-01-03', '50', 15, '', 'null', 0, 15, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ''),
(27, 'صبري', 'بيان', '2016-01-28', '01225522656', 'دكتور', '2016-01-03', 'null', 0, 'مكتب', '6', 30, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'نوع'),
(28, 'أحمد', 'بيان', '2016-01-28', '01225522656', 'دكتور', '2016-01-25', 'null', 0, 'مكتب', '30', 30, 30, 20, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'نوع'),
(29, 'صبري', 'بيان', '2016-01-28', '01225522656', 'دكتور', '2016-01-19', 'null', 0, 'مكتب', '6', 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ''),
(30, 'واءل', 'بيان', '2016-01-28', '01225522656', 'دكتور', '2016-01-19', 'null', 0, 'مكتب', '5', 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ''),
(31, 'بلح', 'بيان', '2016-01-28', '01225522656', 'دكتور', '2016-01-10', 'null', 0, 'مكتب', '5', 30, 20, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ''),
(32, 'مبيبس', 'سيبسييييييييييييي', '2016-01-17', '022222', 'وةىوىوةىوةى', '2016-01-18', '60', 20, '', 'null', 0, 20, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ''),
(33, ' nnnnnnnnnnnnnnnnnn', 'سيبسييييييييييييي', '2016-01-28', '0222222222222', 'وةىوىوةىوةى', '2016-01-12', 'null', 0, '', '5', 30, 20, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'mm');

-- --------------------------------------------------------

--
-- Table structure for table `traders_1`
--

CREATE TABLE IF NOT EXISTS `traders_1` (
`t_ID` int(11) NOT NULL,
  `t_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `date` date NOT NULL,
  `phone` varchar(15) COLLATE utf8_bin NOT NULL,
  `num_shamp` int(15) NOT NULL,
  `class` varchar(40) COLLATE utf8_bin NOT NULL,
  `color` varchar(20) COLLATE utf8_bin NOT NULL,
  `type` varchar(30) COLLATE utf8_bin NOT NULL,
  `mark` varchar(30) COLLATE utf8_bin NOT NULL,
  `number` int(255) NOT NULL,
  `price_shamp` int(255) NOT NULL,
  `price` int(10) NOT NULL,
  `payed` int(10) NOT NULL,
  `total` int(10) NOT NULL,
  `reset` int(10) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=17 ;

--
-- Dumping data for table `traders_1`
--

INSERT INTO `traders_1` (`t_ID`, `t_name`, `date`, `phone`, `num_shamp`, `class`, `color`, `type`, `mark`, `number`, `price_shamp`, `price`, `payed`, `total`, `reset`) VALUES
(11, 'ssdasdas ', '2015-12-18', '123123123  ', 10, 'mnm,', 'jn,mj', '  ', 'mnm,  ', 10, 10, 30, 100, 100, 0),
(12, 'ssdasdas  ', '2015-12-18', '123123123   ', 20, 'mnm,', 'jn,mj', '   ', 'mnm,   ', 10, 10, 20, 100, 100, 0),
(13, 'ريسيس ', '2016-01-26', '012122121 ', 50, 'صنف', 'لون', 'نوع ', 'مارك ', 10, 10, 15, 70, 100, 30),
(14, 'ريسيس  ', '2016-01-26', '012122121  ', 60, 'صنف', 'لون', 'نوع  ', 'مارك  ', 10, 10, 20, 70, 100, 30),
(15, 'ريسيس   ', '2016-01-26', '012122121   ', 80, 'صنف', 'لون', 'نوع   ', 'مارك   ', 10, 10, 50, 100, 100, 0),
(16, 'ريسيس    ', '2016-01-29', '012122121    ', 80, 'صنف', 'لون', 'نوع    ', 'مارك    ', 0, 10, 50, 100, 100, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `userType` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `userType`) VALUES
('أحمد محمد ', '123456', 0),
('عبدالرحمن جمال', '123456', 0),
('عبدالرحمن صالح', '12345', 1),
('مانو سعيد', '123', 1),
('عبدو صالح', '1234', 1);

-- --------------------------------------------------------

--
-- Table structure for table `warsha`
--

CREATE TABLE IF NOT EXISTS `warsha` (
`id` int(11) NOT NULL,
  `shop_name` varchar(30) COLLATE utf8_bin NOT NULL,
  `bayan` varchar(255) COLLATE utf8_bin NOT NULL,
  `date` date NOT NULL,
  `total` int(8) NOT NULL,
  `payed` int(8) NOT NULL,
  `reset` double NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Dumping data for table `warsha`
--

INSERT INTO `warsha` (`id`, `shop_name`, `bayan`, `date`, `total`, `payed`, `reset`) VALUES
(2, 'المحل', 'بيكبيبيكييييييييييييييييييييييييي ثس	\n		ثيييييييييثرب', '2015-12-18', 50, 0, 50),
(3, 'المحل', 'بيكبيبيكييييييييييييييييييييييييي ثس	\n		ثيييييييييثرب', '2016-01-27', 50, 40, 10),
(4, 'محل', 'بيكبيبيكييييييييييييييييييييييييي ثس	\n		ثيييييييييثرب', '2016-01-28', 50, 40, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `glass_office`
--
ALTER TABLE `glass_office`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `makhazen`
--
ALTER TABLE `makhazen`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `masrofat`
--
ALTER TABLE `masrofat`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `traders_1`
--
ALTER TABLE `traders_1`
 ADD PRIMARY KEY (`t_ID`);

--
-- Indexes for table `warsha`
--
ALTER TABLE `warsha`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `glass_office`
--
ALTER TABLE `glass_office`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `makhazen`
--
ALTER TABLE `makhazen`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `masrofat`
--
ALTER TABLE `masrofat`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `traders_1`
--
ALTER TABLE `traders_1`
MODIFY `t_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `warsha`
--
ALTER TABLE `warsha`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
