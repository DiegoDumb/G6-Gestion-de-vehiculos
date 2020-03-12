-- COMPRA

drop trigger if exists CompraCoche;
create trigger CompraCoche
AFTER INSERT ON Vehiculos for each row
insert into Historial(Matricula, num_Bastidor, color, num_Asientos, precio, serie, Tipo_vehiculo)
values (new.Matricula, new.num_Bastidor, new.color, new.num_Asientos, new.precio, new.serie, new.Tipo_vehiculo);

-- CAMBIAR COLOR

DROP TRIGGER IF EXISTS CambiaColor;
CREATE TRIGGER CambiaColor
AFTER UPDATE ON Vehiculos for each row
INSERT INTO Historial(Matricula, num_Bastidor, color, num_Asientos, precio, serie, Tipo_vehiculo)
values (new.Matricula, new.num_Bastidor, new.color, new.num_Asientos, new.precio, new.serie, new.Tipo_vehiculo);

-- ELIMINAR

DROP TRIGGER IF EXISTS BorrarCoche;
CREATE TRIGGER BorrarCoche
AFTER DELETE ON Vehiculos for each row
INSERT INTO historial(Matricula, num_Bastidor, color, num_Asientos, precio, serie, Tipo_vehiculo)
VALUES (new.Matricula, new.num_Bastidor, new.color, new.num_Asientos, new.precio, new.serie, new.Tipo_vehiculo);