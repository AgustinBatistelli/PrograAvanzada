package Algoritmos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import Grafo.CostoAlNodo;
import Grafo.Grafo;
import Grafo.Nodo;

public class Dijkstra {

	private Grafo grafo;
	private Nodo nodoInicial;
	private Nodo nodoFinal;

	private int cantNodos;
	boolean nodoTerminado[];
	private ArrayList<CostoAlNodo> costos;

	private static final int INFINITO = -1;

	public Dijkstra(Grafo grafo) 
	{
		this.grafo = grafo;
		this.nodoInicial = grafo.nodoInicial;
		this.nodoFinal = grafo.nodoFinal;
		this.cantNodos = grafo.cantNodos;
		this.nodoTerminado = new boolean[cantNodos];
		costos = new ArrayList<CostoAlNodo>();
	}

	@SuppressWarnings("unchecked")
	public void ejecutar() throws IOException 
	{
		Queue<CostoAlNodo> cola = new PriorityQueue<CostoAlNodo>();
		CostoAlNodo nodoActual = new CostoAlNodo(this.nodoInicial.nroNodo, 0);
		CostoAlNodo actualizado;
		cola.add(nodoActual);
		int nodo = nodoActual.getNodo();

		for (int i = 0; i < this.cantNodos; i++) 
		{
			if (i != nodo) 
				costos.add(new CostoAlNodo(i, INFINITO));
			else 
			{
				costos.add(new CostoAlNodo(i, 0));
				costos.get(i).agregarNodoAlCamino(nodo);
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
					if (this.grafo.hayArista(nodo, i)) 
					{
						if (this.costos.get(i).getCostoMinimo() == INFINITO || this.costos.get(nodo).getCostoMinimo() + this.grafo.getPesoArista(nodo, i) < this.costos.get(i).getCostoMinimo()) {
							actualizado = this.costos.get(i);
							actualizado.setCostoMinimo(this.costos.get(nodo).getCostoMinimo() + this.grafo.getPesoArista(nodo, i));
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
		
		this.escribirSolucionEnConsola();
	}

	private void escribirSolucionEnConsola() 
	{
		int costo;
		costo = costos.get(this.nodoFinal.nroNodo).getCostoMinimo();
		if (costo == INFINITO)
			System.out.println("NO HAY RUTA");
		else
		{
			ArrayList<Integer> camino = costos.get(this.nodoFinal.nroNodo).getCaminoMasCorto();
			for(int j = 0; j < camino.size(); j++)
			{
				Nodo n = this.grafo.nodos.get(camino.get(j)); ///CUIDADO CON LOS INDICES ACA
				System.out.println(n.x + " " + n.y);
			}
		}
				
	}
	
}
