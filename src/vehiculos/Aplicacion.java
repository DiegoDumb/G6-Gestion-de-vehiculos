package vehiculos;



public class Aplicacion {

	public static void main(String[] args){
		
		//MAIN MENU
		Concesionario Statista = new Concesionario();
		System.out.println(Statista.toString());
		System.out.println();
		
		boolean repetir=true;
		while(repetir == true) {
			System.out.println("Buen dia Señor:");
			System.out.println(""
					+ "1.Comprar"
					+"\n2.Vender"
					+"\n3.Ver Stock");
			int opcion = Console.readInt();
			switch(opcion) {
			case 1: 
				Statista.comprar();
				break;
			case 2:
				Statista.vender();
				System.out.println("¿Quiere pintar el vehiculo?");
				String respuesta = Console.readString();
				if(respuesta == "Si" || respuesta == "si") {
					Taller t1 = new Taller();
					System.out.println("Matricula del vehiculo a pintar.");
					String matricula = Console.readString();
					
					
					//con la matricula recoger los datos del vehiculo a pintar.
					
				}
				else if(respuesta == "No" || respuesta == "no") {
					System.out.println("ok");
				}
				break;
			case 3:
				Statista.verStock();
				System.out.println();
				break;
			}
			System.out.println("¿Quiere usted hacer otra operacion?");
			System.out.println("1.Si"
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
