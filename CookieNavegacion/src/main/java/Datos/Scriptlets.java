package Datos;

import java.util.Iterator;
import java.util.Map;

public class Scriptlets {
	
	
	public static String generaBotonesRadio(String nombreControl, Map<String,String> arrayValoresYEtiquetas, String valorSeleccionado) {
		  String salida = "";
		  Iterator<String> iteradorConjuntoClaves = arrayValoresYEtiquetas.keySet().iterator();
		  while (iteradorConjuntoClaves.hasNext()){
			  String clave = iteradorConjuntoClaves.next();
			  String valor = arrayValoresYEtiquetas.get(clave);
			  if (valorSeleccionado.equals(clave)) {
				  salida += "<label>" + valor + "</label><input type=\"radio\" name=\"" + nombreControl + "\" value=\"" + clave + "\" checked=\"checked\" />" + "\n";
			  } else {
				  salida += "<label>" + valor + "</label><input type=\"radio\" name=\"" + nombreControl + "\" value=\"" + clave + "\" />" + "\n";
			  }
		  }
		  return salida;
		}	
}
