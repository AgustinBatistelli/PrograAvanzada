import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class VendedorasPremiadas {
	
	private int cantidadVentas; /// indica las ventas de cada vendedora
	private int[] importes; /// el importe de cada una de las ventas de cada vendedora
	private boolean enConcurso; /// si es true, la vendedora sigue en el concurso. si es false, quedo eliminada
	private int numeroVendedora; /// el numero de cada vendedora.
	private int importeMaximo; /// el importe maximo de un conjunto de N ventas consecutivas
	private static int numeroVendedoraActual = 1;
	private static int ventasConsideradas; ///variable estatica que guarda el numero de ventas consideradas para el concurso

	/// constructor parametrizado de la clase Vendedora. recibe las ventas y sus importes
	public VendedorasPremiadas (int cantidadVentas, int[] importes) {
		this.cantidadVentas = cantidadVentas;
		this.importes = importes;
		this.enConcurso = true;
		this.numeroVendedora = numeroVendedoraActual;
		numeroVendedoraActual++;
		this.importeMaximo = 0;
	}

	/// este metodo fija el valor del importe maximo a las concursantes a partir de importes parciales 
	public void fijaImporteMaximo(int[] importesParciales) {
		if(this.enConcurso) {
			int importeFinal = importesParciales[0];
			for (int i = 1; i < importesParciales.length; i++) {
				if (importesParciales[i] > importeFinal) {
					importeFinal = importesParciales[i];
				}
			}
			this.importeMaximo = importeFinal;
		}
		else {
			this.importeMaximo= 0;
		}
	}

	public void retiraDelConcurso() {
		this.enConcurso = false;
	}

	public boolean estaEnConcurso() {
		return this.enConcurso;
	}
	
	///me dice cuantos importes parciales va a tener una vendedora
	public int dameCantidadDeImportesParciales(int numeroVentasConsecutivas) {
		return this.cantidadVentas - numeroVentasConsecutivas + 1;
	}

	/// calcula el importe
	public int importe(int inicio, int numeroVentasConsecutivas) {
		int total = 0;
		for (int i = inicio; i < (numeroVentasConsecutivas + inicio); i++) {
			total += this.importes[i];
		}
		return total;
	}

	
	public void generaImportesParciales(int[] importesParciales, int cantidadImportesParciales, int numeroVentasConsecutivas) {
		for (int i = 0; i < cantidadImportesParciales; i++) {
			importesParciales[i] = this.importe(i, numeroVentasConsecutivas);
		}
	}

	public static int resolver(VendedorasPremiadas vendedora[], int numeroVentasConsecutivas) {
		
		int numeroConcursantes = 0, maximaCantidadVentas = 0;
		ventasConsideradas = numeroVentasConsecutivas;
		
		for (int i = 0; i < vendedora.length; i++) {
			if (vendedora[i].cantidadVentas >= numeroVentasConsecutivas) {
				numeroConcursantes++;
			} else {
				vendedora[i].retiraDelConcurso();
			}
			if (vendedora[i].cantidadVentas > maximaCantidadVentas) {
				maximaCantidadVentas = vendedora[i].cantidadVentas;
			}
		}
		if (numeroConcursantes == 0) {
			return -1;
		}
		
		
		while (numeroVentasConsecutivas <= maximaCantidadVentas) { 
			int i = 0;
			///obtendra la suma de importes mas altas de una vendedora o la retirará del concurso
			while (i < vendedora.length) { 
				
				if (vendedora[i].estaEnConcurso()) {
					
					if (vendedora[i].cantidadVentas >= numeroVentasConsecutivas) {
						
						int[] importesParciales = new int[(vendedora[i]
								.dameCantidadDeImportesParciales(numeroVentasConsecutivas))];
						vendedora[i].generaImportesParciales(importesParciales,
								vendedora[i].dameCantidadDeImportesParciales(numeroVentasConsecutivas),numeroVentasConsecutivas);
						vendedora[i].fijaImporteMaximo(importesParciales);
						
					} else {
						
						vendedora[i].retiraDelConcurso();
						
					}
				}
				
				i++;
			}

			int maximoValor = 0, vendedorasConcursando = 0;
			
			for (int j = 0; j < vendedora.length; j++) {
				
				if (vendedora[j].importeMaximo > maximoValor) {
					
					maximoValor = vendedora[j].importeMaximo;
					
				}
			}

			///revisa cuantas vendedoras llegaron a ese importe mayor 
			for (int h = 0; h < vendedora.length; h++) {
				
				if (vendedora[h].importeMaximo == maximoValor) {
					
					vendedorasConcursando++;
					
				} else {
					vendedora[h].retiraDelConcurso();
				}
			}

			if (vendedorasConcursando == 1) {
				devuelveGanadoraEnCurso(vendedora);
			}

			numeroVentasConsecutivas++; 
			ventasConsideradas++;
		}

		return -2;
	}

	public static int devuelveGanadoraEnCurso(VendedorasPremiadas[] vendedora) {
		for (int k = 0; k < vendedora.length; k++) {
			if (vendedora[k].estaEnConcurso()) {
				return k;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(new FileReader("premio7.in"));
		int cantidadVendedoras = sc.nextInt();
		int ventasDeVendedora;
		
		VendedorasPremiadas vendedoras[] = new VendedorasPremiadas[cantidadVendedoras];
		
		for (int i = 0; i < cantidadVendedoras; i++) {
			
			ventasDeVendedora = sc.nextInt();
			
			int[] importesVendedora = new int[ventasDeVendedora];
			
			for (int j = 0; j < ventasDeVendedora; j++) {
				importesVendedora[j] = sc.nextInt();
			}
			
			vendedoras[i] = new VendedorasPremiadas(ventasDeVendedora, importesVendedora);
		}
		
		int numeroVentasConsecutivas = sc.nextInt();
		sc.close();

		int resultado = resolver(vendedoras, numeroVentasConsecutivas);

		PrintWriter pw = new PrintWriter(new FileWriter("premio7.out"));
		
		if (resultado == -2) {
			pw.println("No se puede desempatar");
		} else if (resultado == -1) {
			pw.println("No hay ganadoras");
		} else {
			pw.println(vendedoras[resultado].numeroVendedora);
			pw.println(ventasConsideradas + " " + vendedoras[resultado].importeMaximo);
		}
		pw.close();
	}
	
}
