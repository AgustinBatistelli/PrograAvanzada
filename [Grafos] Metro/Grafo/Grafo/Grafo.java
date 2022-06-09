package Grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo implements Cloneable {

	public int[][] matriz;
	public int cantNodos;
	public int cantAristas;
	public ArrayList<Nodo> nodos;
	public int[] gradosNodos;
	public int cantTuneles;
	public int cantPuentes;
	public ArrayList<Arista> tuneles = new ArrayList<Arista>();
	public ArrayList<Arista> puentes = new ArrayList<Arista>();
	
	public Grafo(String path) throws FileNotFoundException 
	{
		//Leo el archivo.
		Scanner scan = new Scanner(new File(path));

		//Leo del archivo.
		this.cantNodos = scan.nextInt(); //ISLAS NUMEROS.
		this.cantTuneles = scan.nextInt(); //TUNELES NUMEROS.
		this.cantPuentes = scan.nextInt(); //PUENTES NUMEROS.
		this.cantAristas = this.cantTuneles+this.cantPuentes;

		//Inicializacion de la matriz.
		this.inicializarMatriz();
		nodos = new ArrayList<Nodo>();
		gradosNodos = new int[this.cantNodos];

		for (int i = 0; i < this.cantNodos; i++)
			gradosNodos[i] = 0;
		
		//Voy poniendo las aristas(tuneles).
		int n1;
		int n2;
		for (int i = 0; i < this.cantTuneles; i++) 
		{
			n1 = scan.nextInt()-1; //El nodo 10, es el nodo 9 y asi.
			n2 = scan.nextInt()-1; //El nodo 10, es el nodo 9 y asi.
			this.ponerArista(n1, n2); //Doble si no es dirigido.
			this.ponerArista(n1, n2); //Doble si no es dirigido.
			this.tuneles.add(new Arista(n1, n2)); //Doble si no es dirigido.
			this.tuneles.add(new Arista(n2, n1)); //Doble si no es dirigido.
		}
		
		//Voy poniendo las aristas(puentes).
		for (int i = 0; i < this.cantPuentes; i++) 
		{
			n1 = scan.nextInt()-1; //El nodo 10, es el nodo 9 y asi.
			n2 = scan.nextInt()-1; //El nodo 10, es el nodo 9 y asi.
			this.ponerArista(n1, n2); //Doble si no es dirigido.
			this.ponerArista(n2, n1); //Doble si no es dirigido.
			this.puentes.add(new Arista(n1, n2)); //Doble si no es dirigido.
			this.puentes.add(new Arista(n2, n1)); //Doble si no es dirigido.
		}

		//Voy agregando los nodos.
		for (int i = 0; i < this.cantNodos; i++) 
		{
			Nodo nodo = new Nodo(i);
			nodo.setGrado(this.gradosNodos[i]);
			this.nodos.add(nodo);
		}
		scan.close();
	}

	private void inicializarMatriz()
	{ 
		int n = this.cantNodos;
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
	
	public void sacarArista(int fil, int col)
	{
		this.matriz[fil][col] = 0;
	}
	
	public boolean esPuente(int fil, int col)
	{
		return puentes.contains(new Arista(fil, col));
	}
	
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}

}
