package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Mesa;

public interface IMesaDao {
	public void guardarMesa(Mesa mesa);
	public void modificarMesa(Mesa mesa);
	public List<Mesa> obtenerMesasSegunSalon(int salon);
	public List<Mesa> obtenerMesasOcupadas();
	public List<Mesa> obtenerMesasLibres();
}
