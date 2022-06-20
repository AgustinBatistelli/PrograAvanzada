package testSaludos;

public class ClaseTest {
	private int valor = 81;
	
	
	public void go() {
		incr(++valor);
		System.out.println(valor);
	}
	
	public void incr(int valor) {
		valor += 10;
	}
	
	
	public static void main(String[] args) {
//		new ClaseTest().go();
		
		new C3();
	}
}
