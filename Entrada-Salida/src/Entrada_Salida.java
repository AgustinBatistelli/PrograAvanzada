import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
//import java.util.Scanner;

public class Entrada_Salida {
	
	final static String MAX = "Maximo";
	final static String MIN = "Minimo";
	final static String PROM = "Promedio";
		
	public static void main(String[] args) throws IOException  {
//		leerDeTeclado();
//		leerEnteros();
//		leerUsandoSplit(args);
//		escribirArchivo();
//		escribirLineasEnArchivo();
//		leerConScanner("entrada.in");
		obtenerMaxMinYProm();
	}

	public static void leerConScanner(String nomArch) throws Exception {
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File(nomArch));
			
			while(sc.hasNext()) {
				System.out.println(sc.nextLine()); //lee linea completa
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			if(sc != null)
				sc.close();
		}	
		
	}

	public static void obtenerMaxMinYProm() throws IOException {
		int nrosEscritosEnArchivo = escribirArchivoNumRand();
		HashMap<String, Integer> hash = leerEnteros("nrosRandom.txt", nrosEscritosEnArchivo);
		escribirArchivoResultado(hash);
	}

	public static void escribirArchivoResultado(HashMap<String, Integer> hash) {
		System.out.println("+----------+-------+");
		System.out.println("| Máximo   | " + hash.get(MAX) + " |");
		System.out.println("+----------+-------+");
		System.out.println("| Minimo   |" + String.format("%5s", " ") + hash.get(MIN) + " |");
		System.out.println("+----------+-------+");
		System.out.println("| Promedio |" + String.format("%2s", " ") + hash.get(PROM) + String.format("%1s", " ") + "|");
		System.out.println("+----------+-------+");
	}

	public static int escribirArchivoNumRand() {
		int min = 0;
		int max = 12000;
		int cantNrosAleatoriosMin = 10000;
		int cantNrosAleatoriosMax = 20000;
		
		int nrosAleatorios = (int)(Math.random() * (cantNrosAleatoriosMax - cantNrosAleatoriosMin + 1) + cantNrosAleatoriosMin);
		escribirLineasEnArchivo(min, max, nrosAleatorios);
		return nrosAleatorios;
	}

	public static void escribirLineasEnArchivo(int min, int max, int nrosAleatorios) {
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			
			fichero = new FileWriter("nrosRandom.txt");
			pw = new PrintWriter(fichero);
			
			int i = 0;
			int nro;
			
			while(i < nrosAleatorios) {
				nro = (int)(Math.random() * (max - min + 1) + min);
				pw.println(nro);
				i++;
			}
			
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			try {
				if(fichero != null)
					fichero.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static HashMap<String, Integer> leerEnteros(String nombreArch, int nrosEscritosEnArchivo) throws IOException {
		
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		int numero;
		int max = 0;
		int min = 0;
		int prom = 0;
		int i = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		try {
			
			f = new File(nombreArch);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			
			while((linea = br.readLine()) != null) {
				
				numero = Integer.parseInt(linea);
				
				if(numero > max)
					max = numero;
				
				if(i == 0 || numero < min)
					min = numero;
				
				prom += numero;
				
				i++;
			}
			
			prom /= nrosEscritosEnArchivo;
			
			
			
			map.put(MAX, max);
			map.put(MIN, min);
			map.put(PROM, prom);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		
		return map;
	}
	
/*	private static void leerUsandoSplit(String[] args) throws IOException {
		
		try {
			FileReader input = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(input);
			String line;
			line = br.readLine();
			
			while (line != null) {
				String[] datos;
				datos = line.split(" ");
				int entero1 = Integer.parseInt(datos[0]);
				int entero2 = Integer.parseInt(datos[1]);
				System.out.println(entero1 + " " + entero2);
				line = br.readLine();
			}
			
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void escribirLineasEnArchivo() {
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			
			fichero = new FileWriter("prueba.txt");
			pw = new PrintWriter(fichero);
			
			for(int i = 0; i < 10; i++) {
				pw.println("Linea " + i);
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			try {
				if(null != fichero)
					fichero.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void escribirArchivo() {
		try {
			
			String ruta = "/ruta/nombre.txt";
			String contenido = "Contenido ejemplo";
			File file = new File(ruta);
			
			if(!file.exists())
				file.createNewFile();
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenido);
			bw.close(); //TODO: NO OLVIDARSE DE ESTOOOO!!!!!
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void leerDeTeclado() throws IOException {
		int c;
		int contador = 0;
		
		System.out.print("Ingrese una palabra: ");
		
		while( (c = System.in.read() ) != '\n') {
			contador++;
			System.out.print((char) c);
		}
		
		System.out.println("\nContados " + contador + " bytes en total.");
	} */
	
}
