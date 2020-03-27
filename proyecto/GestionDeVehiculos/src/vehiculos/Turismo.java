package vehiculos;
import consultasBD.*;

/**
 * 
 * @author ik012982i9
 * Esta clase se encarga de las tareas respectivas con los turismo.
 * 
 * toString() devuelve un string con la informacion del turismo.
 * 
 */

public class Turismo extends Vehiculos{
	private double capacidadMaletero;
	private int numPuertas;
	
	public Turismo() {}
	
	/**
	 * 
	 * cargaVehiculo() se encarga de recivir la informacion de el turismo.
	 * 
	 */
	
	@Override
	void cargaVehiculo() {
		super.cargaVehiculo();
		
		System.out.println("Introduzca la capacidad del maletero:");
		capacidadMaletero = Console.readDouble();
		System.out.println("Introduzca el numero de puertas:");
		numPuertas = Console.readInt();
		
	}
	/**
	 * 
	 * Se encarga establecer el filtro de venta a la hora de vender un vehiculo.
	 * 
	 */
	void vendeTurismo() {
		Precios turismo = new Precios();
		/*
		 * FILTRO PARA LA ELECCION DEL TIRUSMO
		 */
		System.out.println("¿De que color quiere el vehiculo?");
		String color = Console.readString();
		System.out.println("¿De cuantas puertas quiere el vehiculo?");
		int numPuertas = Console.readInt();
		
		turismo.preciosTurismo(numPuertas,  color);

	}	
	
	@Override
	public String toString() {
		return super.toString()+"Capacidad del maletero: "+capacidadMaletero
				+"\nNumero de puertas: "+numPuertas;
	}

	public double getCapacidadMaletero() {
		return capacidadMaletero;
	}


	public int getNumPuertas() {
		return numPuertas;
	}


	public void setCapacidadMaletero(double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}


	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
}
