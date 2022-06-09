package punto;

public class Punto2DTest {

	public static void main(String[] args) {
		Punto2D p1 = new Punto2D(2.3, 5);
		Punto2D p2 = new Punto2D(2.3, 5);
				
		p2.desplazar(1, 1);
		
		if(p1 == p2)  { //false
			System.out.println("Son iguales");
		} else {
			System.out.println("Son distintos");
		}
		
		if(p1.equals(p2)) //true
			System.out.println("Son iguales");
		else
			System.out.println("Son distintos");
		
		Punto2D p3 = p1.suma(p2);
		
		System.out.println("P1 : " + p1);
		System.out.println("P2 : " + p2);
		System.out.println("P3 : " + p3);
	}
}
