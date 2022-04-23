package LuchadoresJaponeses;

public class Main {

	public static void main(String[] args) {

		int[] dominados = GestionArchivos.crearTorneo("./ArchivosIN/sumo.in");
		
		GestionArchivos.escribirSalida("./ArchivosOUT/sumo.out", dominados);

	}

}
