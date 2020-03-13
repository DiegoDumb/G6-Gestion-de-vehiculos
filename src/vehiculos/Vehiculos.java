package vehiculos;
/**
 * 
 * @author ik012982i9
 * La clase "vehiculos" contiene los datos generales de un vehiculo.
 * 
 * El metodo cargaVehiculo(), pide por consola a estas propiedades y las almacena para llamarlo desde otra clase (Turismo / Camion)
 * y poder completar la informacion de vehiculo que se va a sumar al concesionario.
 * 
 * El metodo sumaVehiculo() incrementa el contador de la cantidad de vehiculos registrados y el metodo restaVehiculo() resta.
 * 
 * El metodo toString() se usa en el aplicacion para mostrar por pantalla la informacion de el vehiculo insertado, eliminado o modificado.
 * 
 */

public abstract class Vehiculos {
	
	private static int numeroVehiculos;
	protected String matricula;
	protected String numBastidor;
	protected String color;
	protected String[] serie = new String[3];;
	protected double precio;
	protected int numAsientos;
	protected String modelo = serie[0];
	protected String marca = serie[1];
	protected String año = serie[2];
	protected String nomSerie;
	//private String tipoVehiculo;
	
	public Vehiculos() {
		  modelo = serie[0];
		  marca = serie[1];
		  año = serie[2];
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
			System.out.println("Introduzca el nombre de la serie");
			nomSerie = Console.readString();
			
			
	}
	 int sumaVehiculo() {
		 int numVehiculos= getNumeroVehiculos();
		 numVehiculos++;
		 
		 return numVehiculos;
	 }
	 
	 int restaVehiculo() {
		 int numVehiculos= getNumeroVehiculos();
		 numVehiculos--;
		 
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

	public void setColor(String color) {
		this.color = color;
	}


	public String getModelo() {
		return modelo;
	}


	public String getMatricula() {
		return matricula;
	}


	public String getNumBastidor() {
		return numBastidor;
	}


	public String getColor() {
		return color;
	}


	


	public String getNomSerie() {
		return nomSerie;
	}





	public double getPrecio() {
		return precio;
	}


	public int getNumAsientos() {
		return numAsientos;
	}


	public String getMarca() {
		return marca;
	}


	public String getAño() {
		return año;
	}
	
	
	

	

	
	

}
