-- COMPRAMOS UN VEHICULO
INSERT INTO Vehiculos VALUES("234 FDA","V23P52E93","rojo",2,380000,"LAMB0001","Coche");
INSERT INTO Coches VALUES("234 FDA","2","240");
INSERT INTO Series VALUES("LAMB0001","Lamborghini","Aventador","2014");

-- CAMBIAMOS COLOR
UPDATE Vehiculos SET color = "morado" WHERE Matricula = "234 FDA";

-- VENDEMOS COCHE

DELETE FROM Vehiculos WHERE matricula = "234 FDA";