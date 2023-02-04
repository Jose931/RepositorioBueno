package Clases;

import java.util.ArrayList;

public class Pregunta{
	private int id_pregunta;
	private String enunciado;
	private ArrayList<Respuesta> respuestas;
	
	
	public Pregunta(int id_pregunta, String enunciado, ArrayList<Respuesta> respuestas) {
		this.id_pregunta = id_pregunta;
		this.enunciado = enunciado;
		this.respuestas = respuestas;
	}
	public int getId_pregunta() {
		return id_pregunta;
	}
	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	@Override
	public String toString() {
		return "Pregunta [id_pregunta=" + id_pregunta + ", enunciado=" + enunciado + ", respuestas=" + respuestas + "]";
	}
	
	
	
}
