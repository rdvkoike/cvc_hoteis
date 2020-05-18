DROP TABLE IF EXISTS usuario;
 
CREATE TABLE usuario (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);
 
INSERT INTO usuario (username, password) VALUES
  ('usertest1', '{bcrypt}$2a$10$43SOV9ROy8vtFwrm.m1SP.rohpDPMug2rtw3UirZf/Ei/bxJ8vbp.');