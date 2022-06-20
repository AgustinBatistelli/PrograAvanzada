
public class Jinetes {
	
	public static int jinetes(int[] estaciones) {
		
		if(estaciones.length == 0) {
			return 0;
		}
		
		int millasAcumuladas = 0;
		int cantJinetesNecesarios = 1;
		
		for(int i = 0; i < estaciones.length; i++) {
			if(millasAcumuladas + estaciones[i] > 100) {
				cantJinetesNecesarios++;
				millasAcumuladas = 0;
			}
			millasAcumuladas += estaciones[i];
		}
		
		return cantJinetesNecesarios;
	}
}
