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
		this.cantNodos = Grafo.nodosMaximos;

		this.nodoInicial = nodoInicial;
		this.arbol = new ArrayList<Arista>();
		this.nodoVisitado = new boolean[Grafo.nodosMaximos];
	}

	@SuppressWarnings("unused")
	public int[]ejecutar() throws IOException 
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
		int i = 0;
		//Recorro para saber la cantidad maxima real de aristas del grafo.
		for (Arista rama : arbol)
			i+=3; //Incremento de a 3. Esto es para no decir bueno el vector va a tener 100000 posiciones.
		int v[] = new int[i];
		i = 0;
		//Recorro las aristas del grafo.
		for (Arista rama : arbol)
		{
			i++;
			v[i] = rama.getNodo1();
			i++;
			v[i] = rama.getNodo2();
		}
		return v;
	}
}
