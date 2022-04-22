package luchadoresJaponeses;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
//		
//		Luchador luch1 = new Luchador(300, 1500);
//		Luchador luch2 = new Luchador(320, 1500);
//		Luchador luch3 = new Luchador(299, 1580);
//		Luchador luch4 = new Luchador(330, 1690);
//		Luchador luch5 = new Luchador(330, 1540);
//		Luchador luch6 = new Luchador(339, 1500);
//		Luchador luch7 = new Luchador(298, 1700);
//		Luchador luch8 = new Luchador(344, 1570);
//		Luchador luch9 = new Luchador(276, 1678);
//		Luchador luch10 = new Luchador(289, 1499);		
//		
//		Torneo torneo = new Torneo(10);
//		
//		torneo.agregarLuchador(luch1);
//		torneo.agregarLuchador(luch2);
//		torneo.agregarLuchador(luch3);
//		torneo.agregarLuchador(luch4);
//		torneo.agregarLuchador(luch5);
//		torneo.agregarLuchador(luch6);
//		torneo.agregarLuchador(luch7);
//		torneo.agregarLuchador(luch8);
//		torneo.agregarLuchador(luch9);
//		torneo.agregarLuchador(luch10);
//		
//		
//		torneo.calcularDuelos();
//		
//		torneo.mostrarArrayDomina();
		
		final String rutaEntrada = "C:\\Users\\marti\\eclipse-workspace\\luchadoresJaponeses\\ArchivosIN\\Entrada.in.txt";
		final String rutaSalida = ".\\ArchivosOUT\\Salida.out.txt";
		
		Torneo torneo;
		try {
			
			torneo = GestionArchivo.leerArchivo(rutaEntrada);
			torneo.calcularDuelos();
			torneo.mostrarArrayDomina();
			GestionArchivo.escribirArchivo(rutaSalida, torneo);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	

}
