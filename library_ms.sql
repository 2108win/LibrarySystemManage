-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:8111
-- Thời gian đã tạo: Th6 13, 2023 lúc 09:17 PM
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
  `quantity` int(11) DEFAULT NULL,
  `book_fee` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `book_details`
--

INSERT INTO `book_details` (`book_id`, `book_name`, `author`, `quantity`, `book_fee`) VALUES
(1, 'Tớ Học Lập Trình', 'Nhiều tác giả', 99, 1000),
(2, 'Introduction to Algorithms', 'UIT', 100, 2000),
(3, 'Lập Trình Và Cuộc Sống', 'Jeff Atwood', 100, 3000),
(4, 'Code Dạo Kí Sự', 'Phạm Huy Hoàng', 100, 4000),
(5, 'Giáo Trình C++ Và Lập Trình Hướng Đối Tượng ', 'Phạm Văn Ất & Lê Trường Thông', 100, 5000),
(6, 'Lập Trình C Toàn Tập Từ Cơ Bản Đến Nâng Cao', 'Hùng Minh & Mạnh Hùng', 100, 6000),
(7, 'Lập Trình Với C# Xây Dựng Ứng Dụng', 'Nhiều tác giả', 100, 7000),
(8, 'Kỹ Thuật Lập Trình Cơ Sở Với Ngôn Ngữ C/C ++', 'Dương Thăng Long & Trương Tiến Tùng', 100, 8000),
(9, 'Khái niệm lập trình', 'UIT', 99, 9000),
(10, 'Python', 'UIT', 100, 10000),
(11, 'Core Java', 'UIT', 99, 11000),
(12, 'Core Java nâng cao', 'UIT', 100, 12000),
(13, 'Effective Java', 'UIT', 100, 13000),
(14, 'Code Complete', 'UIT', 100, 14000),
(15, 'The Pragmatic Programmer', 'UIT', 99, 15000),
(16, 'Clean Code', 'UIT', 100, 16000),
(17, 'Introduction to Algorithms (CLRS)', 'UIT', 99, 17000),
(18, 'Data structure and Algorithms in Java', 'UIT', 100, 18000),
(19, 'Java Đối Tượng', 'UIT', 100, 19000),
(20, 'Art of Computer Programming', 'UIT', 94, 20000);

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
  `status` varchar(20) DEFAULT NULL,
  `issue_fee` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `issue_book_details`
--

INSERT INTO `issue_book_details` (`issue_id`, `book_id`, `book_name`, `student_id`, `student_name`, `issue_date`, `due_date`, `status`, `issue_fee`) VALUES
(19, 1, 'Tớ Học Lập Trình', 1, 'Lã Mai Win', '2023-06-13', '2023-06-30', 'Returned', 1000),
(20, 5, 'Giáo Trình C++ Và Lập Trình Hướng Đối Tượng ', 2, 'Nghiêm Vũ Hoàng Long', '2023-06-01', '2023-06-09', 'Returned', 5500),
(21, 15, 'The Pragmatic Programmer', 4, 'Lê Nguyễn Trung Đan', '2023-05-17', '2023-05-24', 'Overdue', 45000),
(22, 20, 'Art of Computer Programming', 4, 'Lê Nguyễn Trung Đan', '2023-05-17', '2023-05-24', 'Returned', 60000),
(23, 20, 'Art of Computer Programming', 10, 'Nguyễn Thị Hòa', '2023-06-12', '2023-06-15', 'Pending', 20000),
(24, 20, 'Art of Computer Programming', 12, 'Mai Hồng Ngọc', '2023-06-12', '2023-06-17', 'Pending', 20000),
(25, 6, 'Lập Trình C Toàn Tập Từ Cơ Bản Đến Nâng Cao', 13, 'Ngô Kiến Huy', '2023-06-01', '2023-06-12', 'Returned', 6600.000000000001);

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
(1, 'Lã Mai Win', 'Công nghệ Thông tin', 'K19'),
(2, 'Nghiêm Vũ Hoàng Long', 'Kỹ thuật Phần mềm', 'K21'),
(3, 'Hoàng Kim Long', 'Hệ thống Thông tin', 'K20'),
(4, 'Lê Nguyễn Trung Đan', 'An toàn Thông tin', 'K22'),
(5, 'Nguyễn Thanh Tùng', 'Kỹ thuật Phần mềm', 'K24'),
(6, 'Nguyễn Việt Hoàng', 'Hệ thống Thông tin', 'K23'),
(7, 'Hoàng Thuỳ Linh', 'Công nghệ Thông tin', 'K23'),
(8, 'Nguyễn Đức Cường', 'Khoa học Dữ liệu', 'K19'),
(9, 'Phùng Thanh Độ', 'Khoa học Dữ liệu', 'K18'),
(10, 'Nguyễn Thị Hòa', 'Kỹ thuật Phần mềm', 'K20'),
(11, 'Lê Trung Thành', 'Khoa học Máy tính', 'K22'),
(12, 'Mai Hồng Ngọc', 'Hệ thống Thông tin', 'K22'),
(13, 'Ngô Kiến Huy', 'Kỹ thuật Máy tính', 'K22'),
(14, 'Nguyễn Phước Thịnh', 'Kỹ thuật Máy tính', 'K22');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `fee_pending` double DEFAULT NULL,
  `fee_returned` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`, `fee_pending`, `fee_returned`) VALUES
(1, '1234', '1234', '1234@gm.iii', '1234', 55000, 73100);

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
-- AUTO_INCREMENT cho bảng `issue_book_details`
--
ALTER TABLE `issue_book_details`
  MODIFY `issue_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
