package ponyExpress;

public class PonyExpress {		
		/**
		 * @param estaciones es la distancia en millas de una estación hasta la otra
		 * @returns la cantidad de jinetes necesarios para enviar el correo desde un
		 * extremo hasta el otro del recorrido
		 */
		static public  int jinetes(int[] estaciones){ 
			int cantidadDeJinetes = 1;
			int totalMillas = 0;
			for (int estacion : estaciones) {	
				if (totalMillas + estacion > 100) {
					cantidadDeJinetes++;
					totalMillas = estacion;
				}else
					totalMillas += estacion;
			}			
			
			return cantidadDeJinetes;
		}
}


