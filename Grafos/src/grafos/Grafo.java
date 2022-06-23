package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Grafo {

	protected final double VALOR_INFINITO = 999;

	public abstract Double getArista(int nodoOrigen, int nodoDestino);

	public abstract void setArista(int nodoOrigen, int nodoDestino, double valor);

	public abstract int getCantNodos();

	public abstract void mostrarGrafoDFS(int nodoOrigen);

	public abstract void mostrarGrafoBFS(int nodoOrigen);

	public abstract HashSet<Integer> getNodosAdyacentes(int nodo);

	public abstract HashSet<Integer> getNodos();

	public void dijkstra(int nodoOrigen) {
		int cantNodos = getCantNodos();
		ArrayList<Integer> predecesores = new ArrayList<Integer>(cantNodos);
		ArrayList<Boolean> visitados = new ArrayList<Boolean>(cantNodos);
		ArrayList<Double> valores = new ArrayList<Double>(cantNodos);
		Set<Integer> V_S = new HashSet<Integer>(cantNodos); // conjunto de nodos aun no alcanzados con minimo valor..
		
		//se realiza la carga correspondiente de las distintas estructuras..
		for (int i = 0; i < cantNodos; i++) {
			visitados.add(false);
			predecesores.add(nodoOrigen);
			valores.add(getArista(nodoOrigen, i));
			V_S.add(i);
		}
		
		V_S.remove(nodoOrigen); // vuelo el nodo inicial del conjunto

		int w = 0; // indiceMenorValor
		
		// mientras el conjunto no sea vacio itero..
		while (!V_S.isEmpty()) {
			
			// busco el indice de menor valor.
			
			double menor = VALOR_INFINITO;
			for (int i = 0; i < valores.size(); i++) {
				if (valores.get(i) < menor && !visitados.get(i)) {
					menor = valores.get(i);
					w = i;
				}
			}
			
			visitados.set(w, true); // marco como visitado.
			V_S.remove(w);			// lo vuelo del set.

			// Ahora voy a iterar y fijarme si puedo llegar a los distintos nodos con un
			// costo menor si primero paso por el nodo w.

			for (int i = 0; i < cantNodos; i++) {
				if (visitados.get(i) == false) {
					if (valores.get(i) > valores.get(w) + getArista(w, i)) {
						valores.set(i, valores.get(w) + getArista(w, i));
						predecesores.set(i, w);
					}
				}
			}
		}

		// Para mostrar el grafo tengo que recorrer el vector de procedencia desde el ultimo valor de w..
		// Para esto uso w, que es el indice del ultimo nodo al que llegue..

		System.out.println("Caminos mas cortos de " + nodoOrigen + " a ...");

		while (w != nodoOrigen) {

			System.out.println(w + ", costo " + valores.get(w));
			w = predecesores.get(w);
		}

	}

}
