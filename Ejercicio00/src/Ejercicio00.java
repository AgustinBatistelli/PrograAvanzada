public class Ejercicio00 {
	public boolean  checkeoMatriz (int[][] matriz){
		int sumaDiagonal = matriz[0][0];
		boolean bandera = true;
		int i = 1;
		while (i < matriz.length && bandera){
			if ( sumaDiagonal != matriz[i][i] ){
				bandera = false;
			}

			sumaDiagonal += matriz[i][i];
			i++;
		}
		return bandera;
	}
	

	public static void main(String[] args){
		int[][] m = {
						{1,2,3},
						{4,1,6},
						{7,8,2}
						};
		
		Ejercicio00 ejer = new Ejercicio00();
		System.out.println(ejer.checkeoMatriz(m));
			
	}
}
	