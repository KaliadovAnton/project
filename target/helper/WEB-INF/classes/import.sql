--TODO add some tables

insert into `user` (first_name, last_name, email, password, role, enable) values ('Ivan', 'Ivanov', 'user1_mogilev@yopmail.com', '$2a$10$gIywooeWyTcbm5ZGKSKAOOeDCJ6FaCkbE1K18o6Qyb/2r70fdONQq', '0', 'true');
insert into `user` (first_name, last_name, email, password, role, enable) values ('Piotr', 'Petrov', 'user2_mogilev@yopmail.com', '$2a$10$gIywooeWyTcbm5ZGKSKAOOeDCJ6FaCkbE1K18o6Qyb/2r70fdONQq', '0', 'true');
insert into `user` (first_name, last_name, email, password, role, enable) values ('Igor', 'Igorev', 'manager1_mogilev@yopmail.com', '$2a$10$gIywooeWyTcbm5ZGKSKAOOeDCJ6FaCkbE1K18o6Qyb/2r70fdONQq', '1', 'true');
insert into `user` (first_name, last_name, email, password, role, enable) values ('Victor', 'Victorov', 'manager2_mogilev@yopmail.com', '$2a$10$gIywooeWyTcbm5ZGKSKAOOeDCJ6FaCkbE1K18o6Qyb/2r70fdONQq', '1', 'true');
insert into `user` (first_name, last_name, email, password, role, enable) values ('Sergei', 'Sergeev', 'engineer1_mogilev@yopmail.com', '$2a$10$gIywooeWyTcbm5ZGKSKAOOeDCJ6FaCkbE1K18o6Qyb/2r70fdONQq', '2', 'true');
insert into `user` (first_name, last_name, email, password, role, enable) values ('Kirill', 'Kirillov', 'engineer2_mogilev@yopmail.com', '$2a$10$gIywooeWyTcbm5ZGKSKAOOeDCJ6FaCkbE1K18o6Qyb/2r70fdONQq', '2', 'true');
insert into `user` (first_name, last_name, email, password, role, enable) values ('Anton', 'Kaliadov', 'kaabadday@gmail.com', '$2a$10$RVcZ1eDvcWNKIpZFJsjbse7FLuJh6An4/VGXKn3ylLPUgWsJDDgY.', '2', 'true');
insert into category (id, name) values ('1', 'common');
insert into ticket (name, description, created_on, desired_resolution_date, assignee_id, owner_id, category_id, approver_id, state_id, urgency_id) values ('test', 'test', '2020-11-11 15:30:14.332', '2020-11-15 15:30:14.332', '1', '3', '1', '4', '2','2');
insert into ticket (name, description, created_on, desired_resolution_date, assignee_id, owner_id, category_id, approver_id, state_id, urgency_id) values ('test1', 'test1', '2020-11-10 15:30:14.332', '2020-10-15 15:30:14.332', '2', '2', '1', '1', '3','3');