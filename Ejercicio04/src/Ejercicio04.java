
public class Ejercicio04 {
	
	public void crearMatrizResultado(int[][] matriz) {
		int i,
			j,
			k,
			dimension = matriz.length;
	
		for(i = dimension - 1; i >= 0 ; i--) {
			for(j = 0; j <= dimension - i - 1 ; j++){
				System.out.print(matriz[i + j][j] + "\t");
			}
			System.out.println("");
		}
		
		for(i = 0; i < dimension - 1; i++){
			k = 0;
			for(j = i + 1; j < dimension; j++){
				System.out.print(matriz[k][j] + "\t");
				k++;
			}
			System.out.println("");
		}
		
	}
	
	public static void main(String[] args) {
		int[][] matrizTest = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
		};
		
		Ejercicio04 ejercicio = new Ejercicio04();
		
		
		ejercicio.crearMatrizResultado(matrizTest);
	}
}
