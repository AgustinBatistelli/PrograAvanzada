package main.java.ejercicios;

/*
 * Escribir un método en Java que de una matriz numérica dada, devuelva una matriz con la misma cantidad de elementos,
 *  pero donde cada valor es la suma de sus adyacentes originales (arriba, abajo, izquierda, y derecha; si existen)
 * 
 * Ejemplo: Para la matriz 				
 * 8  2 -3  4
 	5 -6 -6 20
	21  1 -5  0
La salida debe ser
15  1  -3 21
28 -4   0 18
27 11 -10 15

	*/

public class Ejercicio02 {

	public int[][] sumAdyacentes(int[][] matriz) {

		int fil = matriz.length;
		int col = matriz[0].length;
		int[][] matResu = new int[fil][col]; // matriz resultado
		int sumador = 0;

		for (int i = 0; i < fil; i++) {
			for (int j = 0; j < col; j++) {

				if (i - 1 >= 0)
					sumador += matriz[i - 1][j];
				if (j - 1 >= 0)
					sumador += matriz[i][j - 1];
				if (i + 1 < fil)
					sumador += matriz[i + 1][j];
				if (j + 1 < col)
					sumador += matriz[i][j + 1];

				matResu[i][j] = sumador + matriz[i][j];
				sumador = 0;
			}

		}
		return matResu;
	}

	public void mostrarMatriz(int[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println('\n');
		}

	}

	public static void main(String[] args) {

		Ejercicio02 eje = new Ejercicio02();

		int[][] matPrueba = { { 8, 2, -3, 4 }, { 5, -6, -6, 20 }, { 21, 1, -5, 0 } };
//		eje.mostrarMatriz(matPrueba);

		eje.mostrarMatriz(eje.sumAdyacentes(matPrueba));
	}

}
