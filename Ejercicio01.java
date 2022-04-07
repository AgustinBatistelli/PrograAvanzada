package main.java.ejercicios;

//	Escribir un método en Java que permita comprobar si la multiplicación de todos los 
//  valores de una matriz numérica, dará 0 o no

public class Ejercicio01 {

	public double productoElemMatriz(int[][] matriz) {

		int fil = matriz.length; // cant filas
		int col = matriz[0].length; // cant elem x fila
		double resultado = 1;

		for (int i = 0; i < fil; i++) {
			for (int j = 0; j < col; j++) {
				resultado *= matriz[i][j];
			}
		}

		return resultado;
	}

	public static void main(String[] args) {

		Ejercicio01 eje = new Ejercicio01();
		int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0, } };
//		int[][] matriz = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 1, 8 }, { 9, 10 } };
		double resu = eje.productoElemMatriz(matriz);

		System.out.println("Producto de los elementos de la matriz es " + resu + (resu == 0 ? " (cero) " : " (distinto de cero) "));
	}
}
