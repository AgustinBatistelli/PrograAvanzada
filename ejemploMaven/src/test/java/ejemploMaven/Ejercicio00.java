package ejemploMaven;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import ejercicioCirculo.Circulo;
import ejercicioCirculo.Punto;

/**
 * Una herramienta para verificar que de verdad se intersecten las
 * circunferencias es esta 
 * 
 * https://www.desmos.com/calculator/inuw0lzxkg
 * https://www.geogebra.org/classic?lang=es-AR
 **/

public class Ejercicio00 {

		@Test
		public void testInterseccion1() {
			Circulo circulo1 = new Circulo(new Punto(5, 4), 3);
			Circulo circulo2 = new Circulo(new Punto(8, 6), 2);
			
			assertEquals(true, circulo1.intersectaCon(circulo2));
		}

		@Test
		public void testInterseccion2() {
			Circulo circulo1 = new Circulo(new Punto(5, 4), 3);
			Circulo circulo2 = new Circulo(new Punto(8, 12), 2);
			
			assertEquals(false, circulo1.intersectaCon(circulo2));
		}
		
		@Test
		public void testInterseccion3() {
			Circulo circulo1 = new Circulo(new Punto(5, 4), 3);
			Circulo circulo2 = new Circulo(new Punto(8, 12), 6.25);
			
			assertEquals(true, circulo1.intersectaCon(circulo2));
		}
		
		@Test
		public void testInterseccion4() {
			Circulo circulo1 = new Circulo(new Punto(-5, -4), 3);
			Circulo circulo2 = new Circulo(new Punto(8, 12), 6.25);
			
			assertEquals(false, circulo1.intersectaCon(circulo2));
		}
		
		@Test
		public void testInterseccion5() {
			Circulo circulo1 = new Circulo(new Punto(-5, -4), 3);
			Circulo circulo2 = new Circulo(new Punto(-8, -12), 6.25);
			
			assertEquals(true, circulo1.intersectaCon(circulo2));
		}
	}
	
