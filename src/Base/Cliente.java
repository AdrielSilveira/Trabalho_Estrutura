package Base;

public class Cliente {
	private String nome;
	private long CNH, telefone, CPF;
	
	public Cliente(String nome, long CNH, long telefone, long CPF) {
		this.nome = nome;
		this.CNH = CNH;
		this.telefone = telefone;
		this.CPF = CPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCNH() {
		return CNH;
	}

	public void setCNH(long cNH) {
		CNH = cNH;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public long getCPF() {
		return CPF;
	}

	public void setCPF(long cPF) {
		CPF = cPF;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", CNH=" + CNH + ", telefone=" + telefone + ", CPF=" + CPF + "]";
	}
	
}
