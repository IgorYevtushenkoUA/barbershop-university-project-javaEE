-- create table role #done
create table role
(
    role_id serial PRIMARY KEY,
    name    varchar(32) NOT NULL
);

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
    age          integer      not null,
    constraint fk_account_role_id
        foreign key (role_id)
            references role (role_id)
);

-- insert role #done
INSERT INTO public.role (name)
VALUES ('admin');
INSERT INTO public.role (name)
VALUES ('master');
INSERT INTO public.role (name)
VALUES ('client');

-- insert account #done
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('admin@gmail.com', 'password', 1, '111-11-01', 'admin', 'admin', 'admin', 27, 'w');
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('master1@gmail.com', 'mstrea1', 2, '222-22-02', 'master', 'master', 'master', 30, 'm');
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('master2@gmail.com', 'masert2', 2, '222-22-03', 'James', 'Tom', 'Bush', 37, 'm');
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('master3@gmail.com', 're3mast', 2, '222-22-04', 'Jackob', 'Becko', 'Tomson', 25, 'm');
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('master4@gmail.com', 're3mast', 2, '222-22-05', 'Ella', 'Fio', 'Fionew', 29, 'w');
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('client1@gmail.com', 'clien1t', 3, '333-33-01', 'client', 'client1', 'client1', 51, 'm');
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('client2@gmail.com', 'clie2nt', 3, '333-33-02', 'client2', 'client2', 'client2', 45, 'm');
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('client3@gmail.com', 'cl3ient', 3, '333-33-03', 'client3', 'client3', 'client3', 21, 'm');
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ('client4@gmail.com', 'tne4ilc', 3, '333-33-04', 'client4', 'client4', 'client4', 18, 'm');
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ( 'client5@gmail.com', 'cl5etnf', 3, '333-33-05', 'client5', 'client5', 'client5', 28, 'm');
INSERT INTO public.account (email, password, role_id, phone_number, first_name, second_name, last_name, age, gender) VALUES ( 'client6@gmail.com', 'ielcnt6', 3, '333-33-06', 'client6', 'client6', 'client6', 35, 'm');

-- table level #done
create table level
(
    level_id serial primary key,
    name     varchar(32)
);


-- table master #done
create table master
(
    master_id       serial        primary key,
    work_experience integer          not null,
    rating          double precision not null,
    level_id        integer          not null,
    constraint fk_master_account_id
        foreign key (master_id)
            references account (account_id),
    constraint fk_master_level_id
        foreign key (level_id)
            references level (level_id)
);

-- insert level #done
INSERT INTO public.level (name)
VALUES ('trainee');
INSERT INTO public.level (name)
VALUES ('master');



-- insert master #done
INSERT INTO public.master (master_id, work_experience, rating, level_id)
VALUES (2, 5, 4.8, 2);
INSERT INTO public.master (master_id, work_experience, rating, level_id)
VALUES (3, 4, 4.8, 2);
INSERT INTO public.master (master_id, work_experience, rating, level_id)
VALUES (4, 10, 5, 2);
INSERT INTO public.master (master_id, work_experience, rating, level_id)
VALUES (5, 1, 4.2, 1);


--
-- -- table procedure todo
-- create table procedure
-- (
--     procedure_id serial primary key,
--     name         varchar(64) not null,
--     price        integer     not null,
--     duration     integer     not null
-- );
--
-- -- table master_has_procedure todo
-- create table master_has_procedure
-- (
--     master_id    integer not null,
--     procedure_id integer not null,
--     constraint fk_master_has_procedure_master_id
--         foreign key (master_id)
--             references master (master_id),
--     constraint fk_master_has_procedure_procedure_id
--         foreign key (procedure_id)
--             references procedure (procedure_id),
--     constraint master_has_procedure_pk
--         primary key (master_id, procedure_id)
-- );
--
-- -- insert procedure todo
-- INSERT INTO public.procedure (name, price, duration)
-- VALUES ('Haircut (including fade)', 400, 30);
-- INSERT INTO public.procedure (name, price, duration)
-- VALUES ('Haircut with a clipper', 300, 30);
-- INSERT INTO public.procedure (name, price, duration)
-- VALUES ('Beard', 300, 30);
-- INSERT INTO public.procedure (name, price, duration)
-- VALUES ('Children''s haircut', 350, 30);
-- INSERT INTO public.procedure (name, price, duration)
-- VALUES ('Royal shave', 350, 30);
-- INSERT INTO public.procedure (name, price, duration)
-- VALUES ('Gray hair camouflage', 350, 30);
-- INSERT INTO public.procedure (name, price, duration)
-- VALUES ('Father + son', 650, 30);
--
-- -- insert master_has_procedure todo
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
