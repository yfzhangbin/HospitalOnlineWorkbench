-- 创建数据库
create database hospitalonlinenworkbench
use hospitalonlinenworkbench

-- 创建表
-- 科室信息
create table if not exists department (
	id int auto_increment comment '编号',
	name varchar(50) comment '科室姓名',
	address varchar(200) comment '科室地址',
	createtime datetime default now() comment '创建时间',
	updatetime datetime default now() comment '修改时间',
	primary key (id)
);

-- 医生信息
create table if not exists doctor (
	id int auto_increment comment '编号',
	name varchar(50) comment '姓名',
	sex varchar(10) comment '性别',
	birthday datetime comment '出生年月日',
	phone varchar(20) comment '电话号码',
	level varchar(20) comment '医师级别: 实习、正式、副主任、主任、教授',
	department_id int comment '所属科室编号',
	createtime datetime default now() comment '创建时间',
	updatetime datetime default now() comment '修改时间',
	primary key (id)
);

-- 病人信息
create table if not exists patient (
	id int auto_increment comment '编号',
	name varchar(50) comment '姓名',
	sex varchar(10) comment '性别',
	birthday datetime comment '出生年月日',
	phone varchar(20) comment '电话号码',
	createtime datetime default now() comment '创建时间',
	updatetime datetime default now() comment '修改时间',
	primary key (id)
);

-- 检查信息
create table if not exists examination (
	id int auto_increment comment '编号',
	doctor_id int comment '医生编号',
	patient_id int comment '病人编号',
	result varchar(200) comment '检查结果',
	createtime datetime default now() comment '检查时间',
	updatetime datetime default now() comment '修改时间',
	primary key (id)
);

-- 诊断信息
create table if not exists diagnosis (
	id int auto_increment comment '编号',
	doctor_id int comment '医生编号',
	patient_id int comment '病人编号',
	result varchar(200) comment '诊断结果',
	createtime datetime default now() comment '创建时间',
	updatetime datetime default now() comment '修改时间',
	primary key (id)
);

-- 挂号信息
create table if not exists registration (
	id int auto_increment comment '编号',
	patient_id int comment '病人编号',
	department_id int comment '科室编号',
	examination_id int comment '检查编号',
	diagnosis_id int comment '诊断编号',
	status varchar(20) comment '就医状态：挂号、检查、诊断',
	createtime datetime default now() comment '挂号时间',
	updatetime datetime default now() comment '修改时间',
	primary key (id)
);

