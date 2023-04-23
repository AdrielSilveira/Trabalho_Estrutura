package Noh;

import Base.Categoria;

public class Nohcategoria {
	private Categoria info;
	private Nohcategoria prox;
	private Nohcategoria ant;
	
	public Nohcategoria(Categoria info2) {
		this.info = info2;
		this.prox = null;
		this.ant = null;
	}

	public Categoria getInfo() {
		return info;
	}

	public void setInfo(Categoria n) {
		this.info = n;
	}

	public Nohcategoria getProx() {
		return prox;
	}

	public void setProx(Nohcategoria n) {
		this.prox = n;
	}

	public Nohcategoria getAnt() {
		return ant;
	}

	public void setAnt(Nohcategoria n) {
		this.ant = n;
	}
	
	public String toString() {
		return info.toString();
	}
}
