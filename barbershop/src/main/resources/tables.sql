-- table role
create table role
(
    role_id serial PRIMARY KEY,
    name    varchar(32) NOT NULL
);

-- table account
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

-- table status
create table status
(
    status_id serial primary key,
    name      varchar(32) not null
);

-- table level
create table level
(
    level_id serial primary key,
    name     varchar(32)
);

-- table procedure
create table procedure
(
    procedure_id serial primary key,
    name         varchar(64) not null,
    price        integer     not null,
    duration     integer     not null
);

-- table master
create table master
(
    master_id       serial           not null,
    work_experience integer          not null,
    rating          double precision not null,
    level_id        integer          not null,
    constraint fk_master_account_id
        foreign key (master_id)
            references account (account_id),
    constraint fk_master_level_id
        foreign key (level_id)
            references level (level_id),
    constraint master_master_id_pk
        primary key (master_id)

);

-- table master_has_procedure
create table master_has_procedure
(
    master_id    integer not null,
    procedure_id integer not null,
    constraint fk_master_has_procedure_master_id
        foreign key (master_id)
            references master (master_id),
    constraint fk_master_has_procedure_procedure_id
        foreign key (procedure_id)
            references procedure (procedure_id),
    constraint master_has_procedure_pk
        primary key (master_id, procedure_id)
);

create table record
(
    record_id             serial primary key,
    client_id             integer   not null,
    master_id             integer   not null,
    procedure_id          integer   not null,
    record_time           timestamp not null,
    status_id             integer   not null,
    procedure_time_record timestamp not null,
    constraint fk_record_client_id
        foreign key (client_id)
            references account (account_id),
    constraint fk_record_master_id
        foreign key (master_id)
            references master (master_id),
    constraint fk_record_procedure_id
        foreign key (procedure_id)
            references procedure (procedure_id),
    constraint fk_record_status_id
        foreign key (status_id)
            references status (status_id)
);

-- table comment
create table comment
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

