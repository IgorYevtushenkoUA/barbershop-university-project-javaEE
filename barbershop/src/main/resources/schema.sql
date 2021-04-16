-- table role #done
create table if not exists role
(
    role_id serial PRIMARY KEY,
    name    varchar(32) NOT NULL
);

-- table account  #done
create table if not exists account
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

-- table status
create table if not exists status
(
    status_id serial primary key,
    name      varchar(32) not null
);

-- table level
create table if not exists level
(
    level_id serial primary key,
    name     varchar(32)
);

-- table procedure
create table if not exists procedure
(
    procedure_id serial primary key,
    name         varchar(64) not null,
    price        integer     not null,
    duration     integer    not null
);

-- table master
create table if not exists master
(
    account_id       integer primary key,
    work_experience integer          not null,
    rating          double precision not null,
    level_id        integer          not null,
    photo           varchar(512)           ,
    constraint fk_master_account_id
        foreign key (account_id)
            references account (account_id),
    constraint fk_master_level_id
        foreign key (level_id)
            references level (level_id)
);
-- admin
create table if not exists admin
(
    account_id integer primary key,
    constraint fk_admin_account foreign key (account_id) references account (account_id)
);

-- client
create table if not exists client
(
    account_id integer primary key,
    constraint fk_admin_account foreign key (account_id) references account (account_id)
);


-- table master_has_procedure
create table if not exists master_has_procedure
(
    master_id    integer not null,
    procedure_id integer not null,
    constraint fk_master_has_procedure_account_id
        foreign key (master_id)
            references master (account_id),
    constraint fk_master_has_procedure_procedure_id
        foreign key (procedure_id)
            references procedure (procedure_id),
    constraint master_has_procedure_pk
        primary key (master_id, procedure_id)
);

create table if not exists record
(
    record_id             serial primary key,
    client_id             integer   not null,
    master_id             integer   not null,
    procedure_id          integer   not null,
    record_time           timestamp not null,
    status_id             integer   not null,
    procedure_start timestamp not null,
    procedure_finish timestamp not null,
    constraint fk_record_client_id
        foreign key (client_id)
            references client (account_id),
    constraint fk_record_master_id
        foreign key (master_id)
            references master (account_id),
    constraint fk_record_procedure_id
        foreign key (procedure_id)
            references procedure (procedure_id),
    constraint fk_record_status_id
        foreign key (status_id)
            references status (status_id)
);

-- table comment
create table if not exists comment
(
    comment_id   serial primary key,
    record_id    integer not null,
    user_comment varchar(2048) null,
    rating       integer not null,
    comment_time date    not null,
    constraint fk_comment_record_id
        foreign key (record_id)
            references record (record_id)
);

