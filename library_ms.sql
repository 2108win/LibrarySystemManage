-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:8111
-- Thời gian đã tạo: Th5 31, 2023 lúc 02:15 PM
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
(1, 'Tớ Học Lập Trình', 'Nhiều tác giả', 99),
(2, 'Introduction to Algorithms', 'UIT', 99),
(3, 'Lập Trình Và Cuộc Sống', 'Jeff Atwood', 100),
(4, 'Code Dạo Kí Sự', 'Phạm Huy Hoàng', 99),
(5, 'Giáo Trình C++ Và Lập Trình Hướng Đối Tượng ', 'Phạm Văn Ất & Lê Trường Thông', 99),
(6, 'Lập Trình C Toàn Tập Từ Cơ Bản Đến Nâng Cao', 'Hùng Minh & Mạnh Hùng', 100),
(7, 'Lập Trình Với C# Xây Dựng Ứng Dụng', 'Nhiều tác giả', 99),
(8, 'Kỹ Thuật Lập Trình Cơ Sở Với Ngôn Ngữ C/C ++', 'Dương Thăng Long & Trương Tiến Tùng', 100),
(9, 'Khái niệm lập trình', 'UIT', 100),
(10, 'Python', 'UIT', 100),
(11, 'Core Java', 'UIT', 100),
(12, 'Core Java nâng cao', 'UIT', 100),
(13, 'Effective Java', 'UIT', 99),
(14, 'Code Complete', 'UIT', 100),
(15, 'The Pragmatic Programmer', 'UIT', 99),
(16, 'Clean Code', 'UIT', 100),
(17, 'Introduction to Algorithms (CLRS)', 'UIT', 99),
(18, 'Data structure and Algorithms in Java', 'UIT', 100),
(20, 'Art of Computer Programming', 'UIT', 96);

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
(1, 7, 'Lập Trình Với C# Xây Dựng Ứng Dụng', 4, 'Lê Nguyễn Trung Đan', '2023-05-27', '2023-05-27', 'Pending'),
(2, 20, 'Art of Computer Programming', 4, 'Lê Nguyễn Trung Đan', '2023-05-27', '2023-05-27', 'Pending'),
(3, 17, 'Introduction to Algorithms (CLRS)', 4, 'Lê Nguyễn Trung Đan', '2023-05-27', '2023-05-27', 'Pending'),
(4, 15, 'The Pragmatic Programmer', 4, 'Lê Nguyễn Trung Đan', '2023-05-27', '2023-05-27', 'Pending'),
(5, 13, 'Effective Java', 7, 'Hoàng Thuỳ Linh', '2023-05-27', '2023-05-27', 'Pending'),
(6, 20, 'Art of Computer Programming', 7, 'Hoàng Thuỳ Linh', '2023-05-27', '2023-05-27', 'Pending'),
(7, 20, 'Art of Computer Programming', 2, 'Nghiêm Vũ Hoàng Long', '2023-05-27', '2023-05-27', 'Pending'),
(8, 20, 'Art of Computer Programming', 10, 'Nguyễn Thị Hòa', '2023-05-27', '2023-05-27', 'Pending'),
(9, 4, 'Code Dạo Kí Sự', 1, 'Lã Mai Win', '2023-05-27', '2023-05-27', 'Pending'),
(10, 5, 'Giáo Trình C++ Và Lập Trình Hướng Đối Tượng ', 1, 'Lã Mai Win', '2023-05-20', '2023-05-20', 'Pending'),
(11, 1, 'Tớ Học Lập Trình', 1, 'Lã Mai Win', '2023-05-31', '2023-05-31', 'Pending');

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
  `contact` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`) VALUES
(1, 'winlax', '123456', 'dangcapcuawin@gmail.com', '0971292838'),
(9, '123', '123', '123@gg.com', '123'),
(10, '1234', '1234', '1234@gm.iii', '1234'),
(11, 'dangcapcuawin', 'Win21082001', 'dangcapcuawin@gmail.com', '12341234'),
(12, '2345', '2345', '2345@gmail.com', '2345');

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
  MODIFY `issue_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT cho bảng `student_details`
--
ALTER TABLE `student_details`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12322;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
