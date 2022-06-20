package luchadoresJaponeses;

import java.util.ArrayList;

public class Torneo {
	private ArrayList<Luchador> arrLuchadores = new ArrayList<Luchador>();
	int[] arrDomina;
	
	public Torneo(int cantLuchadores) {
		arrDomina = new int[cantLuchadores];
	}
	
	
	
	public void agregarLuchador(Luchador luchador) {
		arrLuchadores.add(luchador);
	}
	
	public void calcularDuelos() {
		
		for(int i = 0; i < arrLuchadores.size(); i++) {
			Luchador luchador = new Luchador(arrLuchadores.get(i).getAltura(), arrLuchadores.get(i).getPeso());
			for(int j = 1 + i; j < arrLuchadores.size(); j++) {
				if(luchador.dominaA(arrLuchadores.get(j))) {
					arrDomina[i]++;
				}
				else if(arrLuchadores.get(j).dominaA(luchador)) {
					arrDomina[j]++;
				}
			}
		}	
	}
	
	public void mostrarResultado() {
		for(int i = 0; i < arrDomina.length; i++) {
			System.out.println(arrDomina[i]);
		}
	}
	
	public static void main(String[] args) {

		final String pathEntrada = "./src/main/java/luchadoresJaponeses/archivos/entrada.IN.txt"; 
		final String pathSalida = "./src/main/java/luchadoresJaponeses/archivos/entrada.OUT.txt"; 
		
		try {
			Torneo torneo = GestorArchivos.leerArchivo(pathEntrada);
			torneo.calcularDuelos();		
			GestorArchivos.escribirArchivo(torneo, pathSalida);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
