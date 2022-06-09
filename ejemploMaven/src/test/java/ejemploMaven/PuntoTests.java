package ejemploMaven;

import static org.junit.Assert.*;

import org.junit.Test;

public class PuntoTests {

	@Test	///Esta linea es importante para q funcione
	public void test() {

		assertEquals(1.411414, 1.4141,0.01);
	}
	@Test
	public void test2() {
		
		assertEquals(0, 0,0.01);
	}
	@Test
	public void test3() {
		
		assertEquals(-1, -1,0.01);
	}

}
