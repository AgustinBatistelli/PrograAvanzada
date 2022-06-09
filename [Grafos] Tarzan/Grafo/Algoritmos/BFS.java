package Algoritmos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Grafo.Arista;
import Grafo.Grafo;
public class BFS 
{

	private Grafo grafo;
	private int cantNodos;

	private int nodoInicial;
	private ArrayList<Arista> arbol;
	private boolean[] nodoVisitado;

	public BFS(Grafo grafo, int nodoInicial) 
	{
		this.grafo = grafo;
		this.cantNodos = grafo.cantNodos;

		this.nodoInicial = nodoInicial;
		this.arbol = new ArrayList<Arista>();
		this.nodoVisitado = new boolean[this.cantNodos];
	}

	public void ejecutar() throws IOException 
	{
		Queue<Integer> cola = new LinkedList<Integer>();
		cola.offer(this.nodoInicial);
		int nodo;
		while(!cola.isEmpty()) {
			nodo = cola.peek();
			for (int i = 0; i < this.cantNodos; i++)
			{
				if (nodo != i && !this.nodoVisitado[i])
				{
					if (this.grafo.hayArista(nodo, i))
					{
						this.arbol.add(new Arista(nodo, i));
						cola.offer(i);
						this.nodoVisitado[i] = true;
					}
				}
			}
			nodo = cola.poll();
			this.nodoVisitado[nodo] = true;
		}
		this.escribirSolucionEnConsola();
	}

	public void escribirSolucionEnConsola() 
	{
		System.out.println("BFS: Búsqueda en Anchura:");
		System.out.println("Cantidad de Ramas del Árbol: " + this.arbol.size());
		System.out.println("Nodo Inicial del Recorrido (Raíz del Árbol): " + this.nodoInicial);
		System.out.println("Lista de Ramas:");
		for (Arista rama : arbol)
			System.out.println(rama.getNodo1() + " " + rama.getNodo2());
	}
}
