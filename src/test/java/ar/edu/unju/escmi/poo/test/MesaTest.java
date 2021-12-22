package ar.edu.unju.escmi.poo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unju.escmi.poo.dominio.Mesa;

public class MesaTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando pruebas unitarias");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("finalizando pruebas");
	}

	@Test
	public void testVerificarCantidadDeMesas() {
		int cantComensales=5;
		Mesa mesa = new Mesa();
		int esperado=mesa.calcularCantMesas(cantComensales);
		int cantMesas=2;
		assertEquals(cantMesas,esperado);
	}
	
	@Test
	public void testVerificarCantidadDeMesas2() {
		int cantComensales=8;
		Mesa mesa = new Mesa();
		int esperado=mesa.calcularCantMesas(cantComensales);
		int cantMesas=2;
		assertEquals(cantMesas,esperado);
	}

}
