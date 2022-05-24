package ordenamientos.elementales;

public class Seleccion {

	public static void main(String[] args) {

		Integer[] array = new Integer[10];

		array = Utils.inicializarArray(array);

		for(int i = 0; i < array.length - 1; i++) {

			int min = i;

			for(int j = i+1; j < array.length; j++) {
				if(array [j] < array[min])
					min = j;
			}

			Integer aux = array[min];
			array[min] = array[i];
			array[i] = aux;

		}

		Utils.imprimirArray(array);
	}
}
