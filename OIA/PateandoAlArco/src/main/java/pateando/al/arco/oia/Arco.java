package pateando.al.arco.oia;

public class Arco {
	
	private Coordenada coord;

	public Arco(Coordenada c) {
		this.coord = c;
	}

	public boolean esPaloOTravesanio() {
//		Si no es GOL, pero la coordenada x
//		está entre 0 y 732 inclusive, mientras
//		que la coordenada y es menor o igual
//		que 232, entonces se considera PALO.
		return ( (coord.getX() >= 0 && coord.getX() <= 732) &&
				(coord.getY() == 232 ) || 
				((coord.getX() == 0 || coord.getX() == 732) && 
					(coord.getY() <= 232 ))
				);
	}
	
	public boolean esGol() {
//		Para que sea GOL, la coordenada x debe ser estrictamente mayor que 0, 
//		y estrictamente menor que 732. En cambio,
//		la coordenada y debe ser estrictamente
//		menor que 232.
		
		return ( (coord.getX() > 0 && coord.getX() < 732) &&
				(coord.getY() < 232 ));
	}

	public Coordenada getCoordenada() {
		return coord;
	}
}
