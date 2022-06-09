package ordenamientos.elementales;

public class Insercion {
	
public static void main(String[] args) {
		
		Integer[] array = new Integer[10];
		
		array = Utils.inicializarArray(array);
		
		for (int i = 1; i < array.length; ++i)
        {
            int key = array[i];
            int j = i-1;
  
            while (j >= 0 && array[j] > key)
            {
            	array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
		
		Utils.imprimirArray(array);
		
	}

}
