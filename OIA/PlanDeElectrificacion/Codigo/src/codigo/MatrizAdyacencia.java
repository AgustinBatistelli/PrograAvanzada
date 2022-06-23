package codigo;

public class MatrizAdyacencia {

	private int[][] matriz;

	public MatrizAdyacencia(int cantDeNodos) {
		this.matriz = new int[cantDeNodos][];

		//Matriz simetrica para grafo no dirigido, solo necesito el
		//triangulo inferior
		for (int i = 0; i < cantDeNodos; i++) {
			this.matriz[i] = new int[i];
		}
	}
	
	public void setPeso(int nodoI, int nodoJ, int peso){
		if(nodoI == nodoJ){
			return;
		}
				
		this.matriz[nodoI][nodoJ] = peso;
	}
	
	public int getPeso(int nodoI, int nodoJ){
		
		if(nodoJ>nodoI)
			return this.matriz[nodoJ][nodoI];
		
		return this.matriz[nodoI][nodoJ];
	}

}
