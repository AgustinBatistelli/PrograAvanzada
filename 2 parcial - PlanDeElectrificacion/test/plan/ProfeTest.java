package plan;

import java.io.File;

import org.junit.Test;

public class ProfeTest {

	@Test
	public void caso01() {
		File entrada = new File("lote profe/entradas/0 - Enunciado.in");
		File salida = new File("lote profe/salidas generadas/0 - Enunciado.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso02() {
		File entrada = new File("lote profe/entradas/1 - Caso Vacio.in");
		File salida = new File("lote profe/salidas generadas/1 - Caso Vacio.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso03() {
		File entrada = new File("lote profe/entradas/3 - Caso Doble X.in");
		File salida = new File("lote profe/salidas generadas/3 - Caso Doble X.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso04() {
		File entrada = new File("lote profe/entradas/4 - Caso Circulo.in");
		File salida = new File("lote profe/salidas generadas/4 - Caso Circulo.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso05() {
		File entrada = new File("lote profe/entradas/5 - Caso Rombo.in");
		File salida = new File("lote profe/salidas generadas/5 - Caso Rombo.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso06() {
		File entrada = new File("lote profe/entradas/6 - Caso V.in");
		File salida = new File("lote profe/salidas generadas/6 - Caso V.out");
		new PlanElectrico(entrada, salida).resolver();
	}

	@Test
	public void caso07() {
		File entrada = new File("lote profe/entradas/X - Fatiga.in");
		File salida = new File("lote profe/salidas generadas/X - Fatiga.out");
		new PlanElectrico(entrada, salida).resolver();
	}

}
