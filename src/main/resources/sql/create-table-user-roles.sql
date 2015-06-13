-- creating user and user_role tables
CREATE TABLE user (
	username VARCHAR(64) NOT NULL,
	password VARCHAR(64) NOT NULL,
	enabled BOOLEAN NOT NULL,
	PRIMARY KEY (username)
);
  
CREATE TABLE user_role (
	username VARCHAR(64) NOT NULL,
	role VARCHAR(64) NOT NULL,
	PRIMARY KEY (username, role),
	CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES user (username)
);

-- inserting users
INSERT INTO user (username,password,enabled) VALUES ('dba','123456', TRUE);
INSERT INTO user (username,password,enabled) VALUES ('user','123456', TRUE);
INSERT INTO user (username,password,enabled) VALUES ('admin','123456', TRUE);

-- inserting user roles
INSERT INTO user_role (username, role) VALUES ('dba', 'DBA');
INSERT INTO user_role (username, role) VALUES ('user', 'USER');
INSERT INTO user_role (username, role) VALUES ('admin', 'ADMIN');