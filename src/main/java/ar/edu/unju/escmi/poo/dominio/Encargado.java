package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Encargado")
public class Encargado extends Persona {
	// atributos de la clase encargado el cual controlara el sistema
	private String usuario;
	private String contrasenia; // decidimos ponerle usuario y contrase�a para darle mas seguridad a la
	// aplicacion y que no cualquiera pueda crear reservas.
	private String apellido;

	// constructor de la clase// constructor de la clase
	public Encargado() {
		// TODO Auto-generated constructor stub
	}

	public Encargado(String nombre, String usuario, String contrasenia, String apellido) {
		super(nombre);
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.apellido = apellido;
	}

	// gets y sets
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
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
		return "Encargado [usuario=" + usuario + ", contrasenia=" + contrasenia + ", apellido=" + apellido
				+ ", getNombre()=" + getNombre() + ", getId()=" + getId() + "]";
	}



}
