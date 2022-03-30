public class Ejercicio02 {
	public int[][] sumarAdyacentes(int[][] matrizOriginal) {
			int[][] matrizResultante = new int[3][4];
			int i, j;
			for ( i = 0; i < matrizOriginal.length; i++) {
				for ( j = 0; j <= matrizOriginal.length; j++) {
					matrizResultante[i][j] += matrizOriginal[i][j];
					if (i - 1 >= 0)
						matrizResultante[i][j] += matrizOriginal[i-1][j];
					
					if (i + 1 < matrizOriginal.length)
						matrizResultante[i][j] += matrizOriginal[i+1][j];
					
					if (j - 1 >= 0)
						matrizResultante[i][j] += matrizOriginal[i][j - 1];
					
					if (j + 1 < matrizOriginal.length)
						matrizResultante[i][j] += matrizOriginal[i][j + 1];
					
				}
			}
			
			return matrizResultante;
	}
	
	public void mostrarMatriz(int[][] matriz) {
		for ( int i = 0; i < matriz.length; i++) {
			for ( int j = 0; j < matriz.length + 1; j++) {
					System.out.print(matriz[i][j]);
					System.out.print(" | ");
			}
			System.out.print("\n");
		}	
	}
	
	
	public static void main (String[] args) {
			int[][] matriz = {{8,  2, -3, 4}, 
							  {5, -6, -6,20}, 
							  {21, 1, -5, 0} };
			
			Ejercicio02 ejer = new Ejercicio02();
			
			ejer.mostrarMatriz(ejer.sumarAdyacentes(matriz));
			
	}
}
