
public class Ejercicio01 {
	
	/*
	 * Explicacion: Voy recorriendo cada elemento de la matriz. Si encuentro un cero,
	 * entonces activo una bandera de matriz nula y dejo de recorrer la matriz.
	 * 
	 */
	
	public boolean esMatrizNula(int[][] matriz) {
		int i = 0,
			j,
			filas = matriz.length,
			columnas = matriz[0].length;
		boolean flagCero = false;
		
		while(i < filas && !flagCero) {
			j = 0;
			while(j < columnas && !flagCero) {
				if(matriz[i][j] == 0) {
					flagCero = true;
				}
				j++;
			}
			i++;	
		}
		
		return flagCero;
	}
	
	public static void main(String[] args) {
		int[][] matrizEjemplo = {
				{0,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		Ejercicio01 ejercicio = new Ejercicio01();

		if(ejercicio.esMatrizNula(matrizEjemplo)) {
			System.out.println("La matriz es nula, porque contiene al menos un cero.");
		}
		else {
			System.out.println("La matriz NO es nula, porque NO contiene ceros");
		}
		
	}
}
