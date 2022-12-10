package reserva.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import reserva.modelos.Aluno;
import reserva.modelos.Curso;
import reserva.modelos.Disciplina;
import reserva.modelos.Laboratorio;
import reserva.modelos.Professor;

public class Base implements IBase {

	final int QUANTIDADE_PROFESSORES = 10;
	final int QUANTIDADE_ALUNOS = 500;
	final int QUANTIDADE_LABORATORIOS = 12;

	@Override
	public List<Professor> professores(List<Disciplina> disciplinas) {

		List<Professor> professores = new ArrayList<Professor>();
		Professor professor;
		String nome;

		for (int i = 1; i <= QUANTIDADE_PROFESSORES; i++) {
			
			professor = new Professor();
			nome = "Professor" + String.format("%02d", i);
			professor.setNome(nome);
			professor.setDisciplina(disciplinas.get(i-1));
			professores.add(professor);
		}

		return professores;
	}

	@Override
	public List<Disciplina> disciplinas() {

		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		Disciplina disciplina;

		disciplina = new Disciplina();
		disciplina.setSigla("BES005");
		disciplina.setDescricao("LÓGICA DE PROGRAMAÇÃO E ALGORITMOS");
		disciplinas.add(disciplina);

		disciplina = new Disciplina();
		disciplina.setSigla("BES006");
		disciplina.setDescricao("ESTRUTURA DE DADOS");
		disciplinas.add(disciplina);

		disciplina = new Disciplina();
		disciplina.setSigla("BES008");
		disciplina.setDescricao("PROGRAMAÇÃO ORIENTADA A OBJETOS");
		disciplinas.add(disciplina);

		disciplina = new Disciplina();
		disciplina.setSigla("BES011");
		disciplina.setDescricao("BANCOS DE DADOS");
		disciplinas.add(disciplina);

		disciplina = new Disciplina();
		disciplina.setSigla("BES012");
		disciplina.setDescricao("ENGENHARIA DE REQUISITOS");
		disciplinas.add(disciplina);

		disciplina = new Disciplina();
		disciplina.setSigla("BES020");
		disciplina.setDescricao("PROGRAMAÇÃO PARA DISPOSITIVOS MÓVEIS");
		disciplinas.add(disciplina);

		disciplina = new Disciplina();
		disciplina.setSigla("BES026");
		disciplina.setDescricao("SISTEMAS DISTRIBUÍDOS");
		disciplinas.add(disciplina);

		disciplina = new Disciplina();
		disciplina.setSigla("BES038");
		disciplina.setDescricao("INTELIGÊNCIA ARTIFICIAL");
		disciplinas.add(disciplina);

		disciplina = new Disciplina();
		disciplina.setSigla("BES049");
		disciplina.setDescricao("PROGRAMAÇÃO WEB");
		disciplinas.add(disciplina);

		disciplina = new Disciplina();
		disciplina.setSigla("BES048");
		disciplina.setDescricao("PROGRAMAÇÃO FRONT END");
		disciplinas.add(disciplina);

		return disciplinas;
	}

	public List<String> horariosPossiveis() {
		List<String> horarios = Arrays.asList("07:00", "08:25", "09:50", "11:15", "14:00", "15:25", "16:50", "19:00", "20:25"); 
		return horarios;
	}

	@Override
	public List<Curso> cursos() {

		List<Curso> cursos = new ArrayList<Curso>();
		Curso curso;

		curso = new Curso();
		curso.setSigla("BES");
		curso.setDescricao("BACHARELADO EM ENGENHARIA DE SOFTWARE");
		curso.setQtdAlunos(200);
		cursos.add(curso);

		curso = new Curso();
		curso.setSigla("ADS");
		curso.setDescricao("ANÁLISE E DESENVOLVIMENTO DE SISTEMAS");
		curso.setQtdAlunos(120);
		cursos.add(curso);

		curso = new Curso();
		curso.setSigla("JGD");
		curso.setDescricao("JOGOS DIGITAIS");
		curso.setQtdAlunos(90);
		cursos.add(curso);

		curso = new Curso();
		curso.setSigla("GTI");
		curso.setDescricao("GOVERNANÇA DE TECNOLOGIA DA INFORMAÇÃO");
		curso.setQtdAlunos(40);
		cursos.add(curso);

		curso = new Curso();
		curso.setSigla("INF");
		curso.setDescricao("INFORMÁTICA");
		curso.setQtdAlunos(20);
		cursos.add(curso);

		curso = new Curso();
		curso.setSigla("RDC");
		curso.setDescricao("REDES DE COMPUTADORES");
		curso.setQtdAlunos(30);
		cursos.add(curso);

		return cursos;
	}

	@Override
	public List<Laboratorio> laboratorios() {

		List<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
		Laboratorio laboratorio;
		String sigla = "LAB";
		Integer capacidade;

		for (int i = 1; i <= QUANTIDADE_LABORATORIOS; i++) {

			laboratorio = new Laboratorio();
			laboratorio.setSigla(sigla+i);

			if (i<=4) {
				capacidade = 20;
			} else if(i<=11) {
				capacidade = 15;
			}
			else {
				capacidade = 30;
			}

			laboratorio.setCapacidade(capacidade);
			laboratorios.add(laboratorio);

		}

		return laboratorios;
	}


	@Override
	public List<Aluno> alunos() {

		List<Aluno> alunos = new ArrayList<Aluno>(); 
		Aluno aluno; 
		String numeroFormatado;

		for (int i = 1; i <= QUANTIDADE_ALUNOS; i++) {

			aluno = new Aluno();
			numeroFormatado = String.format("%03d", i);
			aluno.setNome("Aluno"+i);
			aluno.setMatricula("20222"+i);
			alunos.add(aluno);
		}
		return alunos;
	}

}
