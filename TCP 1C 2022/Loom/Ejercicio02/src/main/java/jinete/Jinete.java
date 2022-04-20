package jinete;

public class Jinete {
	
	private final static int MILLAS_MAX = 100;
	private int millas;
	private int millasRestantes;
	private static int cantJinetes = 1;
	
	public Jinete() {
		this.millas = MILLAS_MAX;
		this.millasRestantes = 0;
	}
	

	/**
	 * @param estaciones es la distancia en millas de una estación hasta la otra
	 * @returns la cantidad de jinetes necesarios para enviar el correo desde un
	 * extremo hasta el otro del recorrido
	 */
	public static int jinetes(int[] estaciones) { //18 15
		
		int size = estaciones.length;
		int millasRestantes = MILLAS_MAX;
		Jinete j = new Jinete();
		
		for(int i = 0; i < size && millasRestantes == MILLAS_MAX; i++) {
			
			millasRestantes = MILLAS_MAX - estaciones[i];
		
			for(int z = i+1; z < size; z++) {
				
				if(millasRestantes <= 0) {
					
					j = new Jinete();
					j.millas += millasRestantes; //viene en negativo por eso se suma
					millasRestantes = j.millas;
					cantJinetes++;
				}
				
				millasRestantes -= estaciones[z];
				j.millasRestantes = millasRestantes;
			}
			
//			while(millasRestantes > 0) {
//				
//				for(int k = i + 1; k < size; k++) {
//					millasRestantes -= estaciones[k];
//				}
//					
//			}
		}
		
		if(millasRestantes <= 0) {
			j = new Jinete();
			j.millas += millasRestantes; //viene en negativo por eso se suma
			millasRestantes = j.millas;
			cantJinetes++;
		}
		
		return cantJinetes;
	}
	
}
