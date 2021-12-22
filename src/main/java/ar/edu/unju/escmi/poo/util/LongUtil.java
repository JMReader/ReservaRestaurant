package ar.edu.unju.escmi.poo.util;

import java.util.Scanner;

public class LongUtil {
	public static long pedirLong() throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		long respuesta2 ;
		try {
			respuesta2 = sc.nextLong();
		}catch(Exception ex) {
			throw ex;
		}
		return respuesta2;
	}
}
