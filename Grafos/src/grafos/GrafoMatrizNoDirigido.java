package grafos;

import java.util.Arrays;

public class GrafoMatrizNoDirigido extends GrafoMatrizAdyacencia {

	public GrafoMatrizNoDirigido(int cantNodos) {
		super(cantNodos);
	}

	@Override
	public void setArista(int nodoOrigen, int nodoDestino, double valor) {
		matriz[nodoOrigen][nodoDestino] = valor;
		matriz[nodoDestino][nodoOrigen] = valor;
	}

	public void Prim() {
		boolean[] visitados = new boolean[matriz.length]; // array de vertices visitados
		Arrays.fill(visitados, false); // setteo visitados en false al inicio.

		int cantidadAristas = 0; // la cantidadTotal de Aristas siempre va a ser CantVertices-1
		visitados[0] = true; // arranco por el vertice 0 y lo marco como visitado

		System.out.println("Aristas : Peso");
		double pesoTotal = 0;
		while (cantidadAristas < matriz.length - 1) {
			// For every vertex in the set S, find the all adjacent vertices
			// , calculate the distance from the vertex selected at step 1.
			// if the vertex is already in the set S, discard it otherwise
			// choose another vertex nearest to selected vertex at step 1.
			double min = VALOR_INFINITO;
			int x = 0; // row number
			int y = 0; // col number

			for (int i = 0; i < matriz.length; i++) {
				if (visitados[i] == true) {
					for (int j = 0; j < matriz.length; j++) {
						// not in selected and there is an edge
						if (!visitados[j] && matriz[i][j] != VALOR_INFINITO) {
							if (min > matriz[i][j]) {
								min = matriz[i][j];
								x = i;
								y = j;
							}
						}
					}
				}
			}
			System.out.println(x + " - " + y + " :  " + matriz[x][y]);
			pesoTotal += matriz[x][y];
			visitados[y] = true; // ya asignaste el primero antes cuando hiciste visitados[0], entonces tenes q
									// asignar el siguiente..
			cantidadAristas++;
		}
		System.out.println("Peso total: " + pesoTotal);
	}

	public void primProfe() { //osea va por ahi la cosa..
		boolean[] visitados = new boolean[matriz.length]; // array de vertices visitados
		double[] distancias = new double[matriz.length];
		int[] desdeQueNodoVoy = new int[matriz.length];
		double pesoTotal = 0;
		
		Arrays.fill(visitados, false); // setteo visitados en false al inicio.
		Arrays.fill(desdeQueNodoVoy, 0); // setteo desdeoQueNodoVoy en 0; primer elemento desde el que voy a intentar ir..
		Arrays.fill(distancias, VALOR_INFINITO); // setteo todo en valor inf..

		visitados[0] = true; // seteo en true el primer valor xq ya lo estoy usando..
		int i = 0;
		int cantidadAristas = 0;

		while (cantidadAristas < matriz.length - 1) {

			for (int j = 0; j < distancias.length; j++) {

				if (distancias[j] > matriz[i][j]) {
					distancias[j] = matriz[i][j];
					desdeQueNodoVoy[j] = i; // actualizo el valor del nodo desde el que voy..
					// actualizo el valor del minimo..
				}
			}

			// Este indice va a indicar ahora, cual es el nodo que tengo que ver el valor de
			// sus aristas..
			
			double valorMenorDistancia = VALOR_INFINITO;
			for(int k = 0; k < distancias.length; k++) {
				// busco el valor minimo ..
				if( distancias[k] < valorMenorDistancia && !visitados[k] ) {
					valorMenorDistancia = distancias[k];  
					i = k;
				}
			}
			visitados[i] = true;
			cantidadAristas++;
		}

		System.out.println("Arista - Peso");
		int x = 0; // row number
		int y = 0; // col number

		for (int j = 0; j < desdeQueNodoVoy.length; j++) {

			// busco en el vector desdeQueNodoVoy el menor y el indice de ese valor voy
			// mostrando por pantalla..
			x = j;
			y = desdeQueNodoVoy[j];
			if( matriz[x][y] != VALOR_INFINITO) {
			System.out.println(x + " - " + y + " :  " + matriz[x][y]);
			pesoTotal += matriz[x][y]; 
			}
		}
		
		System.out.println("Peso total: " + pesoTotal);
		
	}

	public void Kruskal() {

	}

}
