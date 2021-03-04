-- insert role
-- INSERT INTO public.role (name)
-- VALUES ('administrator');
-- INSERT INTO public.role (name)
-- VALUES ('master');
-- INSERT INTO public.role (name)
-- VALUES ('client');

-- -- insert account
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('admin@gmail.com', 'password', 1, '111-11-01', 'admin', 'admin', 'admin', 27, 'w');
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('master1@gmail.com', 'mstrea1', 2, '222-22-02', 'master', 'master', 'master', 30, 'm');
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('master2@gmail.com', 'masert2', 2, '222-22-03', 'James', 'Tom', 'Bush', 37, 'm');
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('master3@gmail.com', 're3mast', 2, '222-22-04', 'Jackob', 'Becko', 'Tomson', 25, 'm');
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('master4@gmail.com', 're3mast', 2, '222-22-05', 'Ella', 'Fio', 'Fionew', 29, 'w');
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('client1@gmail.com', 'clien1t', 3, '333-33-01', 'client', 'client1', 'client1', 51, 'm');
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('client2@gmail.com', 'clie2nt', 3, '333-33-02', 'client2', 'client2', 'client2', 45, 'm');
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('client3@gmail.com', 'cl3ient', 3, '333-33-03', 'client3', 'client3', 'client3', 21, 'm');
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('client4@gmail.com', 'tne4ilc', 3, '333-33-04', 'client4', 'client4', 'client4', 18, 'm');
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ( 'client5@gmail.com', 'cl5etnf', 3, '333-33-05', 'client5', 'client5', 'client5', 28, 'm');
-- INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ( 'client6@gmail.com', 'ielcnt6', 3, '333-33-06', 'client6', 'client6', 'client6', 35, 'm');

-- -- insert status
-- INSERT INTO public.status (name)
-- VALUES ('confirmed');
-- INSERT INTO public.status (name)
-- VALUES ('done');
--
-- -- insert level
-- INSERT INTO public.level (name)
-- VALUES ('trainee');
-- INSERT INTO public.level (name)
-- VALUES ('master');

-- insert procedure
INSERT INTO public.procedure (name, price, duration)
VALUES ('Haircut (including fade)', 400, 30);
INSERT INTO public.procedure (name, price, duration)
VALUES ('Haircut with a clipper', 300, 30);
INSERT INTO public.procedure (name, price, duration)
VALUES ('Beard', 300, 30);
INSERT INTO public.procedure (name, price, duration)
VALUES ('Children''s haircut', 350, 30);
INSERT INTO public.procedure (name, price, duration)
VALUES ('Royal shave', 350, 30);
INSERT INTO public.procedure (name, price, duration)
VALUES ('Gray hair camouflage', 350, 30);
INSERT INTO public.procedure (name, price, duration)
VALUES ('Father + son', 650, 30);
--
-- -- insert master
-- INSERT INTO public.master (account_id, work_experience, rating, level_id)
-- VALUES (2, 5, 4.8, 2);
-- INSERT INTO public.master (account_id, work_experience, rating, level_id)
-- VALUES (3, 4, 4.8, 2);
-- INSERT INTO public.master (account_id, work_experience, rating, level_id)
-- VALUES (4, 10, 5, 2);
-- INSERT INTO public.master (account_id, work_experience, rating, level_id)
-- VALUES (5, 1, 4.2, 1);
--
-- -- insert master_has_procedure
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (2, 1);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (2, 2);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (2, 3);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (2, 4);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (3, 1);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (3, 2);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (3, 3);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (3, 7);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (3, 6);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (3, 5);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (4, 1);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (4, 3);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (4, 5);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (4, 7);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (5, 2);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (5, 4);
-- INSERT INTO public.master_has_procedure (master_id, procedure_id)
-- VALUES (5, 6);
--
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (6, 2, 1, '2021-01-10 10:00:00.000000', 2, '2021-01-11 10:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (7, 2, 2, '2021-01-12 10:00:00.000000', 2, '2021-01-13 11:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (7, 3, 1, '2021-01-12 19:00:00.000000', 2, '2021-01-13 15:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (7, 3, 1, '2021-01-13 14:00:00.000000', 2, '2021-01-20 13:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (7, 4, 1, '2021-01-15 15:00:00.000000', 2, '2021-01-20 14:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (8, 5, 2, '2021-01-17 14:00:00.000000', 2, '2021-01-20 15:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (8, 5, 6, '2021-01-20 11:00:00.000000', 2, '2021-01-25 16:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (8, 2, 3, '2021-01-21 12:00:00.000000', 2, '2021-01-25 17:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (9, 2, 4, '2021-01-21 17:00:00.000000', 2, '2021-01-25 18:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (9, 4, 7, '2021-01-22 15:00:00.000000', 2, '2021-01-25 19:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (9, 4, 7, '2021-01-25 15:00:00.000000', 2, '2021-01-26 10:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (9, 4, 5, '2021-01-25 15:00:00.000000', 2, '2021-01-27 11:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (10, 4, 3, '2021-01-25 15:00:00.000000', 2, '2021-01-28 12:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (10, 3, 3, '2021-01-27 14:00:00.000000', 1, '2021-02-05 13:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (10, 3, 2, '2021-01-27 13:00:00.000000', 1, '2021-02-06 00:00:00.000000');
-- INSERT INTO public.record (client_id, master_id, procedure_id, record_time, status_id, procedure_time_record)
-- VALUES (11, 2, 1, '2021-01-28 11:00:00.000000', 1, '2021-02-10 20:00:00.000000');
--
-- -- insert comment
-- INSERT INTO public.comment (record_id, user_comment, rating, comment_time)
-- VALUES (1, 'perfect job', 5, '2021-01-10');
-- INSERT INTO public.comment (record_id, user_comment, rating, comment_time)
-- VALUES (5, 'good job', 5, '2021-01-16');
-- INSERT INTO public.comment (record_id, user_comment, rating, comment_time)
-- VALUES (10, 'best master', 5, '2021-01-24');
-- INSERT INTO public.comment (record_id, rating, comment_time)
-- VALUES (11, 4, '2021-01-26');

