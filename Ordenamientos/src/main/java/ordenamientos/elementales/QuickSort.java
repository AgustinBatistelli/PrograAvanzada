package ordenamientos.elementales;

public class QuickSort {
	
	public static void main(String[] args) {

		Integer[] array = new Integer[10];

		array = Utils.inicializarArray(array);

		ordenar(array, 0, array.length - 1);

		Utils.imprimirArray(array);
	}
	
	static void ordenar(Integer arr[], int min, int max)
    {
        if (min < max)
        {
        	int pi = particion(arr, min, max);
 
            ordenar(arr, min, pi-1);
            ordenar(arr, pi+1, max);
        }
    }

	private static int particion(Integer[] arr, int min, int max) {
		
		int pivot = arr[max];
        int i = (min - 1); //indice del menor elemento
        for (int j = min; j < max; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
  
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
  
        int temp = arr[i+1];
        arr[i+1] = arr[max];
        arr[max] = temp;
  
        return i+1;
	}

}
