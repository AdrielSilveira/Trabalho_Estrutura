package Noh;

import Base.Locacao;

public class Nohlocacao {
	private Locacao info;
	private Nohlocacao prox;
	private Nohlocacao ant;
	
	public Nohlocacao(Locacao info2) {
		this.info = info2;
		this.prox = null;
		this.ant = null;
	}

	public Locacao getInfo() {
		return info;
	}

	public void setInfo(Locacao n) {
		this.info = n;
	}

	public Nohlocacao getProx() {
		return prox;
	}

	public void setProx(Nohlocacao n) {
		this.prox = n;
	}

	public Nohlocacao getAnt() {
		return ant;
	}

	public void setAnt(Nohlocacao n) {
		this.ant = n;
	}
	
	public String toString() {
		return info.toString();
	}
}
