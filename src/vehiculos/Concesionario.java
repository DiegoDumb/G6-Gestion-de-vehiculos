package vehiculos;
import consultasBD.Stock;
/**
 * 
 * @author ik012982i9
 * La clase "Concesionario" tiene informacion basica del concesionario, la informacion esta predeterminada.
 * 
 * El metodo compra() gestiona la compra del vehiculo dependiendo de la categoria (Turismo / Camion)
 * y envia la informacion a una base de datos.
 * 
 * El metodo vende() gestiona la venta del vehiculo dependiendo de la categoria (Turismo / Camion):
 * 1. Inicia un filtro basado en: Turiso : capacidad del maletero y numero de puertas
 * 								  Camion : carga y tipo de mercancia.	
 * 2. Hace una peticion a la base de datos basandose en el filtro y lo muestra por pantalla.
 * 
 * El metodo verStock() muestra por pantalla los vehiculos filtrando por Turismo y Camiones.
 * 
 */

public class Concesionario{
	private String nombre;
	private String direccion;
	private int tlf;
	private String NIF;
	private Stock stock;

	public Concesionario() {
		nombre = "Statista";
		direccion = "PLAZA PABLO RUIZ PICASSO (TORRE PICASSO), 1 - 26";
		tlf = 188822554;
		NIF = "B63272603";
		stock = new Stock();
	}
	
	public void comprar() {
		System.out.println("Turismo - Camion");
		System.out.println("T");
		System.out.println("C");
		
		char tipoVehiculo = Console.readChar();
		if(tipoVehiculo == 't' || tipoVehiculo == 'T') {
			Turismo turismo = new Turismo();
			turismo.cargaVehiculo();
			stock.sumarStockTurismo(turismo);
			System.out.println(turismo.toString());
		}
		else if(tipoVehiculo == 'c' || tipoVehiculo == 'C') {
			Camion camion = new Camion();
			camion.cargaVehiculo();
			stock.sumarStockCamion(camion);
			System.out.println(camion.toString());
		}
	}
	
	void vender() {
		System.out.println("Turismo - Camion");
		System.out.println("T");
		System.out.println("C");
		
		char tipoVehiculo = Console.readChar();
		if(tipoVehiculo == 't' || tipoVehiculo == 'T') {
			Turismo turismo = new Turismo();
			turismo.vendeTurismo();
			
			//System.out.println(turismo.toString());
		}
		else if(tipoVehiculo == 'c' || tipoVehiculo == 'C') {
			Camion camion = new Camion();
			camion.vendeCamion();
			//System.out.println(camion.toString());
		}
		
		
		
		//Consultar con ese color y ese numero de puertas los precios de los vehiculos en stock.
	}

	
	void verStock(){
		Stock stock = new Stock();
		System.out.println("¿Quiere ver el Stock de los camiones o de los Turismo?");
		System.out.println("Turismo - Camion");
		System.out.println("T");
		System.out.println("C");
		
		char tipoVehiculo = Console.readChar();
		if(tipoVehiculo == 't' || tipoVehiculo == 'T') {
			stock.consultaStockTurismo();
		}
		else if(tipoVehiculo == 'c' || tipoVehiculo == 'C') {
			stock.consultaStockCamiones();
		}
	}
	
	void leerXML() {
		
	}
	
	void cargarXML(){
		
	}
	
	public String toString() {
		return "Nombre: "+nombre
				+"\nDireccion: "+direccion
				+"\nTelefono: "+tlf
				+"\nNIF: "+NIF;
	}
}
