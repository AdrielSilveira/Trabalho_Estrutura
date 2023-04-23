package Noh;

import Base.Locacao;

public class NohLocacao {
	private Locacao info;
	private NohLocacao prox;
	private NohLocacao ant;
	
	public NohLocacao(Locacao info2) {
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

	public NohLocacao getProx() {
		return prox;
	}

	public void setProx(NohLocacao n) {
		this.prox = n;
	}

	public NohLocacao getAnt() {
		return ant;
	}

	public void setAnt(NohLocacao n) {
		this.ant = n;
	}
	
	public String toString() {
		return info.toString();
	}
}
