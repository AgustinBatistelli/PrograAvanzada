package Algoritmos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import Grafo.CostoAlNodo;
import TiposGrafos.GrafoNDP;

public class Dijkstra {

	private GrafoNDP grafo;
	private int nodoInicial;

	private int cantNodos;
	boolean nodoTerminado[];
	private ArrayList<CostoAlNodo> costos;
	private ArrayList<Integer> nodosAEvitar = new ArrayList<>();
	private int inseguro = 0;

	private static final int INFINITO = -1;

	public int getNodoInicial() 
	{
		return nodoInicial;
	}

	public GrafoNDP getGrafo() 
	{
		return grafo;
	}

	public int getCantNodos() 
	{
		return this.cantNodos;
	}

	public Dijkstra(GrafoNDP grafo, int nodoInicial) 
	{
		this.grafo = grafo;
		this.nodoInicial = nodoInicial-1;
		this.cantNodos = grafo.getGrafo().getOrdenMatriz();
		this.nodoTerminado = new boolean[cantNodos];
		costos = new ArrayList<CostoAlNodo>();
	}

	@SuppressWarnings("unchecked")
	public void ejecutar() throws IOException 
	{
		Queue<CostoAlNodo> cola = new PriorityQueue<CostoAlNodo>();
		CostoAlNodo nodoActual = new CostoAlNodo(this.nodoInicial, 0);
		cola.add(nodoActual);

		int indice;
		int nodo = nodoActual.getNodo();
		CostoAlNodo actualizado = null;

		for (int i = 0; i < this.cantNodos; i++) 
		{
			if (i != nodo) 
				costos.add(new CostoAlNodo(i, INFINITO));
			else 
			{
				costos.add(new CostoAlNodo(i, 0));
				costos.get(i).agregarNodoAlCamino(nodo);;
			}
		}

		while (!cola.isEmpty()) 
		{
			nodoActual = cola.poll();
			nodo = nodoActual.getNodo();
			
			for (int i = 0; i < this.cantNodos; i++) 
			{
				if (nodo != i && !this.nodoTerminado[i]) 
				{
					if (nodo < i)
						indice = this.grafo.getGrafo().getIndice(nodo, i);
					else
						indice = this.grafo.getGrafo().getIndice(i, nodo);
				
					if (this.grafo.getGrafo().hayArista(indice)) 
					{
						if (this.costos.get(i).getCostoMinimo() == INFINITO || this.costos.get(nodo).getCostoMinimo() + this.getGrafo().getPesoArista(indice) < this.costos.get(i).getCostoMinimo()) {
							//Si pase por un nodo que tenia un dragon.
							for(int x = 0; x < grafo.dragonesNodos.size(); x++)
								if(nodo+1 == grafo.dragonesNodos.get(x).getNroNodo())
									inseguro++;
							//Si pase por un nodo donde QUIZA un dragon pudo haberse movido.
							for(int u = 0; u < grafo.dragonesNodos.size(); u++)
							{
								//Nodo por el que paso.
								int nodo1 = nodo+1;
								//Nodos donde estan los dragones.
								for(int y = 0; y < grafo.dragonesNodos.size(); y++)
								{
									int indice2;
									int nodoDrag = grafo.dragonesNodos.get(y).getNroNodo();
									if (nodo1 < y)
										indice2 = this.grafo.getGrafo().getIndice(nodo1+1, nodoDrag);
									else
										indice2 = this.grafo.getGrafo().getIndice(nodoDrag, nodo1+1);
									//Si hay una conexion entre el nodo que estoy pasando y el nodo del dragon lo agrego como un nodo a evitar.
									if(this.grafo.getGrafo().hayArista(indice2))
										this.nodosAEvitar.add(nodo1-1);
								}
							}
							actualizado = this.costos.get(i);
							actualizado.setCostoMinimo(this.costos.get(nodo).getCostoMinimo() + this.getGrafo().getPesoArista(indice));
							actualizado.setCaminoMasCorto((ArrayList<Integer>)this.costos.get(nodo).getCaminoMasCorto().clone());
							actualizado.agregarNodoAlCamino(i);
							
							if (!cola.contains(actualizado))
								cola.add(actualizado);
						}
					}
				}
			}
			
			this.nodoTerminado[nodo] = true;
		}
		
		//this.escribirSolucionEnConsola();
		if(this.nodosAEvitar.size() == 0)
			this.SolucionEjercicio();
		else
			this.ejecutarEvitando(nodosAEvitar);
	}
	
