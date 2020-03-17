package frames;

import java.io.Serializable;

public class Alumno implements Comparable, Serializable {

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

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + "]";
	}

	@Override
	public int compareTo(Object o) {
		Alumno a = (Alumno) o;
		if (apellidos.compareToIgnoreCase(a.getApellidos()) != 0)
			return apellidos.compareToIgnoreCase(a.getApellidos());
		else
			return nombre.compareToIgnoreCase(a.getNombre());
	}

}
