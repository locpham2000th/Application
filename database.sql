create table ho_gia_dinh(
	id varchar(5) not null primary key,
	ho_ten_chu_ho varchar(30),
	so_nhan_khau int not null,
	dia_chi varchar(50) not null,
	trang_thai int not null, -- 1 la dang sinh song con 0 la da roi di
	constraint check_trangthai_hogiadinh check (trang_thai in (0, 1))
);

create table phi(
	id varchar(3) not null primary key,
	ten_phi varchar(20) not null,
	thoi_gian date not null,
	don_gia int not null, -- So tien tren dau nguoi
	muc_dich varchar(50)
);

create table tra_phi(
	id int primary key AUTO_INCREMENT,
	phi_id varchar(3) not null,
	hogiadinh_id varchar(5) not null,
	thoi_gian_dong date not null,
	constraint traphi_fk_phi foreign key (phi_id) references phi(id)
	ON DELETE CASCADE,
	constraint traphi_fk_hogiadinh foreign key (hogiadinh_id) references ho_gia_dinh(id)
	ON DELETE CASCADE
);

create table dong_gop(
	id varchar(3) not null primary key,
	ten_dong_gop varchar(20) not null,
	muc_dich varchar(50),
    thoi_gian date not null,
    ghi_chu varchar(50)
);

create table ung_ho(
	id int primary key AUTO_INCREMENT,
	donggop_id varchar(3) not null,
	hogiadinh_id varchar(5) not null,
	so_tien int not null,
	thoi_gian date not null,
	constraint ungho_fk_donggop foreign key (donggop_id) references dong_gop(id)
	ON DELETE CASCADE,
	constraint ungho_fk_hogiadinh foreign key (hogiadinh_id) references ho_gia_dinh(id)
	ON DELETE CASCADE
);
