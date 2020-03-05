package vehiculos;

public class Turismo extends Vehiculo{
	private double capacidadMaletero;
	private int numPuertas;
	//inicializar atributos
	public Turismo(String numeroVehiculos, String matricula, String numBastidor, String color, String[] serie,
			double precio, int numAsientos) {
		super(numeroVehiculos, matricula, numBastidor, color, serie, precio, numAsientos);
		
	}
	
	
}
