package myPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Tarzan {

	private static final double INFINITO = -1;
	private int cantNodos = 0;
	private double[][] matAdy;
	private ArrayList<Vector> arboles = new ArrayList<Vector>();
	private ArrayList<CostoAlNodo> costos = new ArrayList<CostoAlNodo>();
	private boolean[] nodoTerminado;

	public Tarzan(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scan = new Scanner(file);
		int x = 0;
		int y = 0;
		double distancia = 0;

		while (scan.hasNextInt()) {
			x = scan.nextInt();
			y = scan.nextInt();
			arboles.add(new Vector(x, y));
			this.cantNodos++;
		}

		scan.close();

		this.matAdy = new double[arboles.size()][arboles.size()];
		this.nodoTerminado = new boolean[arboles.size()];

		for (int i = 0; i < arboles.size(); i++) {
			for (int j = 0; j < arboles.size(); j++) {
				if (i != j) {
					if ((distancia = calcularDistancia(arboles.get(i), arboles.get(j))) <= 50)
						this.matAdy[i][j] = distancia;
					else
						this.matAdy[i][j] = INFINITO;
				}
			}
		}
	}

	private double calcularDistancia(Vector v1, Vector v2) {
		Vector r = restarVectores(v1, v2);
		return calcularModulo(r);
	}

	private Vector restarVectores(Vector v1, Vector v2) {
		return new Vector(v1.getX() - v2.getX(), v1.getY() - v2.getY());
	}

	private double calcularModulo(Vector v) {
		return Math.sqrt(Math.pow(v.getX(), 2) + Math.pow(v.getY(), 2));
	}

	@SuppressWarnings("unchecked")
	public void dijkstra() throws IOException {
		int nodoInicial = 0;
		
		// cola de prioridad para almacenar los nodos adyacentes que se van
		// visitando
		Queue<CostoAlNodo> cola = new PriorityQueue<CostoAlNodo>();
		CostoAlNodo nodoActual = new CostoAlNodo(nodoInicial, 0, this.arboles.get(0));
		// acolo el nodo inicial
		cola.add(nodoActual);

		double peso = 0;
		int nodo = nodoActual.getNodo();
		CostoAlNodo actualizado;

		// inicializo la lista de costos
		for (int i = 0; i < this.cantNodos; i++) {
			if (i != nodo) {
				costos.add(new CostoAlNodo(i, INFINITO, this.arboles.get(i)));
			} else {
				costos.add(new CostoAlNodo(i, 0, this.arboles.get(i)));
				costos.get(i).agregarNodoAlCamino(nodo);
			}
		}

		// mientras la cola no está vacía
		while (!cola.isEmpty()) {
			nodoActual = cola.poll(); // desacolo al primero
			nodo = nodoActual.getNodo();

			// genero todos los números de nodo
			for (int i = 0; i < this.cantNodos; i++) {
				// si el nodo generado es distinto al nodo actual y no está
				// terminado
				if (nodo != i && !this.nodoTerminado[i]) {

					// si hay arista que una los nodos
					if ((peso = this.matAdy[nodo][i]) != INFINITO) {
						// si el nodo que estoy visitando no fue visitado o su
						// costo mínimo es mayor que la distancia recorrida para
						// visitarlo
						if (this.costos.get(i).getCostoMinimo() == INFINITO || this.costos.get(nodo).getCostoMinimo()
								+ peso < this.costos.get(i).getCostoMinimo()) {
							// referencio al nodo
							actualizado = this.costos.get(i);
							// actualizo su costo al dado hasta el nodo actual
							// más el peso de la arista entre ambos
							actualizado.setCostoMinimo(this.costos.get(nodo).getCostoMinimo() + peso);
							// le cambio el camino más corto por el camino más
							// corto hasta el nodo actual
							actualizado.setCaminoMasCorto(
									(ArrayList<Integer>) this.costos.get(nodo).getCaminoMasCorto().clone());
							// agrego el nodo visitado
							actualizado.agregarNodoAlCamino(i);
							// acolo el nodo visitado para luego buscar caminos
							// desde él
							if (!cola.contains(actualizado)) {
								cola.add(actualizado);
							}
						}
					}
				}
			}

			// marco el nodo como terminado ya que su costo mínimo y camino más
			// corto fueron hallados
			this.nodoTerminado[nodo] = true;
		}
		
	}
	
	
	public void escribirSolucion(String path) throws IOException {
		ArrayList<Integer> nodos = new ArrayList<Integer>();
		nodos = this.costos.get(this.costos.size()-1).getCaminoMasCorto();

		FileWriter file  = new FileWriter(path);
		BufferedWriter buffer = new BufferedWriter(file);
		
		if(nodos.size() > 0) {
			for(int i = 0 ; i < nodos.size() ; i++) {
				buffer.write(this.arboles.get(nodos.get(i)).getX() + " " + this.arboles.get(nodos.get(i)).getY());
				buffer.newLine();
			}
		}
		else
			buffer.write("NO HAY RUTA");
		
		
		buffer.close();
	}
}
