package punto;

import java.util.Objects;

public class Punto2D {
	
	private double x;
	private double y;
	
	public Punto2D(double _x, double _y) {
		this.x = _x; //No es necesario usar this porque se llaman diferente con los parametros
		this.y = _y;
		
	}
	
	public Punto2D() {
//		x = 0;
//		y = 0;
		this(0,0);
	}

	@Override
	public String toString() {
		return "Punto2D [x=" + x + ", y=" + y + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto2D other = (Punto2D) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	
	public void desplazar(double _x, double _y) {
		x += _x;
		y += _y;
	}

	public Punto2D suma(Punto2D p2) {
		return new Punto2D(this.x + p2.x, this.y + p2.y);
	}
	
}
