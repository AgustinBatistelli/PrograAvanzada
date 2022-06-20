import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorArchivos {

	
	public static HileraDeLatas cargarHilera(String pathInput) {
		
		HileraDeLatas hilera = new HileraDeLatas();
		File f = null;
		Scanner sc = null;
		
		
		try {
			f = new File(pathInput);
			sc = new Scanner(f);
			
			while(sc.hasNext()) {
				String tipo = sc.next();
				hilera.agregarLata(new Lata(tipo));
			}
			
			hilera.quitarUltimaLata(); ///para borrar la lata F
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(sc != null) {
				sc.close();
			}
		}
		
		return hilera;
	}
	
	public static void escribirSalida(HileraDeLatas hilera, String pathOutput) throws IOException{
		
		File f = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			f = new File(pathOutput);
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			ArrayList<Integer> arrayRespuestaSalida = hilera.procesarHilera();
			
			for(Integer valor : arrayRespuestaSalida) {
				bw.write(valor + "\n");
			}
				
		}
		catch(IOException e ) {
			e.printStackTrace();
		}
		finally {
			if(bw != null) {
				bw.close();
				System.out.println("Archivo creado exitosamente");
			}
		}
		
	}
	
}



















