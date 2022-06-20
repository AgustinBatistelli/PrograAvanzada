package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GrafoMatrizAdyacencia extends Grafo {
	
	protected double[][] matriz;
	
	
	public GrafoMatrizAdyacencia(int cantNodos) {
		matriz = new double[cantNodos][cantNodos];
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
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
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				System.out.format("%3.0f ", matriz[i][j]);
			}
			System.out.print("\n");
		}
	}

	@Override
	public HashSet<Integer> getNodos(){
		HashSet<Integer> nodos = new HashSet<Integer>();
		for(int i = 0; i < matriz.length; i++) {
			nodos.add(i);
		}
		return nodos;
		
	}
	
	@Override
	public double getArista(int nodoOrigen, int nodoDestino) {
		return matriz[nodoOrigen][nodoDestino];	
	}
	
	@Override
	public HashSet<Integer> getNodosAdyacentes(int nodo){
		HashSet<Integer> nodosAdyacentes = new HashSet<Integer>();
		
		for(int i = 0; i < getCantNodos(); i++) {
			if(existeArista(nodo, i)) {
				nodosAdyacentes.add(i);
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
		ArrayList<Integer> arrayResultado = new ArrayList<Integer>();
		ArrayList<Integer> arrayVisitados = new ArrayList<Integer>();
		
		pila.add(nodoOrigen);
		while(!pila.isEmpty()) {
			int nodo = pila.pop();
			arrayResultado.add(nodo);
			for(int i = 0; i < matriz.length; i++) {
				if(matriz[nodo][i] != VALOR_INFINITO && !arrayResultado.contains(i)  && !arrayVisitados.contains(i)) {
					pila.add(i);
					arrayVisitados.add(i);
				}
			}
		}
		
		for(Integer nodo: arrayResultado) {
			System.out.println(nodo);
		}	
	}


	@Override
	public void mostrarGrafoBFS(int nodoOrigen) {
		Queue<Integer> cola = new LinkedList<Integer>();
		ArrayList<Integer> arrayResultado = new ArrayList<Integer>();
		ArrayList<Integer> arrayVisitados = new ArrayList<Integer>();
		
		cola.add(nodoOrigen);
		while(!cola.isEmpty()) {			
			int nodo = cola.remove();
			arrayResultado.add(nodo);
			arrayVisitados.add(nodo);
			for(int i = 0; i < matriz.length; i++) {
				if(matriz[nodo][i] != VALOR_INFINITO && !arrayResultado.contains(i) && !arrayVisitados.contains(i)) {
					cola.add(i);
					arrayVisitados.add(i);
				}
			}
		
		}
		
		for(Integer nodo: arrayResultado) {
			System.out.println(nodo);
		}
	}
}
