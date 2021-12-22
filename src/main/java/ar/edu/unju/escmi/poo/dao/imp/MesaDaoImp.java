package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IMesaDao;
import ar.edu.unju.escmi.poo.dominio.Mesa;


public class MesaDaoImp implements IMesaDao{
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	public void guardarMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(mesa);
		manager.getTransaction().commit();
	}

	public void modificarMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(mesa);
		manager.getTransaction().commit();
		
	}

	public List<Mesa> obtenerMesasSegunSalon(int salon) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT m FROM Mesa m Where m.salon=:salonn AND m.estado =0");
		query.setParameter("salonn", salon);
		@SuppressWarnings("unchecked")
		List<Mesa> mesas = (List<Mesa>)query.getResultList();
		return mesas;
	}

	@Override
	public List<Mesa> obtenerMesasOcupadas() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT m FROM Mesa m Where m.estado=:ocupado");
		query.setParameter("ocupado", true);
		@SuppressWarnings("unchecked")
		List<Mesa> mesas = (List<Mesa>)query.getResultList();
		return mesas;
	}

	@Override
	public List<Mesa> obtenerMesasLibres() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT m FROM Mesa m Where m.estado=:libre");
		query.setParameter("libre", false);
		@SuppressWarnings("unchecked")
		List<Mesa> mesas = (List<Mesa>)query.getResultList();
		return mesas;
	}




}
