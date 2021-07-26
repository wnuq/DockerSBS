CREATE SEQUENCE hibernate_sequence START 4 INCREMENT 1;

CREATE TABLE course (id INT8 NOT NULL,
                    description VARCHAR(255) NOT NULL,
                    title VARCHAR(255) NOT NULL,
                    url_to_cover VARCHAR(255) NOT NULL,
                    PRIMARY KEY (id));