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
	private int a�os_experiencia;
	
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
	public int getA�os_experiencia() {
		return a�os_experiencia;
	}
	public void setA�os_experiencia(int a�os_experiencia) {
		this.a�os_experiencia = a�os_experiencia;
	}
	
	public Persona(String nombre, String apellidos, int edad, double salario, int a�os_experiencia,String carnet) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.salario = salario;
		this.a�os_experiencia = a�os_experiencia;
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
			if(this.salario == ((Persona)personal).salario && this.edad == ((Persona)personal).edad && this.a�os_experiencia == ((Persona)personal).a�os_experiencia) {
				verdad = true;
			}
		}
		return verdad;
	}
}
