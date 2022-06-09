package Algoritmos;

import java.util.ArrayList;

import Grafos.GrafoNoDirigidoPonderado;

public class Prim {
	
	public static int prim(int nodoIni, GrafoNoDirigidoPonderado grafo) {
		int costoTotal = 0;
		ArrayList<Integer> conjuntoSolucion = new ArrayList<Integer>();
		ArrayList<Integer> conjuntoNodos = new ArrayList<Integer>();
		conjuntoSolucion.add(nodoIni);
		for (int i = 0; i < grafo.getMatrizAdyacencia().length; i++) {
			if (nodoIni != i) {
				conjuntoNodos.add(i);
			}
		}
		while (conjuntoNodos.size() != 0) {
			int nodoDeCNodos = 0;
			int nodoDeCSolucion = 0;
			int costo = Integer.MAX_VALUE;
			for (int nodo : conjuntoSolucion) {
				for (int j = 0; j < grafo.getMatrizAdyacencia().length; j++) {
					if (!conjuntoSolucion.contains(j) && grafo.getMatrizAdyacencia()[nodo][j] < costo) {
						costo = grafo.getMatrizAdyacencia()[nodo][j];
						nodoDeCNodos = j;
						nodoDeCSolucion = nodo;
					}
				}
			}
			costoTotal += costo;
			conjuntoSolucion.add(nodoDeCNodos);
			conjuntoNodos.remove((Object) nodoDeCNodos);
			grafo.getArbolAbarcadorDeMenorCosto()[nodoDeCSolucion][nodoDeCNodos] = costo;
			grafo.getArbolAbarcadorDeMenorCosto()[nodoDeCNodos][nodoDeCSolucion] = costo;
		}
		return costoTotal;
	}

}
