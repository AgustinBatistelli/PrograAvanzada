package mesadas_granito;

public class OIA {
	
	private Deposito nv;

	public static void main(String[] args) throws Exception {

		OIA ejercicio = new OIA();
		
		try {
			
			ejercicio.leerArchivo("mesadas.in");
			int cantPilasMin = ejercicio.resolver();
			ejercicio.escribirArchivo("mesadas.out", cantPilasMin);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	private int resolver() {
		return nv.resolver();
	}

	private void leerArchivo(String path) throws Exception {
		nv = GestorArchivo.leerArchivo(path);
	}

	private void escribirArchivo(String path, int cantPilasMin) throws Exception {
		GestorArchivo.escribirArchivo(path, cantPilasMin);
	}

}
