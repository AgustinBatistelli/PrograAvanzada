package circulo;

import punto.Punto;

public class Circulo {

	private Punto centro;
	private double radio;
	
	public Circulo(Punto p, double r) {
		centro = p;
		radio = r;
	}
	
	public boolean intersectaCon(Circulo c) {
		double p1X = centro.getX();
		double p2X = c.centro.getX();
		
		double p1Y = centro.getY();
		double p2Y = c.centro.getY();
		
		double resultadoX = p1X - p2X; 
		double resultadoY = p1Y - p2Y; 
		
		double distanciaCentros = Math.sqrt((resultadoX * resultadoX) + (resultadoY * resultadoY));
		
		double distanciaEntrePuntosCercanos = distanciaCentros - radio - c.radio;
		
		return distanciaEntrePuntosCercanos <= 0;
	}
}
