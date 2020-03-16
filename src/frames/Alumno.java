package frames;

import java.io.Serializable;

public class Alumno implements Serializable{
	
	private String nombre;
	private String apellidos;
	private int telefono;
	
	public Alumno(String nombre, String apellidos, int telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public int getTelefono() {
		return telefono;
	}
}
