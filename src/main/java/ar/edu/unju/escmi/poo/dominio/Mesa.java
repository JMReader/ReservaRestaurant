package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mesas")
public class Mesa {
	// atributos de la clase mesa
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMesa;
	private int salon;
	private boolean estado; // falso desocupada
	@ManyToOne
	@JoinColumn(name = "idReserva")
	private Reserva mesaReserva;

	// constructor

	public Mesa() {
		// TODO Auto-generated constructor stub
	}

	public Mesa(int salon, boolean estado) {
		super();
		this.salon = salon;
		this.estado = estado;
	}

	public Reserva getMesaReserva() {
		return mesaReserva;
	}

	public void setMesaReserva(Reserva mesaReserva) {
		this.mesaReserva = mesaReserva;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	// Gets y sets
	public int getSalon() {
		return salon;
	}

	public void setSalon(int salon) {
		this.salon = salon;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	// atributo unir mesas que nos servira para contra los lugares que quedaran en
	// caso de que se unan las mesas
	public int calcularCantMesas(int cantComensales) {
		int cantMesas;
		if (cantComensales % 4 == 0) {
			cantMesas = cantComensales / 4;
		} else {
			cantMesas = cantComensales / 4 + 1;
		}
		return cantMesas;
	}

	// to string
	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", salon=" + salon + ", estado=" + estado + ", mesaReserva=" + mesaReserva
				+ "]";
	}

}
