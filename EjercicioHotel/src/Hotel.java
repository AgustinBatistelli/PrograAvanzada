import java.util.Arrays;

public class Hotel {
	public int cantHabitaciones;
	public int cantHabitacionesOcupadas;
	int[][] personasEnHabitaciones; //El primer indice indica la habitacion, y el segundo los mayores [0] y menores [1]	
	//a)
	public Hotel(int _cantHabitaciones) {
		this.cantHabitaciones = _cantHabitaciones;
		this.cantHabitacionesOcupadas = 0;
		this.personasEnHabitaciones = new int[_cantHabitaciones][2];
	}
	
	//b)
	public void ocuparHabitacionCon(int mayores, int menores) {
		if(cantHabitacionesOcupadas == cantHabitaciones || mayores + menores > 8) {
			return;
		}
		
		personasEnHabitaciones[cantHabitacionesOcupadas][0] = mayores;
		personasEnHabitaciones[cantHabitacionesOcupadas][1] = menores;
		
		cantHabitacionesOcupadas++;
	}
	
	
	//c)
	public int cantPersonas() {
		int personas = 0;
		for(int i = 0; i < personasEnHabitaciones.length; i++) {
			personas += personasEnHabitaciones[i][0] + personasEnHabitaciones[i][1];
		}
		
		return personas;
	}
	
	
	//d)
	public int contarHabitacionesCon(int mayores) {
		int contador = 0;
		for(int i = 0; i < personasEnHabitaciones.length; i++) {
			if(personasEnHabitaciones[i][0] == mayores) {
				contador++;
			}
		}
		
		return contador;
	}

	//e)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return cantHabitaciones == other.cantHabitaciones;
	}

	@Override
	public String toString() {
		return "Hotel [cantHabitaciones=" + cantHabitaciones + ", cantHabitacionesOcupadas=" + cantHabitacionesOcupadas
				+ ", personasEnHabitaciones=" + Arrays.toString(personasEnHabitaciones) + "]";
	}

	
}
