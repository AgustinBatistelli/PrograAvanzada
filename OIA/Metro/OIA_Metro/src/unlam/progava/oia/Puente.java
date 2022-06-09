package unlam.progava.oia;

public class Puente {
	
	private int idPuente;
	private int origen;
	private int destino;
	
	public Puente(int id, int origen, int destino) {
		this.idPuente = id;
		this.origen = origen;
		this.destino = destino;
	}

	public int getIdPuente() {
		return idPuente;
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}

}
