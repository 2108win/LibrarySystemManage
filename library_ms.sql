SET FOREIGN_KEY_CHECKS=0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE "book_details" ;

SET IDENTITY_INSERT "book_details" ON ;
INSERT INTO "book_details" ("book_id", "book_name", "author", "quantity", "book_fee") VALUES
(1, 'Tớ Học Lập Trình', 'Nhiều tác giả', 101, 1000),
(2, 'Introduction to Algorithms', 'UIT', 99, 2000),
(3, 'Lập Trình Và Cuộc Sống', 'Jeff Atwood', 100, 2000),
(4, 'Code Dạo Kí Sự', 'Phạm Huy Hoàng', 100, 5000),
(5, 'Giáo Trình C++ Và Lập Trình Hướng Đối Tượng ', 'Phạm Văn Ất & Lê Trường Thông', 100, 2000),
(6, 'Lập Trình C Toàn Tập Từ Cơ Bản Đến Nâng Cao', 'Hùng Minh & Mạnh Hùng', 100, 10000),
(7, 'Lập Trình Với C# Xây Dựng Ứng Dụng', 'Nhiều tác giả', 100, 1000),
(8, 'Kỹ Thuật Lập Trình Cơ Sở Với Ngôn Ngữ C/C ++', 'Dương Thăng Long & Trương Tiến Tùng', 100, 3000),
(9, 'Khái niệm lập trình', 'UIT', 100, 2000),
(10, 'Python', 'UIT', 100, 1000),
(11, 'Core Java', 'UIT', 101, 2000),
(12, 'Core Java nâng cao', 'UIT', 100, 20000),
(13, 'Effective Java', 'UIT', 100, 5000),
(14, 'Code Complete', 'UIT', 100, 2000),
(15, 'The Pragmatic Programmer', 'UIT', 100, 10000),
(16, 'Clean Code', 'UIT', 100, 1000),
(17, 'Introduction to Algorithms (CLRS)', 'UIT', 100, 1000),
(18, 'Data structure and Algorithms in Java', 'UIT', 100, 10000),
(20, 'Art of Computer Programming', 'UIT', 100, 20000);

SET IDENTITY_INSERT "book_details" OFF;

CREATE TABLE "issue_book_details" ;

