package color;

public class Coloreo {

	private int cantColores;
	private int[] coloresAsignados;
	
	public int getCantColores() {
		return cantColores;
	}
	
	public int[] getColoresAsignados() {
		return coloresAsignados;
	}
	
	public int getColorNodo(int nodo) {
		return coloresAsignados[nodo];
	}
	

	public void setColoreo(int[] arrayColoresNuevo, int cantColoresNuevo) {
		coloresAsignados = arrayColoresNuevo;
		cantColores = cantColoresNuevo;
	}
	
	public void imprimirColores() {
		for(int i = 0; i < coloresAsignados.length; i++) {
			System.out.println(i + ": " + coloresAsignados[i]);
		}
	}
}
