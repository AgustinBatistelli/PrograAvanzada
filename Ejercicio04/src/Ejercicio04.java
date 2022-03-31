
public class Ejercicio04 {
	//Escribir un método en Java que de una matriz cuadrada dada, devuelva una matriz con n filas, 
	//donde cada una tendrá los datos de una de las diagonales (de abajo a la izquierda hacia arriba a la derecha)

	public void mostrarDiagonales(int[][] matriz) {
		for (int i = matriz.length - 1; i >= 0; i--) {
			for (int j = 0; j < matriz.length - i; j++) {
				
				System.out.printf("%3d",matriz[i+j][j]);
			}
			System.out.print("\n");
		}
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 1; j < matriz.length - i; j++) {
				
				System.out.printf("%3d",matriz[j - 1][j + i]);
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		int[][] matriz = {{1, 2, 3, 4}, 
						  {5, 6, 7, 8}, 
						  {9, 10, 11, 12},
						  {13, 14, 15, 16}};
		
		Ejercicio04 ejer = new Ejercicio04();
		ejer.mostrarDiagonales(matriz);
	}
}
