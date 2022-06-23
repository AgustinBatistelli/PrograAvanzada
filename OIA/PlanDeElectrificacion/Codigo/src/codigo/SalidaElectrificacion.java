package codigo;

import java.util.List;

public class SalidaElectrificacion {
	private int costo;
	private List<Arista> tendidos;
	
	public SalidaElectrificacion(int costo, List<Arista> tendidos) {
		this.costo = costo;
		this.tendidos = tendidos;
	}

	public int getCosto() {
		return costo;
	}

	public List<Arista> getTendidos() {
		return tendidos;
	}
	
	
	
}
