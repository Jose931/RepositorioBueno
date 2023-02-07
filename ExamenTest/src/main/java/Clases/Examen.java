package Clases;

public class Examen {
	
	private int id_examen;
	private String pregunta1;
	private String respuesta1;
	private String pregunta2;
	private String respuesta2;
	private String pregunta3;
	private String respuesta3;
	private double puntuacion;
	
	
	public Examen(int id_examen, String pregunta1, String respuesta1, String pregunta2, String respuesta2,String pregunta3, String respuesta3, double puntuacion) {
		
		this.id_examen = id_examen;
		this.pregunta1 = pregunta1;
		this.respuesta1 = respuesta1;
		this.pregunta2 = pregunta2;
		this.respuesta2 = respuesta2;
		this.pregunta3 = pregunta3;
		this.respuesta3 = respuesta3;
		this.puntuacion = puntuacion;
	}

	public int getId_examen() {
		return id_examen;
	}

	public void setId_examen(int id_examen) {
		this.id_examen = id_examen;
	}

	public String getPregunta1() {
		return pregunta1;
	}

	public void setPregunta1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}

	public String getPregunta2() {
		return pregunta2;
	}

	public void setPregunta2(String pregunta2) {
		this.pregunta2 = pregunta2;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}

	public String getPregunta3() {
		return pregunta3;
	}

	public void setPregunta3(String pregunta3) {
		this.pregunta3 = pregunta3;
	}

	public String getRespuesta3() {
		return respuesta3;
	}

	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Examen [id_examen=" + id_examen + ", pregunta1=" + pregunta1 + ", respuesta1=" + respuesta1
				+ ", pregunta2=" + pregunta2 + ", respuesta2=" + respuesta2 + ", pregunta3=" + pregunta3
				+ ", respuesta3=" + respuesta3 + ", puntuacion=" + puntuacion + "]";
	}

}
