package Pruebas;

import java.io.IOException;

import Grafo.Grafo;

public class Main {

	public static void main(String[] args) throws IOException, CloneNotSupportedException 
	{
		Grafo g = new Grafo("./in/ejercicio.in");
		ClaseIntermedia algoritmo = new ClaseIntermedia(g);
		algoritmo.ejecutar();
		
		//RESTOS DE UNA SOLUCION O(n!) Y RE RARA TARDE COMO 2 HORAS AL PEDO LPM
		//BFS algoritmo = new BFS(g, 0); //Tomo el nodo inicial como 0 es lo mismo tomar otro numero si puedo llegar a todos los demas.
		//algoritmo.sacarPuentes();
	}

}
