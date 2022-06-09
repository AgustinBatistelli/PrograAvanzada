package Algoritmos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import Grafo.CostoAlNodo;
import Grafo.Grafo;

public class Dijkstra {

	private Grafo grafo;
	private int nodoInicial;
	private int nodoFinal;

	private int cantNodos;
	boolean nodoTerminado[];
	private ArrayList<CostoAlNodo> costos;

	private static final int INFINITO = -1;

	public Dijkstra(Grafo grafo, int nodoInicial, int nodoFinal) 
	{
		this.grafo = grafo;
		this.nodoInicial = nodoInicial;
		this.nodoFinal = nodoFinal;
		this.cantNodos = grafo.cantNodos;
		this.nodoTerminado = new boolean[cantNodos];
		costos = new ArrayList<CostoAlNodo>();
	}

	@SuppressWarnings("unchecked")
	public int ejecutar() throws IOException 
	{
		Queue<CostoAlNodo> cola = new PriorityQueue<CostoAlNodo>();
		CostoAlNodo nodoActual = new CostoAlNodo(this.nodoInicial, 0);
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
		//El costo minimo hacia la linea de destino.
		int costo = costos.get(this.nodoFinal).getCostoMinimo();
		return costo;
		//this.escribirSolucionEnConsola();
	}
	
	public String getCaminoMasCorto()
	{
		return costos.get(this.nodoFinal).getCaminoMasCorto().toString();
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
