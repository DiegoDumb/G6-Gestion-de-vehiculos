package vehiculos;

import vehiculos.*;

public class Aplicacion {

	public static void main(String[] args) {
		//MAIN MENU
		System.out.println("Buen dia Sr");
		System.out.println("1.Comprar"
				+"\n2.Vender");
		int opcion = Console.readInt();
		switch(opcion) {
		case 1: 
			System.out.println("Turismo - Camion");
			System.out.println("T");
			System.out.println("C");
			
			char tipoVehiculo = Console.readChar();
			if(tipoVehiculo == 't' || tipoVehiculo == 'T') {
				Turismo turismo = new Turismo();
				turismo.cargaVehiculo();
			}
			else if(tipoVehiculo == 'c' || tipoVehiculo == 'C') {
				Camion camion = new Camion();
				camion.cargaVehiculo();
			}
			break;
		case 2:
			
			break;
		}
		
		
	}

}
