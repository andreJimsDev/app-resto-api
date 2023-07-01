-- [CREATE] tables
CREATE TABLE IF NOT EXISTS users (
    id SERIAL NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS categories (
    id SERIAL NOT NULL,
    nom VARCHAR(255) NOT NULL,
    parent INTEGER,
    tva_sur_place INTEGER,
    tva_emporte INTEGER,
    visible_carte1 boolean,
    visible_carte2 boolean,
    ordre INTEGER,
    PRIMARY KEY (id)
)