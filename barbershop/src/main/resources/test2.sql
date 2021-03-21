CREATE TABLE animals
(
    id          serial PRIMARY KEY,
    name        VARCHAR(250) NOT NULL,
    cage_number VARCHAR(100) NOT NULL
);

CREATE TABLE giraffe
(
    id     integer PRIMARY KEY,
    height DECIMAL NOT NULL,
    CONSTRAINT fk_giraffe_animals FOREIGN KEY (id) REFERENCES animals (id)
);

CREATE TABLE wolfs
(
    id          integer PRIMARY KEY,
    live_region VARCHAR(250) NOT NULL,
    CONSTRAINT fk_wolfs_animals FOREIGN KEY (id) REFERENCES animals (id)
);

