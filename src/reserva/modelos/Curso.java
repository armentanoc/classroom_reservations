package reserva.modelos;

public class Curso {
	
	private String sigla, descricao;
	private Integer qtdAlunos;

	public Integer getQtdAlunos() {
		return qtdAlunos;
	}

	public void setQtdAlunos(Integer qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public String getSigla() {
		return sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setSigla(String string) {
		this.sigla = string;	
	}
	
	public void setDescricao(String string) {
		this.descricao = string;	
	}


}
