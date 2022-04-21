import java.util.Objects;

public class Punto {

	private double x;
	private double y;
	
	public Punto() {
		//this.x = 0;
		//this.y = 0;
		this(0,0); // llamo la constructor parametrizado..
	}
	
	public Punto(double _x, double _y) {
		this.x = _x;
		this.y = _y;
	}
	//sobrecargarToStringParaPoderVisualizarCorrectamente
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		//si apuntan al mismo objeto son lo mismo claramente...
		if (this == obj) 
			return true;
		//si el objeto pasado x parametro apunta a la nada misma es falso claramente.
		if (obj == null)  
			return false;
		// tengo que ver si pertenecen a la misma clase...
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	
	
	public void desplazar(double _dx, double _dy) {
		x += _dx;
		y += _dy;
	}
	
	
	public Punto suma(Punto punto) {
		return new Punto(x+punto.x, y+punto.y);
	}
	
	
	
	
	//lo que queda desreferenciado se libera solo, no tengo destructores como en c++
	//Garbage collector.
	
	
	
	
	
	
}
