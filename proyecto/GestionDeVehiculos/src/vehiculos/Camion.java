package vehiculos;

import consultasBD.Precios;
/**
 * 
 * Contiene las propiedades que lo separande de ser un Turismo.
 * 
 */
public class Camion extends Vehiculos{
	private double carga;
	private String mercancia;
	
	public Camion() {}
	
	
	/**
	 * El metodo cargaVehiculo() sobre escribe la clase de la clase "Vehiculos" iniciando el metodo de su clase padre
	 * y pide la informacion que lo caracteriza.
	 */
	@Override
	void cargaVehiculo() {
		super.cargaVehiculo();
		
		System.out.println("Introduzca la capacidad de carga del camion:");
		carga = Console.readDouble();
		System.out.println("Introduzca la el tipo de la mercancia:");
		System.out.println("G");
		System.out.println("A");
		System.out.println("P");
		mercancia = Console.readString();
		
	}
	
	/**
	 *  Pregunta por consola la informacion que caracteriza a un camion y la usa como filtro para mostrar 
	 *  por pantalla los precios de los camiones que encajen con el fitro para posteriormente pedir la matricula y una vez hecha la venta
	 *  eliminar el camion de la base de datos.
	 */
	
	public void vendeCamion() {
		Precios camion = new Precios();
		// INSETAR ESTANDARES DE MEDIDAS DE CARGA.
		System.out.println("¿Que capacidad de carga maxima quiere?");
		System.out.println(""
				+ "18000 kg"
				+ "\n25000 kg"
				+ "\n31000 kg"
				+ "\n32000 kg");
		double carga = Console.readDouble();
		System.out.println("¿Que tipo de mercancia necesita?");
		System.out.println(""
				+ "1: General"
				+"\n2: Árido"
				+"\n3: Peligrosa");
		int tipoDeMercancia = Console.readInt();
		switch(tipoDeMercancia) {
		case 1:
			 String mercancia= "g";
			 camion.preciosCamion(carga, mercancia);
			break;
		case 2:
			 mercancia= "a";
			 camion.preciosCamion(carga, mercancia);
			break;
		case 3:
			 mercancia= "p";
			 camion.preciosCamion(carga, mercancia);
			break;
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+"Carga: "+carga
				+"\nTipo de mercancia: "+mercancia;
	}

	public double getCarga() {
		return carga;
	}

	public String getTipoMercancia() {
		return mercancia;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	public void setMercancia(String mercancia) {
		this.mercancia = mercancia;
	}

	
	
	
	
	
	
	
}
