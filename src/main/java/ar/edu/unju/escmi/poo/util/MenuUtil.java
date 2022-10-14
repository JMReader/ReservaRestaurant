package ar.edu.unju.escmi.poo.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dao.IMesaDao;
import ar.edu.unju.escmi.poo.dao.IPersonaDao;
import ar.edu.unju.escmi.poo.dao.IReservaDao;
import ar.edu.unju.escmi.poo.dao.imp.MesaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.PersonaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.ReservaDaoImp;
import ar.edu.unju.escmi.poo.dominio.Agencia;
import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Mesa;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Particular;
import ar.edu.unju.escmi.poo.dominio.Persona;
import ar.edu.unju.escmi.poo.dominio.Encargado;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuUtil {


	Persona particularEncontrado = null;
	boolean encontrado = false;
	Scanner sc = new Scanner(System.in);
	Persona agenciaEncontrada = null;
	IPersonaDao personaDao = new PersonaDaoImp();
	IMesaDao mesaDao = new MesaDaoImp();
	IReservaDao reservaDao = new ReservaDaoImp();
	Persona mozoEncontrado = null;

	public void cargarBd(){
		MesasUtil mesaAux = new MesasUtil();
		PersonaUtil personau = new PersonaUtil();
		// Cargaremos las personas y mesas siempre y cuando  no esten anteriormente cargadas en la base de datos
		IPersonaDao personaDao = new PersonaDaoImp();
		//si se encuentra una persona o mesa significa que la base de datos esta cargada.
		List<Persona> personas= personaDao.obtenerPersonas();
		if(personas.size()==0) {
			mesaAux.cargarMesas();
			personau.cargarPersonas();
		}else {
			System.out.println("Base de datos cargada anteriormente");
		}
	}
	
			
	public void mostrarOpciones() {
		System.out.println("1 - Hacer reserva");
		System.out.println("2 - Pagar reserva");
		System.out.println("3 - Elimina reserva");
		System.out.println("4 - Mostrar reservas");
		System.out.println("5 - Dar de alta a un mozo");
		System.out.println("6 - Mostrar mozos");
		System.out.println("7 - Consultar mesas disponibles");
		System.out.println("8 - Consultar mesas ocupadas");
		System.out.println("9 - Salir del programa");
		System.out.println("Elija una opcion:");
	}

	public void login(){
		
			List<Persona> encargados = personaDao.obtenerEncargados();
			boolean bandera=true;
			do {
				System.out.println("ingrese nombre de usuario");
				String usuario = sc.next();
				System.out.println("ingrese contraseña");
				String contrasena = sc.next();
				
				
				for (int i = 0; i < encargados.size(); i++) {
					
					
					if (((Encargado)encargados.get(i)).getUsuario().equals(usuario)
							&& ((Encargado)encargados.get(i)).getContrasenia().equals(contrasena)) {
						System.out.println("Encargado loggeado correctamente");
						bandera=false;
						break;
					}
					
					}
				if(bandera==true) {
					System.out.println("El usuario o la contrasenia no coinciden");
				}
			}while(bandera==true);
			
		
	}
	
	
	
	
	public void opcion1() {
		//pregunto si hay mesas libres
		List<Mesa> totalMesas = null;
		totalMesas = mesaDao.obtenerMesasLibres();

		int cantMesasEnTotal = 0;
		for (int e = 0; e < totalMesas.size(); e++) {
			if (totalMesas.get(e).isEstado() == false) {
				cantMesasEnTotal++;
			}
		}

		if (totalMesas.isEmpty()) {//si no hay mesas libres no se ejecuta la opcion 1
			System.out.println("No hay mesas suficientes en los salones");
		} else {

			boolean hayError = false;
			boolean eSunoODos = true;
			int opc1 = 0;
			do {
				System.out.println("Seleccione una opcion");
				System.out.println("1 - Cliente Particular");
				System.out.println("2 - Cliente Agencia");
				try {
					hayError = false;
					opc1 = IntUtil.pedirInt();
				} catch (Exception e) {
					System.out.println(e.toString());
					System.out.println("Solo valores enteros");
					hayError = true;
				}
				if (opc1 != 1 && opc1 != 2) {
					eSunoODos = false;
					System.out.println("Solo valor 1 o 2");
				} else
					eSunoODos = true;
			} while (hayError || (eSunoODos == false));
			boolean encontrado = false;
			Persona personaEncontrada = null;

			Reserva reserva = new Reserva();
			switch (opc1) {
			case 1://cargando un cliente particular

				long dni = 0;
				do {
					System.out.println("Ingrese dni:");
					try {
						hayError = false;
						dni = LongUtil.pedirLong();
					} catch (Exception e) {
						System.out.println(e.toString());
						hayError = true;
					}
				} while (hayError);

				try {
					encontrado = true;
					personaEncontrada = personaDao.obtenerParticular(dni);
				} catch (Exception e) {
					e.getMessage();
					encontrado = false;
				}

				// si no se encontro al cliente, se lo agrega
				if (encontrado == false) {

					Particular cliente = new Particular();

					boolean seRepite;
					do {// evitara que se aniadan dni ya existentes
						seRepite = false;
						boolean bandera = true;
						do {
							bandera = true;
							System.out.println("Cliente inexsistente, proceda a crearlo.");
							System.out.println("Ingrese dni :");
							dni = 0;
							try {
								dni = LongUtil.pedirLong();
							} catch (Exception e) {
								System.out.println(e.toString());
								System.out.println("ingrese un numero entero \n");
								bandera = false;
							}
						} while (!bandera);

						try {
							seRepite = true;
							personaEncontrada = personaDao.obtenerParticular(dni);
						} catch (Exception e) {
							e.getMessage();
							seRepite = false;
						}
					} while (seRepite == true);

					cliente.setDni(dni);
					sc.nextLine();
					System.out.println("Ingrese nombre:");
					cliente.setNombre(sc.nextLine());

					System.out.println("Ingrese apellido:");
					cliente.setApellido(sc.nextLine());

					System.out.println("Ingrese email:");
					cliente.setEmail(sc.nextLine());

					// hace falta try catch
					long tel = 0;
					hayError = false;

					do {
						System.out.println("Ingrese telefono:");
						try {
							tel = LongUtil.pedirLong();
							hayError = false;
						} catch (Exception e) {
							System.out.println(e.toString());
							System.out.println("ingrese un numero entero \n");
							hayError = true;
						}
					} while (hayError);
					cliente.setTelefono(tel);
					personaEncontrada=cliente;
					personaDao.guardarPersona(cliente);
					

				} else {// se encontro el cliente
					System.out.println(personaEncontrada);
				}

				break;
			case 2://cargando un cliente agencia
				System.out.println("Ingrese cuit:");
				long cuit = 0;
				hayError = false;
				do {
					hayError = false;
					try {
						cuit = LongUtil.pedirLong();
					} catch (Exception e) {
						System.out.println("Ingrese numeros enteros");
					}
				} while (hayError);
				try {
					encontrado = true;
					personaEncontrada = personaDao.obtenerAgencia(cuit);
				} catch (Exception e) {
					e.getMessage();
					encontrado = false;
				}

				// si no se encontro al cliente, se lo agrega
				if (encontrado == false) {

					Agencia cliente = new Agencia();

					boolean seRepite;
					do {// evitara que se aniadan dni ya existentes
						seRepite = false;
						boolean bandera = true;
						do {
							bandera = true;
							System.out.println("Cliente no encontrado. Procede a crear uno");
							System.out.println("Ingrese cuit");
							cuit = 0;
							try {
								cuit = LongUtil.pedirLong();
							} catch (Exception e) {
								System.out.println(e.toString());
								System.out.println("ingrese un numero entero \n");
								bandera = false;
							}
						} while (!bandera);

						try {
							seRepite = true;
							personaEncontrada = personaDao.obtenerAgencia(cuit);
						} catch (Exception e) {
							e.getMessage();
							seRepite = false;
						}
					} while (seRepite == true);

					cliente.setCuit(cuit);
					sc.nextLine();
					System.out.println("Ingrese nombre:");
					cliente.setNombre(sc.nextLine());
					System.out.println("Ingrese email:");
					cliente.setEmail(sc.nextLine());

					long tel = 0;
					hayError = false;
					do {
						System.out.println("Ingrese telefono:");
						try {
							hayError = false;
							tel = LongUtil.pedirLong();
						} catch (Exception e) {
							hayError = true;
							System.out.println("Solo numeros y sin espacios");
							System.out.println(e.toString());
						}
					} while (hayError);
					cliente.setTelefono(tel);

					personaDao.guardarPersona(cliente);
					personaEncontrada=cliente;

				}

				break;

			}
			
			//verificando si hay mesas en alguno de los salones
			List<Mesa> MesasSalonUno = null;
			MesasSalonUno = mesaDao.obtenerMesasSegunSalon(1);

			int cantMesasSalonUno = 0;
			for (int e = 0; e < MesasSalonUno.size(); e++) {
				if (MesasSalonUno.get(e).isEstado() == false) {
					cantMesasSalonUno++;
				}
			}

			List<Mesa> MesasSalonDos = null;
			MesasSalonDos = mesaDao.obtenerMesasSegunSalon(2);

			int cantMesasSalonDos = 0;
			for (int e = 0; e < MesasSalonDos.size(); e++) {
				if (MesasSalonDos.get(e).isEstado() == false) {
					cantMesasSalonDos++;
				}
			}

			int selectSalon = 0;
			if (cantMesasSalonUno == 0 && cantMesasSalonDos != 0) {
				System.out.println("Solo hay lugares en el salon 2");
				selectSalon = 2;
			} else {
				if (cantMesasSalonUno != 0 && cantMesasSalonDos == 0) {
					System.out.println("Solo hay lugares en el salon 1");
					selectSalon = 1;
				} else {
					hayError = false;

					do {// selectSalon solo puede ser 1 o 2
						System.out.println("Ingrese Salon que desea registrar su reserva");
						System.out.println("1 - Salon 1");
						System.out.println("2 - Salon 2");
						try {
							hayError = false;
							selectSalon = IntUtil.pedirInt();
						} catch (Exception e) {
							System.out.println(e.toString());
							hayError = true;
						}
						if (selectSalon == 1 || selectSalon == 2) {
							eSunoODos = true;
						} else {
							System.out.println("Solo valor 1 o 2");
							eSunoODos = false;
						}

					} while (hayError || (!eSunoODos));
				}
			}
			
			
			List<Mesa> mesasSalon = null;
			switch (selectSalon) {
			case 1:
				mesasSalon = mesaDao.obtenerMesasSegunSalon(selectSalon);
				break;
			case 2:
				mesasSalon = mesaDao.obtenerMesasSegunSalon(selectSalon);
				break;
			}

			cantMesasEnTotal = 0;
			for (int e = 0; e < mesasSalon.size(); e++) {
				if (mesasSalon.get(e).isEstado() == false) {
					cantMesasEnTotal++;
				}
			}

			System.out.println("Mesas disponibles " + cantMesasEnTotal);
			System.out.println("Cantidad de lugares disponibles: " + cantMesasEnTotal * 4);

			hayError = false;
			int ocuparMesas = 0;
			boolean menorAUno = false;
			boolean suficientesMesas = true;
			do {
				System.out.println("Ingrese cantidad de comensales: ");
				try {
					hayError = false;
					ocuparMesas = IntUtil.pedirInt();
				} catch (Exception e) {
					hayError = true;
					System.out.println(e.toString());
					System.out.println("Solo numeros enteros");
				}

				if (ocuparMesas < 1) {
					System.out.println("El valor debe ser mayor a 0");
					menorAUno = true;
				} else {
					menorAUno = false;
				}

				if (ocuparMesas > (cantMesasEnTotal * 4)) {
					suficientesMesas = false;
					System.out.println("No hay suficientes mesas");
				} else {
					suficientesMesas = true;
				}
			} while (hayError || menorAUno || !suficientesMesas);
			reserva.setCantComensales(ocuparMesas);
			reserva.setEstado(false);
			reserva.setFechaReserva(LocalDate.now());
			System.out.println("Se cargo la fecha actual");
			reserva.setHoraReserva(LocalTime.now());
			System.out.println("Se cargo la hora actual");

			//cambiando y asignando el estado de las mesas segun la reserva a crear
			List<Persona> mozos = new ArrayList<Persona>();
			Mozo mozoDisponible = null;
			mozos = personaDao.obtenerMozos();
			for (int i = 0; i < mozos.size(); i++) {
				if (((Mozo) mozos.get(i)).isEstado() == false) {
					mozoDisponible = ((Mozo) mozos.get(i));
					mozoDisponible.setCantReserva(mozoDisponible.getCantReserva() + 1);
					reserva.setMozoReserva(mozoDisponible);
					if (mozoDisponible.getCantReserva() == 4) {
						mozoDisponible.setEstado(true);
					}
					personaDao.modificarPersona(mozoDisponible);
					break;
				}

			}
			reserva.setClienteReserva((Cliente) personaEncontrada);
			reservaDao.guardarReserva(reserva);
			Mesa mesaDisponible = new Mesa();
			List<Mesa> mesasParaReserva = new ArrayList<Mesa>();
			
			//ocuparmesas es la cantidad de comensales, luego le asigno la cantidad de mesas
			ocuparMesas= mesaDisponible.calcularCantMesas(ocuparMesas);
			
			int aux = 0;
			for (int i = 0; i < mesasSalon.size(); i++) {
				if (mesasSalon.get(i).isEstado() == false) {
					mesaDisponible = mesasSalon.get(i);
					mesaDisponible.setEstado(true);
					mesaDisponible.setMesaReserva(reserva);
					mesasParaReserva.add(mesaDisponible);
					mesaDao.modificarMesa(mesaDisponible);

					aux++;

				}
				if (aux == ocuparMesas) {
					break;
				}
			}
			reserva.setMesaReserva(mesasParaReserva);
		}
	}

	public void opcion2() {
		
		if(reservaDao.obtenerReservasSinPagar().size()>0) {
		System.out.println("Reservas sin pagar: ");
		reservaDao.obtenerReservasSinPagar().stream().forEach(System.out::println);

		// esta estructura repetitiva termina cunado ingresamos un id de reserva que
		// este cargado en el programa, para pagarlo
		Reserva auxiliar = null;
		boolean hayError = false;// significa que no hay error
		do {
			int aux = 0;
			hayError = false;
			System.out.println("Ingresar id de la reserva que quiere pagar:");
			do {
				try {// Evitar la entrada de string en variables int
					aux = IntUtil.pedirInt();
					hayError = false;
				} catch (Exception e) {
					hayError = true;
					System.out.println(e.toString());
					System.out.println("Ingrese un valor entero");
				}
			} while (hayError);

			try {// se controlora que se busque la reserva y que su estado sea no pagado (false)
				auxiliar = reservaDao.obtenerReserva(aux);
				if (auxiliar.isEstado() == true) {
					auxiliar = null;
					System.out.println("La reserva con ese id ya fue pagada");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				auxiliar = null;
				System.out.println("ese id de reserva no existe, por favor ingrese uno cargado en el programa");
			}

		} while (auxiliar == null);// si termina este bucle, se encontrara la reserva no pagada (que seria auxiliar)
		
		
		
		hayError=false;
		boolean esMenorACero = false;
		
		
		double auxd=0;
		do {
            System.out.println("Ingrese total a pagar: ");
            try {// Evitar la entrada de string en variables int

                auxd = DoubleUtil.pedirDouble();
                hayError = false;
            } catch (Exception e) {
                hayError = true;
                System.out.println(e.toString());
                System.out.println("Ingrese un valor entero");
            }
            if (auxd < 1) {
                System.out.println("El precio no puede ser negativo");
                esMenorACero = true;
            } else {
                esMenorACero = false;
            }

        } while (hayError && esMenorACero);
		
		
		
		auxiliar.setMontoTotal(auxd);
		
		
		
		
		hayError = false;// significa que no hay error
		boolean band = true;
		do {// se repite hasta que el efectivo supere el precio de la reserva
			System.out.println("ingrese el monto con el que se va a pagar la reserva");
			double efectivo = 0;
			do {
				try {// efectivo solo puede ser o entero o double, no string
					hayError = false;
					efectivo = DoubleUtil.pedirDouble();
				} catch (Exception e) {
					System.out.println("ingrese un numero entero o decimal \n");
					System.out.println(e.getMessage());
					hayError = true;
				}
			} while (hayError == true);

			if (efectivo < auxiliar.getMontoTotal()) {
				System.out.println("Es imposible pagar la mesa con esa cantidad de efectivo, es menor al costo");
			} else {// se calcula el vuelto, y se modifica el estado de reserva a pagado(true)
				double vuelto = efectivo - auxiliar.getMontoTotal();
				System.out.println("Reserva pagada, el vuelto a entregar es igual a $ " + vuelto);
				auxiliar.setEstado(true);
				reservaDao.modificarReserva(auxiliar);
				band = false;
				Mesa mesaDisponible;
				Mozo mozoDisponible = null;
				List<Mesa> mesasSalon = auxiliar.getMesaReserva();
				// desvinculo al padre mesa del hijo reserva
				for (int i = 0; i < mesasSalon.size(); i++) {
					mesaDisponible = mesasSalon.get(i);
					mesaDisponible.setEstado(false);
					mesaDisponible.setMesaReserva(null);
					mesaDao.modificarMesa(mesaDisponible);
				}
				mozoDisponible = auxiliar.getMozoReserva();
				mozoDisponible.setCantReserva(mozoDisponible.getCantReserva() - 1);
				mozoDisponible.setEstado(false);
				personaDao.modificarPersona(mozoDisponible);
			}
		} while (band == true);
		}else {
			System.out.println("No hay reservas que se encuentren sin pagar");
		}
	}

	public void opcion3() {
		//se eliminan las reservas sin pagar por si estas fueran canceladas, no se pueden borrar las ya pagadas porque quedan como registro
		if(reservaDao.obtenerReservasSinPagar().size()>0) {
		boolean hayError = false;
		int aux = 0;
		Reserva reservaEliminar = null;
		reservaDao.obtenerReservasSinPagar().stream().forEach(System.out::println);

		do {// se repetira hasta que ingrese una reserva cargada en el sistema
			System.out.println("ingrese el id de la reserva que quiere eliminar");
			try {// Evitar la entrada de string en variables int
				aux = IntUtil.pedirInt();
				reservaEliminar = reservaDao.obtenerReserva(aux);
				hayError = false;
			} catch (Exception e) {
				hayError = true;
				reservaEliminar = null;
				System.out.println(e.toString());
				System.out.println("El id ingresado de reserva no existe");
				System.out.println("Ingrese un valor entero");
			}
		} while (hayError);

		System.out.println(reservaEliminar);
		Mesa mesaDisponible;
		Mozo mozoDisponible = null;
		List<Mesa> mesasSalon = reservaEliminar.getMesaReserva();
		// desvinculo al padre mesa del hijo reserva
		for (int i = 0; i < mesasSalon.size(); i++) {
			mesaDisponible = mesasSalon.get(i);
			mesaDisponible.setEstado(false);
			mesaDisponible.setMesaReserva(null);
			mesaDao.modificarMesa(mesaDisponible);
		}
		mozoDisponible = reservaEliminar.getMozoReserva();
		mozoDisponible.setCantReserva(mozoDisponible.getCantReserva() - 1);
		mozoDisponible.setEstado(false);
		personaDao.modificarPersona(mozoDisponible);
		reservaDao.eliminarReserva(reservaEliminar);
		System.out.println("Reserva eliminada correctamente");
		}else {
			System.out.println("Ninguna reserva cargada es apta para borrarse");
		}
	}

	public void opcion4() {
		reservaDao.obtenerReservas().stream().forEach(System.out::println);
	}

	public void opcion5() {
		Mozo mozoNuevo =new Mozo();
		if(personaDao.obtenerMozos().size()<6) {  
	        long dnim = 0;
	        boolean hayError = false;
	        encontrado = true;
	        do {
	            System.out.println("Ingrese dni del nuevo mozo:");
	            hayError = false;
	            encontrado = true;
	            try {
	                dnim = LongUtil.pedirLong();
	            } catch (Exception e) {
	                hayError = true;
	                System.out.println("Solo numeros enteros");
	                System.out.println(e.toString());
	            }

	            if (!hayError) {
	                encontrado = true;
	                try {
	                    mozoEncontrado = personaDao.obtenerMozo(dnim);
	                    System.out.println("Dni repetido");
	                } catch (Exception e) {
	                    encontrado = false;
	                }
	            }
	        } while (hayError || encontrado);
	        // si no se encontro al cliente, se lo agrega

	        
	        mozoNuevo.setDni(dnim);
	        System.out.println("Dni cargado con exito");
	        sc.nextLine();
	        System.out.println("Ingrese nombre:");
	        mozoNuevo.setNombre(sc.nextLine());
	        System.out.println("Ingrese apellido:");
	        mozoNuevo.setApellido(sc.nextLine());
	        mozoNuevo.setEstado(false);
	        personaDao.guardarPersona(mozoNuevo);

		}else {
			System.out.println("La capacidad maxima de mozos fue alcanzada");
		}
}
	

	public void opcion6() {
		// en persona dao se llama a la lista obtener mozos y se lista con el for each
		personaDao.obtenerMozos().stream().forEach(System.out::println);
	}

	public void opcion7() {
		System.out.println("Mesas libres \n");
		mesaDao.obtenerMesasLibres().stream().forEach(System.out::println);
	}

	public void opcion8() {
		System.out.println("Mesas Ocupadas \n");
		mesaDao.obtenerMesasOcupadas().stream().forEach(System.out::println);
	}

}
