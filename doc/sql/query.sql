-- 查询科室列表
select * from department;

-- 查询某科室下医生列表
select * from doctor where department_id = 1;

-- 查询病人信息
select * from patient where id = 1;

-- 查询某个病人就诊情况
select * from registration where id = 1;

-- 查询就诊排队情况
select count(1) from registration where department_id = 1;

