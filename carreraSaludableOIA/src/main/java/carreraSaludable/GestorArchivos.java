package carreraSaludable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorArchivos {
	
	private static final String pathInput = "./input.IN";
	private static final String pathOutput = "./output.OUT";
	
	public static void escribirSalida(Competencia competencia) throws IOException {
		File f = null;
		FileWriter fw = null;
		BufferedWriter bf = null;
		
		try {
			
			f = new File(pathOutput);
			fw = new FileWriter(f);
			bf = new BufferedWriter(fw);
			
			ArrayList<Categoria> categorias = competencia.getCategorias();
			
			for(Categoria categoria : categorias) {
				bf.write(categoria.getTop());
			}
			
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if (bf != null) {
				System.out.println("Archivo creado exitosamente");
				bf.close();
			}
		}
	}
	
	public static Competencia cargarCompetencia() {
		Competencia competencia = new Competencia();
		File f = null;
		Scanner sc = null;
		
		try {
			f = new File(pathInput);
			sc = new Scanner(f);
			
			
			int cantCompetidores = sc.nextInt();
			int cantCategoriasFem = sc.nextInt();
			int cantCategoriasMasc = sc.nextInt();
			int cantCompetidoresFinalizados = sc.nextInt();
			
			
			for(int i = 0; i < cantCategoriasFem; i++) {
				int edadMin = sc.nextInt();
				int edadMax = sc.nextInt();
				competencia.agregarCategoria(new Categoria(edadMin, edadMax, "F"));
			}
			
			for(int i = 0; i < cantCategoriasMasc; i++) {
				int edadMin = sc.nextInt();
				int edadMax = sc.nextInt();
				competencia.agregarCategoria(new Categoria(edadMin, edadMax, "M"));
			}
			
			for(int i = 0; i < cantCompetidores; i++) {
				int edad = sc.nextInt();
				String sexo = sc.next();
				competencia.agregarCompetidor(new Competidor(edad, sexo));
			}
			
			for(int i = 0; i < cantCompetidoresFinalizados; i++) {
				int nroCompetidor = sc.nextInt();
				competencia.agregarCompetidorFinalizado(nroCompetidor);
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally{
			if(sc != null) {
				sc.close();
			}
		}
		
		return competencia;
	}
}
