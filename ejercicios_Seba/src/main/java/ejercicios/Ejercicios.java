package main.java.ejercicios;

import java.util.Arrays;

public class Ejercicios {

	public static void main(String[] args) {

		Ejercicios ej = new Ejercicios();
//		System.out.println(ej.diagonalPrincipalValorIgualQueEnPosicion());
//		System.out.println(ej.multiplicacionMatrizEsCero());
//		ej.sumaAdyacentes();
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

	public void anagramas() {
		String[] words = new String[] { "cat", "baby", "dog", "bird", "car", "ax"};
		String string1 = "tcabnihjs";
		String string2 = "tbcanihjs";
		String string3 = "baykkjl";
		String string4 = "bbabylkkj";
		String string5 = "ccc";
		String string6 = "breadmaking";

		String s1 = find_embedded_word(words, string1);
		String s2 = find_embedded_word(words, string2);
		String s3 = find_embedded_word(words, string3);
		String s4 = find_embedded_word(words, string4);
		String s5 = find_embedded_word(words, string5);
		String s6 = find_embedded_word(words, string6);

		System.out.println("El resultado 1 es: " + s1);
		System.out.println("El resultado 2 es: " + s2);
		System.out.println("El resultado 3 es: " + s3);
		System.out.println("El resultado 4 es: " + s4);
		System.out.println("El resultado 5 es: " + s5);
		System.out.println("El resultado 6 es: " + s6);
	}

	public String find_embedded_word(String[] words, String s) {
		String embedded = "";

		for(String eachWord : words) {
			String copyOfEachWord = eachWord.replaceAll("\\s", "");
			String copyOfs2 = s.replaceAll("\\s", "");
			boolean status = true;

			if(copyOfEachWord.length() != copyOfs2.length())
				status = false;
			else
			{
				char[] s1Array = copyOfEachWord.toLowerCase().toCharArray();

				char[] s2Array = copyOfs2.toLowerCase().toCharArray();

				Arrays.sort(s1Array);

				Arrays.sort(s2Array);

				status = Arrays.equals(s1Array, s2Array);
			}

			if(!status)
				embedded = null;
			else {
				embedded = eachWord;
				return embedded;
			}

		}

		return embedded;
	}

	public boolean diagonalPrincipalValorIgualQueEnPosicion() {

		int[][] matriz = { {1,0,0,0},{0,1,0,0},{0,0,2,0},{0,0,0,4}};

		int res = matriz[0][0];

		boolean bandera = true;

		for(int i=1 ; i < matriz.length && bandera ; i++)
		{		
			if(res != matriz[i][i]) {
				System.out.print("No coincide");
				bandera = false;
			}

			res += matriz[i][i];

		}

		System.out.print("Coincide");
		return bandera;

	}

	public boolean multiplicacionMatrizEsCero() {

		int[][] matriz = {{2,2,1},{2,2,2},{3,1,1}};

		boolean bandera = false;

		for(int fil=0 ; fil < matriz.length; fil++)
		{	
			for(int col=0 ; col < matriz[fil].length  && !bandera; col++)
			{
				if(matriz[fil][col] == 0)
				{
					System.out.print("El resultado es 0");
					bandera = true;
				}
			}
		}

		return bandera;
	}

	public boolean esMatrizCuadrada(int[][] matriz) {

		boolean bandera = true;
		
		for (int i = 0, l = matriz.length; i < l && bandera; i++) {
			if (matriz[i].length != l) {
				bandera = false;
			}
		}

		return true;

	}

}
