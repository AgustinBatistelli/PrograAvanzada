package lamparitas;

public class mainTest {
	public static void main(String[] args) {
		
	}
	
	public Lamparita obtenerLamparitaMax(){
		Lamparita lamparitaMax = habitaciones[0].lamparitas[0];
		
		for(int i = 0; i < habitaciones.lenght; i++) {
			for(int j = 0; i < habitaciones[i].lamparitas.lenght; j++) {
				if(habitaciones[i].lamparitas[j].getConsumo() > lamparitaMax.getConsumo()) {
					lamparitaMax = habitaciones[i].lamparitas[j].getConsumo();
					
				}
			}
		}		
		return lamparitaMax;
	}
	
}
