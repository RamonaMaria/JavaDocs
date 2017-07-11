select * from emp;

CREATE TABLE LOCATIONS (
LOCATION_ID     NUMBER PRIMARY KEY,
  STREET_ADDRESS  VARCHAR2(40),
  POSTAL_CODE     VARCHAR2(12),
  CITY            VARCHAR2(30)     NOT NULL,
  STATE_PROVINCE  VARCHAR2(25)
);


create table DEPARTMENTS (
  DEPARTMENT_ID    NUMBER PRIMARY KEY,
  DEPARTMENT_NAME  VARCHAR2(30)            NOT NULL,
  LOCATION_ID      NUMBER
);

create table JOBS (
JOB_ID      NUMBER PRIMARY KEY,
  JOB_TITLE   VARCHAR2(35)                 NOT NULL,
  MIN_SALARY  NUMBER(6),
  MAX_SALARY  NUMBER(6)

);

create table EMPLOYEES (
  EMPLOYEE_ID     NUMBER PRIMARY KEY,
  FIRST_NAME      VARCHAR2(20),
  LAST_NAME       VARCHAR2(25)     NOT NULL,
  EMAIL           VARCHAR2(25)     NOT NULL,
  PHONE_NUMBER    VARCHAR2(20),
  HIRE_DATE       DATE                  NOT NULL,
  JOB_ID          VARCHAR2(10)     NOT NULL,
  SALARY          NUMBER(8,2),
  COMMISSION_PCT  NUMBER(2,2),
  MANAGER_ID      NUMBER,
  DEPARTMENT_ID   NUMBER
);


alter table EMPLOYEES 
add constraint FK_EMPLOYEES_DEPARTMENTS
foreign key (DEPARTMENT_ID) references DEPARTMENTS(DEPARTMENT_ID);


alter table EMPLOYEES
add constraint FK_EMPLOYEES_EMPL_MANAGER
foreign key (JOB_ID) references JOBS(JOB_ID)

alter table EMPLOYEES 
add constraint FK_EMPLOYEES_DEPARTMENTS
foreign key (MANAGER_ID) references EMPLOYEES(EMPLOYEE_ID);

select * from employees;
select * from jobs;
select * from departments;

select first_name, last_name
from employees;

select * from employees where department_id=50;

update employees 
set salary=0.3*salary+salary
where department_id=50;

delete from employees
where EMPLOYEE_ID=101;


select * from employees
where job_id='IT_PROG'
order by first_name;


select *
from employees e
inner join departments
on employees.department_id=departments.department_id
where e.department_id=50;


select employees.*, locations.city
from employees
inner join (departments inner join locations on departments.location_id=locations.location_id) on employees.department_id=departments.department_id
where departments.location_id=1700;


create view employees_view as
select employees.employee_id, employees.first_name, departments.department_name
from employees 
inner join departments on employees.department_id=departments.department_id;

select UPPER(first_name), LOWER(last_name)
from employees; 


select  'first_name: ' || first_name
from employees; 

select count(*)
from employees;

select count(*)
from employees
where job_id='IT_PROG';


select department_id, count(employee_id),
from employees
group by department_id;

select avg(salary)
from employees
where department_id=50;

select max(salary), min(salary)
from employees
inner join (departments inner join locations on departments.location_id=locations.location_id) on employees.department_id=departments.department_id
where departments.location_id=1700;
