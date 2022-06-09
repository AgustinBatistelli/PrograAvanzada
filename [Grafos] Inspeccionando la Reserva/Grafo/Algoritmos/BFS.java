package Algoritmos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Grafo.Arista;
import TiposGrafos.GrafoDP;

public class BFS 
{

	private GrafoDP grafo;
	private int cantNodos;
	private int cantAristas;

	private int nodoInicial;
	private ArrayList<Arista> arbol;
	private boolean[] nodoTerminado;
	public int formasLlegar;
	
	public GrafoDP getGrafo() 
	{
		return grafo;
	}

	public int getCantNodos() 
	{
		return cantNodos;
	}

	public int getCantAristas() 
	{
		return cantAristas;
	}

	public int getNodoInicial() 
	{
		return nodoInicial;
	}

	public BFS(GrafoDP grafo, int nodoInicial) 
	{
		this.grafo = grafo;
		this.cantNodos = grafo.getCantNodos();
		this.cantAristas = grafo.getCantAristas();

		this.nodoInicial = nodoInicial;
		this.arbol = new ArrayList<Arista>();
		this.nodoTerminado = new boolean[this.cantNodos];
	}

	public void ejecutar() throws IOException 
	{
		// cola que almacena los nodos visitados
		Queue<Integer> cola = new LinkedList<Integer>();
		// acolo el nodo inicial
		cola.offer(this.nodoInicial);
		
		int nodo;
		
		// mientras la cola no está vacía
		while(!cola.isEmpty()) {
			// pispeo el primer nodo de la cola
			nodo = cola.peek();
			
			// genero todos los números de nodo
			for (int i = 0; i < this.cantNodos; i++) 
			{
				// si el nodo generado no es el nodo actual y no fue terminado
				if (nodo != i && !this.nodoTerminado[i]) 
				{
					
					// si existe una arista que una estos nodos
					if (this.grafo.hayArista(i, nodo)) 
					{
						this.formasLlegar = this.grafo.formasLlegarANodo(i);
						System.out.println("Formas de llegar al nodo:"  + (i+1) + " es: " + formasLlegar);
						// agrego la arista al árbol
						this.arbol.add(new Arista(nodo, i));
						// acolo el otro nodo de la arista para seguir recorriendo a partir de él
						cola.offer(i);
						// marco como terminado al nodo acolado
						this.nodoTerminado[i] = true;
					}
				}
			}
			
			// desacolo el primer nodo de la cola y lo marco como terminado
			nodo = cola.poll();
			this.nodoTerminado[nodo] = true;
		}
		
		// escribo la solucion en consola
		this.escribirSolucionEnConsola();
	}

	public void escribirSolucionEnConsola() 
	{
		//System.out.println(this.formasLlegar);
		System.out.println("BFS: Búsqueda en Anchura:");
		System.out.println("Cantidad de Ramas del Árbol: " + this.arbol.size());
		System.out.println("Nodo Inicial del Recorrido (Raíz del Árbol): " + this.nodoInicial);
		System.out.println("Lista de Ramas:");
		for (Arista rama : arbol)
			System.out.println((rama.getNodo1()+1) + " " + (rama.getNodo2()+1));
	}
}
