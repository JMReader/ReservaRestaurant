package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Particular")
public class Particular extends Cliente {

	private String apellido;
	// atributo cliente
	private long dni;

	// constructor de la clase
	public Particular() {
		// TODO Auto-generated constructor stub
	}

	public Particular(String nombre, String email, long telefono, long dni, String apellido) {
		super(nombre, email, telefono);
		this.dni = dni;
		this.apellido = apellido;
	}

	// gett y sets
	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	// to string
	@Override
	public String toString() {
		return "Particular [dni=" + dni + ", getEmail()=" + getEmail() + ", getTelefono()=" + getTelefono()
				+ ", getNombre()=" + getNombre() + ", getId()=" + getId() + ", Apellido()=" + apellido + "]";
	}

}
