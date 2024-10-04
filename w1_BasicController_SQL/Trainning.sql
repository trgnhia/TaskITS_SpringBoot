CREATE TABLE SinhVien (
    id INT PRIMARY KEY,
    name NVARCHAR(255),
    age INT,
    class VARCHAR(50),
    gpa FLOAT
);

insert into SinhVien(id, name, age, class, gpa) values
	(1, N'Doãn Thị Ngọc Mai', 20, 'LQT50C1', 3.9),
    (2, N'Nguyễn Văn A', 22, 'LQT50C1', 3.12),
	(3, N'Nguyễn Văn B', 18, 'LQT50C1', 3.4),
	(4, N'Nguyễn Văn C', 19, 'LQT50C1', 2.93);
    
create table Khoa(
TenKhoa nchar(60) not null primary key,
Students int 
)

insert into  Khoa (TenKhoa, Students) values
	('CNTT', 1200),
    ('LQT', 778),
    ('KTPM', 1004),
    ('HTTT', 1050),
    ('KT', 990),
    ('NNA', 560);

create table MonHoc(
TenMH nvarchar(255) not null primary key,
Tenkhoa nchar(60), 
SL int, 
DiemTB float, 
Constraint TenKhoa FOREIGN KEY (TenKhoa) REFERENCES Khoa(TenKhoa)
);

insert into MonHoc (TenMH, TenKhoa, SL, DiemTB) values
	(N'Học máy', 'CNTT', 200, 2.134),
    (N'Trí tuệ nhân tạo', 'HTTT', 135, 2.4),
    (N'Luật biển', 'LQT', 120, 2.56),
    (N'Kinh tế số', 'KT', 221, 1.92),
	(N'Listening', 'NNA', 345, 1.52),
	(N'Lập trình java', 'KTPM', 121, 3.0);
	(N'Chuyên đề CNTT', 'CNTT', 216, 3.44),
    (N'Data ', 'HTTT', 166, 3.76),
    (N'Luật dân sự', 'LQT', 168, 2.75),
    (N'Toán rời rạc', 'KT', 233, 3.2),
	(N'Reading', 'NNA', 367, 3.12),
	(N'Lập trình C#', 'KTPM', 222, 2.23);
    
 -- LỆNH SELECT CẢ BẢNG   
select *from MonHoc;
select * from Khoa;
select * from SinhVienVuotKho;

 -- LỆNH SELECT CÓ ĐK
select * from SinhVien where name = N'Nguyễn Văn A';
select * from SinhVien where gpa > 3.2
select * from SinhVien where gpa <= 3.12 and age > 19 
select * from SinhVien order by gpa desc;
select * from SinhVien order by gpa asc;
Delete from SinhVien where id = 3;
select avg(gpa) as DiemTB from SinhVien

-- LỆNH TRUY CẬP VÀO BẢNG
alter table SinhVien drop column class;
alter table SinhVien add khoa nchar(60);
Alter table SinhVien change column khoa TenKhoa nchar(60)

-- LỆNH UPDATE GIÁ TRỊ
Update SinhVien set khoa = 'CNTT' where id = 1;
update SinhVien set khoa = Case
	when id = 2 then 'LQT'
    when id = 3 then 'KTPM'
    when id = 4 then 'KT'
End
where id in (2,3,4);

update SinhVien set Tenkhoa = Case
	when id = 3 then 'LQT'
    when id = 5 then 'HTTT'
    when id = 6 then 'CNTT'
	when id = 7 then 'NNA'
	when id = 8 then 'CNTT'
End
where id in (3,5,6,7,8);

-- Sửa tên 1 bảng
rename table SinhVien to SinhVienVuotKho;   

-- TÍNH TỔNG SỐ LƯỢNG SINH VIÊN VƯỢT KHÓ TRONG MỖI KHOA, HIỂN THỊ NHỮNG KHOA CÓ NHIỀU HƠN 2 SINH VIÊN VƯỢT KHÓ SẮP XẾP THEO THỨ TỰ GIẢM DẦN CỦA SỐ LƯỢNG SV

SELECT sv.TenKhoa, COUNT(sv.id) AS SoLuongSinhVienVuotKho
FROM SinhVienVuotKho sv
GROUP BY sv.TenKhoa
HAVING COUNT(sv.id) > 2
ORDER BY SoLuongSinhVienVuotKho DESC;


-- TÌM CÁC MÔN HỌC CÓ ĐIỂM TB > 2.5 VÀ NẰM TRONG KHOA CÓ ÍT HƠN 1000 SV
SELECT mh.TenMH, mh.DIemTB, k.TenKhoa
From MonHoc mh
Join Khoa k on mh.tenKhoa = k.TenKhoa
where mh.DiemTB > 2.5 And k.Students < 1000;
 
 -- Tìm điểm trung bình của mỗi khoa biết điểm trung bình của 1 khoa được tính bằng (tổng điểm trung bình của mỗi môn trong khoa) / số lượng môn
SELECT mh.TenKhoa , SUM(mh.DiemTB) / COUNT(mh.TenMH) AS DiemTrungBinhKhoa
FROM MonHoc mh
GROUP BY mh.TenKhoa;

 -- Tìm danh sách tất cả sinh viên có GPA cao hơn GPA trung bình của khoa sinh viên đó thuộc về.
 
Select sv.id, sv.name , sv.gpa, sv.TenKhoa
From SInhVienVuotKho sv 
join ( 
SELECT mh.TenKhoa , SUM(mh.DiemTB) / COUNT(mh.TenMH) AS DiemTrungBinhKhoa
FROM MonHoc mh
GROUP BY mh.TenKhoa
) as khoaTB on sv.TenKhoa = KhoaTB.TenKhoa
WHERE sv.gpa > KhoaTB.DiemTrungBinhKhoa;


 -- tìm số lượng sinh viên trong khoa công nghệ thông tin nhưng không đăng kí môn học máy
 select (k.students - mh.SL) as SvHocCNTT_0_HocMay
 from Khoa k
 join MonHoc mh on mh.TenKhoa = k.TenKhoa
 where k.tenKhoa = 'CNTT' AND mh.TenMH = N'Học Máy'
 