package reserva.solicitacao;

import reserva.modelos.Laboratorio;
import reserva.modelos.Professor;

public class Solicitacao {
	
	private Professor prof;
	private Laboratorio lab;
	private String data, hora;
	
	public Solicitacao(Professor p, Laboratorio l, String d, String h) {
		
		this.prof = p;
		this.lab = l;
		this.data = d;
		this.hora = h;
		
	}
	
	public Professor getProfessor() {
		return prof;
	}
	
	public Laboratorio getLaboratorio() {
		return lab;
	}
	
	public String getData() {
		return data;
	}
	
	public String getHora() {
		return hora;
	}

}
