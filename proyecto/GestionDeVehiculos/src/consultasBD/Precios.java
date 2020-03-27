package consultasBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author diego
 * 	
 */
public class Precios {
	Conexion conexion = new Conexion();
	private Connection con = null;
	private Statement stm = null;
	private ResultSet result = null;
	/**
	 * 
	 * @param numPuertas
	 * @param color
	 * Esta clase se encarga de consultar precios de los vehiculos del concesionario filtrando por:
	 * 		Numero de puertas y color en el caso de los turismo.
	 */
	public void preciosTurismo(int numPuertas, String color){
		try {
			con = conexion.conectar();
			stm = con.createStatement();
			
			result = stm.executeQuery ("select vehiculos.precio, series.marca, series.modelo, vehiculos.matricula\n" + 
					"from vehiculos, coches, series\n" + 
					"where series.Nombre_serie = vehiculos.serie\n" + 
					"and num_Puertas = "+numPuertas+" and color = \""+color+"\";");
			
			while(result.next()) {
				
				double precio = result.getDouble(1);
				System.out.println("Precio: "+precio);
				
				String marca = result.getString(2);
				System.out.println("Marca: "+marca);
				
				String modelo = result.getString(3);
				System.out.println("Modelo: "+modelo);
				
				String matricula = result.getString(4);
				System.out.println("Matricula: "+matricula);
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		}
		
	}
	/**
	 * 
	 * @param carga
	 * @param tipoMercancia
	 * 
	 * Consulta los precios de los camiones que cumplan los valores, de carga maxima y tipo de mercancia, insertados por parametros.
	 * 
	 */
	
	public void preciosCamion(double carga, String tipoMercancia){
		try {
			con = conexion.conectar();
			stm = con.createStatement();
			result = stm.executeQuery("SELECT vehiculos.precio, series.marca, series.modelo, vehiculos.matricula\n" 
					+ "FROM vehiculos, camiones, series\n" 
					+ "WHERE vehiculos.matricula = camiones.matricula "
					+ "AND camiones.carga_kg = "+carga+" and tipo_Mercancia = \""+tipoMercancia+"\""
					+ "GROUP BY vehiculos.matricula and series.Nombre_Serie;");
			
			while(result.next()) {
				
				double precio = result.getDouble(1);
				System.out.println("Precio: "+precio);
				
				String marca = result.getString(2);
				System.out.println("Marca: "+marca);
				
				String modelo = result.getString(3);
				System.out.println("Modelo: "+modelo);
				
				String matricula = result.getString(4);
				System.out.println("Matricula: "+matricula);
				System.out.println();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		}
		
	}
}
