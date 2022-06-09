package plan;

import java.io.File;

import org.junit.Test;

public class PlanTest {

	@Test
	public void caso01() {
		File entrada = new File("preparacion de prueba/lote de prueba/entrada/01_TodasTienenCentrales.in");
		File salida = new File("ejecucion de prueba/salida obtenida/01_TodasTienenCentrales.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso02() {
		File entrada = new File("preparacion de prueba/lote de prueba/entrada/02_UnaSolaCentral.in");
		File salida = new File("ejecucion de prueba/salida obtenida/02_UnaSolaCentral.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso03() {
		File entrada = new File("preparacion de prueba/lote de prueba/entrada/03_AlgunasTienenCentralesYTodasAlimentan.in");
		File salida = new File("ejecucion de prueba/salida obtenida/03_AlgunasTienenCentralesYTodasAlimentan.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso04() {
		File entrada = new File("preparacion de prueba/lote de prueba/entrada/04_AlgunasTienenCentralesYAlgunasAlimentan.in");
		File salida = new File("ejecucion de prueba/salida obtenida/04_AlgunasTienenCentralesYAlgunasAlimentan.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso05() {
		File entrada = new File("preparacion de prueba/lote de prueba/entrada/05_AlgunasTienenCentralesYSoloUnaAlimenta.in");
		File salida = new File("ejecucion de prueba/salida obtenida/05_AlgunasTienenCentralesYSoloUnaAlimenta.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso06() {
		File entrada = new File("preparacion de prueba/lote de prueba/entrada/06_MasDeUnTendidoConCostoMinimo.in");
		File salida = new File("ejecucion de prueba/salida obtenida/06_MasDeUnTendidoConCostoMinimo.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso07() {
		File entrada = new File("preparacion de prueba/lote de prueba/entrada/07_UnSoloTendidoConCostoMínimo.in");
		File salida = new File("ejecucion de prueba/salida obtenida/07_UnSoloTendidoConCostoMínimo.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso08() {
		File entrada = new File("preparacion de prueba/lote de prueba/entrada/08_Fatiga.in");
		File salida = new File("ejecucion de prueba/salida obtenida/08_Fatiga.out");
		new PlanElectrico(entrada, salida).resolver();
	}

}
