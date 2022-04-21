package main.java.oop;

import java.util.Arrays;
import java.util.Objects;

/* Definir una clase "Hotel" tal que tenga operaciones para:

a. Crearla con la cantidad de habitaciones que tiene.
b. Ocupar una habitación disponible indicando la cantidad de personas mayores y menores (máximo 8 en total) que la ocuparán.
	void ocuparHabitacionCon(int mayores, int menores)
c. Devolver la cantidad total de personas que ocupan todas las habitaciones del hotel.
d. Devolver la cantidad de habitaciones que están ocupadas portantos mayores como los indicados por parámetro.
	int contarHabitacionesCon(int mayores)
e. Definir la igualdad entre hoteles en funcion de la cantidad de habitaciones.
	
	composicion -> contiene objetos de otra clases.
	
*/
public class Hotel {

	private int cantHabitaciones;
	private int[] arrayMayores; // necesito hacer el new
	private int[] arrayMenores;

	public Hotel(int _cantHabitaciones) {
		cantHabitaciones = _cantHabitaciones;
		arrayMayores = new int[_cantHabitaciones]; // genero el espacio para poder usarlo..
		arrayMenores = new int[_cantHabitaciones];
	}

	public void ocuparHabitacionCon(int mayores, int menores) {
		if (mayores + menores <= 8) {
			int i = 0;
			while (i < cantHabitaciones && (arrayMenores[i] + arrayMayores[i] != 0))
				i++;

			arrayMayores[i] = mayores;
			arrayMenores[i] = menores;
		}
		else
			return; //deberia tirar una exception si no puedo ocupar la habitacion..
	}
	
	public int getCantPersEnHotel() {
		int cantPers = 0;
		for(int i = 0; i < cantHabitaciones; i++) {
			cantPers += arrayMayores[i];
			cantPers += arrayMenores[i];
		}
		return cantPers;
	}

	public int contarHabitacionesCon(int mayores) {
		int contador = 0;		
		for(int i = 0; i < cantHabitaciones; i++) {
			if(arrayMayores[i] == mayores)
				contador++;
		}
		return contador;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arrayMayores);
		result = prime * result + Arrays.hashCode(arrayMenores);
		result = prime * result + Objects.hash(cantHabitaciones);
		return result;
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
		return Arrays.equals(arrayMayores, other.arrayMayores) && Arrays.equals(arrayMenores, other.arrayMenores)
				&& cantHabitaciones == other.cantHabitaciones;
	}

}