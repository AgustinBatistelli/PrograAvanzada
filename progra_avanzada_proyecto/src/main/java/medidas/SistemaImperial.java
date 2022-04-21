package main.java.medidas;

public class SistemaImperial extends UnidadDeMedida{
	
	public SistemaImperial(double valorUnidad, boolean tipoSistema) {
		super(valorUnidad, tipoSistema);
	}
	
	public double convertToMeter(UnidadDeMedida value) {
		return value.unidad/3.280839895;	
	}
	
	public double convertToMile(UnidadDeMedida value) {
		return value.unidad/0.0001893939;
	}
	
	
}
