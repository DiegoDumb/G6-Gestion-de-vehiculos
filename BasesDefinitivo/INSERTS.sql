-- COMPRAMOS UN COCHE
INSERT INTO Vehiculos VALUES("234 FDA","V23P52E93","rojo",2,380000,"LAMB0001","Coche");
INSERT INTO Coches VALUES("234 FDA","2","240");
INSERT INTO Series VALUES("LAMB0001","Lamborghini","Aventador","2014");

-- COMPRAMOS UN CAMION
INSERT INTO Vehiculos VALUES("453 MKG","R45E18J32","gris",2,40000,"CAMI1010","Camion");
INSERT INTO Camiones VALUES("453 MKG","3500","G");
INSERT INTO Series VALUES("CAMI0101","MAN","TGX D38","2017");

-- CAMBIAMOS COLOR
UPDATE Vehiculos SET color = "morado" WHERE Matricula = "234 FDA";

-- VENDEMOS COCHE
DELETE FROM Vehiculos WHERE matricula = "234 FDA";

-- CONSULTAS

-- CONSULTA COCHE CON FILTROS COLOR/NUM PUERTAS
SELECT vehiculos.matricula, vehiculos.precio, series.marca, series.modelo
FROM vehiculos, coches, series
WHERE series.Nombre_Serie = vehiculos.serie AND color = "rojo" AND num_puertas = 2;

-- CONSULTA CAMION CON FILTROS CARGA/TIPO MERCANCIA
SELECT vehiculos.matricula, vehiculos.precio, series.marca, series.modelo
FROM vehiculos, camiones, series
WHERE vehiculos.matricula = camiones.matricula AND camiones.carga_kg = "4600" AND camiones.tipo_Mercancia = "T"
GROUP BY vehiculos.matricula and series.Nombre_Serie;
