package Pruebas;

import java.io.IOException;

import Grafo.Grafo;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		/* Use Dijsktra pero en teoria se podria haber resuelto con BFS tambien 
		 * que permite encontrar la ruta mas corta de un nodo a otro en un grafo no ponderada
		 * el grafo es no ponderado, yo lo pondere a todas las aristas con peso 1
		 * para aplicar Dijsktra que lo vengo usando siempre jaja.
		 */
		Grafo g = new Grafo("./in/ejercicio.in");
		ClaseIntermedia algoritmo = new ClaseIntermedia(g, g.desde, g.hasta);
		algoritmo.ejecutar();
	}

}
