package reserva.solicitacao;

import reserva.modelos.Laboratorio;
import reserva.modelos.Professor;

public interface IReserva {
	
	Solicitacao solicitacaoReserva(Professor p, Laboratorio l, String d, String h);
	Professor identificacaoProfessor();
	String identificacaoData();
	String identificacaoHora();
	Laboratorio identificacaoLaboratorio();

}
