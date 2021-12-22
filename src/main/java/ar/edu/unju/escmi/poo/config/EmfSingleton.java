package ar.edu.unju.escmi.poo.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Clase que define la única instancia para el objeto entity manager factory
 * necesario para realizar todas las transacciones en la bd.
 */
public class EmfSingleton {
	
	private static EmfSingleton miInstancia = new EmfSingleton();
	static private final String PERSISTENCE_UNIT_NAME = "PersistenceTpFinal";
	private EntityManagerFactory emf = null;

	public static EmfSingleton getInstance() {
		return miInstancia;
	}

	private EmfSingleton() {
		
	}

	public EntityManagerFactory getEmf() {
		if (this.emf == null)
			this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		return this.emf;
	}


}
