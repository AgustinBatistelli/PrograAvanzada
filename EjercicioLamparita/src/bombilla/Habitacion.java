package bombilla;

import java.util.ArrayList;

public class Habitacion {

	private ArrayList<Bombilla> arrayBombillas = new ArrayList<Bombilla>();
	private String nombreHabit;
	
	public Habitacion(String nombre) {
		nombreHabit = nombre;
	}
	
	public String getNombreHabit() {
		return nombreHabit;
	}

	public void agregarBombilla(Bombilla bombilla){
		arrayBombillas.add(bombilla);
	}
	
	public Bombilla getLamparaMasPotente() {
		
		Bombilla bombillaMayGasto = new Bombilla(0);
		
		for( Bombilla bomb: arrayBombillas){
			bombillaMayGasto = bombillaMayGasto.compararBombilla(bomb);
		}
		
		return bombillaMayGasto;
	}
	
}