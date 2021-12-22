package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // esto indica que en una sola tabla estaran los clientes, los
														// mozos y los encargados
@DiscriminatorColumn(name = "Tipo", discriminatorType = DiscriminatorType.STRING)
//@NamedQuery(name="listarMozos",query="SELECT m FROM Mozo m")
public abstract class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// atributo de nombre el cual comparten todas las clases
	private String nombre;

	// constructor vacio
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	// constructor de la clase persona, no se coloca id, pues se genera
	// automaticamente
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	// gets y setters del nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// to string de la clase
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}

}
