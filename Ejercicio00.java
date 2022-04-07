package main.java.ejercicios;

// Comentario de modificacion 

public class Ejercicio00 {

	public boolean comprobar(int[][] matriz) {
		int sumaParcial = matriz[0][0];
		boolean bandera = true;
		int i = 1;

		while (i < matriz.length && bandera) {

			if (sumaParcial != matriz[i][i]) {
				bandera = false;
			}
			sumaParcial += matriz[i][i];
			i++;
		}
		
		return bandera;
	}

	public static void main(String[] args) {
//		int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; 
		int[][] matriz = { { 1, 2, 3 }, { 4, 1, 6 }, { 7, 8, 2 } }; 
		
		Ejercicio00 eje = new Ejercicio00();
		System.out.println(eje.comprobar(matriz));

	}
}
