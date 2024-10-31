CREATE TABLE IF NOT EXISTS users
(
    id        BIGINT NOT NULL auto_increment,
    address   VARCHAR(1000) DEFAULT NULL,
    dob       DATE DEFAULT NULL,
    email     VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) DEFAULT NULL,
    is_active BIT(1) DEFAULT NULL,
    lastname  VARCHAR(255) DEFAULT NULL,
    password  VARCHAR(255) NOT NULL,
    phone_no  VARCHAR(255) DEFAULT NULL,
    sex       VARCHAR(8) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY users_email_unique_id (email)
);