package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Reserva;

public interface IReservaDao {
	public void guardarReserva(Reserva reserva);
	public List<Reserva> obtenerReservasSinPagar();
	public List<Reserva> obtenerReservasPagadas();
	public Reserva obtenerReserva(int id);
	public void modificarReserva(Reserva reserva);
	List<Reserva> obtenerReservas();
	public void eliminarReserva(Reserva reserva);
}
