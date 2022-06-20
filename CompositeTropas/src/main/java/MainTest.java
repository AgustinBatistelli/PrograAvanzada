
public class MainTest {
	public static void main(String[] args) {
		Tropa uno = new Tropa();
		uno.agregar(new Guerrero());
		uno.agregar(new Guerrero());
		uno.agregar(new Guerrero());
		
		Tropa dos = new Tropa();
		dos.agregar(new Guerrero());
		dos.agregar(new Guerrero());
		dos.agregar(new Guerrero());
		
		Tropa dosA = new Tropa();
		dosA.agregar(new Guerrero());
		dosA.agregar(new Guerrero());
		
		dos.agregar(dosA);
		
		for (int i = 0; i < 17; i++) {
			uno.atacar(dos);
		}
		System.out.println("Tropa 1 ");
		System.out.println(uno);
		
		System.out.println("Tropa 2");
		System.out.println(dos);
	}
}
