package ar.edu.unju.escmi.poo.util;

import ar.edu.unju.escmi.poo.dao.IPersonaDao;
import ar.edu.unju.escmi.poo.dao.imp.PersonaDaoImp;
import ar.edu.unju.escmi.poo.dominio.Agencia;
import ar.edu.unju.escmi.poo.dominio.Encargado;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Particular;

public class PersonaUtil {
	IPersonaDao personaDao = new PersonaDaoImp();
	public void cargarPersonas() {
		
		Particular p1 = new Particular("juan Manuel", "jcoro@gmail.com",780825,44645369,"Coro reader");
		personaDao.guardarPersona(p1);
		Particular p2 = new Particular("NIcole Magali", "niconi@gmail.com",25050,44645689,"Gimenez");
		personaDao.guardarPersona(p2);
		Particular p3 = new Particular("Cristian Alberto", "crcoha@gmail.com",789595,44655663,"Rocha");
		personaDao.guardarPersona(p3);
		Particular p4 = new Particular("Lucas Marcelo", "lmesconio@gmail.com",78787,44789123,"Mesconi");
		personaDao.guardarPersona(p4);
		Agencia a1 = new Agencia("jujuy top", "topjuy@gmail.com",38852195,693693);
		personaDao.guardarPersona(a1);
		Agencia a2 = new Agencia("north side", "norts@gmail.com",38852635,123123);
		personaDao.guardarPersona(a2);
		Mozo m1 = new Mozo("Mariano ",4468952, "Rodriguez",false,0);
		personaDao.guardarPersona(m1);
		Mozo m2 = new Mozo("Lucas",44444444, "Argota",false,0);
		personaDao.guardarPersona(m2);
		Mozo m3 = new Mozo("Santiago", 4468785, "Tintilay",false,0);
		personaDao.guardarPersona(m3);
		
		Encargado e1 = new Encargado("Carolina", "Profecaro","1234","Apaza");
		personaDao.guardarPersona(e1);
		Encargado e2 = new Encargado("GUstavo", "Gustso","1234","Sosa");
		personaDao.guardarPersona(e2);
		}
	
}
