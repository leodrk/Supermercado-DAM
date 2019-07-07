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
	cantidad int NOT NULL);

INSERT INTO Productos (codigo, nombre, precio, cantidad)
VALUES
(1103,"Leche", 30, 10),
(1104,"Pan lactal", 90, 10),
(1101,"Jugo de naranja", 50, 10),
(1105,"Cereal Oreo", 101, 10),
(1102,"Cafe", 72, 10),
(2207,"Manzana", 72, 10),
(2208,"Lechuga", 79, 10),
(2210,"Choclo", 52, 10),
(2206,"Tomate", 80, 10),
(3311, "Aceite", 110, 10),
(3315, "Queso Rallado", 150, 10),
(3313, "Arroz", 15, 10),
(3312, "Coca Cola 1,5L", 110, 10),
(3314, "Ketchup", 120, 10),
(4419, "Pasta de dientes", 102, 10),
(4418, "Alcohol Etilico", 300, 10),
(4416, "Cepillo de dientes", 100, 10),
(4417, "Hisopos", 210, 10),
(4420, "Papel higienico", 400, 10);
