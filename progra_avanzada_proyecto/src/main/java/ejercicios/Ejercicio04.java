package main.java.ejercicios;

public class Ejercicio04 {
	
	public void mostrarDiagonales(int[][] matriz) {
		
		for (int i = matriz.length - 1; i > 0; i--) {
			for (int j = 0; j < matriz.length - i; j++) {
				
				System.out.printf("%3d",matriz[i+j][j]);
			}
			System.out.print("\n");
		}
		
		int min = matriz.length > matriz[0].length ? matriz[0].length : matriz.length; 
		
		for (int i = 0; i < min ; i++) {
				System.out.printf("%3d",matriz[i][i]);
		}
			System.out.print("\n");
		
			
		for (int i = 0; i < matriz.length ; i++) {
			for (int j = 1; j < matriz[0].length - i; j++) {
				
				System.out.printf("%3d",matriz[j - 1][j + i]);
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
//		int[][] matriz = {{1, 2, 3, 4}, 
//						  {5, 6, 7, 8}, 
//						  {9, 10, 11, 12},
//						  {13, 14, 15, 16}};
//		int[][] matriz = { { 1, 2, 3, 4 },
//						   { 5, 6, 7, 8 },
//						   { 9, 10, 11, 12 },
//						   { 13, 14, 15, 16 },
//						   { 17, 18, 19, 20 } };
//		
		int[][] matriz = { { 1,   2,  3,  4,  5},
				   		   { 6,   7,  8,  9, 10},
				   		   { 11, 12, 13, 14, 15},
				   		   { 16, 17, 18, 19, 20} };
		
		Ejercicio04 ejer = new Ejercicio04();
		ejer.mostrarDiagonales(matriz);
	}
}
