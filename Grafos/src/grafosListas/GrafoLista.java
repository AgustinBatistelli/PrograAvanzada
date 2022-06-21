package grafosListas;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import grafos.Grafo;

public class GrafoLista extends Grafo {
	
	protected List<Node>[] graph; // array de listas de nodos!

	@SuppressWarnings("unchecked")
	public GrafoLista(int size) {
		graph = new List[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new LinkedList<Node>();
		}
	}

	@Override
	public int getCantNodos() {
		return graph.length;
	}

	@Override
	public void setArista(int from, int to, double cost) {
		for (Node current : graph[from]) {
			if (current.number == to) {
				current.cost = cost;
				return;
			}
		}
		graph[from].add(new Node(to, cost));
	}

	@Override
	public Double getArista(int from, int to) {
		for (Node current : graph[from]) {
			if (current.number == to)
				return current.cost;
		}
		return null;
	}


	@Override
	public void mostrarGrafoDFS(int nodoOrigen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarGrafoBFS(int nodoOrigen) {
//		int cantVertices = getCantNodos();
//		int[] alturas = new int[cantVertices];
//		Queue<Integer> cola = new LinkedList<Integer>();
//
//		for (int i = 0; i < alturas.length; i++) {
//			alturas[i] = Integer.MAX_VALUE;
//		}
//
//		List<Adyacencia> adyacenciasNodo;
//		cola.add(nodoOrigen);
//		alturas[nodoOrigen] = 0;
//		while (!cola.isEmpty()) {
//			int topeDeCola = cola.remove();
//			
//			adyacenciasNodo = getListaAdyacenciasNodo(topeDeCola);
//			int alturaActual = alturas[topeDeCola] + 1;
//			for (Adyacencia a : adyacenciasNodo) {
//				int destino = a.getDestino();
//				if (alturas[destino] == Integer.MAX_VALUE) {
//					cola.add(destino);
//					alturas[destino] = alturaActual;
//					System.out.println(destino + ", altura:" + alturaActual);
//				}
//			}
//		}
//		
//		
	}

	@Override
	public HashSet<Integer> getNodosAdyacentes(int nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashSet<Integer> getNodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
