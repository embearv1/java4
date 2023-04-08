create database QLClip
go

use QLClip
go

create table [user](
id int primary key identity,
username varchar(12) not null,
password varchar(20) not null,
name nvarchar(90) not null,
email varchar(40) not null,
isAdmin bit default 0,
active bit default 1
)

create table type_video(
id int primary key identity,
name nvarchar(90) not null,
isAtive bit default 1
)

create table video(
id int primary key identity,
title nvarchar(225),
id_type int foreign key references type_video(id),
href varchar(50),
poster varchar(90) null,
[views] int not null default 0,
shares int not null default 0,
[description] nvarchar(225),
active bit default 1
)

create table history(
id int primary key identity,
id_user int foreign key references [user](id),
id_video int foreign key references video(id),
viewDate datetime default getDate(),
isLiked bit default 0,
likedDate datetime null
)



insert into video(title,id_type,href,poster,[description],active) values
('Doraemon New TV Series',4,'FLEyhngrNE0','https://animehay.live/upload/poster/292.jpg',N'Các câu chuyện trong Doraemon thường có một công thức chung, đó là xoay quanh những rắc rối hay xảy ra với cậu bé Nobita học lớp bốn, nhân vật chính thứ nhì của bộ truyện.',1),
('Pokemon: Mezase Pokemon Master',5,'Axp2_wBIccU','https://animehay.live//upload/poster/3710.jpg',N'Câu chuyện kể về chuyến hành trình hướng tới ước mơ của Satoshi và Pikachu.',1),
('Do It Yourself!!',2,'lG0qqYjZI1I','https://animehay.live//upload/poster/3618.jpg',N'Bộ phim kể về cuộc sống hàng ngày của 6 nữ sinh trung học.',1),
('UniteUp!',7,'XanDesgOJLw','https://animehay.live//upload/poster/3702.jpg',N'Bộ phim về âm nhạc',1),
('Kubo-san wa Mob o Yurusanai',1,'lu-EhVdMdPI','https://animehay.live/upload/poster/981.jpg',N'Học sinh trung học Junta Shiraishi có một mục tiêu đơn giản là sống một tuổi trẻ viên mãn.',1),
('Record of Ragnarok Season 2',7,'-YXtKo2tNnw','https://animehay.live//upload/poster/3712.jpg','7 triệu năm lịch sử của loài người đang đứng trước thời khắc kết thúc dưới bàn tay của thần thánh. Để ngăn cản điều này, Valkyrie quyết định đề xuất cho loài người một cơ hội chống lại quyết định của thần thánh',1),

('Shigatsu wa Kimi no Uso',6,'s5rMX_Akar4','https://animehay.live/upload/poster/75.jpg',N'Câu chuyện kể về Arima Kousei, một thần đồng piano. Nhưng kể từ sau chấn động tâm lí do cái sự qua đời của mẹ cậu, Kosei đã không thể nghe thấy bất kì âm thanh nào.',1)

insert into type_video(name) values(N'Âm nhạc')

select * from type_video
select * from video 

select * from history

SELECT id_video
FROM history
WHERE isLiked = 1
GROUP BY id_video
Order by COUNT(DISTINCT id_user) desc

select * from account


select * from Video v where v.id in 
			 (select top 3 id_video from History his where his.isLiked = 1 
			 group by id_video 
			 order by count(distinct id_user) desc)

Alter table type_video add  isActive bit;

select * from type_video
update type_video set isActive = 1