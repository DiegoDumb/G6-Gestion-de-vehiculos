package consultasBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author diego
 * Esta clase se encagar de establecer la conexion con la base de datos mediante a un driver.
 *  
 */
public class Conexion {
	
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/Concesionario?useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "123456789";
    private Connection conexion;
    
    
    static {
    	try {
    		Class.forName(CONTROLADOR);
    	}catch(ClassNotFoundException e){
    		System.out.println("Error al cargar el controlador");
            e.printStackTrace();
    	}
    }
    
     public Connection conectar() {
        
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        
        return conexion;
    }
	
	 public void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
