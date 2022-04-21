
//todos los objetos heredan de la clase object
public class Pruebas {

	public static void main(String[] args) {

		// Punto punto1; variable referencia
		Punto punto1 = new Punto(); // instancio el obj
		System.out.println(punto1); // direc mem donde esta el obj

		Punto punto2 = new Punto(2, 4);
//		Punto punto2 = new Punto();
		System.out.println(punto2);

//		if(punto1 == punto2) estoy cmp las referencias(direc de mem de punto1 con direc mem punto2)

		if (punto1.equals(punto2))
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
		
		punto2.desplazar(1, 2);
		
		System.out.println(punto1); 
		System.out.println(punto2);
		
		Punto punto3 = punto1.suma(punto2);
		
		System.out.println(punto1); 
		System.out.println(punto2);
		System.out.println(punto3);
		
		
		
	}
	
}
