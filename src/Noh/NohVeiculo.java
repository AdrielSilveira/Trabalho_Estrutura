package Noh;

import Base.Veiculo;

public class Nohveiculo {
	private Veiculo info;
	private Nohveiculo prox;
	private Nohveiculo ant;
	
	public Nohveiculo(Veiculo info2) {
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

	public Nohveiculo getProx() {
		return prox;
	}

	public void setProx(Nohveiculo n) {
		this.prox = n;
	}

	public Nohveiculo getAnt() {
		return ant;
	}

	public void setAnt(Nohveiculo n) {
		this.ant = n;
	}
	
	public String toString() {
		return info.toString();
	}
	
}
