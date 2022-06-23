package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

	public void primMIO() { // osea va por ahi la cosa..
		boolean[] visitados = new boolean[matriz.length]; // array de vertices visitados
		double[] distancias = new double[matriz.length];
		int[] desdeQueNodoVoy = new int[matriz.length];
		double pesoTotal = 0;

		Arrays.fill(visitados, false); // setteo visitados en false al inicio.
		Arrays.fill(desdeQueNodoVoy, 0); // setteo desdeoQueNodoVoy en 0; primer elemento desde el que voy a intentar
											// ir..
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
			for (int k = 0; k < distancias.length; k++) {
				// busco el valor minimo ..
				if (distancias[k] < valorMenorDistancia && !visitados[k]) {
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

		// recorro y voy buscando el minimo, a su vez con otro ciclo externo voy a ir
		// disminuyendo la cnatidad de iteraciones que todavia me faltan..

		double minimo = matriz[0][desdeQueNodoVoy[0]];
		int indiceNodoYaContemplado = 0;
// en vez de buscar los menores, busco el mayor, lo cancelo y muestro el resto... O(1) mejor que O(n^2)
		
		while (cantidadAristas > 0) {
			for (int j = 1; j < desdeQueNodoVoy.length; j++) {
				x = j;
				y = desdeQueNodoVoy[j];
				if (matriz[x][y] < minimo && visitados[x]) {
					minimo = matriz[x][y];
					indiceNodoYaContemplado = x;
				}
			}
			// en x voy a tener el indice del nodo que ya visite..
			visitados[indiceNodoYaContemplado] = false; // lo marco como ya visitado.
			cantidadAristas--;
		}

		for (int j = 0; j < desdeQueNodoVoy.length; j++) {
			x = j;
			y = desdeQueNodoVoy[j];
			if (visitados[j] == true) {
				System.out.println(x + " - " + y + " :  " + matriz[x][y]);
				pesoTotal += matriz[x][y];
			}
		}

		System.out.println("Peso total: " + pesoTotal);

	}

	static class Arista implements Comparable<Arista>{
	    private int origen;     //Vértice origen
	    private int destino;    //Vértice destino
	    private double peso;       //Peso entre el vértice origen y destino
	    Arista(int origen, int destino, double peso){
	    	this.origen = origen;
	    	this.destino = destino;
	    	this.peso = peso;
		}

		public int getDestino() {
			return destino;
		}
		public int getOrigen() {
			return origen;
		}
		
		public double getPeso() {
			return peso;
		}
		public int compareTo(Arista o) {
			return (int) (this.peso - o.peso);
		}
	};
	
	static int find( int x, int padre[]){
	    return ( x == padre[ x ] ) ? x : ( padre[ x ] = find( padre[ x ], padre ) );
	}

	//Método para unir 2 componentes conexas
	static void union( int x , int y , int padre[]){
	    padre[ find( x, padre ) ] = find( y, padre );
	}

	//Método que me determina si 2 vértices estan o no en la misma componente conexa
	static boolean sameComponent( int x , int y , int padre[]){
		return find( x, padre ) == find( y, padre );
	}
	
	public ArrayList<Arista> kruskal() {
		int cantNodosGrafo = getCantNodos();
		int padre[] = new int[ cantNodosGrafo ];
		ArrayList<Arista> solucion = new ArrayList<Arista>(cantNodosGrafo);
		ArrayList<Arista> aristas = new ArrayList<Arista>(cantNodosGrafo);
		
		
		for(int i = 0; i < cantNodosGrafo; i++) {
			padre[i] = i;
		}
		
		for(int i = 0; i < cantNodosGrafo; i++) {
			for(int j = 0; j < cantNodosGrafo; j++) {
				aristas.add(new Arista(i, j, matriz[i][j]));
			}
		}
		Collections.sort(aristas);
		
		for( int i = 0 ; i < aristas.size() ; ++i ){     //Recorremos las aristas ya ordenadas por peso
	        int origen = aristas.get(i).getOrigen();    //Vértice origen de la arista actual
	        int destino = aristas.get(i).getDestino();  //Vértice destino de la arista actual
	        double peso = aristas.get(i).getPeso();        //Peso de la arista actual

	        //Verificamos si estan o no en la misma componente conexa
	        if( !sameComponent( origen , destino , padre) ){  //Evito ciclos
	        	union( origen , destino, padre );  //Union de ambas componentes en una sola
	        	solucion.add(new Arista(origen, destino, peso));
	        }
	    }
		
		for(Arista arista: solucion) {
			System.out.println(arista.getDestino() + 1 + "-" +  (arista.getOrigen() + 1) + ": " +  arista.getPeso());
		}
		
//		System.out.println("El costo total es: " + costoTotal);
		
		
		return solucion;
		
	}

}
