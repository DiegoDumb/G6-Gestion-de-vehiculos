package vehiculos;

import java.util.ArrayList;


public abstract class Vehiculos {
	
	private static int numeroVehiculos;
	private String matricula;
	private String numBastidor;
	private String color;
	private String[] serie;
	private double precio;
	private int numAsientos;
	private String modelo = serie[0];
	private String marca = serie[1];
	private String año = serie[2];
	
	private ArrayList<Turismo> tirusmo;
	private ArrayList<Camion> camiones;
	private ArrayList<Vehiculos> vehiculos;
	
	public Vehiculos() {
		serie = new String[3];
	}

	 void cargaVehiculo(){
		
			System.out.println("Introduzca la matricula del vehiculo:");
			matricula = Console.readString();
			System.out.println("Introduzca el numero de bastidor del vehiculo:");
			numBastidor = Console.readString();
			System.out.println("Introduzca el color del vehiculo:");
			color = Console.readString();
			System.out.println("Introduzca el precio del vehiculo:");
			precio = Console.readDouble();
			System.out.println("Introduzca el numero de asientos:");
			numAsientos = Console.readInt();
			System.out.println("Introduzca el modelo del vehiculo:");
			modelo = Console.readString();
			System.out.println("Introduzca la marca del vehiculo:");
			marca = Console.readString();
			System.out.println("Introduzca el año de fabricacion del vehiculo:");
			año = Console.readString();
			
		
	}
	 int contadorVehiculo() {
		 int numVehiculos= getNumeroVehiculos();
		 numVehiculos++;
		 return numVehiculos;
	 }
	 
	 public String toString(){
		 return "matricula del vehiculo: "+matricula
				 +" numero de bastidor: "+numAsientos
				 +"color: "+color
				 +"precio: "+precio
				 +"numero de asientos: "+numAsientos
				 +"modelo: "+modelo
				 +"marca: "+marca
				 +"año: "+año;
	 }
	
	public static int getNumeroVehiculos() {
		return numeroVehiculos;
	}


	

}
