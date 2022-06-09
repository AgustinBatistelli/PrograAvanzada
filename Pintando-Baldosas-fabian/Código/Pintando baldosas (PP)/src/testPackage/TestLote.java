package testPackage;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import myPackage.Probador;

public class TestLote {

	@Test
	public void caso_00() {
		File entrada = new File("Lote de Prueba/Entrada/00_CasoDelEnunciado.in");
		File salida = new File("Lote de Prueba/Salida Producida/00_CasoDelEnunciado.out");
		Probador prob = new Probador(entrada, salida);
		Assert.assertTrue(prob.probar());
	}
	
	@Test
	public void caso_01() {
		File entrada = new File("Lote de Prueba/Entrada/01_TodasPintadasDelMismoColor.in");
		File salida = new File("Lote de Prueba/Salida Producida/01_TodasPintadasDelMismoColor.out");
		Probador prob = new Probador(entrada, salida);
		Assert.assertFalse(prob.probar());
	}
	
	@Test
	public void caso_02() {
		File entrada = new File("Lote de Prueba/Entrada/02_SoloDosColores.in");
		File salida = new File("Lote de Prueba/Salida Producida/02_SoloDosColores.out");
		Probador prob = new Probador(entrada, salida);
		Assert.assertFalse(prob.probar());
	}
	
	@Test
	public void caso_03() {
		File entrada = new File("Lote de Prueba/Entrada/03_ColoresConsecutivosIguales.in");
		File salida = new File("Lote de Prueba/Salida Producida/03_ColoresConsecutivosIguales.out");
		Probador prob = new Probador(entrada, salida);
		Assert.assertFalse(prob.probar());
	}
	
	@Test
	public void caso_04() {
		File entrada = new File("Lote de Prueba/Entrada/04_NoHayLaMismaCantidadDeColores.in");
		File salida = new File("Lote de Prueba/Salida Producida/04_NoHayLaMismaCantidadDeColores.out");
		Probador prob = new Probador(entrada, salida);
		Assert.assertFalse(prob.probar());
	}
	
	@Test
	public void caso_05() {
		File entrada = new File("Lote de Prueba/Entrada/05_NingunaBaldosaPintada.in");
		File salida = new File("Lote de Prueba/Salida Producida/05_NingunaBaldosaPintada.out");
		Probador prob = new Probador(entrada, salida);
		Assert.assertFalse(prob.probar());
	}

	@Test
	public void caso_06() {
		File entrada = new File("Lote de Prueba/Entrada/06_MePintaronLaBaldosaQueYaEstabaPintada.in");
		File salida = new File("Lote de Prueba/Salida Producida/06_MePintaronLaBaldosaQueYaEstabaPintada.out");
		Probador prob = new Probador(entrada, salida);
		Assert.assertFalse(prob.probar());
	}
}
