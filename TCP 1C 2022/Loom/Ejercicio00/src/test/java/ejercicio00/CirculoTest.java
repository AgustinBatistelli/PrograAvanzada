package ejercicio00;

import static org.junit.Assert.*;

import org.junit.Test;

import circulo.Circulo;
import punto.Punto;

public class CirculoTest {

	@Test
	public void test() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(1, 1), 1);
		assertEquals(true, c1.intersectaCon(c2));
//		System.out.println(c1.intersectaCon(c2)); // true
	}

}
