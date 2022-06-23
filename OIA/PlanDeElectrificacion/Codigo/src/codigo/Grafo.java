package codigo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {

	private List<Integer> nodos;
	private int cantDeNodos;
	private List<Integer> centralesElectricas;
	private List<Integer> ciudades;
	private MatrizAdyacencia matrizAdyancencia;
	private int[][] matrizCostos;
	private List<Arista> tendido;

	public Grafo(int cantDeNodos, List<Integer> centrales) {
		this.cantDeNodos = cantDeNodos;
		this.nodos = new ArrayList<>();
		this.centralesElectricas = new LinkedList<>();
		this.ciudades = new LinkedList<>();
		this.matrizCostos = new int[cantDeNodos][];
		this.tendido = new LinkedList<>();

		// Genero los nodos
		for (int i = 0; i < this.cantDeNodos; i++) {
			nodos.add(i);
		}

		for (int i = 0; i < this.cantDeNodos; i++) {
			this.matrizCostos[i] = new int[i];
		}

		this.matrizAdyancencia = new MatrizAdyacencia(cantDeNodos);
		this.centralesElectricas = centrales;
	}

	public void setValor(int nodoI, int nodoJ, int peso) {
		this.matrizAdyancencia.setPeso(nodoI, nodoJ, peso);
	}

	public SalidaElectrificacion resolver() {
		int costoDirecto, costoIntermedio;
		int menor = Integer.MAX_VALUE, valorActual, costoTotal = 0;
		int[][] matrizPrecedentes = new int[this.cantDeNodos][this.cantDeNodos];
		int menorI = 0, menorJ = 0;
		
		if(this.cantDeNodos == 0 || this.centralesElectricas.isEmpty()){
			return new SalidaElectrificacion(0, null); 
		}
		
		// duplico matriz original para no modificarla
		for (int i = 0; i < this.cantDeNodos; i++) {
			for (int j = 0; j < i; j++) {
				this.matrizCostos[i][j] = this.matrizAdyancencia.getPeso(i, j);
			}
		}

		for (int i = 0; i < this.cantDeNodos; i++) {
			for (int j = 0; j < this.cantDeNodos; j++) {
				matrizPrecedentes[i][j] = i;
			}
		}

		for (int k = 0; k < this.cantDeNodos; k++) {
			for (int i = 0; i < this.cantDeNodos; i++) {
				for (int j = 0; j < i; j++) {
					if (i != k && j != k) {

						costoDirecto = this.getValorMatrizCostos(i, j);
						costoIntermedio = this.getValorMatrizCostos(i, k) + this.getValorMatrizCostos(k, j);

						if (costoIntermedio < costoDirecto) {
							this.setValorMatrizCostos(i, j, costoIntermedio);
						}
					}

				}
			}

		}

		for (int i = 0; i < this.cantDeNodos; i++) {
			if (!this.centralesElectricas.contains(i)) {
				this.ciudades.add(i);
			}

		}

		for (Integer i : this.ciudades) {
			for (Integer j : this.centralesElectricas) {
				valorActual = this.getValorMatrizCostos(i, j);
				if (valorActual < menor) {
					menor = valorActual;
					menorI = i;
					menorJ = j;
				}
			}
			this.tendido.add(new Arista(menorI, menorJ));
			costoTotal += menor;
			menor = Integer.MAX_VALUE;
		}

		return new SalidaElectrificacion(costoTotal, tendido);
	}

	public int getValorMatrizCostos(int i, int j) {
		if (j > i) {
			return this.matrizCostos[j][i];
		}
		return this.matrizCostos[i][j];
	}

	public void setValorMatrizCostos(int i, int j, int valor) {
		if (j > i) {
			this.matrizCostos[j][i] = valor;
		}

		this.matrizCostos[i][j] = valor;
	}

}
