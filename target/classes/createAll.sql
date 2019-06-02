DROP SCHEMA IF EXISTS supermercado;

CREATE SCHEMA supermercado;


USE supermercado;


CREATE TABLE Productos (codigo int NOT NULL UNIQUE,
						nombre VARCHAR (255) NOT NULL,
						precio float NOT NULL);

       INSERT INTO Productos (codigo, nombre, precio)
       VALUES
    		(1103,"Leche", 30),
    		(1104,"Pan lactal", 90),
    		(1101,"Jugo de naranja", 50),
    		(1105,"Cereal Oreo", 101),
    		(1102,"Cafe", 72),
    		(2207,"Manzana", 72),
    		(2208,"Lechuga", 79),
    		(2210,"Choclo", 52),
    		(2206,"Tomate", 80),
    		(3311, "Aceite", 110),
    		(3315, "Queso Rallado", 150),
    		(3313, "Arroz", 15),
    		(3312, "Coca Cola 1,5L", 110),
    		(3314, "Ketchup", 120),
    		(4419, "Pasta de dientes", 102),
    		(4418, "Alcohol Etilico", 300),
    		(4416, "Cepillo de dientes", 100),
    		(4417, "Hisopos", 210),
    		(4420, "Papel higienico", 400);
