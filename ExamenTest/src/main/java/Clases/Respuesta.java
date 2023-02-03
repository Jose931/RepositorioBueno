package Clases;


public class Respuesta {
	private int idRespuesta;
	private String respuesta;
	private int idPregunta;
	private boolean valida;
	
	
	public Respuesta(int idRespuesta, String respuesta, int idPregunta, boolean valida) {
		this.idRespuesta = idRespuesta;
		this.respuesta = respuesta;
		this.idPregunta = idPregunta;
		this.valida = valida;
	}


	public int getIdRespuesta() {
		return idRespuesta;
	}


	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}


	public String getRespuesta() {
		return respuesta;
	}


	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}


	public int getIdPregunta() {
		return idPregunta;
	}


	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}


	public boolean isValida() {
		return valida;
	}


	public void setValida(boolean valida) {
		this.valida = valida;
	}


	@Override
	public String toString() {
		return "Respuesta [idRespuesta=" + idRespuesta + ", respuesta=" + respuesta + ", idPregunta=" + idPregunta
				+ ", valida=" + valida + "]";
	}
	
	
	
	
}
