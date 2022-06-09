package ordenamientos.elementales;

public class MergeSort {
	
	public static void main(String[] args) {

		Integer[] array = new Integer[10];

		array = Utils.inicializarArray(array);

		ordenar(array, 0, array.length - 1);

		Utils.imprimirArray(array);
	}
	
	static void ordenar(Integer arr[], int left, int right)
    {
		if (left < right)
        {
            int m = (left + right)/2;
 
            ordenar(arr, left, m);
            ordenar(arr , m+1, right);
 
            merge(arr, left, m, right);
        }
    }
	
	static void merge(Integer arr[], int left, int middle, int right)
    {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[left + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[middle + 1+ j];
 
 
        int i = 0, j = 0;
 
        int k = left;
        
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
