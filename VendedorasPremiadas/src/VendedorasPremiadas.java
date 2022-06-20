
public class VendedorasPremiadas {
	
	public void inicializarArray(int array[]) {
		int i;
		
		for(i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}
	
	public boolean esArrayNulo(int[] array) {
		int i = 0;
		boolean flagNulo = true;
		
		while(i < array.length && flagNulo) {
			if(array[i] != 0) {
				flagNulo = false;
			}
		}
		
		return flagNulo;
		
	}
	
	public boolean hayUnSoloMaximo(int[] array) {
		int i,
			cantidadMax = 1,
			max = array[0];
		
		for(i = 1; i < array.length; i++) {
			if(array[i] == max) {
				cantidadMax++;
			}
			if(array[i] > max) {
				max = array[i];
				cantidadMax = 1;
			}
		}
		
		return cantidadMax == 1;
	}
	
	public void obtenerGanadora(int[] arrayDatos) {
		
		int cantidadVendedoras = arrayDatos[0],
			cantidadVentas,
			N = arrayDatos[arrayDatos.length - 1],
			i,
			j,
			nroRenglon; ///arranca en 0 y es como el indice de un array
		
		int[] arrayContadorVentas = new int [cantidadVendedoras];
			
		
		do {
			inicializarArray(arrayContadorVentas);
			nroRenglon = 1;
			for(i = 0; i < cantidadVendedoras; i++) {
				cantidadVentas = arrayDatos[nroRenglon];
				nroRenglon++;
				if(cantidadVentas >= N) {
					for(j = 0; j < cantidadVentas; j++) {
						arrayContadorVentas[i] += arrayDatos[nroRenglon];
						nroRenglon++;
					}				
				}
				else {
					nroRenglon += cantidadVentas;
				}
			}
			N++;
		} while(!hayUnSoloMaximo(arrayContadorVentas) && !esArrayNulo(arrayContadorVentas));
		
		if(!esArrayNulo(arrayContadorVentas)) {
			System.out.println("hay ganadores");
		}
		else {
			System.out.println("empate");
		}
		
	}
	
	public static void main(String[] args) {
		int[] arrayTest = {3,3,20,44,10,4,5,7,46,18,5,10,24,40,10,5,2};
		
		VendedorasPremiadas ejercicio = new VendedorasPremiadas();
		ejercicio.obtenerGanadora(arrayTest);
	}
}
