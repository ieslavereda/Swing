package frames;

import java.io.Serializable;

public class Alumno implements Comparable, Serializable {
	
	public static enum SEXO {
		HOMBRE,MUJER
	}

	private String nombre;
	private String apellidos;
	private int telefono;
	private String provincia;
	private SEXO sexo;
	private String dni;
	private int years;

	public Alumno(String nombre, String apellidos, int telefono, String provincia, SEXO sexo, String dni, int years) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.provincia = provincia;
		this.sexo = sexo;
		this.dni = dni;
		this.years = years;
	}
	public Alumno(String nombre, String apellidos, int telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;		
	}
	

	protected String getNombre() {
		return nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected int getTelefono() {
		return telefono;
	}

	protected String getProvincia() {
		return provincia;
	}

	protected SEXO getSexo() {
		return sexo;
	}

	protected String getDni() {
		return dni;
	}

	protected int getYears() {
		return years;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", provincia="
				+ provincia + ", sexo=" + sexo + ", dni=" + dni + ", years=" + years + "]";
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
