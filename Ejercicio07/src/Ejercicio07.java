import java.io.*;

public class Ejercicio07 {
	public static void mostrarTabla(int max, int min, int prom) {
		System.out.println("+----------+-------+");
		System.out.format("| Máximo   | %5d |\n", max);
		System.out.println("+----------+-------+");
		System.out.format("| Mínimo   | %5d |\n", min);
		System.out.println("+----------+-------+");
		System.out.format("| Promedio | %5d |\n", prom);
		System.out.println("+----------+-------+");
	}
	
	public void crearArchivoRandoms() {
		try {
			File f = new File("./archivos/archivoRandoms.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			int numRandom = (int) Math.floor(Math.random() * 12000),
				cantNumeros = (int) Math.floor(10000 + Math.random() * 10000); 	
			int min = numRandom,
				max = numRandom,
				suma = 0;
			
			for (int i = 1; i < cantNumeros; i++) {
				numRandom = (int) Math.floor(Math.random() * 12000); 
				if(numRandom > max) {
					max = numRandom;
				}
				if(numRandom < min) {
					min = numRandom;
				}
				suma += numRandom;
			}
			
			mostrarTabla(max, min, suma/cantNumeros);
			bw.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Ejercicio07 ejercicio = new Ejercicio07();
		ejercicio.crearArchivoRandoms();
	}
}
