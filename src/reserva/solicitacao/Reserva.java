package reserva.solicitacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

import reserva.base.Base;
import reserva.execucao.Imprimir;
import reserva.modelos.Laboratorio;
import reserva.modelos.Professor;

public class Reserva implements IReserva {

	Scanner sc = new Scanner(System.in);
	Base b = new Base();
	static Imprimir i = new Imprimir();

	public void tentarReserva() {

		imprimirTitulo();

		Professor p = identificacaoProfessor();
		Laboratorio l = identificacaoLaboratorio();
		String d = identificacaoData();
		String h = identificacaoHora();

		if (!(p == null || l == null || d == null || h == null)) {
			Solicitacao s = solicitacaoReserva(p, l, d, h);
			imprimirSolicitacao(s);	
		}
		else {
			dadosIncorretos();
		}
	}

	private void imprimirSolicitacao(Solicitacao s) {

		i.print("\nReserva efetuada com sucesso");
		i.print("\n Professor: " + s.getProfessor().getNome());
		i.print(" Disciplina: " + s.getProfessor().getDisciplina().getSigla());
		i.print(" Laboratório: " + s.getLaboratorio().getSigla());
		i.print(" Quantidade de máquinas: " + s.getLaboratorio().getCapacidade());
		i.print(" Data da reserva: " + s.getData());
		i.print(" Horário: " + s.getHora());

	}

	private void dadosIncorretos() {
		i.print("\nATENÇÃO: Não foi possível apresentar a reserva pois um"
				+ "\nou mais dados não foram informados corretamente.");

	}

	private void imprimirTitulo() {
		divider();
		i.print("\nSOLICITANDO O LABORATÓRIO");
		divider();
		i.print("\n");
	}

	public Solicitacao solicitacaoReserva(Professor p, Laboratorio l, String d, String h) {

		Solicitacao s = new Solicitacao(p, l, d, h);
		return s;

	}

	private static void divider() {

		for (int j = 0; j <= 50; j++) {
			System.out.print("=");
			j++;
		}

	}

	@Override
	public Professor identificacaoProfessor() {

		i.print("\nProfessor, informe seu nome: ");
		String nome = sc.nextLine();
		
		//tratando o dado recebido
		nome = nome.toLowerCase(); //tudo em minúscula
		nome = nome.substring(0,1).toUpperCase().concat(nome.substring(1)); //primeira letra maiúscula
	
		try {
			
			//checando se o professor está na base de dados
			for (Professor p : b.professores(b.disciplinas())) {
				if (p.getNome().equals(nome)) {
					return p;
				}
			}

			throw new Exception();

		} catch (Exception e) {

			naoEncontrado("Professor");
			return null;

		}
	}

	@Override
	public String identificacaoData() {
		i.print("\nProfessor, informe a data: ");
		String dataStr = sc.next(), format = "dd/MM/uuuu";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter
				.ofPattern(format)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate date = LocalDate.parse(dataStr, dateTimeFormatter);
			if(date.isAfter(LocalDate.now())) {
				return dataStr;
			}
			else {
				i.print("Erro: A data da reserva não pode ser menor do que o dia atual !!!");
				return null;
			}
			
		} catch (DateTimeParseException e) {
			i.print("Data não encontrada !!!"
					+ "\nInforme uma data no formato dd/mm/aaaa.");
			return null;
		} 
	}

	@Override
	public String identificacaoHora() {

		try {
			i.horarios(b.horariosPossiveis());
			String horarioDesejado = sc.next();
			for (String horario : b.horariosPossiveis()) {
				if (horario.equals(horarioDesejado)) {
					return horario;
				}
			} 

			throw new Exception();

		}
		catch (Exception e) {
			naoEncontrado("Horário");
			return null;
		}
	}

	@Override
	public Laboratorio identificacaoLaboratorio() {

		i.print("\nProfessor, informe o laboratório: ");
		String sigla = sc.next().toUpperCase();

		try {

			for (Laboratorio lab : b.laboratorios()) {
				if (lab.getSigla().equals(sigla)) {
					return lab;
				}
			}

			throw new Exception();

		} catch (Exception e) {

			naoEncontrado("Laboratório");
			return null;

		}
	}
	
	public void naoEncontrado(String item) {
		i.print(item + " não encontrado !!!");
	}
}
