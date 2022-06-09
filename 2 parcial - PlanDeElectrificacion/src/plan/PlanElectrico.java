package plan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PlanElectrico extends EjercicioOIA{

	private int[] padres;
	ArrayList<AristaPonderada> aristas = new ArrayList<AristaPonderada>();
	ArrayList<Integer> centrales = new ArrayList<Integer>();
	ArrayList<Arista> recorrido = new ArrayList<Arista>();
	
	private int minimoCosto = 0;
	private int cantCiudades;
	private int cantCentrales;
	
	public PlanElectrico(File entrada, File salida) {
		super(entrada, salida);
		this.cargarEntrada();
	}
	
	private void cargarEntrada() {
		try {
			Scanner scan = new Scanner(entrada);
			int peso = 0;
			this.cantCiudades = scan.nextInt();
			this.cantCentrales = scan.nextInt();

			for (int i = 0; i < this.cantCentrales; i++)
				this.centrales.add(scan.nextInt() - 1);

			for (int i = 0; i < this.cantCiudades; i++) {
				for (int j = 0; j < this.cantCiudades; j++) {
					peso = scan.nextInt();
					if (i < j) {
						this.aristas.add(new AristaPonderada(i, j, peso));
					}
				}
			}
			
			Collections.sort(this.aristas, new Comparator<AristaPonderada>() {
				@Override
				public int compare(AristaPonderada a1, AristaPonderada a2) {
					return a1.getCosto() - a2.getCosto();
				}
			});
			scan.close();
		} catch(IOException e) {
			System.out.println("Error en la lectura del archivo de entrada");
		}
	}

	@Override
	public void resolver() {
		calcularTendido();
		grabarSolucionEnArchivo();
	}

	private void calcularTendido() {
		if ((this.centrales.size() != this.cantCiudades) && (this.centrales.size() != 0)) {
			this.kruskal();		
		}
	}
	
	private void kruskal() {
		int aristas = 0;
		int nodo1 = 0;
		int nodo2 = 0;
		int peso = 0;
		int k = 0;
		int noUnir = 0;

		this.padres = new int[this.cantCiudades];
		
		for (int i = 0; i < this.cantCiudades; i++) {
			this.padres[i] = i;
		}

		for (int i = 0; i < this.aristas.size(); i++) {
			nodo1 = this.aristas.get(i).getNodo1();
			nodo2 = this.aristas.get(i).getNodo2();
			peso = this.aristas.get(i).getCosto();

			if (!(this.centrales.contains(nodo1) && this.centrales.contains(nodo2))) {
				
				union(this.aristas.get(i).getNodo1(), this.aristas.get(i).getNodo2());
				this.recorrido.add(new Arista(nodo1, nodo2));
				noUnir = i;
				break;
			}
		}
		
		this.minimoCosto += peso;
		aristas++;

		while (aristas < (this.cantCiudades - this.cantCentrales) && k < this.aristas.size()) {
			if(k != noUnir) {
				nodo1 = this.aristas.get(k).getNodo1();
				nodo2 = this.aristas.get(k).getNodo2();
				peso = this.aristas.get(k).getCosto();
				if(!(this.centrales.contains(nodo1) && this.centrales.contains(nodo2))) {
					if (find(nodo1) != find(nodo2)) {
						union(nodo1, nodo2);
						aristas++;
						this.recorrido.add(new Arista(nodo1, nodo2));
						this.minimoCosto += peso;
					}
				}
			}
			k++;
		}
	}
	
	private int find(int nodo) {
		return this.padres[nodo] == nodo ? nodo : find(this.padres[nodo]);
	}

	private void union(int nodo1, int nodo2) {
		this.padres[find(nodo1)] = this.padres[find(nodo2)];
	}
	
	private void grabarSolucionEnArchivo() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(salida));
			
			buffer.write(String.valueOf(this.minimoCosto));
			buffer.newLine();
			for (int i = 0; i < this.recorrido.size(); i++) {
				buffer.write(String.valueOf(this.recorrido.get(i).getNodo1()+1));
				buffer.write(" ");
				buffer.write(String.valueOf(this.recorrido.get(i).getNodo2()+1));
				buffer.newLine();
			}
			
			buffer.close();
		} catch(IOException e) {
			System.out.println("Error en la escritura del archivo de salida");
		}
	}
	
	public void mostrarAristas() {
		for(int i = 0 ; i < this.aristas.size() ; i++) {
			System.out.println((this.aristas.get(i).getNodo1()+1) + " " + (this.aristas.get(i).getNodo2()+1) + " " + (this.aristas.get(i).getCosto()));
		}
	}
	
	public void mostrarRecorrido() {
		for(int i = 0 ; i < this.recorrido.size() ; i++) 
			System.out.println((this.recorrido.get(i).getNodo1()+1) + " " + (this.recorrido.get(i).getNodo2()+1));
	}
	
	public void mostrarCentrales() {
		for (int i = 0; i < this.cantCentrales; i++) {
			System.out.println(this.centrales.get(i) + " ");
		}
	}
}
