package consultasBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author diego
 * Esta clase se encagar de la configurar la conexion con la base de datos
 * mediante un driver e imprime por consola si la conexion a sido exitosa o no.
 */
public class Conexion {
	
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/Concesionario";
    private static final String USUARIO = "root";
    private static final String CLAVE = "123456789";
    
    static {
    	try {
    		Class.forName(CONTROLADOR);
    	}catch(ClassNotFoundException e){
    		System.out.println("Error al cargar el controlador");
            e.printStackTrace();
    	}
    }
    
	public Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");
        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        
        return conexion;
    }
	
	public void cerrarConexion() {
		// TODO
	}
}
