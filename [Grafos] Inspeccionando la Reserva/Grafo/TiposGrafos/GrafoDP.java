package TiposGrafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Grafo.Nodo;

public class GrafoDP {

	private static final int INFINITO = -1;
	private int[][] grafo;
	private int cantNodos;
	private int cantAristas;

	private ArrayList<Nodo> nodos;


	public GrafoDP(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scan = new Scanner(file);
		int fil;
		int col;
		int peso;
		this.cantNodos = scan.nextInt();
		this.cantAristas = scan.nextInt();
		this.grafo = new int[this.cantNodos][this.cantNodos];
		nodos = new ArrayList<Nodo>();

		for (int i = 0; i < this.cantNodos; i++) {
			this.grafo[i][i] = 0;
			for (int j = i + 1; j < this.cantNodos; j++) {
				this.grafo[i][j] = INFINITO;
				this.grafo[j][i] = INFINITO;
			}
		}

		for (int i = 0; i < this.cantAristas; i++) {
			fil = scan.nextInt()-1; //El nodo 1 sera el nodo 0, y el nodo 10 sera el nodo 9.
			col = scan.nextInt()-1; //El nodo 1 sera el nodo 0, y el nodo 10 sera el nodo 9.
			peso = 1; //Es un grafo dirigido pero no ponderado, asi que el peso es uno.
			this.grafo[col][fil] = peso;
		}

		for (int i = 0; i < this.cantNodos; i++) {
			Nodo nodo = new Nodo(i);
			this.nodos.add(nodo);
		}

		scan.close();
	}

	public void mostrar() {
		for (int i = 0; i < this.cantNodos; i++) {
			System.out.println();
			for (int j = 0; j < this.cantNodos; j++) {
				System.out.print(this.grafo[i][j] + " ");
			}
		}
	}

	public void mostrarNodos() {
		for (int i = 0; i < this.cantNodos; i++)
			System.out.println("n: " + this.nodos.get(i).getNroNodo());
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public int[][] getGrafo() {
		return this.grafo;
	}
	
	public boolean hayArista(int i, int j)
	{
		return this.grafo[i][j]!=INFINITO;
	}
	
	//El primer nodo empieza de 0 no de 1.
	/* Esto es ni mas ni menos que dado un nodo ver cuantas aristas que apunten a el hay.
	 */
	public int formasLlegarANodo(int nodo)
	{
		int retorno = 0;
		for(int i = 0; i < this.cantNodos; i++)
		{
			if(this.grafo[nodo][i] == 1)
				retorno++;
		}
		return retorno;
	}
	
	public int formasIrseDelNodo(int nodo)
	{
		int retorno = 0;
		for(int i = 0; i < this.cantNodos; i++)
		{
			if(this.grafo[i][nodo] == 1)
				retorno++;
		}
		return retorno;
	}
}
