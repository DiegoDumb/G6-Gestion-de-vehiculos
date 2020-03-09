package vehiculos;

public class Turismo extends Vehiculos{
	private double capacidadMaletero;
	private int numPuertas;
	
	
	public Turismo() {
		
	}
	
	@Override
	void cargaVehiculo() {
		super.cargaVehiculo();
		
		System.out.println("Introduzca la capacidad del maletero:");
		capacidadMaletero = Console.readDouble();
		System.out.println("Introduzca el numero de puertas:");
		numPuertas = Console.readInt();
		
		
		contadorVehiculo();
	}
	
	void comprarTurismo() {
		
	}
	
	@Override
	public String toString() {
		return super.toString()+"Capacidad del maletero: "+capacidadMaletero
				+"Numero de puertas: "+numPuertas;
	}
	
	
	
	
}
