
public class MainTest {
	public static void main(String[] args) {
		
		Tanque t1 = new Tanque();
		Tanque t2 = new Tanque();
		
		
		
		System.out.println("Tanque 1: " + t1.toString());
		System.out.println("Tanque 2: " + t2.toString());
		
		System.out.println("Comienza la batalla");
		
		t1.atacar(t2);
		
		System.out.println("Tanque 1: " + t1.toString());
		System.out.println("Tanque 2: " + t2.toString());
		
		
		t1.cambiarModo(new ModoDefensa());
		t1.atacar(t2);
		
		System.out.println("Tanque 1: " + t1.toString());
		System.out.println("Tanque 2: " + t2.toString());
		
		
		t2.cambiarModo(new ModoDefensa());
		t1.atacar(t2);
		
		System.out.println("Tanque 1: " + t1.toString());
		System.out.println("Tanque 2: " + t2.toString());
	}
	
}
