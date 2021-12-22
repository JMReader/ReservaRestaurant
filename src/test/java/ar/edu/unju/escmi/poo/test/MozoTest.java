package ar.edu.unju.escmi.poo.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unju.escmi.poo.dao.IPersonaDao;
import ar.edu.unju.escmi.poo.dao.imp.PersonaDaoImp;
import ar.edu.unju.escmi.poo.dominio.Mozo;

public class MozoTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando pruebas unitarias");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("finalizando pruebas");
	}

	@Test
	public void testVerificarObtenerMozo() {
		Mozo mozo = new Mozo("Mariano ",4468952, "Rodriguez",false,0);
		IPersonaDao personaDao = new PersonaDaoImp();
		Mozo mozobd = (Mozo) personaDao.obtenerMozo(4468952);
		assertEquals(mozo.getDni(),mozobd.getDni());
	}
	
	@Test
	public void testVerificarObtenerMozo2() {
		Mozo mozo = new Mozo("Santiago", 4468785, "Tintilay",false,0);
		IPersonaDao personaDao = new PersonaDaoImp();
		Mozo mozobd = (Mozo) personaDao.obtenerMozo(4468785);
		assertEquals(mozo.getDni(),mozobd.getDni());
	}

}
