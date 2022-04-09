package ejercicioCirculo;

public class Punto {
	private double x, y;

	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Punto() {
		this(0, 0);
	}
	
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
	
	public double distanciaEntre(Punto punto2) {
		return Math.sqrt(Math.pow(x - punto2.x, 2)+ Math.pow(y - punto2.y, 2));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	
}
