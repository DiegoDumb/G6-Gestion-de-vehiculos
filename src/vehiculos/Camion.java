package vehiculos;
import javax.xml.soap.SAAJResult;

import consultasBD.Precios;
import consultasBD.Stock;
/**
 * 
 * La clase "Camion" contiene las propiedades que lo separande de ser un Turismo.
 * 
 * El metodo cargaVehiculo() sobre escribe la clase de la clase "Vehiculos" iniciando el metodo de su clase padre
 * y pide la informacion que lo caracteriza.
 * 
 * El metodo vendeCamion() pregunta por consola la informacion que caracteriza a un camion y la usa como filtro para mostrar 
 * por pantalla los precios de los camiones que encajen con el fitro para posteriormente pedir la matricula y una vez hecha la venta
 * eliminar el camion de la base de datos.
 * 
 */
public class Camion extends Vehiculos{
	private double carga;
	private String tipoMercancia;
	
	public Camion() {}
	
	@Override
	void cargaVehiculo() {
		super.cargaVehiculo();
		
		System.out.println("Introduzca la capacidad de carga del camion:");
		carga = Console.readDouble();
		System.out.println("Introduzca la el tipo de la mercancia:");
		System.out.println("G");
		System.out.println("A");
		System.out.println("P");
		tipoMercancia = Console.readString();
		
		sumaVehiculo();
	}
	
	void vendeCamion() {
		Precios camion = new Precios();
		Stock camiones = new Stock();
		char mercancia;
		// INSETAR ESTANDARES DE MEDIDAS DE CARGA.
		System.out.println("¿Que capacidad de carga maxima quiere?");
		double carga = Console.readDouble();
		System.out.println("¿Que tipo de mercancia necesita?");
		System.out.println(""
				+ "1: General"
				+"\n2: Árido"
				+"\n3: Peligrosa");
		int tipoDeMercancia = Console.readChar();
		switch(tipoDeMercancia) {
		case 1:
			 mercancia= 'g';
			 camion.preciosCamion(carga, mercancia);
			 System.out.println("Introduzca la matricula del camion que desea: ");
			 String matriculaG = Console.readString();
			 camiones.eliminarStock(matriculaG);
			break;
		case 2:
			 mercancia= 'a';
			 camion.preciosCamion(carga, mercancia);
			 System.out.println("Introduzca la matricula del camion que desea: ");
			 String matriculaA = Console.readString();
			 camiones.eliminarStock(matriculaA);
			break;
		case 3:
			 mercancia= 'p';
			 camion.preciosCamion(carga, mercancia);
			 System.out.println("Introduzca la matricula del camion que desea: ");
			 String matriculaP = Console.readString();
			 camiones.eliminarStock(matriculaP);
			break;
		}
		
		
		
		restaVehiculo();
	}
	
	@Override
	public String toString() {
		return super.toString()+"Carga: "+carga
				+"Tipo de mercancia: "+tipoMercancia;
	}

	public double getCarga() {
		return carga;
	}

	public String getTipoMercancia() {
		return tipoMercancia;
	}

	
	
	
	
	
}
