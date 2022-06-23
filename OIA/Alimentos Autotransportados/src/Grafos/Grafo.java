package Grafos;

public class Grafo {
	
	protected int [][] matrizAdyacencia;
	
	public void mostrarMatrizAdyacencia() {
		System.out.print("\t");
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < matrizAdyacencia.length; j++) {
				if (matrizAdyacencia[i][j] != Integer.MAX_VALUE) {
					System.out.print(matrizAdyacencia[i][j] + "\t");
				} else {
					System.out.print("-\t");
				}
			}
			System.out.println();
		}
	}
	
	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}
	
	public int[][] getMatrizAdyacencia(){
		return this.matrizAdyacencia;
	}
	
	
	

}
