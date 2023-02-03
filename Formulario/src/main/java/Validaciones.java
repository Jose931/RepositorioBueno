import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Validaciones {
	
	
	static String comprobarEdad(String fecha) {
		if (fecha != null && fecha.length() != 0) {
			LocalDate fechaUser = LocalDate.parse(fecha);
			if(mayorEdad(fechaUser)) {
				return "";
			}
			return "No eres mayor de edad. ";
		}else {
			return "Fecha no introducida. ";
		}
	}
	
	static boolean mayorEdad(LocalDate fechaNcimiento) {
		if(calculoEdad(fechaNcimiento) >= 18) {
			return true;
		}
		return false;
	}
	
	static int calculoEdad(LocalDate fecha) {
		LocalDate fechaActual = LocalDate.now();
		
		if(fecha != null) {
			return Period.between(fecha, fechaActual).getYears();
		}else{
			return 0;
		}
	}
	
	static String comprobarNombre(String nombre) {
		if(nombre.length() == 0) {
			return "Falta rellenar el nombre. ";
		}
		return "";
	}
	
	static String comprobarClave(String contraseña) {
		
		if(contraseña.length() < 6 || contraseña.length() > 12 ) {
			return "La clave debe tener entre 6 y 12 caracteres. ";
		}
		return "";
	}
	
	static String comprobarPais(String paises) {
		if(paises == null || paises == "") {
			return "Debes seleccionar al menos un pais. ";
		}
		return "";
	}
	
	static String comprobarGenero(String sexo) {
		if(sexo.length() == 0) {
			return "Debes seleccionar un genero. ";
		}
		return "";
	}
	
	static String comprobarAcepto(String acepto) {
		if(acepto == null) {
			return "Debes aceptar los terminos. ";
		}
		return "";
	}
	
	static String comprobarEstaciones(String [] estaciones) {
		if(estaciones.length == 0 || estaciones == null ) {
			return "No has elegido ninguna estacion. ";
		}
		return "";
	}
	
	static String comprobarColores(String [] colores) {
		if(colores.length == 0 || colores == null ) {
			return "No has elegido ningun color. ";
		}
		return "";
	}
	
}
