package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Agencia")
public class Agencia extends Cliente {
	// atributo de la clase agencia
	private long cuit;

	// constructores de la clase

	public Agencia() {
		// TODO Auto-generated constructor stub
	}

	public Agencia(String nombre, String email, long telefono, long cuit) {
		super(nombre, email, telefono);
		this.cuit = cuit;
	}

	// gets y sets
	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	// to string

	@Override
	public String toString() {
		return "Agencia [cuit=" + cuit + ", getEmail()=" + getEmail() + ", getTelefono()=" + getTelefono()
				+ ", getNombre()=" + getNombre() + ", getId()=" + getId() + "]";
	}

}
