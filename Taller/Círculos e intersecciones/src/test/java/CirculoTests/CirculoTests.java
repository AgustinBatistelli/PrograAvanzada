package CirculoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ejercicioCirculo.Circulo;
import ejercicioCirculo.Punto;

public class CirculoTests {

	@Test
	public void testHayInterseccion() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(1, 1), 1.5);
		
		assertTrue(c1.hayInterseccion(c2));
	}
	
	@Test
	public void testNoHayInterseccion() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(4, 0), 1);
		
		assertFalse(c1.hayInterseccion(c2));
	}

	@Test
	public void testMismoCirculo() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(0, 0), 1);
		
		assertTrue(c1.hayInterseccion(c2));
	}
	
}
