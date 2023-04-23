package Noh;

import Base.Veiculo;

public class NohVeiculo {
	private Veiculo info;
	private NohVeiculo prox;
	private NohVeiculo ant;
	
	public NohVeiculo(Veiculo info2) {
		this.info = info2;
		this.prox = null;
		this.ant = null;
	}

	public Veiculo getInfo() {
		return info;
	}

	public void setInfo(Veiculo n) {
		this.info = n;
	}

	public NohVeiculo getProx() {
		return prox;
	}

	public void setProx(NohVeiculo n) {
		this.prox = n;
	}

	public NohVeiculo getAnt() {
		return ant;
	}

	public void setAnt(NohVeiculo n) {
		this.ant = n;
	}
	
	public String toString() {
		return info.toString();
	}
	
}
