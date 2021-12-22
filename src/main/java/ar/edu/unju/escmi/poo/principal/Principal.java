
package ar.edu.unju.escmi.poo.principal;

import java.util.Scanner;

import ar.edu.unju.escmi.poo.util.MenuUtil;

import ar.edu.unju.escmi.poo.util.IntUtil;

public class Principal {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);

		int opc = 0;
		
		MenuUtil menu = new MenuUtil();
		//controlara si se debe cargar la base de datos
		menu.cargarBd();
		//pedira el ingreso de un usuario al sistema 
		menu.login();
		do {
			menu.mostrarOpciones();
			boolean band = true;
			do {
				try {
					band = false;
					opc = IntUtil.pedirInt();
				} catch (Exception e) {
					System.out.println("ingrese un numero entero \n");
					e.getMessage();
					band = true;
				}
			} while (band == true);

			switch (opc) {

			case 1: {
				menu.opcion1();

				break;
			}
			case 2: {

				menu.opcion2();

				break;
			}
			case 3:
				menu.opcion3();
				break;
			case 4:
				menu.opcion4();
				break;
			case 5: {
				menu.opcion5();
				break;

			}
			case 6: {
				menu.opcion6();
			}

				break;
			case 7: {
				menu.opcion7();
			}

				break;

			case 8: {
				menu.opcion8();
				break;
			}
			case 9: {
				System.out.println("--------------Programa Finalizado--------------");
				break;
			}
			default:

				break;
			}
		} while (opc != 9);

		sc.close();

	}
}