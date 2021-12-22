package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IPersonaDao;
import ar.edu.unju.escmi.poo.dominio.Persona;

public class PersonaDaoImp implements IPersonaDao {

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	IPersonaDao personaDao;
	public void guardarPersona(Persona persona) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(persona);
		manager.getTransaction().commit();
	}

	public void borrarPersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	public List<Persona> obtenerPersonas() {
		// TODO Auto-generated method stub
		
		Query query = manager.createQuery("SELECT p FROM Persona p ");
		
		List<Persona> personas = query.getResultList();
		
		return personas;
	}

	public void modificarPersona(Persona persona) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(persona);
		manager.getTransaction().commit();
	}

	public Persona obtenerPersona(long dniPersona) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Persona> obtenerClientesParticulares() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Persona> obtenerClientesAgencia() {
		// TODO Auto-generated method stub
		return null;
	}
//falta seguir modificando los metodos para guardar modificar o traer objetos de la base de datos

	public Persona obtenerParticular(long dni) {
		// TODO Auto-generated method stub
		// consulta dinámica usando un parámetro para dni de empleado
		Query query = manager.createQuery("SELECT p FROM Persona p " + "WHERE p.dni = :dniPersona");
		query.setParameter("dniPersona", dni);
		Persona particularEncontrado = (Persona) query.getSingleResult();
		return particularEncontrado;
	}

	public Persona obtenerAgencia(long cuit) {
		// TODO Auto-generated method stub
		// consulta dinámica usando un parámetro para dni de empleado
		Query query = manager.createQuery("SELECT p FROM Persona p " + "WHERE p.cuit = :cuitPersona");
		query.setParameter("cuitPersona", cuit);
		Persona agenciaEncontrada = (Persona) query.getSingleResult();
		return agenciaEncontrada;
	}

	public Persona obtenerMozo(long dni) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT p FROM Persona p " + "WHERE p.dni = :dniMozo");
		query.setParameter("dniMozo", dni);
		Persona mozoEncontrado = (Persona) query.getSingleResult();
		return mozoEncontrado;
		
	}

	public List<Persona> obtenerMozos() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT p FROM Persona p " + "WHERE p.estado =: cero OR p.estado =: uno");
		query.setParameter("uno", true);
		query.setParameter("cero", false);
		@SuppressWarnings("unchecked")
		List<Persona> mozos = query.getResultList();
		return mozos;
			
	}

	@Override
	public List<Persona> obtenerEncargados() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT p FROM Persona p " + "WHERE p.contrasenia >:cero");
		query.setParameter("cero", " ");
		@SuppressWarnings("unchecked")
		List<Persona> encargados = query.getResultList();
		return encargados;
	}

}
