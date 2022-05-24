package ordenamientos.elementales;

public class Burbujeo {
	
	public static void main(String[] args) {
		
		Integer[] array = new Integer[10];
		
		boolean s = true;
		
		array = Utils.inicializarArray(array);
		
		while(s) {
			s = false;
			
			for(int i = 0; i < array.length - 1; ++i) {
				if(array[i] > array[i + 1]) {
					Integer aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
					s = true;
				}
			}
			
			if(!s)
				break;
		}
		
		Utils.imprimirArray(array);
		
	}
	
}
