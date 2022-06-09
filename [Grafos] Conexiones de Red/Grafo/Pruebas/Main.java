package Pruebas;

import java.io.IOException;

import Grafo.Grafo;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		Grafo g = new Grafo("./in/ejercicio.in");
		g.resolver();
	}

}
