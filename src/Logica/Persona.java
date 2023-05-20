package Logica;

import java.io.Serializable;

public class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellidos;
	private String carnet_identidad;
	private int edad;
	private double salario;
	private int años_experiencia;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getAños_experiencia() {
		return años_experiencia;
	}
	public void setAños_experiencia(int años_experiencia) {
		this.años_experiencia = años_experiencia;
	}
	
	public Persona(String nombre, String apellidos, int edad, double salario, int años_experiencia,String carnet) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.salario = salario;
		this.años_experiencia = años_experiencia;
		this.carnet_identidad = carnet;
	}
	public String getCarnet_identidad() {
		return carnet_identidad;
	}
	public void setCarnet_identidad(String carnet_identidad) {
		this.carnet_identidad = carnet_identidad;
	}
	
	@Override
	public boolean equals(Object personal) {
		boolean verdad = false;
		if(this.nombre.equals(((Persona)personal).nombre) && this.carnet_identidad.equals(((Persona)personal).carnet_identidad) && this.apellidos.equals(((Persona)personal).apellidos)) {
			if(this.salario == ((Persona)personal).salario && this.edad == ((Persona)personal).edad && this.años_experiencia == ((Persona)personal).años_experiencia) {
				verdad = true;
			}
		}
		return verdad;
	}
}
