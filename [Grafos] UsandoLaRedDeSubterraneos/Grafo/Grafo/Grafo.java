package Grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {

	public int[][] matriz;
	public int cantNodos;
	public int cantAristas;
	public ArrayList<Nodo> nodos = new ArrayList<Nodo>();
	public int cantidadEstaciones;
	public int desde;
	public int hasta;
	
	public Grafo(String path) throws FileNotFoundException 
	{
		//Leo el archivo.
		Scanner scan = new Scanner(new File(path));

		//Leo del archivo.
		this.cantNodos = scan.nextInt();
		//this.cantAristas = scan.nextInt();
		this.cantidadEstaciones = scan.nextInt();
		scan.nextLine();
		//Inicializacion de la matriz.
		this.inicializarMatriz();
		
		//Voy agregando los nodos(lineas).
		for (int i = 0; i < this.cantNodos; i++) 
		{
			//Leo la linea.
			String linea = scan.nextLine();
			//Me quedo con los numeros.
			String vector[] = linea.split(" ");
			int estacionesDeLaLinea[] = new int[vector.length];
			
			for(int j = 0; j < vector.length; j++)
				estacionesDeLaLinea[j] = Integer.valueOf(vector[j]);
			Nodo nodo = new Nodo(i);
			//Cada nodo va a a tener estaciones, porque cada nodo representa una linea.
			nodo.estaciones = estacionesDeLaLinea;
			this.nodos.add(nodo);
		}
		
		//Voy uniendo las lineas en base a sus estaciones.
		for(int i = 0; i < this.cantNodos; i++)
		{
			int estacionesDeLaLinea[] = this.nodos.get(i).estaciones;
			//Recorro las estaciones de la linea.
			for(int j = 0; j < estacionesDeLaLinea.length; j++)
			{
				//Recorro las otras lineas.
				for(int k = 0; k < this.cantNodos; k++)
				{
					//Si son distintas lineas.
					if(i != k)
					{
						int estacionesDeLaLinea2[] = this.nodos.get(k).estaciones;
						for(int x = 0; x < estacionesDeLaLinea2.length; x++)
						{
							if(estacionesDeLaLinea[j] == estacionesDeLaLinea2[x])
							{
								this.ponerArista(i, k);
								this.ponerArista(k, i);
							}
						}
					}
				}
			}
		}
		this.desde = scan.nextInt();
		this.hasta = scan.nextInt();
		scan.close();
	}

	private void inicializarMatriz() // Recibe el orden de la matriz
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
	
	public ArrayList<Integer> getLineasbyEstacion(int estacion)
	{
		ArrayList<Integer> lineas = new ArrayList<Integer>();
		for(int i = 0; i < this.nodos.size(); i++)
		{
			for(int j = 0; j < this.nodos.get(i).estaciones.length; j++)
			{
				if(estacion == this.nodos.get(i).estaciones[j])
				{
					lineas.add(i);
					break;
				}
			}
		}
		return lineas;
	}
}