	//Dijsktra pero evitando pasar por ciertos nodos.
	@SuppressWarnings("unchecked")
	public void ejecutarEvitando(ArrayList<Integer> nodosAEvitar) throws IOException 
	{
		//Adaptar el numero que ingresa el usuario, EJ: nronodo = 3, es internamente nodo = 2.
		for(int i = 0; i < nodosAEvitar.size(); i++)
			nodosAEvitar.set(i, nodosAEvitar.get(i)-1);
		Queue<CostoAlNodo> cola = new PriorityQueue<CostoAlNodo>();
		CostoAlNodo nodoActual = new CostoAlNodo(this.nodoInicial, 0);
		cola.add(nodoActual);

		int indice;
		int nodo = nodoActual.getNodo();
		CostoAlNodo actualizado = null;

		for (int i = 0; i < this.cantNodos; i++) 
		{
			if (i != nodo) 
				costos.add(new CostoAlNodo(i, INFINITO));
			else 
			{
				costos.add(new CostoAlNodo(i, 0));
				costos.get(i).agregarNodoAlCamino(nodo);;
			}
		}

		while (!cola.isEmpty()) 
		{
			nodoActual = cola.poll();
			nodo = nodoActual.getNodo();
			
			for (int i = 0; i < this.cantNodos; i++) 
			{
				if (nodo != i && !this.nodoTerminado[i]) 
				{
					if (nodo < i)
						indice = this.grafo.getGrafo().getIndice(nodo, i);
					else
						indice = this.grafo.getGrafo().getIndice(i, nodo);
				
					//Si hay una arista y ademas no esta en la lista de nodos a evitar.
					if (this.grafo.getGrafo().hayArista(indice) && !nodosAEvitar.contains(nodo)) 
					{
						if (this.costos.get(i).getCostoMinimo() == INFINITO || this.costos.get(nodo).getCostoMinimo() + this.getGrafo().getPesoArista(indice) < this.costos.get(i).getCostoMinimo()) {
							//Si pase por un nodo que tenia un dragon.
							for(int x = 0; x < grafo.dragonesNodos.size(); x++)
								if(nodo+1 == grafo.dragonesNodos.get(x).getNroNodo())
									inseguro++;
							actualizado = this.costos.get(i);
							actualizado.setCostoMinimo(this.costos.get(nodo).getCostoMinimo() + this.getGrafo().getPesoArista(indice));
							actualizado.setCaminoMasCorto((ArrayList<Integer>)this.costos.get(nodo).getCaminoMasCorto().clone());
							actualizado.agregarNodoAlCamino(i);
							
							if (!cola.contains(actualizado))
								cola.add(actualizado);
						}
					}
				}
			}
			this.nodoTerminado[nodo] = true;
		}
		this.SolucionEjercicio();
	}
	
	private void SolucionEjercicio()
	{
		int costo;
		costo = costos.get(grafo.princesa-1).getCostoMinimo();
		if(costo == INFINITO)
		{
			System.out.println("NO HAY CAMINO");
			return;
		}
		else if(inseguro > 0)
		{
			System.out.println("INTERCEPTADO");
			return;
		}
		else
		{
			for(int i : costos.get(grafo.princesa-1).getCaminoMasCorto())
				System.out.print((i+1)+" ");
		}
	}

	private void escribirSolucionEnConsola() 
	{
		int costo;
		System.out.println("DIJKSTRA: Nodo Inicial: " + (this.nodoInicial+1));
		for (int i = 0; i < this.costos.size(); i++) {
			costo = costos.get(i).getCostoMinimo();
			if (costo == INFINITO)
				System.out.println("Nodo Final: " + (i+1) + " Costo del Camino Más Corto: INFINITO");
			else
				System.out.println("Nodo Final: " + (i+1) + " Costo del Camino Más Corto: " + costo);
		
		}		
	}
	
}
