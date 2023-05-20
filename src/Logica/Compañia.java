package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class Compañia{
	private String nombre;
	public Persona presidente;
	public Persona vicepresindete;
	public ArrayList<Persona>Trabajadores;
	public LinkedList<Juegos>Videojuegos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Persona getPresidente() {
		return presidente;
	}
	public void setPresidente(Persona presidente) {
		this.presidente = presidente;
	}
	public Persona getVicepresindete() {
		return vicepresindete;
	}
	public void setVicepresindete(Persona vicepresindete) {
		this.vicepresindete = vicepresindete;
	}
	public ArrayList<Persona> getTrabajadores() {
		return Trabajadores;
	}
	public void setTrabajadores(ArrayList<Persona> trabajadores) {
		Trabajadores = trabajadores;
	}
	
	public Compañia(String nombre) {
		this.nombre = nombre;
		Videojuegos = new LinkedList<Juegos>();
		Trabajadores = new ArrayList<Persona>();
		presidente = null;
		vicepresindete = null;
	}
	public void ingresar_videojuegos(Juegos juego)
	{
		Videojuegos.addLast(juego);
	}
	public void ingresar_trabajador(Persona persona) {
		Trabajadores.add(persona);
	}
	
	public boolean juegos_iguales(Juegos juego_seleccionado) {
		boolean verdad = false;
		Iterator<Juegos>iter = Videojuegos.listIterator();
		while(iter.hasNext() && verdad == false) {
			Juegos valor = iter.next();
			if(valor.equals(juego_seleccionado) && valor.gastos == juego_seleccionado.gastos && valor.beneficios == juego_seleccionado.beneficios) {
				verdad = true;
			}
		}
		return verdad;
	}
	public boolean personas_iguales(Persona personal) {
		boolean verdad = false;
		if(presidente != null) {
			if(presidente.equals(personal)) {
				verdad = true;
			}
		}
		else if (vicepresindete != null) {
			if(presidente.equals(personal)) {
				verdad = true;
			}
		}
		for(int contador = 0; contador<Trabajadores.size() && verdad == false && verdad==false;contador++) {
			if(Trabajadores.get(contador).equals(personal)) {
				verdad = true;
			}
		}
		return verdad;
	}
}
