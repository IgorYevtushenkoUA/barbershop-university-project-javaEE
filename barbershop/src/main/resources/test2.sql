-- CREATE TABLE animals
-- (
--     id          serial PRIMARY KEY,
--     name        VARCHAR(250) NOT NULL,
--     cage_number VARCHAR(100) NOT NULL
-- );
--
-- CREATE TABLE giraffe
-- (
--     id     integer PRIMARY KEY,
--     height DECIMAL NOT NULL,
--     CONSTRAINT fk_giraffe_animals FOREIGN KEY (id) REFERENCES animals (id)
-- );
--
-- CREATE TABLE wolfs
-- (
--     id          integer PRIMARY KEY,
--     live_region VARCHAR(250) NOT NULL,
--     CONSTRAINT fk_wolfs_animals FOREIGN KEY (id) REFERENCES animals (id)
-- );

insert into animals(name, cage_number) values ('giraffe1','111');
-- insert into animals(name, cage_number) values ('giraffe2','222');
-- insert into animals(name, cage_number) values ('giraffe3','333');
--
insert into giraffe(id, height) values(2,1.0);