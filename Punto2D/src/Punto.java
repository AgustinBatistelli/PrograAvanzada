import java.util.Objects;

//Por defecto me hace un constructor implicitamente e inicializa los datos

public class Punto {
	private double x;
	private double y;
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Punto() {
//		this.x = 0;
//		this.y = 0;
		this(0, 0); //otra forma de hacerlo, invocando al constructor parametrizado pero en 0
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	
	
	//equals tambien es una sobrecarga
	public Punto suma(Punto puntoSuma) {
		Punto puntoNuevo = new Punto(x + puntoSuma.x, y + puntoSuma.y);
		return puntoNuevo;
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
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
	
	
}

//Todos los objetos en Java herendan de la clase Object
//Por eso al printear un objecto de una se invoca a un metodo de Object que muestra la dir. de memoria
