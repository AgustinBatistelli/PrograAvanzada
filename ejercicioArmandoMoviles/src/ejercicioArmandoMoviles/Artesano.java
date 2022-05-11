package ejercicioArmandoMoviles;

import java.util.ArrayList;

public class Artesano {

	private int varillasNecesarias; // cantidad de movilesGenerados.
	private int pesoTotalColgantes;
	
	
	public int crearColgantes(ArrayList<Integer> arrayPesos) {
		
		int sumaPesos = 0;
		int cantPesosAUsar = 0;
		
		for(int i = 0; i < arrayPesos.size(); i++) {
			
			for(int j = i+1; j < arrayPesos.size(); j++) {
				
				if(arrayPesos.get(i).getPeso() == arrayPesos.get(j).getPeso()) {
					sumaPesos += arrayPesos.get(i).getPeso() + arrayPesos.get(j).getPeso();
					cantPesosAUsar++;
				}
					
			}
			
		}
		
		this.resultado = "" + sumaPesos + " " + cantPesosAUsar;
		
	}
	
		
	public int getVarillasNecesarias() {
		return varillasNecesarias;
	}
	public int getPesoTotalColgantes() {
		return pesoTotalColgantes;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
}
