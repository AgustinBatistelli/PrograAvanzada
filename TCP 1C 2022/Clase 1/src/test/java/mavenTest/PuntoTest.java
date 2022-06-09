package mavenTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ejemploMaven.Punto;

public class PuntoTest {

	@Test
	public void test() {
		Punto p = new Punto(1,1);
		double res = 1.41;
		
		assertEquals(res, p.getModulo(), 0.01);
	}
	
	@Test
	public void test2() {
		Punto p = new Punto(0,0);
		double res = 0;
		
		assertEquals(res, p.getModulo(), 0.01);
	}
	
	@Test
	public void test3() {
		Punto p = new Punto(-1,-1);
		double res = 1.41;
		
		assertEquals(res, p.getModulo(), 0.01);
	}
}
