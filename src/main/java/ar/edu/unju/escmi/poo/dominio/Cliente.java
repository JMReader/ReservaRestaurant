package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.Entity;

@Entity
public abstract class Cliente extends Persona {

	// atributos de la clase cliente, la cual es abstracta porque no se puede genera
	// como si un cliente solo, el cliente debe ser particular o una agencia
	private String email;
	private long telefono;

	// constructor de la clase cliente
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String email, long telefono) {
		super(nombre);
		this.email = email;
		this.telefono = telefono;
	}
	// gets y sets

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [email=" + email + ", telefono=" + telefono + "]";
	}

	

}
