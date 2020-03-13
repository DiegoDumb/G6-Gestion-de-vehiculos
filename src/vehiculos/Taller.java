package vehiculos;

public class Taller{
	
	String nombre;
	String direccion;
	int tlf;
	String NIF;
	
	public Taller() {
		nombre = "Los Santos Customs";
		direccion = "C/ Macarena nº 23- 38016- Madrid";
		tlf = 384527905;
		NIF = "C63213603";
	}
	
	void pintar(){
		System.out.println("¿De que color quiere pintar el vehiculo?");
		String color = Console.readString();
		//ORDEN UPDATE para cambiar el color
		System.out.println("Su vehiculo ahora es de color "+color);
	}
	
	public String toString() {
		return "Nombre: "+nombre
				+"Direccion"+direccion
				+"Telefono: "+tlf
				+"NIF: "+NIF;
	}
	
}
