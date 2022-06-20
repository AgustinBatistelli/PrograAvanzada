package testCollections;

public class Persona 
implements Comparable<Persona>
{
	private double altura, peso;

	public Persona (double altura, double peso) {
		this.peso = peso;
		this.altura = altura;
	}
	
	public int compareTo(Persona p) {
		// TODO Auto-generated method stub
		return (int) (altura - p.altura);
	}

	@Override
	public String toString() {
		return "Persona [altura=" + altura + ", peso=" + peso + "]";
	}
	
	public double getAltura() {
		return altura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(altura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (Double.doubleToLongBits(altura) != Double.doubleToLongBits(other.altura))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		return true;
	}
	
}


