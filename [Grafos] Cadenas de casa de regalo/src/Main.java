import java.io.IOException;

import TiposGrafos.GrafoNDNP;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		System.out.println("LOTE DEL EJERCICIO");
		GrafoNDNP ejercicio = new GrafoNDNP("./in/ejercicio.in");
		//RESOLUCION POR COLOREO.
		/* 1) Empiezo por colorear el nodo menos conexo(con menor grado) y guardo el color de ese nodo.
		 * 2) Cada vez que coloreo un nodo del mismo color que el nodo menos conexo aumento el contador.
		 * NOTA: Obviamente, siempre que puedo intento colorear con el mismo color que coloree el primer nodo(tienda)
		 */
		ejercicio.coloreoMatula(1000);
		ejercicio.resultadoEjercicio();
		System.out.println();
		System.out.println("TIENDAS PEGADAS");
		GrafoNDNP tiendasPegadas = new GrafoNDNP("./in/tiendaspegadas.in");
		tiendasPegadas.coloreoMatula(1000);
		tiendasPegadas.resultadoEjercicio();
		System.out.println();
		System.out.println("TOTALMENTE CONEXO");
		GrafoNDNP tiendasTotalmenteConexas = new GrafoNDNP("./in/totalmenteconexo.in");
		tiendasTotalmenteConexas.coloreoMatula(1000);
		tiendasTotalmenteConexas.resultadoEjercicio();
		System.out.println();
		System.out.println("TOTALMENTE NO CONEXO");
		GrafoNDNP tiendasTotalmenteNoConexas = new GrafoNDNP("./in/totalmentenoconexo.in");
		tiendasTotalmenteNoConexas.coloreoMatula(1000);
		tiendasTotalmenteNoConexas.resultadoEjercicio();
	}

}
