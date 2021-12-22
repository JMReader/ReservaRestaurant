package ar.edu.unju.escmi.poo.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {

	// atributos de la clase reserva
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	private int cantComensales;
	private boolean estado; // si estado igual a true la cuenta estara pagada, de caso contrario no lo
							// estara
	private LocalDate fechaReserva;
	private double montoTotal;
	private LocalTime horaReserva;
	@OneToMany(mappedBy = "mesaReserva")
	private List<Mesa> mesaReserva;
	@ManyToOne
	@JoinColumn(name = "idMozo")
	private Mozo mozoReserva;
	
	@OneToOne
	@JoinColumn(name = "idCliente")
	private Cliente clienteReserva;

	// constructors
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	// gets y sets

	public Reserva(int idReserva, int cantComensales, boolean estado, LocalDate fechaReserva, double montoTotal,
			LocalTime horaReserva, List<Mesa> mesaReserva, Mozo mozoReserva) {
		super();
		this.idReserva = idReserva;
		this.cantComensales = cantComensales;
		this.estado = estado;
		this.fechaReserva = fechaReserva;
		this.montoTotal = montoTotal;
		this.horaReserva = horaReserva;
		this.mesaReserva = mesaReserva;
		this.mozoReserva = mozoReserva;
	}

	public Cliente getClienteReserva() {
		return clienteReserva;
	}

	public void setClienteReserva(Cliente clienteReserva) {
		this.clienteReserva = clienteReserva;
	}

	public int getCantComensales() {
		return cantComensales;
	}

	public List<Mesa> getMesaReserva() {
		return mesaReserva;
	}

	public void setMesaReserva(List<Mesa> mesaReserva) {
		this.mesaReserva = mesaReserva;
	}

	public Mozo getMozoReserva() {
		return mozoReserva;
	}

	public void setMozoReserva(Mozo mozoReserva) {
		this.mozoReserva = mozoReserva;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public void setCantComensales(int cantComensales) {
		this.cantComensales = cantComensales;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public LocalTime getHoraReserva() {
		return horaReserva;
	}

	public void setHoraReserva(LocalTime horaReserva) {
		this.horaReserva = horaReserva;
	}

	// to string

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", cantComensales=" + cantComensales + ", estado=" + estado
				+ ", fechaReserva=" + fechaReserva + ", montoTotal=" + montoTotal + ", horaReserva=" + horaReserva
				+ ", mozoReserva=" + mozoReserva.getApellido() + "]";
	}

}
