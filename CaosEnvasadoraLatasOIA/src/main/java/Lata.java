
public class Lata {
	private String tipo;
	
	public Lata(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	
	
}
