import java.io.*;

public class Entrada_Salida {
	
	/*
	 * static = accede al metodo sin necesidad de referenciar o instanciar la clase
	 * 
	 * Stream = flujo de una uente a un destino. Trabaja la comunicacion 
	 * de informacion. Estos flujos son secuencias ordenadas de datos 
	 * que tienen un flujo de entrada o un flujo de salida
	 * 
	 * Flujos de bytes = los flujos de entrada estan implementados por subclases de la clase InputStream 
	 * y los de salida OutputStream.
	 * 
	 * Flujo de Caracteres = los flujos de entrada de caracteres estan implementado por subclases de la clase Reader 
	 * y los de saluda Writer.
	 * 
	 * Clase abstract = no puedo generar una instancia de esta clase, pero si de las que heredan de esta.
	 * 
	 * InputStream:
	 * 
	 * read() lee un caracter y retorna un entero
	 * 
	 * read(byte[] buffer) lee el flujo en un arreglo y devuelve la cantidad de bytes leidos
	 * 
	 * read(byte[] buffer, int offset, int lenght) desde que inicio y hasta que fin leer los bytes y devuelve la cant de bytes leidos
	 * 
	 * close() cierra el flujo
	 * 
	 * skip(long n) descarta la cant de bytes del flujo
	 * 
	 * OutputStream:
	 * 
	 * write()
	 * 
	 * write(byte[] buffer)
	 * 
	 * write(byte[] buffer, int offset, int lenght)
	 * 
	 * close() cierra el flujo
	 * 
	 * flush() vacia el flujo
	 * 
	 * -------------------------------------------------------------------------------------------------------------------------------
	 * 
	 * Reader:
	 * 
	 * read() lee un caracter y retorna un entero
	 * 
	 * read(byte[] buffer) lee el flujo en un arreglo y devuelve la cantidad de bytes leidos
	 * 
	 * read(byte[] buffer, int offset, int lenght) desde que inicio y hasta que fin leer los bytes y devuelve la cant de bytes leidos
	 * 
	 * close() cierra el flujo
	 * 
	 * skip(long n) descarta la cant de bytes del flujo
	 * 
	 * Writer:
	 * 
	 * write(int b) escribe en el flujo de salido los 8 bits de menor orden del argumento b
	 * 
	 * write(byte[] b)
	 * 
	 * write(byte[] b, int offset, int lenght)
	 * 
	 * close() cierra el flujo
	 * 
	 * flush() vacia el flujo
	 */
	
	public static void main(String[] args) throws IOException  {
		
		leerDeTeclado();
		leerEnteros();
		leerUsandoSplit(args);
		escribirArchivo();
		escribirLineasEnArchivo();
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

	private static void escribirArchivo() {
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

	private static void leerUsandoSplit(String[] args) throws IOException {
		
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

	private static void leerEnteros() throws IOException {
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		int numero;
		
		try {
			
			f = new File("enteros.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			
			while((linea = br.readLine()) != null) {
				numero = Integer.parseInt(linea);
				System.out.print(numero);
			}
			
			br.close(); //implementarlo en otro lado
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void leerDeTeclado() throws IOException {
		int c;
		int contador = 0;
		
		System.out.print("Ingrese una palabra: ");
		
		while( (c = System.in.read() ) != '\n') {
			contador++;
			System.out.print((char) c);
		}
		
		System.out.println("\nContados " + contador + " bytes en total.");
	}
	
	/*
	 * BufferedReader/BufferedWriter para flujo de caracteres
	 * BufferedInputStream/BufferedOutputStream para flujo de bytes
	 * Ejemplo: 
	 * InputStreamReader entrada = new InputStreamReader(System.in);
	 * BufferedReader teclado = new BufferedReader(entrada);
	 * String cadena = teclado.readLine();
	 */

}
