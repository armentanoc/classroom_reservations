package reserva.execucao;

import java.util.Iterator;
import java.util.List;

import reserva.modelos.Aluno;
import reserva.modelos.Curso;
import reserva.modelos.Disciplina;
import reserva.modelos.Laboratorio;
import reserva.modelos.Professor;

public class Imprimir {

	public void cursos(List<Curso> cursos) {

		print("\nLISTA DE CURSOS: ");

		for (Curso curso : cursos) {
			print(" (" + curso.getSigla() + ") " + curso.getDescricao() + " => " + curso.getQtdAlunos() + " alunos");
		}

	}

	public void disciplinas(List<Disciplina> disciplinas) {

		print("\nLISTA DE DISCIPLINAS: ");

		for (Disciplina disciplina : disciplinas) {
			print(" (" + disciplina.getSigla() + ") " + disciplina.getDescricao());
		}

	}

	public void laboratorios(List<Laboratorio> laboratorios) {

		print("\nLISTA DE LABORATÓRIOS: ");

		for (Laboratorio laboratorio : laboratorios) {
			print(" " + laboratorio.getSigla() + " => " + laboratorio.getCapacidade() + " máquinas");
		}

	}

	public void professores(List<Professor> professores) {

		print("\nLISTA DE PROFESSORES: ");

		for (Professor professor : professores) {
			print(" " + professor.getNome() + " => " + professor.getDisciplina().getSigla());
		}

	}

	public void alunos(List<Aluno> alunos) {

		print("\nLISTA DE ALUNOS: ");

		for (Aluno aluno : alunos) {
			System.out.println(" (" + aluno.getMatricula() + ") " + aluno.getNome());
		}
		
		print("");

	}
	
	public void horarios(List<String> horarios) {

		print("\nHorários Possíveis: ");

		for (Iterator i = horarios.iterator(); i.hasNext();) {
			System.out.print(i.next() + " ");
		}
		
		print("\nProfessor, informe para qual horário deseja reservar o laboratório: ");
	}
	
	public void print (String str) {
		System.out.println(str);
	}
}
