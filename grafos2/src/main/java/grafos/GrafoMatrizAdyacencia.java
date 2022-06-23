package grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GrafoMatrizAdyacencia extends Grafo {
	
	protected double[][] matriz;
	
	public GrafoMatrizAdyacencia(int cantNodos) {
		matriz = new double[cantNodos][cantNodos];
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				matriz[i][j] = VALOR_INFINITO;
			}
		}
	}
	
	public static class Arista implements Comparable<Arista>{
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
	
	public void floyd() {
		int cantNodos = getCantNodos();
		double [][] matrizResultado = new double[cantNodos][cantNodos];
		
		for(int i = 0; i < cantNodos; i++) {
			for(int j = 0; j < cantNodos; j++) {
				matrizResultado[i][j] = matriz[i][j];
			}
		}
		
		for(int i = 0; i < cantNodos; i++) {
			for(int j = 0; j < cantNodos; j++) {
				for(int k = 0; k < cantNodos; k++) {
					if(j != i && k != i && j != k)
						matrizResultado[j][k] = minimo(matrizResultado[j][k], matrizResultado[j][i] + matrizResultado[i][k]);
				}
			}
		}
		
		for(int i = 0; i < cantNodos; i++) {
			for(int j = 0; j < cantNodos; j++) {
				System.out.format("%4d ",(int)matrizResultado[i][j]);
			}
			System.out.println("");
		}
	}
	
	private double minimo(double a, double b) {
		return a < b ? a : b;
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
	
	
	
	public void setArista(int nodoOrigen, int nodoDestino, double valor) {
		matriz[nodoOrigen][nodoDestino] = valor;
	}
	
	@Override
	public int getCantNodos() {
		return matriz.length;
	}
	
	public void mostrarMatriz() {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				System.out.format("%3.0f ", matriz[i][j]);
			}
			System.out.print("\n");
		}
	}

	@Override
	public HashSet<Integer> getNodos(){
		HashSet<Integer> nodos = new HashSet<Integer>();
		for(int i = 0; i < matriz.length; i++) {
			nodos.add(i);
		}
		return nodos;
		
	}
	
	@Override
	public double getArista(int nodoOrigen, int nodoDestino) {
		return matriz[nodoOrigen][nodoDestino];	
	}
	
	@Override
	public HashSet<Integer> getNodosAdyacentes(int nodo){
		HashSet<Integer> nodosAdyacentes = new HashSet<Integer>();
		
		for(int i = 0; i < getCantNodos(); i++) {
			if(existeArista(nodo, i)) {
				nodosAdyacentes.add(i);
			}
		}
		
		return nodosAdyacentes;
	}
	
	public boolean existeArista(int nodoOrigen, int nodoDestino) {
		return getArista(nodoOrigen, nodoDestino) != VALOR_INFINITO;
	}

	
	@Override
	public void mostrarGrafoDFS(int nodoOrigen) {
		Stack<Integer> pila = new Stack<Integer>();
		ArrayList<Integer> arrayResultado = new ArrayList<Integer>();
		ArrayList<Integer> arrayVisitados = new ArrayList<Integer>();
//		int cantVisitados = 0;
		
		pila.add(nodoOrigen);
		while(!pila.isEmpty()) {
			int nodo = pila.pop();
			arrayResultado.add(nodo);
			for(int i = 0; i < matriz.length; i++) {
				if(matriz[nodo][i] != VALOR_INFINITO && !arrayResultado.contains(i)  && !arrayVisitados.contains(i)) {
					pila.add(i);
					arrayVisitados.add(i);
//					cantVisitados++;
				}
			}
		}
		
		for(Integer nodo: arrayResultado) {
			System.out.println(nodo);
		}	
	}


	@Override
	public void mostrarGrafoBFS(int nodoOrigen) {
		Queue<Integer> cola = new LinkedList<Integer>();
		ArrayList<Integer> arrayResultado = new ArrayList<Integer>();
		ArrayList<Integer> arrayVisitados = new ArrayList<Integer>();
		
		cola.add(nodoOrigen);
		while(!cola.isEmpty()) {			
			int nodo = cola.remove();
			arrayResultado.add(nodo);
			arrayVisitados.add(nodo);
			for(int i = 0; i < matriz.length; i++) {
				if(matriz[nodo][i] != VALOR_INFINITO && !arrayResultado.contains(i) && !arrayVisitados.contains(i)) {
					cola.add(i);
					arrayVisitados.add(i);
				}
			}
		
		}
		
		for(Integer nodo: arrayResultado) {
			System.out.println(nodo);
		}
	}
}
