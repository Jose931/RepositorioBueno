package Clases;


public class Respuesta {
	private int id_pregunta;
	private String texto;
	private boolean valida;
	
	
	public Respuesta(int id_pregunta, String texto, boolean valida) {
		this.id_pregunta = id_pregunta;
		this.texto = texto;
		this.valida = valida;
	}
	public int getId_pregunta() {
		return id_pregunta;
	}
	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isValida() {
		return valida;
	}
	public void setValida(boolean valida) {
		this.valida = valida;
	}
	@Override
	public String toString() {
		return "Respuesta [id_pregunta=" + id_pregunta + ", texto=" + texto + ", valida=" + valida + "]";
	}
	
	
}
