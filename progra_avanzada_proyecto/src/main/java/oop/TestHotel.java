package main.java.oop;

public class TestHotel {

	public static void main(String[] args) {
		Hotel hotel1 = new Hotel(12);
		
		hotel1.ocuparHabitacionCon(2,2);
		hotel1.ocuparHabitacionCon(2,0);
		hotel1.ocuparHabitacionCon(4,4);
		hotel1.ocuparHabitacionCon(4,0);
		hotel1.ocuparHabitacionCon(2,1);
		
		System.out.println("Cantidad de personas en el hotel: " + hotel1.getCantPersEnHotel());
		System.out.println("Cantidad de habitaciones con 2 mayores: " + hotel1.contarHabitacionesCon(2));
		
	}

}
