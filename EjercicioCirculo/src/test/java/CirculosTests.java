import static org.junit.Assert.*;

import org.junit.Test;

import ejercicioCirculo.Circulo;
import ejercicioCirculo.Punto;

public class CirculosTests {

	@Test
	public void testIntersecta1() {
		Circulo c1 = new Circulo(new Punto(0, 0), 2);
		Circulo c2 = new Circulo(new Punto(1, 1), 1);
		
		assertTrue(c1.intersectaCon(c2));
	}
	
	@Test
	public void testIntersecta2() {
		Circulo c1 = new Circulo(new Punto(-1, -1), 2);
		Circulo c2 = new Circulo(new Punto(-2, -2), 3);
		
		assertTrue(c1.intersectaCon(c2));
	}
	
	@Test
	public void testNoIntersecta1() {
		Circulo c1 = new Circulo(new Punto(0, 0), 2);
		Circulo c2 = new Circulo(new Punto(10, 10), 1);
		
		assertFalse(c1.intersectaCon(c2));
	}
	
	@Test
	public void testNoIntersecta2() {
		Circulo c1 = new Circulo(new Punto(-10, -10), 2);
		Circulo c2 = new Circulo(new Punto(5, 5), 5);
		
		assertFalse(c1.intersectaCon(c2));
	}

}
