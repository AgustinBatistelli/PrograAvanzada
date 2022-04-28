package mesadas_granito;

public class OIA {
	
	private NegocioVenta nv;

	public static void main(String[] args) throws Exception {

		OIA ejercicio = new OIA();
		
		try {
			
			ejercicio.leerArchivo("mesadas.in");
			ejercicio.resolver();
			ejercicio.escribirArchivo("mesadas.out");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	private void resolver() {
		nv.resolver();
	}

	private void leerArchivo(String path) throws Exception {
		nv = GestorArchivo.leerArchivo(path);
	}

	private void escribirArchivo(String path) throws Exception {
		GestorArchivo.escribirArchivo(path, this.nv.getResultado());
	}

}
