package ejercicioCirculo;

/*Consigna
Para construir un círculo se requiere un punto, que será su centro, y un radio. 
Nuestro pequeño programa nos permitirá verificar si hay o no intersección entre dos círculos.
Se te pide programar las clases Punto, Circulo, y una prueba que te permita verificar el correcto
funcionamiento del método especificado.

Ejemplo de funcionamiento:

Circulo c1 = new Circulo(new Punto(0, 0), 1);
Circulo c2 = new Circulo(new Punto(1, 1), 1.5);
System.out.println(c1.intersectaCon(c2)); // true
*/

public class Circulo {

	private Punto centro;
	private double radio;

	public Circulo(Punto _centro, double _radio) {
		super();
		centro = _centro;
		radio = _radio;
	}

	public boolean intersectaCon(Circulo c2) {
		 
		if( radio + c2.radio >= centro.calcularDistanciaDesde(c2.centro))
			return true;
		return false;
	}

	
	public static void main(String[] args) {
		
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(1, 1), 1.5);
		Punto p1 = new Punto(0,0);
		Punto p2 = new Punto(1,1);
		System.out.println("Disatncia entre punto c1 y c2= " + p1.calcularDistanciaDesde(p2));
		
		System.out.println("El resultado es :" + c1.intersectaCon(c2)); // true

	}

}
