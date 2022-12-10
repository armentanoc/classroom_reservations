package reserva.base;

import java.util.List;

import reserva.modelos.Aluno;
import reserva.modelos.Curso;
import reserva.modelos.Disciplina;
import reserva.modelos.Laboratorio;
import reserva.modelos.Professor;

public interface IBase {

	List<Curso> cursos();
	List<Disciplina> disciplinas();
	List<Laboratorio> laboratorios();
	List<Aluno> alunos();
	List<Professor> professores(List<Disciplina> disciplinas);
}
