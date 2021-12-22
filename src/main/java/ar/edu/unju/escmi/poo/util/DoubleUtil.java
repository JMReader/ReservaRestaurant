package ar.edu.unju.escmi.poo.util;

import java.util.Scanner;

public class DoubleUtil {

	public static double pedirDouble()throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double respuesta2 ;
		try {
			respuesta2 = sc.nextDouble();
						
		}catch(Exception miExcepcion) {
			
			
			throw miExcepcion;

			 
		}
		
		return respuesta2;

	}
	
}
