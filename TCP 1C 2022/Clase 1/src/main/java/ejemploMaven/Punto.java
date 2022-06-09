package ejemploMaven;

public class Punto {

	private double x, y;
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static void main(String[] args) {
		Punto p = new Punto(1,1);
		System.out.println(p.getModulo());
	}

	public double getModulo() {
		return Math.hypot(x, y);
	}
}
