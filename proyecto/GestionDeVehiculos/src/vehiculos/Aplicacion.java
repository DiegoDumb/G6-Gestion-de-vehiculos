package vehiculos;


import consultasBD.Stock;
import consultasBD.XML;

/**
 * 
 * @author diego
 * Esta clase se encarga de iniciar la aplicacion y los metodos.
 * La mayoria de las interacciones con el usuario y el menu basico se gestionan aqui.
 */
public class Aplicacion {

	public static void main(String[] args){
		
		//MAIN MENU
		XML xml = new XML();
		Concesionario Statista = new Concesionario();
		System.out.println(Statista.toString());
		System.out.println();
		boolean repetir=true;
		while(repetir == true) {
			System.out.println("Buen dia Señor:");
			System.out.println(""
					+"1.Comprar"
					+"\n2.Vender"
					+"\n3.Ver Stock"
					+"\n4 crear XML"
					+"\n5 cargar XML");
			int opcion = Console.readInt();
			switch(opcion) {
			case 1: 
				Statista.comprar();
				break;
			case 2:
				Stock stock = new Stock();
				Statista.vender();
				System.out.println("Matricula del vehiculo que quiere:");
				String matricula = Console.readString();
				System.out.println("¿Quiere pintar el vehiculo?");
				System.out.println("1. Si");
				System.out.println("0. No");
				int respuesta = Console.readInt();
				if(respuesta == 1) {
					Taller taller = new Taller();
					System.out.println("Taller:");
					System.out.println(taller.toString());
					
					taller.pintar(matricula);
					
					stock.eliminarStock(matricula);
					System.out.println("Venta hecha");
				}
				else if(respuesta == 0) {
					System.out.println("ok");
					stock.eliminarStock(matricula);
					System.out.println("Venta hecha");
				}
				break;
			case 3:
				System.out.println();
				Statista.verStock();
				break;
			case 4:
				xml.crearXML();
				break;
			case 5:
				xml.cargarXML();
				break;
			}
			System.out.println("¿Quiere usted hacer otra operacion?");
			System.out.println(""
					+ "1.Si"
					+"\n2.No");
			int respuesta = Console.readInt();
			switch (respuesta) {
			case 1:
				repetir = true;
				break;
			case 2:
				repetir = false;
				System.out.println("Adios.");
				break;
			}
		}
		
	}

}
