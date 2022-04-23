package ponyExpress;

/*
* Cómo funcionaba:
* Habia una cierta cantidad de estaciones, donde el jinete cambiaba su caballo por uno fresco,
* o se le pasaba la bolsa de correo al próximo jinete.
* El problema
* Se te pide ayuda para implementar el siguiente método:
* Nota: Cada jinete viaja tan lejos como puede, pero nunca lo hace más de 100 millas seguidas
*/

public class Jinete {
	
	/**
	 * @param estaciones es la distancia en millas de una estación hasta la otra
	 * @returns la cantidad de jinetes necesarios para enviar el correo desde un
	 *          extremo hasta el otro del recorrido
	 * Logica: primero me fijo si puedo llegar a la siguiente estacion con el jinete actual.
	 * 		   si puego entonces utilizo esa cantidad de jinetes, sino necesito uno mas.
	 */
	public static int jinetes(int[] estaciones) {

		int contadorJinetes = 1;
		int acumuladorMillas = estaciones[0];

		for (int i = 1; i < estaciones.length; i++) {

			if ((acumuladorMillas + estaciones[i]) > 100) {
				contadorJinetes++;
				acumuladorMillas = estaciones[i];
			} else {
				acumuladorMillas += estaciones[i];
			}

		}
		return contadorJinetes;

	}
	
//	public static void main(String[] args) {
//		
//		System.out.println("Cantidad de jinetes necesarios: " + Jinete.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}) );
//		
//	}
	
}
