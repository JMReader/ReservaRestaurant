package ar.edu.unju.escmi.poo.util;

import ar.edu.unju.escmi.poo.dao.IMesaDao;
import ar.edu.unju.escmi.poo.dao.imp.MesaDaoImp;
import ar.edu.unju.escmi.poo.dominio.Mesa;

public class MesasUtil {
	public void cargarMesas() {
		IMesaDao mesaDao = new MesaDaoImp();
		for (int i = 0; i < 20; i++) {
			// Reserva reserva = new Reserva(0, false, null, 0, null, null, null);
			Mesa mesa = new Mesa(1, false);
			mesaDao.guardarMesa(mesa);
		}
		for (int o = 0; o < 10; o++) {
			// Reserva reserva = new Reserva(0, false, null, 0, null, null, null);
			Mesa mesa = new Mesa(2, false);
			mesaDao.guardarMesa(mesa);
		}
	}
	
}
