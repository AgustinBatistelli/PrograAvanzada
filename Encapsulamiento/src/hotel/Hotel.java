package hotel;

import java.util.Objects;

public class Hotel {

	/*
	 * Definir una clase "Hotel" tal que tenga operaciones para: 
	 * a. Crear la clase con la cantidad de habitaciones que tiene. 
	 * b. Ocupar una habitación disponible indicando la cantidad de personas mayores y menores (máximo 8 en total) que la
	 * ocuparán.
	 * void ocuparHabitacionCon(int mayores, int menores) 
	 * c. Devolver la cantidad total de personas que ocupan todas las habitaciones del hotel.
	 * d. Devolver la cantidad de habitaciones que están ocupadas portantos mayores
	 * como los indicados por parámetro.
	 * int contarHabitacionesCon(int mayores )
	 * e. Definir la igualdad entre hoteles en funcion de la cantidad de habitaciones
	 */
	
	private int cantHab;
	private int [] cantMay;
	private int [] cantMen;
	
	//a
	public Hotel(int habitaciones) {
		cantHab = habitaciones;
		cantMay = new int [habitaciones];
		cantMen = new int [habitaciones]; 
		//es necesario el new para el vector por q sino no hay reserva de memoria
		
	}
	
	//b
	public void ocuparHabitacionCon(int mayores, int menores) {
		
		int i = 0;
		
		if(mayores + menores < 8) {
			
			while(i < cantHab && !habitacionVacia(cantMay[i], cantMen[i])) {
				
				cantMay[i] = mayores;
				cantMen[i] = menores;
				i++;		
			}
		}
	}
	
	private boolean habitacionVacia(int i, int j) {
		return i + j != 0;
	}

	//c
	public int personasQueOcupanTodasLasHabitaciones() {
		
		int sum = 0;
		
		for(int i = 0; i < this.cantHab; i++) {
			sum += this.cantMay[i] + this.cantMen[i];
		}
		
		return this.cantHab * sum;
	}
	
	//d
	public int contarHabitacionesCon(int mayores) {
		
		int sum = 0;
		
		for(int i = 0; i < this.cantHab; i++) {
			sum += this.cantMay[i];
		}
		
		return sum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantHab);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return cantHab == other.cantHab;
	}
	
	
	
}
