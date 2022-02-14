CREATE TABLE degree (
                        id SERIAL PRIMARY KEY,
                        degree_name VARCHAR(20)
);

CREATE TABLE lector (

                        id SERIAL PRIMARY KEY,
                        first_name VARCHAR(50),
                        last_name VARCHAR(50),
                        degree INT REFERENCES degree(id)
);

CREATE TABLE department (

                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100)
);

CREATE TABLE assigned_lector (

                                 id SERIAL PRIMARY KEY,
                                 lector INT REFERENCES lector(id),
                                 department INT REFERENCES department(id)
);
