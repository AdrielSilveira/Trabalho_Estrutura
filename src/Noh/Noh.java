package Noh;

public class Noh {
	private Object info;
	private Noh prox;
	private Noh ant;
	
	public Noh(Object info2) {
		this.info = info2;
		this.prox = null;
		this.ant = null;
	}

	public Object getInfo() {
		return info;
	}

	public Noh getProx() {
		return prox;
	}

	public void setProx(Noh n) {
		this.prox = n;
	}

	public Noh getAnt() {
		return ant;
	}

	public void setAnt(Noh n) {
		this.ant = n;
	}

	@Override
	public String toString() {
		return info.toString();
	}
	
	
}
