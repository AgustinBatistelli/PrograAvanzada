package ordenamientos.elementales;

public class ShellSort {
	
	public static void main(String[] args) {

		Integer[] array = new Integer[10];

		array = Utils.inicializarArray(array);

		ordenar(array);

		Utils.imprimirArray(array);
	}
	
	static void ordenar(Integer arr[])
    {
        int n = arr.length;
  
        for (int gap = n / 2; gap > 0; gap /= 2) {
            
            for (int i = gap; i < n; i += 1) {
                
                int temp = arr[i];
  
                int j;
                
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
  
                arr[j] = temp;
            }
        }
    }

}
