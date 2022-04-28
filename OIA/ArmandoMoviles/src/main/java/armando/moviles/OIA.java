package armando.moviles;

public class OIA {
	
	private Artesano artesano;

	public static void main(String[] args) {
		OIA oia = new OIA();
		
		try {
			
			oia.leerArchivo("colgantes.in");
			oia.resolver();
			oia.esribirArchivo("colgantes.out");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	private void leerArchivo(String path) throws Exception {
		artesano = GestorArchivos.leerArchivo(path);
	}

	private void resolver() {
		artesano.resolver();
	}
	
	private void esribirArchivo(String path) throws Exception {
		GestorArchivos.escribirArchivo(path, this.artesano.getResultado());
	}
	
}
