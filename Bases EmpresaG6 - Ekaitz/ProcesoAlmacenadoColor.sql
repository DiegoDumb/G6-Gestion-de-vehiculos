CREATE DEFINER=`root`@`localhost` PROCEDURE `ProcesoColor`()
BEGIN
SELECT * FROM vehiculos WHERE color = "rojo";
END