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
Correo VARCHAR(10)
FOREIGN KEY (Matricula_Vehiculo_Vendido) REFERENCES Vehiculos(Matricula)
);

CREATE TABLE Series(
Nombre_Serie VARCHAR(15) PRIMARY KEY,
Marca VARCHAR(15),
Modelo VARCHAR(15),
Año_Fabricación INTEGER(4)
);

CREATE TABLE Historial(
Codigo INTEGER(10) AUTO_INCREMENT PRIMARY KEY,
Matricula VARCHAR(10) NOT NULL,
Fecha_Compra DATE NOT NULL,
Fecha_Venta DATE NOT NULL,
num_Bastidor VARCHAR(20),
color VARCHAR(10) NOT NULL,
num_Asientos INTEGER(2),
precio DOUBLE,
serie VARCHAR(10) NOT NULL,
Tipo_Vechiculo VARCHAR(6)
);

-- TRIGGERS E INSERTS

-- creo el trigger para rellenar Historial a la vez que Vehiculos

drop trigger if exists RellenarHistorial;
create trigger RellenarHistorial
AFTER INSERT ON Vehiculos for each row
insert into Historial(Matricula, Fecha_compra, num_Bastidor, color, num_Asientos, precio, serie, Tipo_vehiculo)
values (new.Matricula, new.Fecha_compra, new.num_Bastidor, new.color, new.num_Asientos, new.precio, new.serie, new.Tipo_vehiculo);

INSERT INTO Vehiculos VALUES("234 FDA",'2020-06-03',"V23P52E93","rojo",2,380000,"LAMB0001","Coche");

-- creo el siguiente trigger para actualizar el color cuando se actualice en vehiculos.

drop trigger if exists ActualizarHistorial;
create trigger ActualizarHistorial
AFTER UPDATE ON Vehiculos for each row
update historial SET color = new.color;

UPDATE Vehiculos SET color = "morado" WHERE Matricula = "234 FDA";

INSERT INTO Coches VALUES("234 FDA","2","240");
INSERT INTO Series VALUES("LAMB0001","Lamborghini","Aventador","2014");
