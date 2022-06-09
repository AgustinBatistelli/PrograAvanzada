package Algoritmos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import Grafo.Arista;
import Grafo.Grafo;

public class DFS {

	private Grafo grafo;
	private int cantNodos;

	private int nodoInicial;
	private ArrayList<Arista> arbol;
	private boolean[] nodoVisitado;

	public DFS(Grafo grafo, int nodoInicial) 
	{
		this.grafo = grafo;
		this.cantNodos = grafo.cantNodos;

		this.nodoInicial = nodoInicial;
		this.arbol = new ArrayList<Arista>();
		this.nodoVisitado = new boolean[this.cantNodos];
	}

	public ArrayList<Arista> ejecutar() throws IOException 
	{
		Stack<Integer> pila = new Stack<Integer>(); //Creo una pila.
		pila.push(this.nodoInicial); //Agrego el nodo inicial a la pila.
		int nodo; // Variable auxiliar nodo.
		boolean adyacente = false; //Variable auxiliar adyacente.
		
		while(!pila.isEmpty()) //Mientras la pila no este vacia.
		{
			nodo = pila.peek(); //Asigno el nodo al primero de la pila.
			for (int i = 0; i < this.cantNodos; i++) //For hast cantidad de nodos.
			{
				if (nodo != i && !this.nodoVisitado[i]) //Si el i es distinto del nodo y i no fue visitado.
				{
					if (this.grafo.hayArista(nodo, i)) //Si hay una arista que conecte nodo y i.
					{
						this.arbol.add(new Arista(nodo, i)); //Agrego la arista al arbol.
						this.nodoVisitado[nodo] = true; //Lo marco como visitado al nodo.
						pila.push(i); //Agrego a la pila el i.
						adyacente = true; //Lo marco como adyacente.
						break; //BREAK Salgo.
					}
				}
			}
			if (!adyacente) //Si no tiene mas adyacentes.
			{
				nodo = pila.pop(); //Lo saco de la pila.
				this.nodoVisitado[nodo] = true; //Lo marco como visitado.
			} else //Si tiene adyacentes no lo saco de la pila.
				adyacente = false;
		}
		
		//this.escribirSolucionEnConsola();
		
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		for (Arista rama : arbol)
			aristas.add(new Arista(rama.getNodo1(), rama.getNodo2()));
		return aristas;
		
	}

	public void escribirSolucionEnConsola() 
	{
		System.out.println("DFS: Búsqueda en Profundidad:");
		System.out.println("Cantidad de Ramas del Árbol: " + this.arbol.size());
		System.out.println("Nodo Inicial del Recorrido (Raíz del Árbol): " + (this.nodoInicial+1));
		System.out.println("Lista de Ramas:");
		for (Arista rama : arbol)
			System.out.println((rama.getNodo1()+1) + " " + (rama.getNodo2()+1));
	}
}
