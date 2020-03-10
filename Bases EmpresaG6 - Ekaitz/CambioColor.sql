CREATE DEFINER=`root`@`localhost` PROCEDURE `CambioColor`()
BEGIN
UPDATE vehiculos SET color = "Morado" WHERE matricula = "234 FDA";
END