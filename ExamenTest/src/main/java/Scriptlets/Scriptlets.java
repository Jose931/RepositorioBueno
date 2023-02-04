package Scriptlets;

import java.util.Iterator;
import java.util.Map;

public class Scriptlets {
	
	public static String generaCajasChequeo(Map<Integer,String> arrayValoresYEtiquetas, String[] valoresSeleccionados) {
		String salida = "";
		int numerovaloresSeleccionados = valoresSeleccionados.length;  // cuantos valores seleccionados se han recibido
		if (numerovaloresSeleccionados > 0) {  // hay alg�n valor seleccionado
			int contadorValoresSeleccionados = 0;  // cu�ntos valores seleccionados ya se han recorrido
			Iterator<Integer> iteradorConjuntoClaves = arrayValoresYEtiquetas.keySet().iterator();
			while (iteradorConjuntoClaves.hasNext()) {
				Integer clave = iteradorConjuntoClaves.next();
				String valor = arrayValoresYEtiquetas.get(clave);
				if ( (contadorValoresSeleccionados < numerovaloresSeleccionados) &&
		             (valoresSeleccionados[contadorValoresSeleccionados].equals(clave)) ) {
					salida += "<label>" + valor + "</label><input type=\"checkbox\" name=\"" + valor + "\" value=\"" + clave + "\" checked=\"checked\" /><br>" + "\n";
					contadorValoresSeleccionados++;
				} else {
					salida += "<label>" + valor + "</label><input type=\"checkbox\" name=\"" + valor + "\" value=\"" + clave + "\" /><br>" + "\n";
				}  
			}
		} else {
			Iterator<Integer> iteradorConjuntoClaves = arrayValoresYEtiquetas.keySet().iterator();
			while (iteradorConjuntoClaves.hasNext()) {
				Integer clave = iteradorConjuntoClaves.next();
				String valor = arrayValoresYEtiquetas.get(clave);
				salida += "<label>" + valor + "</label><input type=\"checkbox\" name=\"" + valor + "\" value=\"" + clave + "\" /><br>" + "\n";
			}    
		}  
		return salida;
	}

}