SET IDENTITY_INSERT "issue_book_details" ON ;
INSERT INTO "issue_book_details" ("issue_id", "book_id", "book_name", "student_id", "student_name", "issue_date", "due_date", "status", "issue_fee") VALUES
(1, 7, 'Lập Trình Với C# Xây Dựng Ứng Dụng', 4, 'Lê Nguyễn Trung Đan', '2023-05-27', '2023-05-27', 'Returned', NULL),
(2, 20, 'Art of Computer Programming', 4, 'Lê Nguyễn Trung Đan', '2023-05-27', '2023-05-27', 'Returned', NULL),
(3, 17, 'Introduction to Algorithms (CLRS)', 4, 'Lê Nguyễn Trung Đan', '2023-05-27', '2023-05-27', 'Returned', NULL),
(4, 15, 'The Pragmatic Programmer', 4, 'Lê Nguyễn Trung Đan', '2023-05-27', '2023-05-27', 'Returned', NULL),
(5, 13, 'Effective Java', 7, 'Hoàng Thuỳ Linh', '2023-05-27', '2023-05-27', 'Returned', NULL),
(6, 20, 'Art of Computer Programming', 7, 'Hoàng Thuỳ Linh', '2023-05-27', '2023-05-27', 'Returned', NULL),
(7, 20, 'Art of Computer Programming', 2, 'Nghiêm Vũ Hoàng Long', '2023-05-27', '2023-05-27', 'Returned', NULL),
(8, 20, 'Art of Computer Programming', 10, 'Nguyễn Thị Hòa', '2023-05-27', '2023-05-27', 'Returned', NULL),
(9, 4, 'Code Dạo Kí Sự', 1, 'Lã Mai Win', '2023-05-27', '2023-05-27', 'Returned', NULL),
(10, 5, 'Giáo Trình C++ Và Lập Trình Hướng Đối Tượng ', 1, 'Lã Mai Win', '2023-05-20', '2023-05-20', 'Returned', NULL),
(11, 1, 'Tớ Học Lập Trình', 1, 'Lã Mai Win', '2023-05-31', '2023-05-31', 'Returned', NULL),
(12, 8, 'Kỹ Thuật Lập Trình Cơ Sở Với Ngôn Ngữ C/C ++', 5, 'Nguyễn Thanh Tùng', '2023-06-27', '2023-06-27', 'Returned', NULL),
(13, 4, 'Code Dạo Kí Sự', 3, 'Hoàng Kim Long', '2023-06-01', '2023-06-01', 'Returned', NULL),
(14, 1, 'Tớ Học Lập Trình', 3, 'Hoàng Kim Long', '2023-06-08', '2023-06-08', 'Returned', NULL),
(15, 1, 'Tớ Học Lập Trình', 1, 'Lã Mai Win', '2023-06-04', '2023-06-04', 'Returned', NULL),
(16, 2, 'Introduction to Algorithms', 1, 'Lã Mai Win', '2023-06-02', '2023-06-02', 'Returned', NULL),
(17, 20, 'Art of Computer Programming', 1, 'Lã Mai Win', '2023-06-09', '2023-06-09', 'Returned', NULL),
(18, 18, 'Data structure and Algorithms in Java', 1, 'Lã Mai Win', '2023-06-21', '2023-06-21', 'Returned', NULL),
(19, 4, 'Code Dạo Kí Sự', 2, 'Nghiêm Vũ Hoàng Long', '2023-06-17', '2023-06-17', 'Returned', NULL),
(20, 3, 'Lập Trình Và Cuộc Sống', 3, 'Hoàng Kim Long', '2023-06-16', '2023-06-16', 'Returned', NULL),
(21, 1, 'Tớ Học Lập Trình', 1, 'Lã Mai Win', '2023-06-12', '2023-06-12', 'Returned', NULL),
(22, 2, 'Introduction to Algorithms', 1, 'Lã Mai Win', '2023-06-12', '2023-06-12', 'Returned', NULL),
(23, 3, 'Lập Trình Và Cuộc Sống', 1, 'Lã Mai Win', '2023-06-12', '2023-06-12', 'Returned', NULL),
(24, 20, 'Art of Computer Programming', 1, 'Lã Mai Win', '2023-06-12', '2023-06-12', 'Returned', NULL),
(25, 10, 'Python', 1, 'Lã Mai Win', '2023-06-15', '2023-06-15', 'Returned', NULL),
(26, 16, 'Clean Code', 1, 'Lã Mai Win', '2023-06-30', '2023-06-30', 'Returned', NULL),
(27, 1, 'Tớ Học Lập Trình', 1, 'Lã Mai Win', '2023-06-14', '2023-06-14', 'Returned', NULL),
(28, 2, 'Introduction to Algorithms', 1, 'Lã Mai Win', '2023-06-14', '2023-06-14', 'Returned', NULL),
(29, 3, 'Lập Trình Và Cuộc Sống', 1, 'Lã Mai Win', '2023-06-14', '2023-06-14', 'Returned', 2000),
(30, 4, 'Code Dạo Kí Sự', 1, 'Lã Mai Win', '2023-06-14', '2023-06-14', 'Returned', 5000),
(31, 20, 'Art of Computer Programming', 1, 'Lã Mai Win', '2023-06-14', '2023-06-14', 'Returned', 20000),
(32, 3, 'Lập Trình Và Cuộc Sống', 3, 'Hoàng Kim Long', '2023-06-13', '2023-06-13', 'Returned', 2000),
(33, 1, 'Tớ Học Lập Trình', 14, 'Nguyễn Phước Thịnh', '2023-06-09', '2023-06-09', 'Returned', 1100),
(34, 10, 'Python', 10, 'Nguyễn Thị Hòa', '2023-06-04', '2023-06-10', 'Returned', 1100),
(35, 11, 'Core Java', 12, 'Mai Hồng Ngọc', '2023-05-22', '2023-05-29', 'Returned', 6000);

SET IDENTITY_INSERT "issue_book_details" OFF;

CREATE TABLE "student_details" ;

SET IDENTITY_INSERT "student_details" ON ;
INSERT INTO "student_details" ("student_id", "student_name", "branch", "year") VALUES
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

SET IDENTITY_INSERT "student_details" OFF;

CREATE TABLE "users" ;

SET IDENTITY_INSERT "users" ON ;
INSERT INTO "users" ("id", "name", "password", "email", "contact", "fee_pending", "fee_returned") VALUES
(1, '1234', '1234', '1234@gm.com', '1234', 0, 44200);

SET IDENTITY_INSERT "users" OFF;
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
