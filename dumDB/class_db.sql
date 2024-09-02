-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2024 at 10:24 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `class_db1`
--

-- --------------------------------------------------------

--
-- Table structure for table `classroom`
--

CREATE TABLE `classroom` (
  `id` bigint(20) NOT NULL,
  `class_code` varchar(255) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `teacher_phone_number` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `classroom`
--

INSERT INTO `classroom` (`id`, `class_code`, `class_name`, `teacher_name`, `teacher_phone_number`) VALUES
(1, 'A01', 'Lớp học 1', 'Giáo Viên 1', '0913918539'),
(2, 'A02', 'Lớp học 2', 'Giáo viên 2', '0913978534'),
(3, 'A03', 'Lớp học 3', 'Giáo viên 3', '0913657842'),
(4, 'A04', 'Lớp học 4', 'Giáo viên 4', '0912354782');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` date NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `student_code` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `classroom_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `address`, `date_of_birth`, `gender`, `phone_number`, `student_code`, `student_name`, `classroom_id`) VALUES
(1, 'Hà Nội', '2014-05-07', 'male', '0942157864', 'B01', 'Học sinh 1', 1),
(2, 'TP HCM', '2014-05-13', 'female', '0935642157', 'B02', 'Học sinh 2', NULL),
(15, 'Hà Nội', '2014-03-07', 'male', '0942557864', 'B03', 'Học sinh 3', 2),
(16, 'TP HCM', '2012-05-13', 'female', '0934542157', 'B04', 'Học sinh 4', NULL),
(17, 'Đà Nẵng', '2013-03-07', 'male', '0999557864', 'B05', 'Học sinh 5', 3),
(18, 'Huế', '2018-03-07', 'male', '0942557664', 'B06', 'Học sinh 6', 3),
(19, 'Nam Định', '2015-03-05', 'male', '0942557854', 'B07', 'Học sinh 7', 4),
(20, 'Hà Nội', '2014-12-07', 'male', '0942578864', 'B08', 'Học sinh 8', 4),1

(21, 'Cà Mau', '2020-06-03', 'male', '0963548752', 'B09', 'Học sinh mới', NULL),
(22, 'Tây Nguyên', '2011-06-03', 'female', '0963548754', 'B10', 'Học sinh 10',1 ),
(23, 'Thái bình', '2022-06-03', 'male', '0953145781', 'B11', 'Học sinh 11', NULL),
(24, '123 Nguyen Trai, Hanoi', '2005-05-20', 'Male', '084123456789', 'S123456', 'Nguyen Van A', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `classroom`
--
ALTER TABLE `classroom`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_a7nn6gkjgpevkv2owkkp5ai7c` (`class_code`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ehyy0sfg2s1qmd3vw4q7nlwiu` (`student_name`),
  ADD KEY `FKekydum3jitwpq1lvbiqteidko` (`classroom_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `classroom`
--
ALTER TABLE `classroom`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `FKekydum3jitwpq1lvbiqteidko` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
