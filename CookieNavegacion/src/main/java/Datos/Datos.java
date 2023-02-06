package Datos;

import java.util.*;
;

public class Datos {
	
	public static Map<String, String>usuarios = new HashMap<String, String>(){{
		put("admin", "admin");
		put("jose", "jose");
		put("user", "user");
		
	}};
	 
	 
	public static LinkedHashMap<String, String> arrayColores = new LinkedHashMap<String, String>() {
		{
			put("R", "Rojo");
			put("V", "Verde");
			put("A", "Azul");
			put("M", "Morado");
			put("N", "Naranja");
		}
	};
}
