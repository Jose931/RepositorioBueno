package Scriptlets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import Clases.Pregunta;

public class Scriptlets {
	
	
	
	public static String arrayCheckBox(String nombreControl, Map<Integer, String> arrayRespuestas,
			int[] seleccionados) {
		String salida = "";
		int contador = 0;
		int valoresSeleccionados = seleccionados.length;
		Iterator<Integer> iteradorClaves = arrayRespuestas.keySet().iterator();

		if (valoresSeleccionados > 0) {
			while (iteradorClaves.hasNext()) {
				String checked = "";
				int clave = iteradorClaves.next();
				String valor = arrayRespuestas.get(clave);
				if ((contador < valoresSeleccionados) && (seleccionados[contador] == clave)) {
					checked = "checked";
					contador++;
				}
				salida += "<input type='checkbox' name='" + nombreControl + "' value='" + clave + "' " + checked
						+ " /><label>" + valor + "</label><br>";
			}
		} else {
			while (iteradorClaves.hasNext()) {
				String checked = "";
				int clave = iteradorClaves.next();
				String valor = arrayRespuestas.get(clave);
				salida += "<input type='checkbox' name='" + nombreControl + "' value='" + clave + "' " + checked + " /><label>" + valor + "</label><br>";
			}
		}

		return salida;
	}
	
	
	
	public static String muestrExamen(ArrayList<Pregunta> examen) {
		String salida = "";
		
		for(int i = 0; i < examen.size(); i++) {
			salida += "<div><label>" + examen.get(i).getEnunciado() +"</label>";
			for(int j = 0; j < examen.get(i).getRespuestas().size(); j++) {
				
				if(examen.get(i).getRespuestas().get(j).isMarcada() && examen.get(i).getRespuestas().get(j).isValida()) {
					
					salida += "<div><label>" + examen.get(i).getRespuestas().get(j).getTexto() +"</label><label class = 'acierto'>Correcta</label><label>+1</label></div>";
					
				}else if(examen.get(i).getRespuestas().get(j).isMarcada() && !examen.get(i).getRespuestas().get(j).isValida()) {
					
					salida += "<div><label>" + examen.get(i).getRespuestas().get(j).getTexto() +"</label><label class = 'error'>No correcta</label><label>-0,25</label></div>";
				}else {
					
					salida += "<div><label>" + examen.get(i).getRespuestas().get(j).getTexto() +"</label></div>";
				}
			}
			salida += "</div>";
		}
		
		return salida;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
