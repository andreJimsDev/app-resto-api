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

CREATE TABLE IF NOT EXISTS fournisseurs (
    id SERIAL NOT NULL,
    nom VARCHAR(255) NOT NULL,
    contact VARCHAR(255),
    adresse VARCHAR(255),
    ville VARCHAR(255),
    code_postal VARCHAR(255) ,
    tel1 VARCHAR(255),
    tel2 VARCHAR(255),
    fax VARCHAR(255),
    numero_compte VARCHAR(255),
    email VARCHAR(255),
    remarques VARCHAR(255),
    numero_tva VARCHAR(255),
    PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS produits (
    id SERIAL NOT NULL,
    designation VARCHAR(255) NOT NULL,
    prixVente INTEGER NOT NULL,
    prixEmporte INTEGER NOT NULL,
    prixAchat INTEGER,
    categorieId INTEGER NOT NULL,
    qteStock INTEGER,
    qteMin INTEGER,
    fournisseurId INTEGER,
    demandeCuisson boolean,
    demandeAccompagnement boolean,
    gererStock boolean,
    refArticleFournisseur VARCHAR(255),
    createdAt DATE,
    updatedAt DATE,
    PRIMARY KEY (id)
)