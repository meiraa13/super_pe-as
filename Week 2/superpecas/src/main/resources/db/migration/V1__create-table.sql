CREATE TABLE cars (
id INT PRIMARY KEY auto_increment,
modelName VARCHAR(255) NOT NULL,
manufacturer VARCHAR(255) NOT NULL,
uniqueCode VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE pieces (
id INT PRIMARY KEY auto_increment,
pieceName VARCHAR(255) NOT NULL,
description VARCHAR(255) NOT NULL,
serialNumber VARCHAR(255) NOT NULL,
pieceManufacturer VARCHAR(255) NOT NULL,
carId INT NOT NULL,
carModel VARCHAR(255) NOT NULL,
FOREIGN KEY (carId) REFERENCES cars(id)
);