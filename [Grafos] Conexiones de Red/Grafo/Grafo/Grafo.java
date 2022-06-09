package Grafo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Algoritmos.BFS;

public class Grafo {

	//No respeto el encapsulamiento dado que es lo de MENOS en la resolucion de un ejercicio asi jaja.
	/* Hay dos soluciones, esta es la de menos performance
	 * 1) Crear una matriz con la cantidad MAXIMA de nodos que podrian existir.
	 * 2) Recorrer dos veces el archivo, una vez para ver la cantidad de nodos, y otra para resolver el ejercicio.
	 */
	public static final int nodosMaximos = 10000;
	public int[][] matriz;
	public int cantNodos;
	public int cantAristas;
	public int nodoSalida;
	public int nodoLlegada;
	public String path;
	
	public Grafo(String path)
	{
		this.path = path;
		//Inicializacion de la matriz.
		this.inicializarMatriz();
	}
	
	public void resolver() throws IOException
	{
		//Leo el archivo.
		Scanner scan = new Scanner(new File(path));

		int n1;
		int n2;
		char c = 'A'; // Simulo una letra.
		while (true) 
		{
			c = scan.next().charAt(0);
			if(c == 'F') break;
			//Leo las computadoras involucradas en la conexion.
			n1 = scan.nextInt()-1; //El nodo 10, es el nodo 9 y asi.
			n2 = scan.nextInt()-1; //El nodo 10, es el nodo 9 y asi.
			//Si es C entonces agrego la arista.
			if(c == 'C')
			{
				this.ponerArista(n1, n2);
				this.ponerArista(n2, n1);
			}
			//Si es P entonces pregunto por la arista.
			else if(c == 'P')
			{
				//Me fijo si del nodo1, es lo mismo que tomar nodo2, a que nodos puedo llegar.
				BFS algoritmo = new BFS(this, n1);
				//El vector se llena con todos los nodos a los que es posible llegar desde nodo1, incluido nodo1.
				int v[] = algoritmo.ejecutar();
				//Compruebo si tanto nodo1 (aunque es obvio nodo1) como nodo2 estan dentro del vector de los nodos que puedo llegar.
				boolean e1 = this.estaEnVector(n1, v);
				boolean e2 = this.estaEnVector(n2, v);
				if(e1 && e2)
					System.out.println("S");
				else
					System.out.println("N");
			}
		}
		scan.close();
	}

	private void inicializarMatriz() // Recibe el orden de la matriz
	{ 
		int n = nodosMaximos;
		matriz = new int[n][n];

		for (int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
			matriz[i][j] = 0;
	}

	public void ponerArista(int fil, int col) 
	{
		this.matriz[fil][col] = 1;
	}

	public boolean hayArista(int fil, int col) 
	{
		return this.matriz[fil][col] != 0;
	}
	
	public boolean estaEnVector(int i, int v[])
	{
		for(int k = 0; k < v.length; k++)
			if(v[k] == i)
				return true;
		return false;
	}
}
