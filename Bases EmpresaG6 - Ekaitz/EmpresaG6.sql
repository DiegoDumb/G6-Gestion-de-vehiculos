DROP DATABASE IF EXISTS EmpresaG6;
CREATE DATABASE EmpresaG6;
USE EmpresaG6;

CREATE TABLE Vehiculos(
Matricula VARCHAR(10) NOT NULL PRIMARY KEY,
Fecha_Compra DATE NOT NULL,
num_Bastidor VARCHAR(20),
color VARCHAR(10) NOT NULL,
num_Asientos INTEGER(2),
precio DOUBLE,
serie VARCHAR(10) NOT NULL,
Tipo_Vechiculo VARCHAR(6)
);

CREATE TABLE Coches(
Matricula VARCHAR(10) NOT NULL PRIMARY KEY,
num_Puertas INTEGER(1),
capacidad_Maletero_dm3 INTEGER(3),
FOREIGN KEY (Matricula) REFERENCES Vehiculos(Matricula)
);

CREATE TABLE Camiones(
Matricula VARCHAR(10) NOT NULL PRIMARY KEY,
carga_kg INTEGER(5),
tipo_Mercancia VARCHAR(1) NOT NULL,
FOREIGN KEY (Matricula) REFERENCES Vehiculos(Matricula)
);

CREATE TABLE Cliente(
DNI VARCHAR(10) NOT NULL PRIMARY KEY,
Fecha_venta DATE,
Matricula_Vehiculo_Vendido VARCHAR(10) NOT NULL,
Nombre VARCHAR(15),
TLFContacto INTEGER(9),
Correo VARCHAR(10)
);

CREATE TABLE Series(
Nombre_Serie VARCHAR(15) PRIMARY KEY,
Marca VARCHAR(15),
Modelo VARCHAR(15),
Año_Fabricación INTEGER(4)
);

-- INSERTS DE UN VEHICULO

INSERT INTO Vehiculos VALUES("234 FDA","2020-06-03","V23P52E93","Rojo","2","380000","LAMB0001","Coche");
INSERT INTO Coches VALUES("234 FDA","2","240");
INSERT INTO Series VALUES("LAMB0001","Lamborghini","Aventador","2014");

-- 	LLAMANDO AL PROCESO ALMACENADO
-- realiza una consulta sobre el color del coche indicado

CALL ProcesoColor();