-- table account #done
create table account
(
    account_id   serial primary key,
    email        varchar(128) not null,
    password     varchar(255) not null,
    role_id      integer      not null,
    phone_number varchar(255) not null,
    first_name   varchar(255) not null,
    second_name  varchar(255) not null,
    last_name    varchar(255) not null,
    gender       char         not null,
    age          integer      not null
);

-- table master #done
create table master
(
    account_id       integer       primary key,
    work_experience integer          not null,
    rating          double precision not null,
    level_id        integer          not null,
    constraint fk_master_account
        foreign key (account_id)
            references account (account_id)
);

-- -- insert account #done
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
--
--
-- -- insert master #done
-- INSERT INTO public.master (master_id, work_experience, rating, level_id)
-- VALUES (2, 5, 4.8, 2);
-- INSERT INTO public.master (master_id, work_experience, rating, level_id)
-- VALUES (3, 4, 4.8, 2);
-- INSERT INTO public.master (master_id, work_experience, rating, level_id)
-- VALUES (4, 10, 5, 2);
-- INSERT INTO public.master (master_id, work_experience, rating, level_id)
-- VALUES (5, 1, 4.2, 1);
