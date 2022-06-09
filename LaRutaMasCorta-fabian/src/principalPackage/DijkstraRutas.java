package principalPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraRutas {

	private CiudadesYRutas grafo;
	private int nodoInicial;
	
	private int cantNodos;
	boolean nodoTerminado[];
	private ArrayList<CostoAlNodo> costos;

	private static final int INFINITO = -1;

	public int getNodoInicial() {
		return nodoInicial;
	}

	public CiudadesYRutas getGrafo() {
		return grafo;
	}

	public int getCantNodos() {
		return this.cantNodos;
	}

	public DijkstraRutas(CiudadesYRutas grafo, int nodoInicial) {
		this.grafo = grafo;
		this.nodoInicial = nodoInicial;
		this.cantNodos = grafo.getGrafo().getOrdenMatriz();
		this.nodoTerminado = new boolean[cantNodos];
		costos = new ArrayList<CostoAlNodo>();
	}

	@SuppressWarnings("unchecked")
	public void ejecutar() throws IOException {
		// cola de prioridad para almacenar los nodos adyacentes que se van visitando
		Queue<CostoAlNodo> cola = new PriorityQueue<CostoAlNodo>();
		CostoAlNodo nodoActual = new CostoAlNodo(this.nodoInicial, 0);
		// acolo el nodo inicial
		cola.add(nodoActual);

		int indice;
		int nodo = nodoActual.getNodo();
		CostoAlNodo actualizado;

		// inicializo la lista de costos
		for (int i = 0; i < this.cantNodos; i++) {
			if (i != nodo) {
				costos.add(new CostoAlNodo(i, INFINITO));
			} else {
				costos.add(new CostoAlNodo(i, 0));
				costos.get(i).agregarNodoAlCamino(nodo);;
			}
		}

		// mientras la cola no está vacía
		while (!cola.isEmpty()) {
			nodoActual = cola.poll(); // desacolo al primero
			nodo = nodoActual.getNodo();
			
			// genero todos los números de nodo
			for (int i = 0; i < this.cantNodos; i++) {
				// si el nodo generado es distinto al nodo actual y no está terminado
				if (nodo != i && !this.nodoTerminado[i]) {
					// genero el índice para la matriz simétrica
					if (nodo < i) {
						indice = this.grafo.getGrafo().getIndice(nodo, i);
					} else {
						indice = this.grafo.getGrafo().getIndice(i, nodo);
					}

					// si hay arista que una los nodos
					if (this.grafo.getGrafo().hayArista(indice)) {
						// si el nodo que estoy visitando no fue visitado o su costo mínimo es mayor que la distancia recorrida para visitarlo
						if (this.costos.get(i).getCostoMinimo() == INFINITO || this.costos.get(nodo).getCostoMinimo() + this.getGrafo().getPesoArista(indice) < this.costos.get(i).getCostoMinimo()) {
							// referencio al nodo
							actualizado = this.costos.get(i);
							// actualizo su costo al dado hasta el nodo actual más el peso de la arista entre ambos
							actualizado.setCostoMinimo(this.costos.get(nodo).getCostoMinimo() + this.getGrafo().getPesoArista(indice));
							// le cambio el camino más corto por el camino más corto hasta el nodo actual
							actualizado.setCaminoMasCorto((ArrayList<Integer>)this.costos.get(nodo).getCaminoMasCorto().clone());
							// agrego el nodo visitado
							actualizado.agregarNodoAlCamino(i);
							
							// acolo el nodo visitado para luego buscar caminos desde él
							if (!cola.contains(actualizado)) {
								cola.add(actualizado);
							}
						}
					}
				}
			}
			
			// marco el nodo como terminado ya que su costo mínimo y camino más corto fueron hallados
			this.nodoTerminado[nodo] = true;
		}

	}

	public void escribirSolucionEnConsola(int nodoFinal) {
		
		int distancia = costos.get(nodoFinal).getCostoMinimo();
		if (distancia == INFINITO) {
			System.out.println("No hay ruta entre " + this.grafo.getNombreCiudad(this.nodoInicial) + " y " + this.grafo.getNombreCiudad(nodoFinal));
		} else {
			System.out.print("La ruta más corta es de " + distancia + "km:");
			for (Integer ciudadDeLaRuta : this.costos.get(nodoFinal).getCaminoMasCorto()) {
				System.out.print(" " + this.grafo.getNombreCiudad(ciudadDeLaRuta));
			}
		}		
	}

	public void escribirSolucionEnArchivo(File salida, int nodoFinal) throws IOException {
		FileWriter file = new FileWriter(salida);
		BufferedWriter buffer = new BufferedWriter(file);

		int distancia = costos.get(nodoFinal).getCostoMinimo();
		if (distancia == INFINITO) {
			buffer.write("No hay ruta entre " + this.grafo.getNombreCiudad(this.nodoInicial) + " y " + this.grafo.getNombreCiudad(nodoFinal));
		} else {
			buffer.write("La ruta más corta es de " + distancia + "km:");
			for (Integer ciudadDeLaRuta : this.costos.get(nodoFinal).getCaminoMasCorto()) {
				buffer.write(" " + this.grafo.getNombreCiudad(ciudadDeLaRuta));
			}
		}
		buffer.close();
	}
	
}
