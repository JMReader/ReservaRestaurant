package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IReservaDao;
import ar.edu.unju.escmi.poo.dominio.Reserva;

public class ReservaDaoImp implements IReservaDao{
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	public void guardarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(reserva);
		manager.getTransaction().commit();
	}
	@Override
	public List<Reserva> obtenerReservasSinPagar() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT p FROM Reserva p " + "WHERE p.estado =: cero");
		query.setParameter("cero", false);
		@SuppressWarnings("unchecked")
		List<Reserva> reservass = query.getResultList();
		return reservass;
	}
	@Override
	public List<Reserva> obtenerReservasPagadas() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT p FROM Reserva p " + "WHERE p.estado =: uno");
		query.setParameter("uno", true);
		@SuppressWarnings("unchecked")
		List<Reserva> reservass = query.getResultList();
		return reservass;
	}
	@Override
	public Reserva obtenerReserva(int id) {
		// TODO Auto-generated method stub
		
		Query query = manager.createQuery("SELECT r FROM Reserva r " + "WHERE r.idReserva = :idR");
		query.setParameter("idR", id);
		Reserva reservaEncontrada = (Reserva) query.getSingleResult();
	
		return reservaEncontrada;
	}
	
	@Override
	public void modificarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
        manager.getTransaction().begin();
        manager.merge(reserva);
        manager.getTransaction().commit();
	}
	
	@Override
	public List<Reserva> obtenerReservas() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT r FROM Reserva r");
		@SuppressWarnings("unchecked")
		List<Reserva> reservas = query.getResultList();
		return reservas;
	}
	@Override
	public void eliminarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		//manager.createNativeQuery("SET FOREIGN_KEY_CHECKS=0");
		manager.remove(reserva);
		manager.getTransaction().commit();
	}

}
