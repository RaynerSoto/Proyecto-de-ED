package Logica;

import java.io.Serializable;

public class Juegos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nombre;
	public String Genero_principal;
	public String Genero_secundario;
	public double gastos;
	public double beneficios;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero_principal() {
		return Genero_principal;
	}
	public void setGenero_principal(String genero_principal) {
		Genero_principal = genero_principal;
	}
	public String getGenero_secundario() {
		return Genero_secundario;
	}
	public void setGenero_secundario(String genero_secundario) {
		Genero_secundario = genero_secundario;
	}
	public double getGastos() {
		return gastos;
	}
	public void setGastos(double gastos) {
		this.gastos = gastos;
	}
	public double getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(double beneficios) {
		this.beneficios = beneficios;
	}
	public double ganancias() {
		return beneficios-gastos;
	}
	
	public Juegos(String nombre, String genero_principal, String genero_secundario, double gastos,double beneficios) {
		this.nombre = nombre;
		this.Genero_principal = genero_principal;
		this.Genero_secundario = genero_secundario;
		this.gastos = gastos;
		this.beneficios = beneficios;
	}
	@Override
	public  boolean equals(Object e) {
		boolean verdad=false;
		if(e instanceof Juegos) {
			if(this.nombre.trim().equalsIgnoreCase(((Juegos)e).getNombre().trim()) && this.Genero_principal.equals(((Juegos) e).getGenero_principal()) && this.Genero_secundario.equals(((Juegos)e).Genero_secundario)){
				verdad = true;
			}
		}
		return verdad;
	}
	
	
}
