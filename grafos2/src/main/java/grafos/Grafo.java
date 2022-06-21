package grafos;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Grafo {
	public abstract double getArista(int nodoOrigen, int nodoDestino);
	public abstract void setArista(int nodoOrigen, int nodoDestino, double valor);

	public abstract int getCantNodos();
	public abstract void mostrarGrafoDFS(int nodoOrigen);
	public abstract void mostrarGrafoBFS(int nodoOrigen);
	public abstract HashSet<Integer> getNodosAdyacentes(int nodo);
	protected final double VALOR_INFINITO = 999;
	
	public abstract HashSet<Integer> getNodos();
	
	public void dijkstra(int nodoOrigen) {
		int cantNodos = getCantNodos();
		HashSet<Integer> V_S = new HashSet<Integer>(cantNodos);
		ArrayList<Double> D = new ArrayList<Double>(cantNodos);
		ArrayList<Integer> arrayPredecesores = new ArrayList<Integer>(cantNodos);
		
		ArrayList<Boolean> arrayVisitados = new ArrayList<Boolean>(cantNodos);
		///cargamos los pesos
		for(int i = 0; i < cantNodos; i++) {
			arrayVisitados.add(false);
			arrayPredecesores.add(0);
			D.add(getArista(nodoOrigen, i));
			V_S.add(i);
		}
		
		
		
		V_S.remove(nodoOrigen);
		arrayVisitados.set(nodoOrigen, true);
		
		int w;		
		while(!V_S.isEmpty()) {
			w = indiceMinimoArrayList(D, arrayVisitados);
			
			arrayVisitados.set(w, true);
			V_S.remove(w);
			
			for(int j = 0; j < D.size(); j++) {
				if(arrayVisitados.get(j) == false) {/// proceso si no visité el nodo
					if(D.get(j) > D.get(w) + getArista(w, j)) {
						D.set(j, D.get(w) + getArista(w, j));
						arrayPredecesores.set(j, w);
					}
				}
			}
		}	
		System.out.println("Array de costos");
		
		for(Double costo : D) {
			System.out.println(costo);
		}
		
		System.out.println("Array de predecesores");
		
		for(int nodo : arrayPredecesores) {
			System.out.println(nodo);
		}
	}
	
		private int indiceMinimoArrayList(ArrayList<Double> D, ArrayList<Boolean> arrayVisitados) {
	
		int indice = 0;
		double min = VALOR_INFINITO;
		
		
		for(int i = 0 ; i < D.size(); i++) {
			if(arrayVisitados.get(i) == false) {
				min = D.get(i);
				indice = i;
			}
		}		
		for(int i = 0; i < D.size(); i++) {
			if(arrayVisitados.get(i) == false && D.get(i) < min) {
				min = D.get(i);
				indice = i;
			}
		}
		return indice;
	}
	
}
