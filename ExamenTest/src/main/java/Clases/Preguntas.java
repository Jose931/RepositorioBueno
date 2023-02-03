package Clases;



public class Preguntas {
	private int id_pregunta;
	private String pregunta;
	private Respuesta respuesta1;
	private Respuesta respuesta2;
	private Respuesta respuesta3;
	private Respuesta respuesta4;
	
	
	public Preguntas(int id_pregunta, String pregunta, Respuesta respuesta1, Respuesta respuesta2, Respuesta respuesta3, Respuesta respuesta4) {
		this.id_pregunta = id_pregunta;
		this.pregunta = pregunta;
		this.respuesta1 = respuesta1;
		this.respuesta2 = respuesta2;
		this.respuesta3 = respuesta3;
		this.respuesta4 = respuesta4;
	}


	public int getId_pregunta() {
		return id_pregunta;
	}


	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}


	public String getPregunta() {
		return pregunta;
	}


	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}


	public String getRespuesta1() {
		return respuesta1.getRespuesta();
	}


	

	public String getRespuesta2() {
		return respuesta2.getRespuesta();
	}


	
	public String getRespuesta3() {
		return respuesta3.getRespuesta();
	}


	
	public String getRespuesta4() {
		return respuesta4.getRespuesta();
	}


	
	@Override
	public String toString() {
		return "Preguntas [id_pregunta=" + id_pregunta + ", pregunta=" + pregunta + ", respuesta1=" + respuesta1.getIdPregunta()
				+ ", respuesta2=" + respuesta2.getIdPregunta() + ", respuesta3=" + respuesta3.getIdPregunta() + ", respuesta4=" + respuesta4.getIdPregunta() + "]";
	}


	
	
	
	
	
	
}
