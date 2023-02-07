package Clases;

import java.util.*;

public class CreaMapas {

	/**
	 * Este metodo crea un mapa de las repuestas a partir del array de Preguntas y
	 * el numero que sera el de el numero de pregunta en el que nos encontremos
	 * 
	 * @param {@code ArrayList<Preguntas>, int numeroPregunta}
	 * @return {@code LinkedHashMap<Integer, String>}
	 */
	public static LinkedHashMap<Integer, String> hazMapa(ArrayList<Pregunta> preguntas, int numeroPregunta) {

		LinkedHashMap<Integer, String> arrayRespuestas = new LinkedHashMap<Integer, String>() {
			{

				for (int i = 0; i < preguntas.get(numeroPregunta).getRespuestas().size(); i++) {
					put(i, preguntas.get(numeroPregunta).getRespuestas().get(i).getTexto());
				}
			}

		};

		return arrayRespuestas;
	}
}
