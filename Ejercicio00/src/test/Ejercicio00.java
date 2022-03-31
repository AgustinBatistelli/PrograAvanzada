package test;

public class Ejercicio00 {
	public boolean comprobar(int[][] matriz){
		int sumaParcial = matriz[0][0];
		boolean bandera = true;
		int i = 1;
		
		while( i < matriz.length && bandera ){
			if(sumaParcial != matriz[i][i]){
				bandera = false;
			}
			sumaParcial += matriz[i][i];
			i++;
		}
		return bandera;
	}
	
	public static void main(String[] args) {
		int [][] matriz = {{1,2,3},{4,1,6},{7,8,2},};
		
		Ejercicio00 ejercicio = new Ejercicio00();
		System.out.println(ejercicio.comprobar(matriz));
			
	}
}
