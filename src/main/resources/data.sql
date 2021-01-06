DROP TABLE IF EXISTS contacts;

CREATE TABLE contacts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  phone_number VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);

INSERT INTO contacts (first_name, last_name, phone_number, email) VALUES
  ('Maria', 'Popescu', '0721000012', 'Maria.Popescu@gmail.com'),
  ('Ion', 'Popa', '0762322211','Ion.Popa@gmail.com'),
  ('Folrunsho', 'Alakija', '0789999999','Fol.Al@yahoo.com');