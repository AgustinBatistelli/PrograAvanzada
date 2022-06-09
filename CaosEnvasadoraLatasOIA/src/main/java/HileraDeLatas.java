import java.util.ArrayList;
import java.util.HashMap;

public class HileraDeLatas {
	ArrayList<Lata> arrayLatas = new ArrayList<Lata>();
	HashMap<Integer, Integer> tablaConsecutivos = new HashMap<Integer, Integer>();
	
	public void agregarLata(Lata lata) {
		arrayLatas.add(lata);
	}
	
	public void quitarUltimaLata() {
		arrayLatas.remove(arrayLatas.size() - 1);
	}
	
	public ArrayList<Integer> procesarHilera() {
		int i = 0;
		
		
		int cantTotalLatas = arrayLatas.size();
		
		while(i < cantTotalLatas) {
			int cantLatasConsecutivas = 0;
			int indiceAnalizado = i;
			
			while( i < cantTotalLatas && arrayLatas.get(i).getTipo().equals("G") ) {
				cantLatasConsecutivas++;
				i++;
			}
			if(cantLatasConsecutivas > 0) {
				tablaConsecutivos.put(indiceAnalizado, cantLatasConsecutivas);
			}
			
			i++;
		}
		///ya tengo cargado el mapa
		
		int indiceMax = 0;
		int maxConsecutivo = 0;
		
		for(Integer indice : tablaConsecutivos.keySet()) {
			int cantConsecutivos = tablaConsecutivos.get(indice);
			
			if( cantConsecutivos > maxConsecutivo) {
				maxConsecutivo = cantConsecutivos;
				indiceMax = indice;
			}
		}
		
		tablaConsecutivos.remove(indiceMax);
		
		int segundoIndiceMax = 0;
		int segundoMaxConsecutivo = 0;
		
		for(Integer indice : tablaConsecutivos.keySet()) {
			int cantConsecutivos = tablaConsecutivos.get(indice);
			
			if( cantConsecutivos > segundoMaxConsecutivo) {
				segundoMaxConsecutivo = cantConsecutivos;
				segundoIndiceMax = indice;
			}
		}
		
		ArrayList<Integer> arrayRespuesta = new ArrayList<Integer>();
		arrayRespuesta.add(cantTotalLatas);
		arrayRespuesta.add(maxConsecutivo);
		arrayRespuesta.add(segundoMaxConsecutivo);
		
		if(tablaConsecutivos.size() == 0) {
			arrayRespuesta.add(0);
		}
		else {
			arrayRespuesta.add(Math.abs(indiceMax - segundoIndiceMax  - segundoMaxConsecutivo));			
		}
//		
		
		return arrayRespuesta;
//		System.out.println("La cantidad de latas es: " + cantTotalLatas);
//		System.out.println("Cantidad de latas en la secuencia mas larga: " + maxConsecutivo);
//		System.out.println("Cantidad de latas en la segunda secuencia mas larga: " + segundoMaxConsecutivo);
//		System.out.println("Distancia entre ambas secuencias: " + Math.abs(indiceMax - segundoIndiceMax  - segundoMaxConsecutivo));
//		
		
	}
	
	
	public static void main(String[] args) {
		HileraDeLatas hilera = GestorArchivos.cargarHilera("./input.IN");
		hilera.procesarHilera();
		
		try {
			GestorArchivos.escribirSalida(hilera, "./output.OUT");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}








