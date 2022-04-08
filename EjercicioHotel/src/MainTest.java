
public class MainTest {
	public static void main(String[] args) {
		Hotel h1 = new Hotel(5);
		Hotel h2 = new Hotel(20);
		h1.ocuparHabitacionCon(5, 0);
		h1.ocuparHabitacionCon(1, 2);
		h1.ocuparHabitacionCon(5, 2);
		h1.ocuparHabitacionCon(5, 2);
		
		
		System.out.println(h1);
		System.out.println(h1.cantPersonas());
		System.out.println(h1.contarHabitacionesCon(2));
		System.out.println(h1.equals(h2));
		
		
	}
}
