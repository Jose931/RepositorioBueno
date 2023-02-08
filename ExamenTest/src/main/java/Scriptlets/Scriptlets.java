package Scriptlets;

import java.util.Iterator;
import java.util.Map;

public class Scriptlets {
	
	public static String generaArrayCajasChequeo(String nombreControl, Map<Integer,String> arrayValoresYEtiquetas, int[] valoresSeleccionados) {
		String salida = "";
		int[] prueba = new int[valoresSeleccionados.length];
		int contador = 0;
		int numerovaloresSeleccionados = valoresSeleccionados.length;  // cu�ntos valores seleccionados se han recibido
		if (numerovaloresSeleccionados > 0) {  // hay alg�n valor seleccionado
			int contadorValoresSeleccionados = 0;  // cu�ntos valores seleccionados ya se han recorrido
			Iterator<Integer> iteradorConjuntoClaves = arrayValoresYEtiquetas.keySet().iterator();
			while (iteradorConjuntoClaves.hasNext()) {
				Integer clave = iteradorConjuntoClaves.next();
				String valor = arrayValoresYEtiquetas.get(clave);
				if ( (contadorValoresSeleccionados < numerovaloresSeleccionados) &&
		             (valoresSeleccionados[contadorValoresSeleccionados]==clave) ) {
					salida += "<input type=\"checkbox\" name=\"" + valor + "\" value=\"" + clave + "\" checked=\"checked\" />" + "<label>" + valor + "</label>" + "\n" + "<br>";
					prueba[contador] = clave;
					contador++;
					contadorValoresSeleccionados++;
				} else {
					salida += "<input type=\"checkbox\" name=\"" + nombreControl + "\" value=\"" + clave + "\" />" + "<label>" + valor + "</label>" + "\n"  + "<br>";
				}  
			}
		} else {
			Iterator<Integer> iteradorConjuntoClaves = arrayValoresYEtiquetas.keySet().iterator();
			while (iteradorConjuntoClaves.hasNext()) {
				Integer clave = iteradorConjuntoClaves.next();
				String valor = arrayValoresYEtiquetas.get(clave);
				salida += "<input type=\"checkbox\" name=\"" + nombreControl + "\" value=\"" + clave + "\" />" + "<label>" + valor + "</label>" + "\n"  + "<br>";
			}    
		}  		
		

		return salida;
	}

}
