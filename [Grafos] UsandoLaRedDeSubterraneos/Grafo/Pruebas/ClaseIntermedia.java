package Pruebas;

import java.io.IOException;
import java.util.ArrayList;

import Algoritmos.Dijkstra;
import Grafo.Grafo;

public class ClaseIntermedia 
{
	public Grafo g;
	public int estacionPartida;
	public int estacionLlegada;
	//Por si una misma estacion esta en mas de una linea.
	private ArrayList<Integer> lineasPartida = new ArrayList<Integer>();
	private ArrayList<Integer> lineasLlegada = new ArrayList<Integer>();
	
	public ClaseIntermedia(Grafo g, int i, int j)
	{
		this.g = g;
		this.estacionPartida = i;
		this.estacionLlegada = j;
	}
	
	private void lineasPartidaLlegada()
	{
		this.lineasPartida.addAll(this.g.getLineasbyEstacion(this.estacionPartida));
		this.lineasLlegada.addAll(this.g.getLineasbyEstacion(this.estacionLlegada));
	}
	
	public void ejecutar() throws IOException
	{
		this.lineasPartidaLlegada();
		//Si la estacion se encuentra tanto en la linea de llegada como de salida.
		int contador = 0;
		for(int i = 0; i < this.lineasPartida.size(); i++)
			if(lineasLlegada.contains(this.lineasPartida.get(i)))
				contador++;
		for(int i = 0; i < this.lineasLlegada.size(); i++)
			if(lineasPartida.contains(this.lineasLlegada.get(i)))
				contador++;
		if(contador>0)
		{
			System.out.println(0);
			return;
		}
			
		
		//Esto es previniendo que puedo tener las estaciones de partida y llegada en muchas lineas diferentes.
		int matrizCostos[][] = new int[this.lineasPartida.size()][this.lineasLlegada.size()];
		
		for(int i = 0; i < this.lineasPartida.size(); i++)
		{
			for(int j = 0; j < this.lineasLlegada.size(); j++)
			{
				if(this.lineasPartida.get(i)!=this.lineasPartida.get(j))
				{
					//Aplico tantos Dijsktra como posibilidades haya de lineas de partida y lineas de llegada.
					Dijkstra algoritmo = new Dijkstra(this.g, this.lineasPartida.get(i), this.lineasPartida.get(j));
					matrizCostos[i][j] =  algoritmo.ejecutar();
				}
			}	
		}
		
		//SALIDA POR PANTALLA.
		int menores[] = this.menorEnMatriz(matrizCostos);
		System.out.println(menores[0]);
		Dijkstra algoritmo = new Dijkstra(this.g, this.lineasPartida.get(menores[1]), this.lineasPartida.get(menores[2]));
		algoritmo.ejecutar();
		System.out.println(algoritmo.getCaminoMasCorto());
		
	}
	
	private int[] menorEnMatriz(int m[][])
	{
		int menor = Integer.MAX_VALUE;
		int mini = 0;
		int minj = 0;
		for(int i = 0; i < this.lineasPartida.size(); i++)
		{
			for(int j = 0; j < this.lineasLlegada.size(); j++)
			{
				if(menor>m[i][j] && i!=j)
				{
					menor = m[i][j];
					mini = i;
					minj = j;
				}
			}
		}
		/* El ++ es porque yo saque los transbordos que es lo mismo, si yo hice un transbordo
		 * es porque pase de un tren a otro tren, por ende son 2 trenes.
		 * Si hice 5 transbordos, estuve en 6 trenes y asi.
		 */
		return new int[]{++menor, mini, minj};
	}
}
