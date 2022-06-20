
public class Pruebas {
	public static void main(String[] args) {
		Punto punto1 = new Punto();
		Punto punto2 = new Punto(2.3, 5);
		
		System.out.println(punto1.equals(punto2));
//		System.out.println(punto2); //se invoca implicitamente a toString() de Punto
	}
}
