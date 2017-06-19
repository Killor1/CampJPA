CREATE TABLE cuidador (
       dni char(9),
       nom varchar(30),
       telefon char(9),
       adreça varchar(100),
       email varchar(25),

       CONSTRAINT cuidador_pk PRIMARY KEY (dni),
       CONSTRAINT dni_valid_ck CHECK (dni ~*'[[:digit:]]{8}[[:alpha]]{1}')
);

CREATE TABLE nen (
       id_nen int,
       nom varchar(30),
       data_naixement date,
       cuidador char(9),

       CONSTRAINT nen_pk PRIMARY KEY (id_nen),
       CONSTRAINT nen_to_cuidador_fk FOREIGN KEY (cuidador) REFERENCES cuidador(dni)
);

CREATE TABLE campament (
       id_campament int,
       lloc varchar(30),
       data_inici date,
       data_fi date,

       CONSTRAINT campament_pk PRIMARY KEY (id_campament)
);

CREATE TABLE campament_nens (
       id_campament int,
       id_nen int,

       CONSTRAINT campament_nens_pk PRIMARY KEY (id_campament, id_nen),
       CONSTRAINT campament_nens2nen_fk FOREIGN KEY (id_nen) REFERENCES nen(id_nen),
       CONSTRAINT campament_nens2campament_fk FOREIGN KEY (id_campament) REFERENCES campament(id_campament)

);

CREATE TABLE activitat (
       id_activitat int,
       descripcio text,

       CONSTRAINT activitat_pk PRIMARY KEY (id_activitat)

);

CREATE TABLE activitats_campament (
       id_campament int,
       id_activitat int,

       CONSTRAINT activitats_campament_pk PRIMARY KEY (id_campament, id_activitat),
       CONSTRAINT activitats_campament2campament_fk FOREIGN KEY (id_campament) REFERENCES campament(id_campament),
       CONSTRAINT activitats_campament2activitat_fk FOREIGN KEY (id_activitat) REFERENCES activitat(id_activitat)

);

