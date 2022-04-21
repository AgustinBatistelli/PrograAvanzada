package ejemploMaven;

import static org.junit.Assert.*;

import org.junit.Test;

import ejercicioCirculo.Punto;

public class PuntoTests {

	@Test //le digo a java que es una prueba sino no funca
	public void test() {
//		fail("Not yet implemented");
		
		Punto p = new Punto(1, 1);
		
//		double modulo = p.getModulo();
		double resultadoEsperado = 1.44;
		
		
//		assertEquals(resultadoEsperado, modulo, 0,01);
	}

}
