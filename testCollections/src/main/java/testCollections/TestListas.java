package testCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class TestListas {
	public static void main(String[] args) {
		Comparator<Persona> cmp = new Comparator<Persona>() {

			public int compare(Persona p1, Persona p2) {
				return (int) (p1.getAltura() - p2.getAltura());
			}
		};
		
//		TEST DE ARRAY LIST
//		ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();
//		
//		arrayPersonas.add(new Persona(170, 120));
//		arrayPersonas.add(new Persona(150, 50));
//		arrayPersonas.add(new Persona(190, 90));
//		arrayPersonas.add(new Persona(205, 90));
//		arrayPersonas.add(new Persona(130, 100));
		
//		for(Persona persona : arrayPersonas) {
//			System.out.println(persona.toString());
//		}
//		
		
		
//		///Usando la interfaz Comparable de la clase Persona
//		Collections.sort(arrayPersonas); 
//		
		///Usando el objecto Comparator, e implementando getter de altura de la persona
		
//		arrayPersonas.sort(cmp);
//		
		
		
//		System.out.println("\n");
//		for(Persona persona : arrayPersonas) {
//			System.out.println(persona.toString());
//		}
		
		///TEST LINKEDLIST 
		LinkedList<Persona> lista = new LinkedList<Persona>();
		lista.add(new Persona(170, 120));
		lista.add(new Persona(150, 50));
		lista.add(new Persona(190, 90));
		lista.add(new Persona(190, 90));
		lista.add(new Persona(205, 90));
		lista.add(new Persona(130, 100));
		lista.add(new Persona(130, 100));
		lista.add(new Persona(130, 100));
		
		for(Persona persona : lista) {
			System.out.println(persona.toString());
		}
	
		Collections.sort(lista);
		lista.sort(cmp);
		

		System.out.println("\n");
		for(Persona persona : lista) {
			System.out.println(persona.toString());			
		}
		
		
		///TEST SET
		//Para utilizar HashSet tengo que hacer un override de equals() y hashCode()
//		HashSet<Persona> personaSet = new HashSet<Persona>();
		TreeSet<Persona> personaSet = new TreeSet<Persona>();
		
		personaSet.addAll(lista);
		
		System.out.println("------Mostrando TreeSet-----");
		for(Persona persona : personaSet) {
			System.out.println(persona.toString());
		}

		
	}
}
