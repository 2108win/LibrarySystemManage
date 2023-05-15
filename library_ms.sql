-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:8111
-- Thời gian đã tạo: Th5 13, 2023 lúc 08:30 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `library_ms`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book_details`
--

CREATE TABLE `book_details` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(250) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `book_details`
--

INSERT INTO `book_details` (`book_id`, `book_name`, `author`, `quantity`) VALUES
(1, '1', '1', 0),
(2, '2', '2', 0),
(3, '3', '3', 2),
(4, '4', '4', 0),
(5, '5', '55', 54),
(6, '66', '66', 65),
(7, '777', '7', 65),
(10, 'test101212', 'rr', 9),
(11, 'test101212', 'rr', 9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `issue_book_details`
--

CREATE TABLE `issue_book_details` (
  `issue_id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(150) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `issue_book_details`
--

INSERT INTO `issue_book_details` (`issue_id`, `book_id`, `book_name`, `student_id`, `student_name`, `issue_date`, `due_date`, `status`) VALUES
(61, 10, 'test10', 5, 'test100', '2023-05-13', '2023-05-13', 'Returned'),
(62, 1, '1', 1, 'Win Lã 1', '2023-05-13', '2023-05-13', 'Pending'),
(63, 10, 'test10', 5, 'test100', '2023-05-13', '2023-05-13', 'Returned'),
(64, 10, 'test10', 5, 'test100', '2023-05-27', '2023-05-27', 'Returned'),
(65, 2, '2', 3, 'Win Lã 3', '2023-05-20', '2023-05-20', 'Pending'),
(66, 5, '5', 3, 'Win Lã 3', '2023-05-20', '2023-05-20', 'Returned'),
(67, 1, '1', 12, 'Win Lã 1', '2023-05-27', '2023-05-27', 'Pending'),
(68, 7, '777', 2, 'Win Lã 12334', '2023-05-27', '2023-05-27', 'Pending');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student_details`
--

CREATE TABLE `student_details` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `branch` varchar(200) DEFAULT NULL,
  `year` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `student_details`
--

INSERT INTO `student_details` (`student_id`, `student_name`, `branch`, `year`) VALUES
(1, 'Win Lã 1', 'Hệ thống Thông tin', 'K19'),
(2, 'Win Lã 12334', 'Kỹ thuật Phần mềm', 'K18'),
(3, 'Win Lã 3', 'Hệ thống Thông tin', 'K18'),
(12, 'Win Lã 1233455555', 'Hệ thống Thông tin', 'K18');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`) VALUES
(1, 'winlax', '123456', 'dangcapcuawin@gmail.com', '0971292838'),
(2, 'wwin', '123456', '2108win@gmail.com', '123455566666'),
(3, 'winlax', '123456', 'dangcapcuawin@gmail.com', '0971292838'),
(4, '1242', '14', '234242@gmail.com', '234234'),
(5, 'winlax', '123', '124@gmail.com', '123'),
(6, 'winla', '1234', 'dangca', '1234'),
(7, 'winla111', '1233', '1234@gmail.com', '1234'),
(8, 'winlax123', '123', 'dangca@gmaic.com', '123'),
(9, '123', '123', '123@gg.com', '123'),
(10, '1234', '1234', '1234@gm.iii', '1234'),
(11, 'dangcapcuawin', 'Win21082001', 'dangcapcuawin@gmail.com', '12341234');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `book_details`
--
ALTER TABLE `book_details`
  ADD PRIMARY KEY (`book_id`);

--
-- Chỉ mục cho bảng `issue_book_details`
--
ALTER TABLE `issue_book_details`
  ADD PRIMARY KEY (`issue_id`);

--
-- Chỉ mục cho bảng `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`student_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `book_details`
--
ALTER TABLE `book_details`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10013;

--
-- AUTO_INCREMENT cho bảng `issue_book_details`
--
ALTER TABLE `issue_book_details`
  MODIFY `issue_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT cho bảng `student_details`
--
ALTER TABLE `student_details`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12322;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
