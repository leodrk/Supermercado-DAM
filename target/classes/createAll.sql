DROP SCHEMA IF EXISTS supermercado;

CREATE SCHEMA supermercado;


USE supermercado;

CREATE TABLE Facturas (codigo int NOT NULL UNIQUE,
	dineroObtenido float NOT NULL,
	fechaDeEmision DATE);

CREATE TABLE Usuarios (nombre VARCHAR (255) NOT NULL UNIQUE,
	password VARCHAR (255) NOT NULL);
INSERT INTO Usuarios (nombre, password)
VALUES
("asd","123");

CREATE TABLE Productos (codigo int NOT NULL UNIQUE,
	nombre VARCHAR (255) NOT NULL,
	precio float NOT NULL,
	cantidad float NOT NULL);

INSERT INTO Productos (codigo, nombre, precio, cantidad)
VALUES
(1103,"Leche", 30, 1),
(1104,"Pan lactal", 90, 1),
(1101,"Jugo de naranja", 50, 1),
(1105,"Cereal Oreo", 101, 1),
(1102,"Cafe", 72, 1),
(2207,"Manzana", 72, 1),
(2208,"Lechuga", 79, 1),
(2210,"Choclo", 52, 1),
(2206,"Tomate", 80, 1),
(3311, "Aceite", 110, 1),
(3315, "Queso Rallado", 150, 1),
(3313, "Arroz", 15, 1),
(3312, "Coca Cola 1,5L", 110, 1),
(3314, "Ketchup", 120, 1),
(4419, "Pasta de dientes", 102, 1),
(4418, "Alcohol Etilico", 300, 1),
(4416, "Cepillo de dientes", 100, 1),
(4417, "Hisopos", 210, 1),
(4420, "Papel higienico", 400, 1);
