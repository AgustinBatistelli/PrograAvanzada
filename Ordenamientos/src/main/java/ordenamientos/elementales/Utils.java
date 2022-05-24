package ordenamientos.elementales;

import java.util.Random;

public class Utils {

	public static void imprimirArray(Integer[] list) {
		for(Integer elem : list) {
			System.out.print(elem + " ");
		}
	}
	
	public static Integer[] inicializarArray(Integer[] list) {
		Random rn = new Random();
		for(int i = 0; i < 10; i++) {
			list[i] = rn.nextInt(10 - 0 + 1) + 0;
		}
		return list;
	}
	
}
