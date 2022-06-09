package tests;

import java.io.IOException;

import org.junit.Test;

import myPackage.Tarzan;

public class Tests {

	@Test
	public void caso_00() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/00_CasoDelEnunciado.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/00_CasoDelEnunciado.out");
	}
	
	@Test
	public void caso_01() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/01_NoHayCamino.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/01_NoHayCamino.out");
	}

	@Test
	public void caso_02() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/02_HayUnSoloCamino.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/02_HayUnSoloCamino.out");
	}
	
	@Test
	public void caso_03_a() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/03_HayMásDeUnCamino.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/03_HayMásDeUnCamino (a).out");
	}
	
	@Test
	public void caso_03_b() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/03_HayMásDeUnCamino.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/03_HayMásDeUnCamino (b).out");
	}
	
	@Test
	public void caso_04() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/04_TodoEnVertical.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/04_TodoEnVertical.out");
	}
	
	@Test
	public void caso_05() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/05_TodoEnHorizontal.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/05_TodoEnHorizontal.out");
	}
	
	@Test
	public void caso_06() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/06_UnSoloÁrbol.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/06_UnSoloÁrbol.out");
	}
	
	@Test
	public void caso_07() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/07_DosÁrboles.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/07_DosÁrboles.out");
	}
	
	@Test
	public void caso_08() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/08_1000Arboles(Fatiga).in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/08_1000Arboles(Fatiga).out");
	}
	
	@Test
	public void caso_09() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/09_NoSePuedeSaltarANingúnÁrbol.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/09_NoSePuedeSaltarANingúnÁrbol.out");
	}
	
	@Test
	public void caso_10() throws IOException {
		Tarzan t = new Tarzan("lote de prueba/entradas/10_SePuedeSaltarEntreTodosLosÁrboles.in");
		t.dijkstra();
		t.escribirSolucion("lote de prueba/salidas producidas/10_SePuedeSaltarEntreTodosLosÁrboles.out");
	}
}
