package reserva.execucao;

import java.util.Scanner;

import reserva.base.Base;
import reserva.solicitacao.Reserva;

public class Executar {
	
	static Imprimir i = new Imprimir();
	static Base b = new Base();
	static Reserva r = new Reserva();
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Criando a base
		i.cursos(b.cursos());
		i.disciplinas(b.disciplinas());
		i.laboratorios(b.laboratorios());
		i.professores(b.professores(b.disciplinas()));
		i.alunos(b.alunos());
		
		//Tentando uma reserva
		r.tentarReserva();
		
	}
}
