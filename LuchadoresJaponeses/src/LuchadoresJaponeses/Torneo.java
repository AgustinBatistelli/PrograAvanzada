package LuchadoresJaponeses;


public class Torneo {
	private int[] dominados;
	private Luchador[] luchadores;
	private int cantLuchadores;
	
	public Torneo(int cantidadDeLuchadores){
		luchadores = new Luchador[cantidadDeLuchadores];
		dominados = new int[cantidadDeLuchadores];
		cantLuchadores = 0;		
		for(int i = 0; i < cantidadDeLuchadores; i++) {
			dominados[i] = 0;
		}
	}
	
	public void agregarLuchador(Luchador luchador) {
		luchadores[cantLuchadores] = luchador;
		cantLuchadores++;
	}
	
	
	public int[] calcularDuelos() {
		int hayVictoria;
		
		for(int i = 0; i < luchadores.length; i++) {
			for(int j = i + 1; j < luchadores.length; j++) {
				hayVictoria = luchadores[i].dominar(luchadores[j]); 
				if(hayVictoria > 0)
					dominados[i]++;
				else 
					if (hayVictoria < 0 ) 
						dominados[j]++;
			}
		}
		return dominados;
	}
}
