package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//grafos no dirigidos.

public class GrafoMatrizAdyacencia extends Grafo {

	protected double[][] matriz;

	public GrafoMatrizAdyacencia(int cantNodos) {
		matriz = new double[cantNodos][cantNodos];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = VALOR_INFINITO;
			}
		}
	}

	public void setArista(int nodoOrigen, int nodoDestino, double valor) {
		matriz[nodoOrigen][nodoDestino] = valor;
	}

	@Override
	public int getCantNodos() {
		return matriz.length;
	}

	public void mostrarMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.format("%3.0f ", matriz[i][j]);
			}
			System.out.print("\n");
		}
	}

	// esta no se para que la usas
	// xq estas metiendo los valores del iterador del for en un set,
	// no son los valores de los nodos..
	@Override
	public HashSet<Integer> getNodos() {
		HashSet<Integer> nodos = new HashSet<Integer>();
		for (int i = 0; i < matriz.length; i++) {
			nodos.add(i);
		}
		return nodos;
	}

	@Override
	public Double getArista(int nodoOrigen, int nodoDestino) {
		return matriz[nodoOrigen][nodoDestino];
	}

	@Override
	public HashSet<Integer> getNodosAdyacentes(int valorNodo) {
		HashSet<Integer> nodosAdyacentes = new HashSet<Integer>();

		for (int i = 0; i < getCantNodos(); i++) {
			if (existeArista(valorNodo, i)) {
				nodosAdyacentes.add(i); // agrego el indice del nodo.
			}
		}

		return nodosAdyacentes;
	}

	public boolean existeArista(int nodoOrigen, int nodoDestino) {
		return getArista(nodoOrigen, nodoDestino) != VALOR_INFINITO;
	}

	@Override
	public void mostrarGrafoDFS(int nodoOrigen) {
		Stack<Integer> pila = new Stack<Integer>();
		Integer[] arrayResultado = new Integer[matriz.length];
		boolean[] arrayVisitado = new boolean[matriz.length];

		pila.add(nodoOrigen);
		arrayVisitado[nodoOrigen] = true;

		int elemAgrego = 0;
		while (!pila.isEmpty()) {
			int nodo = pila.pop();
			arrayResultado[elemAgrego] = nodo;
			for (int i = matriz.length - 1; i >= 0; i--) {
				if (matriz[nodo][i] != VALOR_INFINITO && !arrayVisitado[i]) {
					pila.add(i);
					arrayVisitado[i] = true;
				}
			}
			elemAgrego++;
		}

		for (Integer nodo : arrayResultado) {
				System.out.println(nodo);
		}
		
		// falta chequear si tengo elementos disjuntos, osea si tengo 2 grafos separados
		// o mas..	
	}

	@Override
	public void mostrarGrafoBFS(int nodoOrigen) {
		Queue<Integer> cola = new LinkedList<Integer>();
		Integer[] arrayResultado = new Integer[matriz.length];
		boolean[] arrayVisitado = new boolean[matriz.length]; // todo esta en false al inicio.

		cola.add(nodoOrigen); // lo agrego a la cola..
		arrayVisitado[nodoOrigen] = true; // nodo visitado..

		int elemAgrego = 0;
		while (!cola.isEmpty()) {
			int nodo = cola.remove(); // lo vuelo..
			arrayResultado[elemAgrego] = nodo;
			for (int i = 0; i < matriz.length; i++) {
				if (matriz[nodo][i] != VALOR_INFINITO && !arrayVisitado[i]) {
					cola.add(i); // agrego elemento a la cola..
					arrayVisitado[i] = true; // agrego elemento al array de visitados.
				}
			}
			elemAgrego++;
		}
		
//		for(int i = 0; i < arrayVisitado.length; i++) {
//			if( arrayVisitado[i] == false) {
//				//tengo que ciclar nuevamente... a partir de ese nodo..
//			}
//		}
		
		for (Integer nodo : arrayResultado) {
				System.out.println(nodo);
		}

		// falta chequear si tengo elementos disjuntos, osea si tengo 2 grafos separados
		// o mas..
	}
	
	public void floyd() {

		int cantNodos = getCantNodos();
		double[][] matrizResultado = new double[cantNodos][cantNodos];

		// cargo la matriz con la informacion del grafo.
		
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				matrizResultado[i][j] = matriz[i][j];
			}
		}
		// obtengo el menor valor entre cada arista..
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				for (int k = 0; k < cantNodos; k++) {
					if (i != j && i != k && j != k) {
						matrizResultado[i][j] = min(matrizResultado[i][j],
								matrizResultado[i][k] + matrizResultado[k][j]);
					}
				}
			}
		}
		// muestro la matriz resultado..
		
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				System.out.printf("%4d", (int) matrizResultado[i][j]);
			}
			System.out.println("");
		}
		

	}

	private double min(double val1, double val2) {
		return val1 < val2 ? val1 : val2;
	}

	

}
