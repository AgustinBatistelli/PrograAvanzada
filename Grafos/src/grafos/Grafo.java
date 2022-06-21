package grafos;

import java.util.HashSet;

public abstract class Grafo {
	
	protected final double VALOR_INFINITO = 999;
	
	public abstract Double getArista(int nodoOrigen, int nodoDestino);
	public abstract void setArista(int nodoOrigen, int nodoDestino, double valor);
	public abstract int getCantNodos();
	public abstract void mostrarGrafoDFS(int nodoOrigen);
	public abstract void mostrarGrafoBFS(int nodoOrigen);
	public abstract HashSet<Integer> getNodosAdyacentes(int nodo);
	public abstract HashSet<Integer> getNodos();
	
	
	
	
}
