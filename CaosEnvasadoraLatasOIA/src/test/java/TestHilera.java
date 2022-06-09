import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestHilera {

	@Test
	public void testCasoBase() {
		HileraDeLatas hilera = GestorArchivos.cargarHilera("./src/test/resources/archivosIN/inputCasoBase.IN");
		
		ArrayList<Integer> arrayRespuestaSalida = hilera.procesarHilera();
				
		assertEquals(45, (int) arrayRespuestaSalida.get(0));
		assertEquals(9,(int) arrayRespuestaSalida.get(1));
		assertEquals(6,(int) arrayRespuestaSalida.get(2));
		assertEquals(10, (int) arrayRespuestaSalida.get(3));
		
	}
	
	@Test
	public void testUnaSolaHilera() {
		HileraDeLatas hilera = GestorArchivos.cargarHilera("./src/test/resources/archivosIN/inputCasoUnaSolaConsecutiva.IN");
		
		ArrayList<Integer> arrayRespuestaSalida = hilera.procesarHilera();
				
		assertEquals(7, (int) arrayRespuestaSalida.get(0));
		assertEquals(4,(int) arrayRespuestaSalida.get(1));
		assertEquals(0,(int) arrayRespuestaSalida.get(2));
		assertEquals(0,(int) arrayRespuestaSalida.get(3));
		
	}
	
	@Test
	public void testUnaSolaHileraYSoloGarbanzos() {
		HileraDeLatas hilera = GestorArchivos.cargarHilera("./src/test/resources/archivosIN/inputCasoUnaSolaConsecutivaGarbanzos.IN");
		
		ArrayList<Integer> arrayRespuestaSalida = hilera.procesarHilera();
				
		assertEquals(4, (int) arrayRespuestaSalida.get(0));
		assertEquals(4,(int) arrayRespuestaSalida.get(1));
		assertEquals(0,(int) arrayRespuestaSalida.get(2));
		assertEquals(0,(int) arrayRespuestaSalida.get(3));
		
	}

	@Test
	public void testSinLineasGarbanzo() {
		HileraDeLatas hilera = GestorArchivos.cargarHilera("./src/test/resources/archivosIN/inputSinLineasGarbanzo.IN");
		
		ArrayList<Integer> arrayRespuestaSalida = hilera.procesarHilera();
				
		assertEquals(9, (int) arrayRespuestaSalida.get(0));
		assertEquals(0,(int) arrayRespuestaSalida.get(1));
		assertEquals(0,(int) arrayRespuestaSalida.get(2));
		assertEquals(0,(int) arrayRespuestaSalida.get(3));
		
	}
	
	
}
