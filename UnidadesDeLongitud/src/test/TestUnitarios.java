package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import unidLong.UnidadDeLongitud;
import unidLong.sistemaMetrico.Metro;

public class TestUnitarios {

	@Test
	public void test() {
		Double conversionMetroAPie = Metro.convertir((double) 1, UnidadDeLongitud.METRO, UnidadDeLongitud.PIE);
		
		assertEquals(new Double(3.28), conversionMetroAPie);
	}
	
	@Test
	public void test1() {
		Double conversionMetroAKm = Metro.convertir((double) 1, UnidadDeLongitud.METRO, UnidadDeLongitud.KILOMETRO);
		
		assertEquals(new Double(0.001), conversionMetroAKm);
	}
	
	@Test
	public void test2() {
		Double conversionMetroAMilla = Metro.convertir((double) 1, UnidadDeLongitud.METRO, UnidadDeLongitud.MILLA);
		
		assertEquals(new Double(6.21212121212121E-4), conversionMetroAMilla);
	}


	
	@Test
	public void test3() {
		Double conversionMetroAMetro = Metro.convertir((double) 1, UnidadDeLongitud.METRO, UnidadDeLongitud.METRO);
		
		assertEquals(new Double(1), conversionMetroAMetro);
	}

}
