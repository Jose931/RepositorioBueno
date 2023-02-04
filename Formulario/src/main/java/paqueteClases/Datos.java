package paqueteClases;

import java.util.*;

public class Datos {

	public static LinkedHashMap<String, String> arrayPaises = new LinkedHashMap<String, String>() {
		{
			put("IG", "Inglaterra");
			put("FR", "Francia");
			put("AR", "Argentina");
		}
	};

	public static LinkedHashMap<String, String> arrayColores = new LinkedHashMap<String, String>() {
		{
			put("R", "Rojo");
			put("V", "Verde");
			put("A", "Azul");
			put("M", "Morado");
			put("N", "Naranja");
		}
	};
	public static LinkedHashMap<String, String> sexo = new LinkedHashMap<String, String>() {
		{
			put("M", "Mujer");
			put("H", "Hombre");	
		}
	};
	
	public static LinkedHashMap<String, String> arrayEstacion = new LinkedHashMap<String, String>() {
		{
			put("P", "Primavera");
			put("V", "Verano");
			put("O", "Otoño");
			put("I", "Invierno");
		}
	};
	
	
	
	
	
}