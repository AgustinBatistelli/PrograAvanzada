package ejercicio02;

public class Ejercicio02 {
	
	public static void main(String[] args) {

		Ejercicio02 ej = new Ejercicio02();
		ej.sumaAdyacentes();
	}
	
	public void sumaAdyacentes() {
		
		int[][] matPrueba = {
				{8, 2,-3, 4},
				{5,-6,-6,20},
				{21, 1,-5, 0} };

		int[][] matFinal = new int[3][4];

		for(int i = 0; i < matPrueba.length; i++) {

			for(int j = 0; j < matPrueba[i].length; j++) {

				if(i-1 >= 0)
					matFinal[i][j] += matPrueba[i-1][j];

				if(i+1 < matPrueba.length)
					matFinal[i][j] += matPrueba[i+1][j];

				if(j-1 >= 0)
					matFinal[i][j] += matPrueba[i][j-1];

				if(j+1 < matPrueba[i].length)
					matFinal[i][j] += matPrueba[i][j+1];

				matFinal[i][j] += matPrueba[i][j];
			}
		}

		imprimirMatriz(matPrueba);
		System.out.println("\n");
		imprimirMatriz(matFinal);
	}
	
	public void imprimirMatriz(int[][] mat) {
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]);
				System.out.print("|");
			}
			System.out.print("\n");
		}

	}

}
