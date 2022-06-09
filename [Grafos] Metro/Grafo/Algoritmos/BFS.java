package Algoritmos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

	public Set<Integer> ejecutar() throws IOException 
	{
		Queue<Integer> cola = new LinkedList<Integer>(); //Creo una cola que se iguala a una LinkedList.
		cola.offer(this.nodoInicial); //Agrego el nodo inicial.
		int nodo; //Variable auxiliar nodo.
		while(!cola.isEmpty()) { //Mientras la cola no este vacia.
			nodo = cola.peek(); //Asigno nodo al primero de la cola.
			for (int i = 0; i < this.cantNodos; i++)  //For hasta cantidad de nodos.
			{
				if (nodo != i && !this.nodoVisitado[i])  //Si el i es distinto que nodo y el i no fue visitado.
				{
					if (this.grafo.hayArista(nodo, i)) //Si hay arista entre nodo e i
					{
						this.arbol.add(new Arista(nodo, i)); //Agrego al arbol la arista.
						cola.offer(i); //Pongo en la cola el i.
						this.nodoVisitado[i] = true; //Marco el i como visitado.
					}
				}
			}
			nodo = cola.poll(); //Asigno nodo a lo que saco de la cola.
			this.nodoVisitado[nodo] = true;//El nodo fue visitado.
		}
		//this.escribirSolucionEnConsola();
		return nodosLlegados();
	}
	
	public Set<Integer> nodosLlegados()
	{
		Set<Integer> n = new LinkedHashSet<Integer>();
		for (Arista rama : arbol)
		{
			n.add((rama.getNodo1()+1));
			n.add((rama.getNodo2()+1));
		}
		return n;
	}

	public void escribirSolucionEnConsola() 
	{
		System.out.println("BFS: Búsqueda en Anchura:");
		System.out.println("Cantidad de Ramas del Árbol: " + this.arbol.size());
		System.out.println("Nodo Inicial del Recorrido (Raíz del Árbol): " + this.nodoInicial);
		System.out.println("Lista de Ramas:");
		for (Arista rama : arbol)
			System.out.println((rama.getNodo1()+1) + " " + (rama.getNodo2()+1));
	}
	
	/* Voy sacando las aristas puentes y comprobando si sigo llegando a todas las islas.
	 * No es buena solucion creo.
	 * 
	 */
	public void sacarPuentes() throws IOException, CloneNotSupportedException
	{
		int i = 0;
		Set<Integer> n = new LinkedHashSet<Integer>();
		n.addAll(this.ejecutar()); //Tengo el numero de todos los nodos a los que llego sin sacar ningun puente.
		Grafo copia = (Grafo)this.grafo.clone();
		int maximos[] = new int[this.cantNodos];
		for(; i<this.grafo.cantPuentes;)
		{
			maximos[i] = sacarPuentesRecursiva(i, 0);
			this.grafo = copia;
			i++;	
		}
		System.out.println(maximoEnVector(maximos));
		//return this.maximoEnVector(maximos);
	}
	
	public int sacarPuentesRecursiva(int i, int puentesSacados) throws IOException, CloneNotSupportedException
	{
		Set<Integer> n = new LinkedHashSet<Integer>();
		n.addAll(this.ejecutar()); //Tengo el numero de todos los nodos a los que llego sin sacar ningun puente.
		Grafo copia = (Grafo)this.grafo.clone();
		
		for(; i<this.grafo.cantPuentes; )
		{
			Arista a = this.grafo.puentes.get(i);
			int nodo1 = a.getNodo1();
			int nodo2 = a.getNodo2();
			//Saco un puente
			this.grafo.sacarArista(nodo1, nodo2);
			this.grafo.sacarArista(nodo1, nodo2);
			//Comparo si sigo llegando hasta el resto de las islas.
			BFS algoritmo = new BFS(this.grafo, 0);
			//Si al sacar el puente sigo llegando al resto de las islas, intento sacar otro.
			if(algoritmo.ejecutar().equals(n))
			{
				sacarPuentesRecursiva(++i, ++puentesSacados);
			}
			//Si al sacar la arista puente no sigo llegando a todos los nodos, agrego la arista que saque.
			else
			{
				this.grafo.ponerArista(nodo1, nodo2);
				this.grafo.ponerArista(nodo1, nodo2);
				i++;
			}	
		}
		return puentesSacados;
	}
	
	private int maximoEnVector(int v[])
	{
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < v.length; i++)
			if(max<v[i])
				max = v[i];
		return max;
	}
}
