package TiposGrafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

import Grafo.MatrizSimetrica;
import Grafo.Nodo;

public class GrafoNDNP {

	private MatrizSimetrica grafo;
	private int cantNodos;

	private int colorMax = 1;
	private ArrayList<Nodo> nodos;
	private int[] nodosColoreados;
	private int[] gradosNodos;

	private int mejorColor = 0;
	private int[] solucion;
	private int[] mejoresColores;

	public GrafoNDNP(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scan = new Scanner(file);
		scan.useLocale(Locale.ENGLISH);

		//El primer numero es la cantidad de tiendas(osea de nodos).
		this.cantNodos = scan.nextInt();
		//------------INICIALIZACIONES--------
		this.grafo = new MatrizSimetrica(this.cantNodos);

		this.colorMax = 1;
		nodos = new ArrayList<Nodo>();
		nodosColoreados = new int[this.cantNodos];
		gradosNodos = new int[this.cantNodos];
		solucion = new int[this.cantNodos];
		mejoresColores = new int[this.cantNodos];

		
		for (int i = 0; i < this.cantNodos; i++)
			gradosNodos[i] = 0;

		for (int i = 0; i < this.cantNodos; i++)
			mejoresColores[i] = 0;
		
		//------------------------------------------------------
		//-----CARGA DE LA MATRIZ DE ADYACENCIA EN BASE AL ENUNCIADO--------------
		int renglon = 0;
		int indice, indice2;
		int n1;
		int n2;
		while(renglon<this.cantNodos)
		{
			n1 = scan.nextInt(); //Leo el identificador del lugar segun el ejercicio.
			n2 = scan.nextInt(); //Leo los lugares conectados al identificador del lugar.
			//Cuando una tienda es un -1, termine el renglon.
			while(n2!=-1)
			{
				//Se resta uno porque no hay tienda 0, pero en programacion se empieza a contar desde 0 jaja.
				indice = this.grafo.getIndice(n1-1, n2-1);
				//Otro indice porque es lo mismo 6-7 que 7-6
				//indice2 = this.grafo.getIndice(n2-1, n1-1);
				this.grafo.ponerArista(indice);
				//this.grafo.ponerArista(indice2);
				gradosNodos[n1-1]++; //Aumento el grado del nodo(tienda).
				gradosNodos[n2-1]++; //Aumento el grado del nodo(tienda).
				n2 = scan.nextInt();
			}
			//Cambio de renglon.
			renglon++;
		}

		//Seteo el grado de los nodos, dentro de cada entidad nodo.
		for (int i = 0; i < this.cantNodos; i++) 
		{
			Nodo nodo = new Nodo(i);
			nodo.setGrado(this.gradosNodos[i]);
			this.nodos.add(nodo);
		}
		scan.close();
	}

	private void colorear() {
		int color = 1;
		int nodo;
		int indice;
		int j;

		this.colorMax = 1;
		
		for (int i = 0; i < this.cantNodos; i++)
			this.nodosColoreados[i] = 0;

		nodosColoreados[this.nodos.get(0).getNroNodo()] = color;

		for (int i = 1; i < this.cantNodos; i++) {
			nodo = this.nodos.get(i).getNroNodo();
			this.nodosColoreados[nodo] = color;
			j = 0;
			while (j < this.cantNodos) {
				if (nodo != j) {
					if (nodo < j)
						indice = this.grafo.getIndice(nodo, j);
					else
						indice = this.grafo.getIndice(j, nodo);
					if (this.grafo.hayArista(indice) && this.nodosColoreados[nodo] == this.nodosColoreados[j]) {
						color++;
						if (color > colorMax)
							colorMax = color;
						this.nodosColoreados[nodo] = color;
						j = -1;
					}
					
				}
				j++;
			}
			color = 1;
		}
	}
	
	//Igual en los tres tipos de grafos.
	public void coloreoMatula(int corridas) throws IOException 
	{
		int nroCorrida = 0;
		for (int i = 0; i < corridas; i++) {
			Collections.shuffle(this.nodos);
			Collections.sort(this.nodos, new Comparator<Nodo>() {
				@Override
				public int compare(Nodo nodo1, Nodo nodo2) {
					return nodo1.getGrado() - nodo2.getGrado();
				}
			});
			this.colorear();

			if (this.colorMax < this.mejorColor || this.mejorColor == 0) 
			{
				this.mejorColor = this.colorMax;
				nroCorrida = i + 1;
				this.solucion = this.nodosColoreados.clone();
			}
			//FIX CON TOTALMENTE CONEXO.
			try{this.mejoresColores[this.colorMax]++;}catch(Exception e){}
			
		}

		this.mejorColor = 0;
		for (int i = 0; i < this.cantNodos; i++)
			this.mejoresColores[i] = 0;
	}
	
	/* El mejor color es el primero, porque empiezo a colorea el nodo(tienda) menos conexo (de menor grado).
	 * 
	 */
	public void resultadoEjercicio()
	{
		int contador = 0;
		for(int i = 0; i < this.nodosColoreados.length; i++)
			if(this.nodosColoreados[i] == 1)
				contador++;
		System.out.println(contador);
		for(int i = 0; i < this.nodosColoreados.length; i++)
			if(this.nodosColoreados[i] == 1)
				System.out.print((i+1) + " ");
	}
}
