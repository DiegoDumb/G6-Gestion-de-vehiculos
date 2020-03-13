-- COMPRA

DROP TRIGGER IF EXISTS CompraCoche;
CREATE TRIGGER CompraCoche
AFTER INSERT ON Vehiculos FOR EACH ROW
INSERT INTO Historial(Fecha, Matricula, num_Bastidor, color, num_Asientos, precio, serie, Tipo_vehiculo, Descripción)
VALUES (now(), new.Matricula, new.num_Bastidor, new.color, new.num_Asientos, new.precio, new.serie, new.Tipo_vehiculo, "COMPRADO");

-- CAMBIAR COLOR

DROP TRIGGER IF EXISTS CambiaColor;
CREATE TRIGGER CambiaColor
AFTER UPDATE ON Vehiculos for each row
INSERT INTO Historial(Fecha, Matricula, num_Bastidor, color, num_Asientos, precio, serie, Tipo_vehiculo, Descripción)
values (now(), new.Matricula, new.num_Bastidor, new.color, new.num_Asientos, new.precio, new.serie, new.Tipo_vehiculo, "PINTADO");

-- ELIMINAR

DROP TRIGGER IF EXISTS BorrarCoche;
CREATE TRIGGER BorrarCoche
AFTER DELETE ON Vehiculos FOR EACH ROW
INSERT INTO Historial(Fecha, Matricula, num_Bastidor, color, num_Asientos, precio, serie, Tipo_vehiculo, Descripción)
VALUES (now(), old.Matricula, old.num_Bastidor, old.color, old.num_Asientos, old.precio, old.serie, old.Tipo_vehiculo, "VENDIDO");