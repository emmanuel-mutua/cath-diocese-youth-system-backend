
CREATE TABLE IF NOT EXISTS Deanery(
deanery_Id SERIAL PRIMARY KEY,
deanery_name VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS Parish(
parish_id SERIAL PRIMARY KEY,
deanery_id INTEGER,
parish_name VARCHAR(20),
FOREIGN KEY (deanery_id) REFERENCES Deanery(deanery_Id)
    );

CREATE TABLE IF NOT EXISTS Youth (
        serial_number SERIAL PRIMARY KEY,
        full_name VARCHAR(255) NOT NULL,
        date_of_birth DATE NOT NULL,
        phone_number VARCHAR(20),
        gender VARCHAR(10) NOT NULL,
        id_or_birth_cert_number VARCHAR(50) NOT NULL,
        local_church_name VARCHAR(255),
        small_christian_community_name VARCHAR(255),
        parish_id INTEGER,
        deanery_id INTEGER,
        baptized BOOLEAN,
        received_holy_communion BOOLEAN,
        confirmation BOOLEAN,
        married BOOLEAN,
        FOREIGN KEY (deanery_id) REFERENCES Deanery(deanery_Id),
        FOREIGN KEY (parish_id) REFERENCES Parish(parish_id)
        );


    CREATE TABLE IF NOT EXISTS Userr (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
        password VARCHAR(255) NOT NULL,
        user_role VARCHAR(20) NOT NULL
        );

    CREATE TABLE IF NOT EXISTS parish_admin (
        id SERIAL PRIMARY KEY,
        username VARCHAR(20) NOT NULL,
        parish_id INTEGER NOT NULL,
        password VARCHAR(20) NOT NULL
    );
--     INSERT INTO Userr (username, password, user_role) VALUES ('xxx','xxx','super_admin')

