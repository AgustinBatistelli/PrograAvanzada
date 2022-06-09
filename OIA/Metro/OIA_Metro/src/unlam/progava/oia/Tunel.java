package unlam.progava.oia;

public class Tunel {
	
	private int idTunel;
	private int origen;
	private int destino;
	
	public Tunel(int id, int origen, int destino) {
		this.idTunel = id;
		this.origen = origen;
		this.destino = destino;
	}

	public int getIdTunel() {
		return idTunel;
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}
	
	

}
