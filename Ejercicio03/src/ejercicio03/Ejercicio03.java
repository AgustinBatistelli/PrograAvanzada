package ejercicio03;

public class Ejercicio03 {
	
	public static void main (String[] args) {
		Ejercicio03 ej = new Ejercicio03();
		ej.modasMatriz();
	}

	public void modasMatriz() {

		int mat[][] = {
				{1, 2, 3, 4},
				{5, -6, -6, 20},
				{1, 1, 10, 10} };

		int vecSolucion[] = new int [mat.length];

		int contadorMax=0;

		int numeroMax=0;

		int contador=0;

		int numero=0;

		for(int i = 0; i < mat.length; i++) {

			for(int j = 0; j < mat[i].length; j++) {

				numero = mat[i][j];

				for(int k = 0; k < mat[i].length; k++) { //recorrer la fila

					if(mat[i][k] == numero)
						contador++; //cuenta si el numero esta 1 o mas veces

				}


				if(contadorMax < contador || (contadorMax == contador && numero > numeroMax)) { //condicion para guardar el numero maximo en todos los casos
					numeroMax = numero;
					contadorMax = contador;
				}

				contador = 0; //cuando paso al otro numero, reseteo valores
				numero = 0;

			}

			vecSolucion[i] = numeroMax;
			numeroMax = 0;
			contadorMax = 0;
		}

		imprimirVector(vecSolucion);
	}
	
	public void imprimirVector(int[] vecSolucion) {
		for(int i = 0; i < vecSolucion.length; i++) {
			System.out.print(vecSolucion[i]);
			System.out.print("|");
		}
	}
	
}
