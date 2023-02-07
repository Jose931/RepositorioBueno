package Clases;


public class Respuesta {
	private int id_pregunta;
	private String texto;
	private boolean valida;
	private boolean marcada;
	
	
	public Respuesta(int id_pregunta, String texto, boolean valida, boolean marcada) {
		this.id_pregunta = id_pregunta;
		this.texto = texto;
		this.valida = valida;
		this.marcada = marcada;
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
	
	public boolean get_marcada() {
		return marcada;
	}
	@Override
	public String toString() {
		return "Respuesta [id_pregunta=" + id_pregunta + ", texto=" + texto + ", valida=" + valida + "]";
	}
	
	
}
