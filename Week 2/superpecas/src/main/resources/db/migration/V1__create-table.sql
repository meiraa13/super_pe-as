CREATE TABLE cars (
  id varchar(255) PRIMARY KEY,
  name varchar(255) NOT NULL,
  manufacturer varchar(255) NOT NULL,
  year int NOT NULL,
  color varchar(255) NOT NULL,
  mileage int NOT NULL,
  photo varchar(255) UNIQUE NOT NULL,
  available bool DEFAULT true
);

CREATE TABLE users (
  id varchar(255) PRIMARY KEY,
  name varchar(255) NOT NULL,
  email varchar(255) UNIQUE NOT NULL,
  password varchar(255) NOT NULL,
  isAdmin bool DEFAULT false
);

CREATE TABLE rentals (
  id varchar(255) PRIMARY KEY,
  user varchar(255) NOT NULL,
  car varchar(255) not NULL,
  rentDate datetime NOT NULL,
  returnDate datetime,
  initialMileage int NOT NULL,
  returnMileage int,
  FOREIGN KEY (user) REFERENCES users(id),
  FOREIGN KEY (car) REFERENCES cars(id)
);


