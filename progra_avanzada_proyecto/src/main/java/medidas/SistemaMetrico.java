package main.java.medidas;

public class SistemaMetrico extends UnidadDeMedida {
	
	public SistemaMetrico(double valorUnidad, boolean tipoSistema) {
		super(valorUnidad, tipoSistema);
	}
	
	public double convertToFeet(UnidadDeMedida value) {
		return value.unidad*3.280839895;	
	}
	
	public double convertToKilometre(UnidadDeMedida value) {
		return value.unidad/0.001;
	}
	
	public static void main(String[] args) {
		
		
		
	}
	
}
