
public class Ejercicio01 {
	// Escribir un m�todo en Java que permita comprobar si la multiplicaci�n de todos los valores de una matriz num�rica, dar� 0 o no
	
	public boolean tieneCero(int[][] matriz) {
		boolean bandera = false;
		for( int i = 0; i < matriz.length; i++){
			for( int j = 0; j < matriz.length && !bandera; j++){
				if (matriz[i][j] == 0) {
					bandera = true;
				}
			}
		}
		
		return bandera;
	}
	
	public static void main (String[] args) {
		int [][] matriz = {{1, 2, 3}, {1, 2, 3}, {0, 2, 3}};
		
		Ejercicio01 ejer = new Ejercicio01();
		System.out.println(ejer.tieneCero(matriz));
	}
	
}
