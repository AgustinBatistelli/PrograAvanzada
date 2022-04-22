package bombilla;

import java.util.ArrayList;

public class Casa {
	private ArrayList<Habitacion> arrayHabitaciones = new ArrayList<Habitacion>();
	private String nombre;
	
	public Casa(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarHabitacion(Habitacion habit) {
		arrayHabitaciones.add(habit);
	}
	
//	public void recorrerHabitacion() {
//		
//	}
	
	public Bombilla bombillaMayorGasto() {
		Bombilla bombillaGasto = new Bombilla(0);
		
		for (Habitacion h: arrayHabitaciones) {
			bombillaGasto = bombillaGasto.compararBombilla(h.getLamparaMasPotente());
		}
		return bombillaGasto;
	}
	
}