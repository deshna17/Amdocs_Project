create table user1(
user_id number primary key,
name varchar2(100),
phone_no number,
email varchar2(100),
address varchar2(100),
reg_date date,
password varchar2(100),
upload_photo long);

select * from feedback;

create table admin1( 
admin_id number primary key, 
name varchar2(100),
email varchar2(100), 
password varchar2(100));
create sequence userid start with 100 increment by 1;

create table feedback(
user_id number references user1,
f_id number primary key,
feedback_message varchar2(1000));

create sequence f_id start with 100 increment by 1;

create table course ( 
course_id number primary key, 
c_name varchar2(100),
c_desp varchar2(100), 
c_fees varchar2(100),
c_resource varchar2(100));

create sequence course_id start with 100 increment by 1;

create table enroll ( 
enroll_id number primary key,
user_id number references user1,
course_id number references course);

create sequence enroll_id start with 1000 increment by 1;