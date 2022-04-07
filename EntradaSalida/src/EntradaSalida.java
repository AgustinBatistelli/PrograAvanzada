import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EntradaSalida {
	public static void main(String[] args) {

		
		int minRandom = 10000;
		int maxRandom = 20000;
		int cantidadRandomEnteros = (int)Math.floor(Math.random() * (maxRandom-minRandom+1)+minRandom);
		System.out.println("Cantidad de enteros: " + cantidadRandomEnteros);
		
		EntradaSalida entradaSalida = new EntradaSalida();

		String pathEntrada = new String("enterosRandoms.txt");
		entradaSalida.escriboArchivoRandoms(pathEntrada, cantidadRandomEnteros);

		int[] enteros = new int[cantidadRandomEnteros];
		entradaSalida.leoArchivo(pathEntrada, enteros);

		int mayor = entradaSalida.buscoMayor(enteros);
		int menor = entradaSalida.buscoMenor(enteros);
		int promedio = entradaSalida.promedio(enteros);

		String pathSalida = new String("tablaResultados.txt");
		entradaSalida.escriboArchivoTablaResultados(pathSalida, mayor, menor, promedio);
	}
	
	public void escriboArchivoRandoms(String path, int cantEnteros) {		
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter(path);
			pw = new PrintWriter(archivo);
			
			
			for (int i = 0; i < cantEnteros; i++) {
				int minEntero = 0;
				int maxEntero = 12000;
				int enteroRandom = (int)Math.floor(Math.random() * (maxEntero-minEntero+1)+minEntero);
				
				pw.println(enteroRandom);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (null != archivo) 					
					archivo.close();
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void leoArchivo(String pathFile, int[] array) {
		try {
			Scanner arch = new Scanner(new File(pathFile));
			
			int i = 0;
			while (arch.hasNextInt()) {
				array[i] = arch.nextInt();
				i++;
			}
			arch.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public int buscoMayor (int[] array) {
		int mayor = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (mayor < array[i]) 
				mayor = array[i];
		}
		
		return mayor;
	}
	
	public int buscoMenor (int[] array) {
		int menor = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (menor > array[i]) 
				menor = array[i];
		}
		
		return menor;
	}
	
	public int promedio(int[] array) {
		int sumaTotal = 0;
		for (int i = 0; i < array.length; i++) 
			 sumaTotal += array[i];
		
		return sumaTotal / array.length;
	}
	
	public void escriboArchivoTablaResultados(String path, int mayor, int menor, int promedio) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter(path);
			pw = new PrintWriter(archivo);
		
			pw.println("+----------+-------+");
			pw.println("|Máximo    |" + mayor + "   |");
			pw.println("+----------+-------+");
			pw.println("|Mínimo    |" + menor + "   |");
			pw.println("+----------+-------+");
			pw.println("|Promedio  |" + promedio + "   |");
			pw.println("+----------+-------+");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (null != archivo) 					
					archivo.close();
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
