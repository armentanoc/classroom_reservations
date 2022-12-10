package reserva.modelos;

public class Professor extends Pessoa {
	
	private Disciplina disciplina;

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
		
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

}
