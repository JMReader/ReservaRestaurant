
package ar.edu.unju.escmi.poo.dominio;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Mozo")
public class Mozo extends Persona {
	// atributos de la clase mozo
	private long dni;
	private String apellido;
	private boolean estado; // si estado es igual a falso esta desocupado, si el estado es igual a verdadero
							// // esta ocupado
	private int cantReserva;
	@OneToMany(mappedBy = "mozoReserva")
	private List<Reserva> reservaDeMozo;

	// esta ocupado
	// constuctor de la clase mozo
	public Mozo() {
		// TODO Auto-generated constructor stub
	}

	public Mozo(String nombre, long dni, String apellido, boolean estado, int cantReserva) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.estado = estado;
		this.cantReserva = 0;
	}

	// gets y sets

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public int getCantReserva() {
		return cantReserva;
	}

	public void setCantReserva(int cantReserva) {
		this.cantReserva = cantReserva;
	}

	public List<Reserva> getReservaDeMozo() {
		return reservaDeMozo;
	}

	public void setReservaDeMozo(List<Reserva> reservaDeMozo) {
		this.reservaDeMozo = reservaDeMozo;
	}

	// to string

	@Override
	public String toString() {
		return "Mozo [dni=" + dni + ", apellido=" + apellido + ", estado=" + estado + ", cantReserva=" + cantReserva
				+ ", reservaDeMozo=" + reservaDeMozo + "]";
	}

}
