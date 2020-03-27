package vehiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import consultasBD.Conexion;
/**
 * 
 * @author diego
 * Esta clase se encarga de pintar un vehiculo.
 * 
 */
public class Taller{
	
	Conexion conexion;
	private Connection con;
	
	String nombre;
	String direccion;
	int tlf;
	String NIF;
	
	public Taller() {
		nombre = "Los Santos Customs";
		direccion = "C/ Macarena nº 23- 38016- Madrid";
		tlf = 384527905;
		NIF = "C63213603";
		
		conexion = new Conexion();
		con = conexion.conectar();
	}
	/**
	 * 
	 * @param matricula
	 * Recibe una matricula por parmetros y cambia el color del coche segun la matricula.
	 * 
	 */
	public void pintar(String matricula){
		
		System.out.println("¿De que color quiere pintar el vehiculo?");
		String color = Console.readString();
		try {
			PreparedStatement stm = con.prepareStatement("UPDATE Vehiculos SET color = \""+color+"\" WHERE Matricula = \""+matricula+"\";");	
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Su vehiculo ahora es de color "+color);
	}

	public String toString() {
		return "Nombre: "+nombre
				+"\nDireccion"+direccion
				+"\nTelefono: "+tlf
				+"\nNIF: "+NIF;
	}
	
}
