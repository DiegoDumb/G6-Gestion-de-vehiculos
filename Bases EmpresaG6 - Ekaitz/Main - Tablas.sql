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
Tipo_Vehiculo VARCHAR(6)
);

CREATE TABLE Coches(
Matricula VARCHAR(10) NOT NULL PRIMARY KEY,
num_Puertas INTEGER(1),
capacidad_Maletero_dm3 INTEGER(3),
FOREIGN KEY (Matricula) REFERENCES Vehiculos(Matricula)
ON DELETE CASCADE
);

CREATE TABLE Camiones(
Matricula VARCHAR(10) NOT NULL PRIMARY KEY,
carga_kg INTEGER(5),
tipo_Mercancia VARCHAR(1) NOT NULL,
FOREIGN KEY (Matricula) REFERENCES Vehiculos(Matricula)
ON DELETE CASCADE
);

CREATE TABLE Cliente(
DNI VARCHAR(10) NOT NULL PRIMARY KEY,
Fecha_venta DATE,
Matricula_Vehiculo_Vendido VARCHAR(10) NOT NULL,
Nombre VARCHAR(15),
TLFContacto INTEGER(9),
Correo VARCHAR(10),
FOREIGN KEY (Matricula_Vehiculo_Vendido) REFERENCES Vehiculos(Matricula)
);

CREATE TABLE Series(
Nombre_Serie VARCHAR(15) PRIMARY KEY,
Marca VARCHAR(15),
Modelo VARCHAR(15),
Año_Fabricación INTEGER(4)
);

CREATE TABLE Historial(
Codigo INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
Matricula VARCHAR(10) NOT NULL,
Fecha_Compra DATE NOT NULL,
Fecha_Venta DATE,
num_Bastidor VARCHAR(20),
color VARCHAR(10) NOT NULL,
num_Asientos INTEGER(2),
precio DOUBLE,
serie VARCHAR(10) NOT NULL,
Tipo_Vehiculo VARCHAR(6)
);