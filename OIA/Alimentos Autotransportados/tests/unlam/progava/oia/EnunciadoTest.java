package unlam.progava.oia;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import junitx.framework.FileAssert;

public class EnunciadoTest {

	EjercicioOIA ejercicio = new EjercicioOIA();
	
	@Test
	public void enunciado() throws IOException {
		ejecutarCaso(0);
	}
	
	public void ejecutarCaso(int numCaso) throws IOException {	
		String caso = "0" + numCaso;
		
		String in = "src/unlam/progava/oia/in/" + caso + ".in";
		String expected = "src/unlam/progava/oia/expected/" + caso + ".out";
		String actual = "src/unlam/progava/oia/out/" + caso + ".out";
		
		ejercicio.leer(in);
		ejercicio.resolver();
		ejercicio.escribir(actual);
		
		FileAssert.assertEquals(new File(expected), new File(actual));
	}
	
}
