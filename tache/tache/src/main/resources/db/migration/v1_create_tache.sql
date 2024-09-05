CREATE TABLE taches (
    idTache BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    status ENUM('A_FAIRE','EN_COURS','TERMINE') NOT NULL,
    id_projet BIGINT NOT NULL
);
