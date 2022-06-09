package Grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {

	public int[][] matriz;
	public int cantNodos;
	public int cantAristas;
	public ArrayList<Nodo> nodos;
	public static final int MAXLINEAS = 1000;
	public Nodo nodoInicial;
	public Nodo nodoFinal;
	
	public Grafo(String path) throws FileNotFoundException 
	{
		//Leo el archivo.
		Scanner scan = new Scanner(new File(path));

		//Inicializacion de la matriz.
		this.inicializarMatriz();
		nodos = new ArrayList<Nodo>();
		
		//Voy poniendo las nodos y las aristas.
		int j = 0;
		while(scan.hasNextInt())
		{
			int x = scan.nextInt();
			int y = scan.nextInt();
			Nodo n = new Nodo(x, y, j);
			for(Nodo k : this.nodos)
			{
				if(n.esAdyacente(k))
				{
					this.ponerAristaNoDirigido(n.nroNodo, k.nroNodo);
					this.cantAristas++;
				}
			}
			this.nodos.add(n);
			j++;
		}
		
		this.cantNodos = this.nodos.size();
		this.nodoInicial = this.nodos.get(0);
		this.nodoFinal = this.nodos.get(this.nodos.size()-1);

		scan.close();
	}

	private void inicializarMatriz()
	{ 
		int n = Grafo.MAXLINEAS;
		matriz = new int[n][n];

		for (int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
			matriz[i][j] = 0;
	}

	public void ponerAristaNoDirigido(int fil, int col) 
	{
		this.matriz[fil][col] = 1;
		this.matriz[col][fil] = 1;
	}
	
	public void ponerAristaPeso(int fil, int col, int peso)
	{
		this.matriz[fil][col] = peso;
	}

	public boolean hayArista(int fil, int col) 
	{
		return this.matriz[fil][col] != 0;
	}
	
	public int getPesoArista(int fil, int col)
	{
		return this.matriz[fil][col];
	}
}
