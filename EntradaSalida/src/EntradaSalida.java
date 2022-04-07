import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EntradaSalida {
	public static void main(String[] args) {

		
		int minRandom = 10000;
		int maxRandom = 20000;
		int cantidadRandomEnteros = (int)Math.floor(Math.random() * (maxRandom-minRandom+1) + minRandom);
		System.out.println("Cantidad de enteros: " + cantidadRandomEnteros);
		
		EntradaSalida entradaSalida = new EntradaSalida();

		String pathEntrada = new String("enterosRandoms.txt");
		entradaSalida.escriboArchivoRandoms(pathEntrada, cantidadRandomEnteros);

		int[] enteros = new int[cantidadRandomEnteros];
		entradaSalida.leoArchivo(pathEntrada, enteros);

		String pathSalida = new String("tablaResultados.txt");
		entradaSalida.escriboArchivoTablaResultados(pathSalida, entradaSalida.mayorMenorPromedio(enteros));
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
	
	public int[] mayorMenorPromedio(int[] array) {
		int mayor = array[0];
		int menor = array[0];
		int sumaTotal = 0;
		for (int i = 0; i < array.length; i++){
			  
			  if (mayor < array[i])
				  mayor = array[i];

			  if (menor > array[i])
				  menor = array[i];
			  
			  sumaTotal += array[i];
			 
		}
		int[] arrayResp = new int[3];
		arrayResp[0] = mayor;
		arrayResp[1] = menor;
		arrayResp[2] = sumaTotal / array.length;
		
		return arrayResp;
	}
	
	
	public void escriboArchivoTablaResultados(String path, int[] array) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter(path);
			pw = new PrintWriter(archivo);
		
			pw.println("+----------+-------+");
			pw.println("|Máximo    |" + array[0] + "   |");
			pw.println("+----------+-------+");
			pw.println("|Mínimo    |" + array[1] + "   |");
			pw.println("+----------+-------+");
			pw.println("|Promedio  |" + array[2] + "   |");
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
