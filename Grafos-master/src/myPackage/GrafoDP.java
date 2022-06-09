package myPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GrafoDP {

	private static final int INFINITO = -1;
	private int[][] grafo;
	private int cantNodos;
	private int cantAristas;
	private double ptajeAdyacencia;
	private int gradoMax;
	private int gradoMin;

	private int colorMax = 1;
	private ArrayList<Nodo> nodos;
	private int[] nodosColoreados; // el indice coincide con el numero de nodo,
									// y el valor que guarda es el color
	private int[] gradosNodos;

	private int mejorColor = 0;
	private int[] solucion;
	private int[] mejoresColores;

	public GrafoDP(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scan = new Scanner(file);
		int fil;
		int col;
		int peso;
		this.cantNodos = scan.nextInt();
		this.cantAristas = scan.nextInt();
		this.ptajeAdyacencia = scan.nextDouble();
		this.gradoMax = scan.nextInt();
		this.gradoMin = scan.nextInt();
		this.grafo = new int[this.cantNodos][this.cantNodos];
		this.colorMax = 1;
		nodos = new ArrayList<Nodo>();
		nodosColoreados = new int[this.cantNodos];
		gradosNodos = new int[this.cantNodos];
		solucion = new int[this.cantNodos];
		mejoresColores = new int[this.cantNodos + 1];

		for (int i = 0; i < this.cantNodos; i++)
			gradosNodos[i] = 0;

		for (int i = 0; i < this.cantNodos; i++) {
			this.grafo[i][i] = 0;
			for (int j = i + 1; j < this.cantNodos; j++) {
				this.grafo[i][j] = INFINITO;
				this.grafo[j][i] = INFINITO;
			}
		}

		for (int i = 0; i < this.cantNodos; i++)
			mejoresColores[i] = 0;

		for (int i = 0; i < this.cantAristas; i++) {
			fil = scan.nextInt();
			col = scan.nextInt();
			gradosNodos[fil]++;
			gradosNodos[col]++;
			peso = scan.nextInt();
			this.grafo[fil][col] = peso;
		}

		for (int i = 0; i < this.cantNodos; i++) {
			Nodo nodo = new Nodo(i);
			nodo.setGrado(this.gradosNodos[i]);
			this.nodos.add(nodo);
		}

		scan.close();
	}

	private void colorear() {
		int color = 1;
		int nodo;
		int j;

		this.colorMax = 1;
		for (int i = 0; i < this.cantNodos; i++)
			this.nodosColoreados[i] = 0;

		nodosColoreados[this.nodos.get(0).getNroNodo()] = color; // coloreo el
																	// primer
																	// nodo de
																	// la lista

		for (int i = 1; i < this.cantNodos; i++) {
			nodo = this.nodos.get(i).getNroNodo();
			this.nodosColoreados[nodo] = color;
			j = 0;
			while (j < this.cantNodos) {
				if (nodo != j) {
					if (((this.grafo[nodo][j] != INFINITO && this.grafo[nodo][j] != 0)
							|| (this.grafo[j][nodo] != INFINITO && this.grafo[j][nodo] != 0))
							&& this.nodosColoreados[nodo] == this.nodosColoreados[j]) {
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

	public void coloreoSecuencial(int corridas) throws IOException {
		int nroCorrida = 0;
		for (int i = 0; i < corridas; i++) {
			Collections.shuffle(this.nodos);
			this.colorear();

			if (this.colorMax < this.mejorColor || this.mejorColor == 0) {
				this.mejorColor = this.colorMax;
				nroCorrida = i + 1;
				this.solucion = this.nodosColoreados.clone(); // copio la mejor
																// solucion
																// hasta el
																// momento
			}

			this.mejoresColores[this.colorMax]++;
		}

		this.escribirSolucion("SECUENCIAL");
		this.escribirVectorEstadistico("SECUENCIAL");
		System.out.print("SECUENCIAL: ");
		System.out.println("Menor cantidad de colores: " + this.mejorColor + ", en numero de iteracion: " + nroCorrida);

		this.mejorColor = 0;
		for (int i = 0; i < this.cantNodos; i++) // me aseguro de limpiar el
													// vector estadistico
			this.mejoresColores[i] = 0;
	}

	public void coloreoWelshPowell(int corridas) throws IOException {
		int nroCorrida = 0;
		for (int i = 0; i < corridas; i++) {
			Collections.shuffle(this.nodos);
			Collections.sort(this.nodos, new Comparator<Nodo>() {
				@Override
				public int compare(Nodo nodo1, Nodo nodo2) {
					return nodo2.getGrado() - nodo1.getGrado(); // ordeno por
																// grado
																// decreciente
				}
			});
			this.colorear();

			if (this.colorMax < this.mejorColor || this.mejorColor == 0) {
				this.mejorColor = this.colorMax;
				nroCorrida = i + 1;
				this.solucion = this.nodosColoreados.clone(); // copio la mejor
																// solucion
																// hasta el
																// momento
			}

			this.mejoresColores[this.colorMax]++;
		}

		this.escribirSolucion("WELSH-POWELL");
		this.escribirVectorEstadistico("WELSH-POWELL");
		System.out.print("WELSH-POWELL: ");
		System.out.println("Menor cantidad de colores: " + this.mejorColor + ", en numero de iteracion: " + nroCorrida);

		this.mejorColor = 0;
		for (int i = 0; i < this.cantNodos; i++) // me aseguro de limpiar el
													// vector estadistico
			this.mejoresColores[i] = 0;
	}

	public void coloreoMatula(int corridas) throws IOException {
		int nroCorrida = 0;
		for (int i = 0; i < corridas; i++) {
			Collections.shuffle(this.nodos);
			Collections.sort(this.nodos, new Comparator<Nodo>() {
				@Override
				public int compare(Nodo nodo1, Nodo nodo2) {
					return nodo1.getGrado() - nodo2.getGrado(); // ordeno por
																// grado
																// creciente
				}
			});
			this.colorear();

			if (this.colorMax < this.mejorColor || this.mejorColor == 0) {
				this.mejorColor = this.colorMax;
				nroCorrida = i + 1;
				this.solucion = this.nodosColoreados.clone(); // copio la mejor
																// solucion
																// hasta el
																// momento
			}

			this.mejoresColores[this.colorMax]++;
		}

		this.escribirSolucion("MATULA");
		this.escribirVectorEstadistico("MATULA");
		System.out.print("MATULA: ");
		System.out.println("Menor cantidad de colores: " + this.mejorColor + ", en numero de iteracion: " + nroCorrida);

		this.mejorColor = 0;
		for (int i = 0; i < this.cantNodos; i++) // me aseguro de limpiar el
													// vector estadistico
			this.mejoresColores[i] = 0;
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
			System.out.println("n: " + this.nodos.get(i).getNroNodo() + " g: " + this.nodos.get(i).getGrado());
	}

	public void mostrarGrados() {
		for (int i = 0; i < this.cantNodos; i++)
			System.out.println("n: " + i + " g: " + this.gradosNodos[i]);
	}

	private void escribirSolucion(String algoritmo) throws IOException {
		FileWriter file = new FileWriter("COLOREO" + "_" + algoritmo + "_" + this.cantNodos + "_"
				+ String.format("%.2f", this.ptajeAdyacencia) + ".out");
		BufferedWriter buffer = new BufferedWriter(file);

		buffer.write(String.valueOf(this.cantNodos));
		buffer.write(" ");
		buffer.write(String.valueOf(this.colorMax));
		buffer.write(" ");
		buffer.write(String.valueOf(this.cantAristas));
		buffer.write(" ");
		buffer.write(String.valueOf(NumberFormat.getInstance().format(this.ptajeAdyacencia)));
		buffer.write(" ");
		buffer.write(String.valueOf(this.gradoMax));
		buffer.write(" ");
		buffer.write(String.valueOf(this.gradoMin));
		buffer.newLine();

		for (int i = 0; i < this.solucion.length; i++) {
			buffer.write(String.valueOf(i));
			buffer.write(" ");
			buffer.write(String.valueOf(this.solucion[i]));
			buffer.newLine();
		}

		buffer.close();
	}

	private void escribirVectorEstadistico(String algoritmo) throws IOException {
		FileWriter file = new FileWriter("VECTOR" + "_" + algoritmo + "_" + this.cantNodos + "_"
				+ String.format("%.2f", this.ptajeAdyacencia) + ".out");
		BufferedWriter buffer = new BufferedWriter(file);

		for (int i = 0; i < this.cantNodos; i++) {
			buffer.write(String.valueOf(i + 1));
			buffer.write(" ");
			buffer.write(String.valueOf(this.mejoresColores[i]));
			buffer.newLine();
		}

		buffer.close();
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public double getPtajeAdyacencia() {
		return ptajeAdyacencia;
	}

	public int getGradoMax() {
		return gradoMax;
	}

	public int getGradoMin() {
		return gradoMin;
	}

	public int[][] getGrafo() {
		return this.grafo;
	}
}
