
public class Ejercicio03 {
	
	/* 
	 * La idea es recorrer todos los elementos de una fila de la matriz e ir acumulando
	 * la cantidad de apariciones en un array contador.
	 * Luego, ese array contador es utilizado para obtener la moda de la fila, y almacenarla
	 * en el array de resultado llamado "arrayModas"
	 * 
	 * */
	
	public int posicionElementoArray(int[] array, int elemento) {
		int i = 0,
			pos = -1;
		
		while(i < array.length && pos == -1) {
			if(array[i] == elemento) {
				pos = i;
			}
			i++;
		}
		return pos;
	}
	
	public int obtenerModaDelArray(int[] arrayContador, int[] arrayValores) {
		int i,
			maxValorModa = arrayValores[0],
			maxApariciones = arrayContador[0];
		
		for(i = 1; i < arrayContador.length; i++) {
			if(arrayContador[i] == maxApariciones && arrayValores[i] > maxValorModa) {
				maxValorModa = arrayValores[i];
			}
			
			if(arrayContador[i] > maxApariciones) {
				maxApariciones = arrayContador[i];	
				maxValorModa = arrayValores[i];
			}			
		}
		return maxValorModa;
	}
	
	public void inicializarArray(int array[]) {
		int i;
		
		for(i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}
	
	public int[] obtenerArrayModas(int matriz[][]) {
		int[] arrayContador = new int[matriz[0].length];
		int[] arrayModas = new int[matriz.length];
		
		int i,
			j,
			pos;
		
		for(i = 0; i < matriz.length; i++) {
			inicializarArray(arrayContador);
			for(j = 0; j < matriz[0].length; j++) {
				pos = posicionElementoArray(matriz[i], matriz[i][j]);
				
				arrayContador[pos]++;
			}
			arrayModas[i] = obtenerModaDelArray(arrayContador, matriz[i]);
		}

		return arrayModas;
	}
	
	
	
	public static void main(String[] args) {
		int[][] matrizTest = {
				{1, 2, 3, 4},
				{5,-6,-6, 20},
				{1, 1, 10, 10}
		};
		
		Ejercicio03 ejercicio = new Ejercicio03();
		int[] arrayRes = ejercicio.obtenerArrayModas(matrizTest);
		
		for(int i = 0; i < arrayRes.length; i++) {
			System.out.println(arrayRes[i]);
		}
	}
}
