create table ho_gia_dinh(
	id varchar(5) not null primary key,
	ho_ten_chu_ho nvarchar(30),
	so_nhan_khau int not null,
	dia_chi nvarchar(50) not null,
	trang_thai int not null, -- 1 la dang sinh song con 0 la da roi di
	thoi_gian_den date, 
    thoi_gian_roi_di date,
	constraint check_trangthai_hogiadinh check (trang_thai in (0, 1)),
	constraint check_thoigian check (thoi_gian_roi_di > thoi_gian_den)
);

create table phi(
	id varchar(3) not null primary key,
	ten_phi nvarchar(20) not null,
	thoi_gian_thu date,
	don_gia int not null, -- So tien tren dau nguoi
	muc_dich nvarchar(50)
);

create table tra_phi(
	id int primary key AUTO_INCREMENT,
	phi_id varchar(3) not null,
	hogiadinh_id varchar(5) not null,
	trang_thai int not null, -- 1 la da dong, 0 la chua dong
	thoi_gian_dong date,
	ghi_chu nvarchar(50),
	constraint traphi_fk_phi foreign key (phi_id) references phi(id)
	ON DELETE CASCADE,
	constraint traphi_fk_hogiadinh foreign key (hogiadinh_id) references ho_gia_dinh(id)
	ON DELETE CASCADE,
	constraint check_trangthai_traphi check (trang_thai in (0,1))
);

create table dong_gop(
	id varchar(4) not null primary key,
	ten_dong_gop nvarchar(20) not null,
	muc_dich nvarchar(50)
);

create table ung_ho(
	id int primary key AUTO_INCREMENT,
	donggop_id varchar(4) not null,
	hogiadinh_id varchar(5) not null,
	so_tien int not null,
	thoi_gian date,
	constraint ungho_fk_donggop foreign key (donggop_id) references dong_gop(id)
	ON DELETE CASCADE,
	constraint ungho_fk_hogiadinh foreign key (hogiadinh_id) references ho_gia_dinh(id)
	ON DELETE CASCADE
);

CREATE TABLE Persons (
    Personid int PRIMARY KEY AUTO_INCREMENT,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int
);