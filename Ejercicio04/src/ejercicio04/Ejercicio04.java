package ejercicio04;

public class Ejercicio04 {
	
	public static void main(String[] args) {

		Ejercicio04 ej = new Ejercicio04();
		ej.obtenerDiagonalesDeMatrizCuadrada();
	}
	
	public void obtenerDiagonalesDeMatrizCuadrada() {

		int mat[][] = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}, 
				{13, 14, 15, 16} };

		int i, j, k, dimension = mat.length;

		for(i = dimension - 1; i >= 0 ; i--) {
			
			for(j = 0; j <= dimension - i - 1 ; j++){
				
				System.out.print(mat[i + j][j] + " ");
			}
			
			System.out.print("\n");
		}

		for(i = 0; i < dimension - 1; i++){
			
			k = 0;
			
			for(j = i + 1; j < dimension; j++){
				
				System.out.print(mat[k][j] + " ");
				k++;
			}
			
			System.out.print("\n");
		}
	}

}
