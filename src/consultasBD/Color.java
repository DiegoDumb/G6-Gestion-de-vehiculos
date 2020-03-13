package consultasBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author diego
 * Esta clase se encarga de cambiar el color de cambiar el color de con vehiculos.
 * Con el metodo cambiarColor() recive por parametros el color y envia una orden de update 
 * a la base de datos para que cambie el color.
 * 
 */
public class Color {
	Conexion conexion = new Conexion();
	private Connection con = null;
	private Statement stm = null;
	private ResultSet result = null;
	// camibar de resultset a prepeared statement
	public void cambiarColor(String color){
		try {
			con = conexion.conectar();
			stm = con.createStatement();
			//cambiar el color
			//concatenar con las variables
			result = stm.executeQuery("");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
