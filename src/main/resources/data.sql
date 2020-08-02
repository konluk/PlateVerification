DROP TABLE IF EXISTS stolen_plates;

CREATE TABLE stolen_plates (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  plate VARCHAR(10) NOT NULL,
  email VARCHAR(250) NOT NULL
);

INSERT INTO stolen_plates (plate, email) VALUES
  ('ZM111CA', 'testmail@gmail.com'),
  ('BA136EE', 'testmail2@gmail.com'),
  ('BA777AB', 'testmail3@gmail.com');
