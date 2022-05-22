package unlam.progava.oia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

public class TestsNombresRepetidos {

	@Test
	public void testCasoBase() {
		
		Juego juego = GestorDeArchivos.cargarJuego("tests/unlam/progava/oia/00.IN");
		juego.calcularNombresRepetidos();
		
		TreeMap<String, Integer> mapaResultados = juego.getMapaResultado();
		
		ArrayList<String> arrayNombres = new ArrayList<String>(mapaResultados.size());
		ArrayList<Integer> arrayCantRepetidos = new ArrayList<Integer>(mapaResultados.size());
		
		for(String nombre : mapaResultados.keySet()) {
			
			int cant = mapaResultados.get(nombre);
			
			arrayNombres.add(nombre);
			arrayCantRepetidos.add(cant);

		}
		
		assertEquals("Ana", arrayNombres.get(0));
		assertEquals("Juan", arrayNombres.get(1));
		assertEquals("Juana", arrayNombres.get(2));
		
		assertEquals(5, (int )arrayCantRepetidos.get(0));
		assertEquals(7, (int )arrayCantRepetidos.get(1));
		assertEquals(4, (int )arrayCantRepetidos.get(2));
		
		
		
	}

	
	@Test
	public void testMasMaximosQueNombres() {
		
		Juego juego = GestorDeArchivos.cargarJuego("tests/unlam/progava/oia/01.IN");
		juego.calcularNombresRepetidos();
		
		TreeMap<String, Integer> mapaResultados = juego.getMapaResultado();
		
		ArrayList<String> arrayNombres = new ArrayList<String>(mapaResultados.size());
		ArrayList<Integer> arrayCantRepetidos = new ArrayList<Integer>(mapaResultados.size());
		
		for(String nombre : mapaResultados.keySet()) {
			
			int cant = mapaResultados.get(nombre);
			
			arrayNombres.add(nombre);
			arrayCantRepetidos.add(cant);

		}
		
		assertEquals("Ana", arrayNombres.get(0));
		assertEquals("Ricardo", arrayNombres.get(1));
		
		assertEquals(1, (int )arrayCantRepetidos.get(0));
		assertEquals(1, (int )arrayCantRepetidos.get(1));
		
		
	}

	@Test
	public void testMasMaximosQuePersonasDistintas() {
		
		Juego juego = GestorDeArchivos.cargarJuego("tests/unlam/progava/oia/02.IN");
		juego.calcularNombresRepetidos();
		
		TreeMap<String, Integer> mapaResultados = juego.getMapaResultado();
		
		ArrayList<String> arrayNombres = new ArrayList<String>(mapaResultados.size());
		ArrayList<Integer> arrayCantRepetidos = new ArrayList<Integer>(mapaResultados.size());
		
		for(String nombre : mapaResultados.keySet()) {
			
			int cant = mapaResultados.get(nombre);
			
			arrayNombres.add(nombre);
			arrayCantRepetidos.add(cant);

		}
		
		assertEquals("Ana", arrayNombres.get(0));
		assertEquals(4, (int )arrayCantRepetidos.get(0));
		
		
	}
	
}
