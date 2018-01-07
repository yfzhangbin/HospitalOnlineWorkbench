use hospitalonlinenworkbench

-- 插入测试数据
-- 科室信息
insert into department (id, name, address) values (null, '内科', '1号楼101室');
insert into department (id, name, address) values (null, '外科', '1号楼201室');
insert into department (id, name, address) values (null, '儿科', '2号楼110室');
insert into department (id, name, address) values (null, '骨科', '3号楼201室');
insert into department (id, name, address) values (null, '急救科', '1号楼120室');
insert into department (id, name, address) values (null, '检验科', '3号楼001室');

-- 医生信息
insert into doctor (id, name, sex, birthday, phone, level, department_id) values (null, '李林', '男', '1972-10-23', '13739484831', '正式', 1);
insert into doctor (id, name, sex, birthday, phone, level, department_id) values (null, '张灿', '女', '1970-08-13', '13339234832', '主任', 1);
insert into doctor (id, name, sex, birthday, phone, level, department_id) values (null, '宋燕', '男', '1974-01-04', '13439434833', '正式', 2);
insert into doctor (id, name, sex, birthday, phone, level, department_id) values (null, '吴刚', '女', '1982-03-22', '13539544834', '副主任', 2);
insert into doctor (id, name, sex, birthday, phone, level, department_id) values (null, '赵强', '男', '1984-02-14', '13639244835', '教授', 3);
insert into doctor (id, name, sex, birthday, phone, level, department_id) values (null, '马千里', '女', '1990-01-01', '13739464836', '副主任', 4);
insert into doctor (id, name, sex, birthday, phone, level, department_id) values (null, '马腾飞', '男', '1974-05-20', '13839574837', '主任', 4);
insert into doctor (id, name, sex, birthday, phone, level, department_id) values (null, '李珍', '女', '1961-10-12', '13939684838', '实习', 5);
insert into doctor (id, name, sex, birthday, phone, level, department_id) values (null, '王时', '男', '1988-09-09', '13039894839', '教授', 5);
insert into doctor (id, name, sex, birthday, phone, level, department_id) values (null, '刘艳艳', '女', '1958-12-09', '13439895830', '教授', 6);	

-- 病人信息
insert into patient (id, name, sex, birthday, phone) values (null, '李晶晶', '男', '1992-03-23', '13239384733');
insert into patient (id, name, sex, birthday, phone) values (null, '赵顽强', '男', '1971-02-13', '15331484829');
insert into patient (id, name, sex, birthday, phone) values (null, '林木森', '男', '1961-01-20', '17739384832');
insert into patient (id, name, sex, birthday, phone) values (null, '王栋', '男', '1995-04-06', '13740213835');
insert into patient (id, name, sex, birthday, phone) values (null, '邱邵', '男', '1984-10-13', '13740424832');
insert into patient (id, name, sex, birthday, phone) values (null, '孙莉莉', '女', '1997-03-24', '13149484833');
insert into patient (id, name, sex, birthday, phone) values (null, '赵宝刚', '男', '1995-06-23', '15739584238');
insert into patient (id, name, sex, birthday, phone) values (null, '冯川', '男', '1987-03-07', '17339663833');
insert into patient (id, name, sex, birthday, phone) values (null, '王大陆', '男', '1979-09-19', '14712384831');
insert into patient (id, name, sex, birthday, phone) values (null, '李昆', '男', '1991-10-23', '15274948323');

-- 检查信息
insert into examination (id, doctor_id, patient_id, result) values (null, 10, 1, '血液化验');
insert into examination (id, doctor_id, patient_id, result) values (null, 10, 3, '尿液检测');
insert into examination (id, doctor_id, patient_id, result) values (null, 10, 5, '胸透');

-- 诊断信息
insert into diagnosis (id, doctor_id, patient_id, result) values (null, 1, 1, '流感');
insert into diagnosis (id, doctor_id, patient_id, result) values (null, 2, 3, '皮肤感染');
insert into diagnosis (id, doctor_id, patient_id, result) values (null, 4, 5, '骨折');

-- 挂号信息
insert into registration (id, patient_id, department_id, examination_id, diagnosis_id, status) values (null, 1, 1, 1, 1, '诊断');
insert into registration (id, patient_id, department_id, examination_id, diagnosis_id, status) values (null, 3, 1, 2, 2, '诊断');
insert into registration (id, patient_id, department_id, examination_id, diagnosis_id, status) values (null, 5, 3, 3, 3, '诊断');

