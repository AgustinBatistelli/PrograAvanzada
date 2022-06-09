package TiposGrafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Grafo.MatrizSimetrica;
import Grafo.Nodo;

public class GrafoNDP {

	private MatrizSimetrica grafo;
	private int cantNodos;
	private int cantAristas;

	private ArrayList<Nodo> nodos = new ArrayList<Nodo>();
	public ArrayList<Nodo> dragonesNodos = new ArrayList<Nodo>();
	private int[] pesosAristas;
	public int dragones;
	public int principe;
	public int princesa;

	public GrafoNDP(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scan = new Scanner(file);
		int fil;
		int col;
		int peso;
		int indice;

		this.cantNodos = scan.nextInt();
		this.cantAristas = scan.nextInt();
		this.dragones = scan.nextInt();
		this.princesa = scan.nextInt();
		this.principe = scan.nextInt();
		for(int i = 0; i < dragones; i++)
			this.dragonesNodos.add(new Nodo(scan.nextInt()));
		this.grafo = new MatrizSimetrica(this.cantNodos);

		this.pesosAristas = new int[(this.cantNodos * this.cantNodos - this.cantNodos) / 2];
		for (int i = 0; i < this.cantAristas; i++)
			pesosAristas[i] = 0;

		for (int i = 0; i < this.cantAristas; i++) {
			fil = scan.nextInt()-1;
			col = scan.nextInt()-1;
			peso = scan.nextInt();
			indice = this.grafo.getIndice(fil, col);
			this.pesosAristas[indice] = peso;
			this.grafo.ponerArista(indice);
		}

		for (int i = 0; i < this.cantNodos; i++) {
			Nodo nodo = new Nodo(i);
			for(int j = 0; j < this.dragonesNodos.size(); j++)
				if(i+1 == this.dragonesNodos.get(j).getNroNodo())
					nodo.setDragon(true);
			this.nodos.add(nodo);
		}
		scan.close();
	}


	public void mostrar() {
		this.grafo.mostrar();
	}

	public void mostrarNodos() {
		for (int i = 0; i < this.cantNodos; i++)
			System.out.println("n: " + this.nodos.get(i).getNroNodo() + " g: ");
	}
	
	public int getPesoArista(int indice) {
		return pesosAristas[indice];
	}

	public MatrizSimetrica getGrafo() {
		return this.grafo;
	}

}
