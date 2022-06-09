package Pruebas;

import java.io.IOException;
import java.util.ArrayList;

import Algoritmos.DFS;
import Grafo.Arista;
import Grafo.Grafo;

public class ClaseIntermedia 
{
	public Grafo g;
	public int puentesDelCamino[];
	
	public ClaseIntermedia(Grafo g)
	{
		this.g = g;
		puentesDelCamino = new int[g.cantNodos];
	}
	
	public void ejecutar() throws IOException
	{
		for(int i = 0; i < g.cantNodos; i++)
		{
			int puentesEnCamino = 0;
			DFS algoritmo = new DFS(g, i);
			ArrayList<Arista> aristas = algoritmo.ejecutar();
			for(int j = 0; j < aristas.size(); j++)
			{
				Arista a = aristas.get(j);
				int n1 = a.getNodo1();
				int n2 = a.getNodo2();
				if(g.esPuente(n1, n2))
					puentesEnCamino++;
			}
			puentesDelCamino[i] = puentesEnCamino;
		}
		System.out.println(this.menorEnVector());
	}
	
	private int menorEnVector()
	{
		int menor = Integer.MAX_VALUE;
		for(int i = 0; i < this.puentesDelCamino.length; i++)
			if(menor>this.puentesDelCamino[i])
				menor = this.puentesDelCamino[i];
		return menor;
	}
}
