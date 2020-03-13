package consultasBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vehiculos.Console;

public class Precios {
	Conexion conexion = new Conexion();
	private Connection con = null;
	private Statement stm = null;
	private ResultSet result = null;
	
	public void preciosTurismo(int numPuertas, String color){
		try {
			con = conexion.conectar();
			stm = con.createStatement();
			//consulta de los precios
			//concatenar con las variables
			result = stm.executeQuery ("select precio, marca, modelo\n" + 
					"from vehiculos, coches, series\n" + 
					"where vehiculos.matricula = coches.matricula\n" + 
					"and (num_Puertas = "+numPuertas+" and color = \"+color+\");");
			
			while(result.next()) {
				
				double precio = result.getDouble(6);
				System.out.println("Precio: "+precio);
				
				String marca = result.getString(2);
				System.out.println("Marca: "+marca);
				
				String modelo = result.getString(3);
				System.out.println("Modelo: "+modelo);
				
				String matricula = result.getString(1);
				System.out.println("Matricula: "+matricula);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void preciosCamion(double carga, char tipoMercancia){
		try {
			con = conexion.conectar();
			stm = con.createStatement();
			//consulta de los precios
			//concatenar con las variables
			result = stm.executeQuery("select precio, marca, modelo\r\n" + 
					"from vehiculos, coches, series\r\n" + 
					"where vehiculos.matricula = coches.matricula \r\n" + 
					"and (num_Puertas = "+carga+" and color = \"+tipoMercancia+\");");
			
			while(result.next()) {
				//no funciona
				double precio = result.getDouble(6);
				System.out.println(precio);
				
				String marca = result.getString(2);
				System.out.println(marca);
				
				String modelo = result.getString(3);
				System.out.println(modelo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
