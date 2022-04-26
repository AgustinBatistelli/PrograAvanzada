package oia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorArchivos {

	public static Carrera leerArchivo(String path) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileReader(path));

		String linea = sc.nextLine();

		String[] datos = linea.split(" ");

		Integer cantCorredores = Integer.valueOf(datos[0]);
		Integer cf = Integer.valueOf(datos[1]);
		Integer cm = Integer.valueOf(datos[2]);
		Integer corredoresQueFinalizaronCarrera = Integer.valueOf(datos[3]);

		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		categorias = guardarCategoria(sc, linea, datos, cf, categorias, 'F');
		categorias = guardarCategoria(sc, linea, datos, cm, categorias, 'M');

		ArrayList<Corredor> corredores = new ArrayList<Corredor>();

		for(int k = 0; k < cantCorredores; k++) {

			linea = sc.nextLine();
			datos = linea.split(" ");

			Corredor corredor = new Corredor(
					Integer.valueOf(datos[0]), 
					datos[1].charAt(0), 
					k+1
					);

			corredores.add(corredor);
		}

		ArrayList<Corredor> finalizaron = new ArrayList<Corredor>();

		for (int j = 0; j < corredoresQueFinalizaronCarrera; j++) {

			int index = sc.nextInt();

			Corredor corredor = new Corredor(
					corredores.get(index - 1).getEdad(),
					corredores.get(index - 1).getSexo(),
					index
					);

			finalizaron.add(corredor);
		}

		sc.close();

		return new Carrera(categorias, corredores, finalizaron);
	}

	private static ArrayList<Categoria> guardarCategoria(Scanner sc, String linea, String[] datos, 
			Integer cantCategoriasXSexo, ArrayList<Categoria> categorias, char sexo) {

		for(int i = 0; i < cantCategoriasXSexo; i++) { //guardo las categorias con el rango de edades

			linea = sc.nextLine();
			datos = linea.split(" ");

			Categoria categoria = new Categoria(
					Integer.valueOf(datos[0]), 
					Integer.valueOf(datos[1]), 
					i+1,
					sexo);

			categorias.add(categoria);
		}

		return categorias;
	}

	public static void escribirArchivo(String path, String resultado) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
		bw.write(resultado);
		bw.close();
	}

}
