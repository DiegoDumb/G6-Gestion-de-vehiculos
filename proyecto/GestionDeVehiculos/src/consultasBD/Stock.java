package consultasBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import consultasBD.Conexion;

import vehiculos.Camion;
import vehiculos.Turismo;
/**
 * 
 * @author diego
 * Esta clase se encargar de todas la tareas que tengan que ver con el stock.
 */
public class Stock{
	private Conexion conexion;
	private Connection con;
	
	public Stock(){
		conexion = new Conexion();
		con = conexion.conectar();
	}

	/**
	 * 
	 * @author diego
	 * Hace una consulta a la base de datos de toda la informacion pertinente de cada turismo.
	 */
	public void consultaStockTurismo(){
		try {
			Statement stm = con.createStatement();
			ResultSet result = stm.executeQuery("select vehiculos.*, coches.num_puertas, coches.capacidad_maletero_dm3, series.marca, series.modelo, series.anio_fabricacion\r\n" + 
					"from vehiculos, coches, series\r" + 
					"where vehiculos.matricula = coches.matricula and vehiculos.serie = series.Nombre_Serie;");
			while(result.next()) {
				String matricula = result.getString(1);
				System.out.println("\tMatricula: "+matricula);
				
				String numBastidor = result.getString(2);
				System.out.println("\tNumero de bastidor: "+numBastidor);
				
				String color = result.getString(3);
				System.out.println("\tColor: "+color);
				
				int numAsientos = result.getInt(4);
				System.out.println("\tNumero de asientos: "+numAsientos);
				
				double precio = result.getDouble(5);
				System.out.println("\tPrecio: "+precio);
				
				String serie = result.getString(6);
				System.out.println("\tSerie: "+serie);
				
				int numPuertas = result.getInt(7);
				System.out.println("\tNumero de puertas: "+numPuertas);
				
				double capacidadMateletero = result.getDouble(8);
				System.out.println("\tCapacidad del maletero: "+capacidadMateletero+" Litros");
				
				String marca = result.getString(9);
				System.out.println("\tMarca: "+marca);
				
				String modelo = result.getString(10);
				System.out.println("\tModelo: "+modelo);
				
				int añoFrabricacion = result.getInt(11);
				System.out.println("\tAño de frabricacion: "+añoFrabricacion);
				System.out.println();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		}
	}
	/**
	 * 
	 * Hace una consulta a la base de datos de toda la informacion pertinente de cada camion.
	 * 
	 */
	public void consultaStockCamiones(){
		try {
			
			Statement stm = con.createStatement();
			ResultSet result = stm.executeQuery("select vehiculos.*, Camiones.carga_kg, Camiones.tipo_Mercancia, series.marca, series.modelo, series.anio_fabricacion\r\n" + 
					"from vehiculos, Camiones, series\r\n" + 
					"where vehiculos.matricula = camiones.matricula and vehiculos.serie = series.Nombre_Serie;");
			while(result.next()) {

				String matricula = result.getString(1);
				System.out.println("\tMatricula: "+matricula);
				
				String numBastidor = result.getString(2);
				System.out.println("\tNumero de bastidor: "+numBastidor);
				
				String color = result.getString(3);
				System.out.println("\tColor: "+color);
				
				int numAsientos = result.getInt(4);
				System.out.println("\tNumero de asientos: "+numAsientos);
				
				double precio = result.getDouble(5);
				System.out.println("\tPrecio: "+precio);
				
				String serie = result.getString(6);
				System.out.println("\tSerie: "+serie);
				
				int cargaMaxima = result.getInt(7);
				System.out.println("\tCarga maxima: "+cargaMaxima);
				
				String tipoMercancia = result.getString(8);
				System.out.println("\tTipo de mercancia: "+tipoMercancia);
				
				String marca = result.getString(9);
				System.out.println("\tMarca: "+marca);
				
				String modelo = result.getString(10);
				System.out.println("\tModelo: "+modelo);
				
				int añoFrabricacion = result.getInt(11);
				System.out.println("\tAño de frabricacion: "+añoFrabricacion);
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	/**
	 * 
	 * @param turismo
	 * Recive un turismo por parametros y lo envia a la base de datos.
	 */
	public void sumarStockTurismo(Turismo turismo) {
		
		try {
			
			/*
			 * PreparedStatements. Enviando las sentencias a MySQL
			 */
			PreparedStatement stmV = con.prepareStatement("INSERT INTO Vehiculos (matricula, num_Bastidor, color, num_Asientos, precio, serie) VALUES (?,?,?,?,?,?)");
			PreparedStatement stmC = con.prepareStatement("INSERT INTO coches (matricula, num_Puertas, capacidad_Maletero_dm3) VALUES (?,?,?)");
			PreparedStatement stmS = con.prepareStatement("INSERT INTO series (Nombre_Serie, Marca, Modelo, Anio_Fabricacion) VALUES (?,?,?,?)");
			PreparedStatement commit = con.prepareStatement("commit;");
			
			stmV.setString(1, turismo.getMatricula());
			stmV.setString(2, turismo.getNumBastidor());
			stmV.setString(3, turismo.getColor());
			stmV.setInt(4, turismo.getNumAsientos());
			stmV.setDouble(5, turismo.getPrecio());
			stmV.setString(6, turismo.getNomSerie());
			
			stmC.setString(1, turismo.getMatricula());
			stmC.setInt(2, turismo.getNumPuertas());
			stmC.setDouble(3, turismo.getCapacidadMaletero());
			
			stmS.setString(1, turismo.getNomSerie());
			stmS.setString(2, turismo.getMarca());
			stmS.setString(3, turismo.getModelo());
			stmS.setString(4, turismo.getAño());
			
			stmV.executeUpdate();
			stmC.executeUpdate();
			stmS.executeUpdate();
			commit.executeUpdate();
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
		}
		
	}
	/**
	 * 
	 * @param camion
	 * Recibe un camion por parametros y lo envia a la base de datos.
	 * 
	 */
public void sumarStockCamion(Camion camion) {
		
		try {
			
			/*
			 * PreparedStatements. Enviando las sentencias a MySQL
			 */
			
			PreparedStatement stmV = con.prepareStatement("INSERT INTO Vehiculos (matricula, num_Bastidor, color, num_Asientos, precio, serie) VALUES (?,?,?,?,?,?)");
			PreparedStatement stmC = con.prepareStatement("INSERT INTO camiones (matricula, carga_kg, tipo_Mercancia) VALUES (?,?,?)");
			PreparedStatement stmS = con.prepareStatement("INSERT INTO series (Nombre_Serie, Marca, Modelo, Anio_Fabricacion) VALUES (?,?,?,?)");
			PreparedStatement commit = con.prepareStatement("commit;");
			
			/*
			 * 
			 */
			stmV.setString(1, camion.getMatricula());
			stmV.setString(2, camion.getNumBastidor());
			stmV.setString(3, camion.getColor());
			stmV.setInt(4, camion.getNumAsientos());
			stmV.setDouble(5, camion.getPrecio());
			stmV.setString(6, camion.getNomSerie());
			
			stmC.setString(1, camion.getMatricula());
			stmC.setDouble(2, camion.getCarga());
			stmC.setString(3, camion.getTipoMercancia());
			
			stmS.setString(1, camion.getNomSerie());
			stmS.setString(2, camion.getMarca());
			stmS.setString(3, camion.getModelo());
			stmS.setString(4, camion.getAño());
			
			stmS.executeUpdate();
			stmV.executeUpdate();
			stmC.executeUpdate();
			commit.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		}
	}
	/**
	 * 
	 * @param matricula
	 * 
	 * Recibe una matricula por parametros y elimina el vehiculo que le corresponda.
	 */
	public void eliminarStock(String matricula) {
		try {
			
			PreparedStatement stm = con.prepareStatement("delete from vehiculos where matricula =\""+matricula+"\";");
			PreparedStatement commit = con.prepareStatement("commit;");
			
			stm.executeUpdate();
			commit.executeUpdate();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
		}
	}
	
}
