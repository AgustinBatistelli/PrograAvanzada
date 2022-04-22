package bombilla;

public class Main {

	// Cual es la bombilla con mayor potencia?

	public static void main(String[] args) {

		Casa casa = new Casa("Casa de Facu");

		Habitacion habit1 = new Habitacion("habit1");
		Habitacion habit2 = new Habitacion("habit2");
		Habitacion habit3 = new Habitacion("habit3");

		Bombilla bomb1 = new Bombilla(100);
		Bombilla bomb2 = new Bombilla(150);
		Bombilla bomb3 = new Bombilla(200);
		Bombilla bomb4 = new Bombilla(250);
		Bombilla bomb5 = new Bombilla(75);
		Bombilla bomb6 = new Bombilla(25);

		habit1.agregarBombilla(bomb1);
		habit1.agregarBombilla(bomb2);
		habit1.agregarBombilla(bomb3);
		
		habit2.agregarBombilla(bomb3);
		habit2.agregarBombilla(bomb4);
		habit2.agregarBombilla(bomb5);
		
		habit3.agregarBombilla(bomb6);
		
		casa.agregarHabitacion(habit1);
		casa.agregarHabitacion(habit2);
		casa.agregarHabitacion(habit3);
		
		System.out.println(casa.bombillaMayorGasto().getPotencia());

		System.out.println(habit1.getLamparaMasPotente().getPotencia());

	}

}
