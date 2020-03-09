package vehiculos;

public class Camion extends Vehiculos{
	private double carga;
	private char tipoMercancia;
	
	public Camion() {
	}
	
	@Override
	void cargaVehiculo() {
		super.cargaVehiculo();
		
		System.out.println("Introduzca la capacidad de carga del camion:");
		carga = Console.readDouble();
		System.out.println("Introduzca la el tipo de la mercancia:");
		tipoMercancia = Console.readChar();
		
		contadorVehiculo();
	}
	
	@Override
	public String toString() {
		return super.toString()+"Carga: "+carga
				+"Tipo de mercancia: "+tipoMercancia;
	}
	
	
	
	
}
