package Lista;

import Base.Locacao;
import Noh.Nohlocacao;

public class LDElocacao {

	private Nohlocacao inicio;
	private Nohlocacao fim;
	
	public LDElocacao() {
		this.inicio = null;
		this.fim = null;
	}
	
	public void insereInicio(Locacao info) {
		Nohlocacao novo = new Nohlocacao(info);
		if(inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.setProx(inicio);
			inicio.setAnt(novo);
			inicio = novo;
		}
	}
	
	public void insereFim(Locacao info) {
		Nohlocacao novo = new Nohlocacao(info);
		if(fim == null) {
			inicio = novo;
			fim = novo;
		}else {
			novo.setAnt(fim);
			fim.setProx(novo);
			fim = novo;
		}
	}
	
	public boolean estaVazia() {
		return inicio == null;
	}
	
	public boolean remove(Locacao info) {
		Nohlocacao p = busca(info);
		if(p == null) 
			return false;
		if(p.getAnt() == null) {
			inicio = p.getProx();
			if(inicio != null) {
				inicio.setAnt(null);
			}else if(p.getProx() == null) {
				p.getAnt().setProx(null);
				fim = p.getAnt();
			}else {
				p.getAnt().setProx(p.getProx());
				p.getAnt().setAnt(p.getAnt());
			}
		}return true;
	}
	
	public Nohlocacao busca(Locacao info) {
		Nohlocacao resultado = null;
		for(Nohlocacao i = inicio; i != null && i.getInfo() != null; i.getProx()) {
			if(i.getInfo().getCNH() == info.getCNH()) {
				resultado = i;
			}
		}return resultado;
	}
	
	public int tamanho() {
		int count = 0;
		for(Nohlocacao i = inicio; i != null; i.getProx()) {
			count++;
		}return count;
	}
	
	public void imprimeInicio() {
		for(Nohlocacao i = inicio; i != null; i.getProx()) {
			System.out.println(i.toString() + "\n");
		}
	}
	
	public void imprimeFim() {
		for(Nohlocacao i = fim; i != null; i.getAnt()) {
			System.out.print(i.toString() + "\n");
		}
	}
	
	public Locacao get(String placa) {
		Nohlocacao nohLoc = busca(placa);
		if(nohLoc != null) 
			return nohLoc.getInfo();
		return null;
		
	}
	
	public Nohlocacao busca(String placa) {
		Nohlocacao resultado = null;
		for(Nohlocacao i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getPlaca().equals(placa))
				resultado = i;
		}
		return resultado;
}
	
	public boolean possuiLocacao(Long CNH) {
		for(Nohlocacao i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getCNH() == CNH) 
				return true;
		}return false;
	}
	
	public boolean possuiLoacao(String placa) {
		for(Nohlocacao i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getPlaca() == placa) {
				return true;
			}
		}return false;
	}
	
	
	public boolean estaLocado(Long CNH) {
		for(Nohlocacao i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getCNH() == CNH) {
				return true;
			}
		}return false;	
	}
	
	public boolean estaLocado(String placa) {
		for(Nohlocacao i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getPlaca() == placa) {
				return true;
			}
		}return false;
	}
	
	
}