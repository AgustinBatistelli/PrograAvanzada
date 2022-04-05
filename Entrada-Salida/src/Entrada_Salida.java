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
	
	public static void main(String[] args) throws IOException {
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
