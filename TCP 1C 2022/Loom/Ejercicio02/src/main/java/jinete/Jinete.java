package jinete;

public class Jinete {
	
	private final static int MILLAS_MAX = 100;
	
	/**
	 * @param estaciones es la distancia en millas de una estación hasta la otra
	 * @returns la cantidad de jinetes necesarios para enviar el correo desde un
	 * extremo hasta el otro del recorrido
	 */
	public static int jinetes(int[] estaciones) { //18 15
		
		int sumaMillas = 0;
		int cantJinetes = 0;
		
		for(int i = 0; i < estaciones.length; i++) {
			
			if( (sumaMillas + estaciones[i]) <= MILLAS_MAX )
				sumaMillas += estaciones[i];
			else if (estaciones[i] > MILLAS_MAX)
				return 0;
			else {
				cantJinetes++;
				sumaMillas = estaciones[i];
			}
		}
		
		cantJinetes++;
		return cantJinetes;
	}
	
}
