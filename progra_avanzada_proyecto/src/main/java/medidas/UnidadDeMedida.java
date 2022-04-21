package main.java.medidas;

public class UnidadDeMedida {
	
	protected double unidad;
	protected boolean sistemaMetrico;
	
	protected UnidadDeMedida(double valorUnidad, boolean tipoSistema) {
		super();
		unidad = valorUnidad;
		sistemaMetrico = tipoSistema;
	}
	
	public double convertToMeter() {
		return unidad/3.280839895;	
	} 
	
	public static void main(String[] args) {
		
		UnidadDeMedida unidad1 = new UnidadDeMedida(1, true);
		
		System.out.println();
		
	}
	
}


// Lo que hicimos en clase.
//public class UnidadesLongitudEnum {
////
////	Un método estático que recibe la cantidad,
////	la unidad origen y la unidad destino, retornando la cantidad 
////	en la unidad destino. Manejarlo con String
////	
//	static public double convertir(double cantidad, Medidas unidadOrigen, Medidas unidadDestino){
// 
//		if(unidadOrigen == Medidas.METROS){
//			switch(unidadDestino){
//			case KILOMETROS:
//				cantidad  /= 1000;
//				break;
//				case MILLAS:
//					cantidad /= 1609;
//					break;
//				case PIES: 
//					cantidad *= 3.281;
//					break;
//				case METROS:
//						break;
//			}
//		}
//		if(unidadOrigen == Medidas.KILOMETROS){
//			switch(unidadDestino){
//			case MILLAS:
//				 cantidad /= 1.609;
//				 break;
//			case PIES:
//				cantidad *= 3281;
//				break;
//			case METROS:
//				cantidad *= 1000;
//				break;
//			case KILOMETROS:
//				break;
//			}
//		}
//		if(unidadOrigen == Medidas.MILLAS){
//			switch(unidadDestino){
//			case KILOMETROS:
//				cantidad *= 1.609;
//				break;
//			case PIES:
//				cantidad *= 5280;
//				break;
//			case METROS:
//				cantidad *= 1609;
//				break;
//			case MILLAS:
//				break;
//			}
//		}
//		if(unidadOrigen == Medidas.PIES){
//			switch(unidadDestino){
//			case KILOMETROS:
//				cantidad /= 3281;
//				break;
//			case MILLAS:
//				cantidad /= 5280;
//				break;
//			case METROS:
//				cantidad /= 3.281;
//				break;
//			case PIES:
//				break;
//			}
//		}
// 
//		return cantidad;
// 
//	}
// 
//	public static void main(String[] args) {
// 
//		System.out.println( UnidadesLongitudEnum.convertir(1, Medidas.KILOMETROS, Medidas.METROS));
// 
//	}
// 
//}
// 
// 
// 
//public enum Medidas {
//	METROS,
//	KILOMETROS,
//	PIES,
//	MILLAS,
// 
// 
// 
//}
// 
//public class UnidadesLongitud {
////
////	Un método estático que recibe la cantidad,
////	la unidad origen y la unidad destino, retornando la cantidad 
////	en la unidad destino. Manejarlo con String
////	
//	static public double convertir(double cantidad, String unidadOrigen, String unidadDestino){
// 
//		if(unidadOrigen == "metros"){
//			switch(unidadDestino){
//				case "kilometros":
//					cantidad  /= 1000;
//					break;
//				case "millas":
//					cantidad /= 1609;
//					break;
//				case "pies": 
//					cantidad *= 3.281;
//					break;
// 
//			}
//		}
//		if(unidadOrigen == "kilometros"){
//			switch(unidadDestino){
//			case "millas":
//				 cantidad /= 1.609;
//				 break;
//			case "pies":
//				cantidad *= 3281;
//				break;
//			case "metros":
//				cantidad *= 1000;
//				break;
// 
//			}
//		}
//		if(unidadOrigen == "millas"){
//			switch(unidadDestino){
//			case "kilometros":
//				cantidad *= 1.609;
//				break;
//			case "pies":
//				cantidad *= 5280;
//				break;
//			case "metros":
//				cantidad *= 1609;
//				break;
//			}
//		}
//		if(unidadOrigen == "pies"){
//			switch(unidadDestino){
//			case "kilometros":
//				cantidad /= 3281;
//				break;
//			case "millas":
//				cantidad /= 5280;
//				break;
//			case "metros":
//				cantidad /= 3.281;
//				break;
// 
//			}
//		}
// 
//		return cantidad;
// 
//	}
// 
//	public static void main(String[] args) {
// 
//		System.out.println( UnidadesLongitud.convertir(1, "kilometros", "millas"));
// 
//	}
// 
//}