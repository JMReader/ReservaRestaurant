package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Persona;

public interface IPersonaDao {
	public void guardarPersona(Persona persona);
	public void borrarPersona(Persona persona);
	public List<Persona> obtenerPersonas();
	public void modificarPersona(Persona persona);
	public Persona obtenerParticular(long dni);
	public Persona obtenerAgencia(long cuit);
	public Persona obtenerMozo(long dni);
	public List<Persona> obtenerEncargados();
	public List<Persona> obtenerClientesParticulares();
	public List<Persona> obtenerClientesAgencia();
	public List<Persona> obtenerMozos();
	//falta seguir modificando
}
