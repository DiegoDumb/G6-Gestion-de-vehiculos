package vehiculos;
import consultasBD.*;
/**
 * 
 * @author ik012982i9
 * 
 */
public class Turismo extends Vehiculos{
	private double capacidadMaletero;
	private int numPuertas;
	
	public Turismo() {}
	
	
	@Override
	void cargaVehiculo() {
		super.cargaVehiculo();
		
		System.out.println("Introduzca la capacidad del maletero:");
		capacidadMaletero = Console.readDouble();
		System.out.println("Introduzca el numero de puertas:");
		numPuertas = Console.readInt();
		//ORDEN PARA INSERTAR COCHE EN B.D
		//cargar pasando los datos por parametros
		//GENERAR GETERS PARA METERLOS POR PARAMETROS
		
		sumaVehiculo();
	}
	
	void vendeTurismo() {
		Precios turismo = new Precios();
		Stock stock = new Stock();
		System.out.println("¿De que color quiere el vehiculo?");
		String color = Console.readString();
		System.out.println("¿De cuantas puertas quiere el vehiculo?");
		int numPuertas = Console.readInt();
		
		turismo.preciosTurismo(numPuertas,  color);
		
		System.out.println("Introduzca la matricula del camion que desea: ");
		String matricula = Console.readString();
		stock.eliminarStock(matricula);
		
		restaVehiculo();
	}
	
	
	
	@Override
	public String toString() {
		return super.toString()+"Capacidad del maletero: "+capacidadMaletero
				+"Numero de puertas: "+numPuertas;
	}


	public double getCapacidadMaletero() {
		return capacidadMaletero;
	}


	public int getNumPuertas() {
		return numPuertas;
	}
	
	
	
	
}
