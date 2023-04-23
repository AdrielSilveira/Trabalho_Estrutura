package Lista;

import Noh.Noh;

public class LDE implements Lista {
	private Noh inicio;
	private Noh fim;
	
	public LDE() {
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public Noh getIncio() {
		return inicio;
	}
	
	public Noh getFim() {
		return fim;
	}
	
	public void insereIncio(Object info) {
		Noh novo = new Noh(info);
		if(inicio == null) {
			inicio = novo;
			fim = novo;
		}else {
			novo.setProx(inicio);
			inicio.setAnt(novo);
			inicio = novo;
		}
	}
	
	public boolean estaVazia() {
		return inicio == null;
	}
	
	public void insereFim(Object info) {
		Noh novo = new Noh(info);
		if(fim == null) {
			inicio = novo;
			fim = novo;
		}else {
			novo.setAnt(fim);
			fim.setProx(novo);
			fim = novo;
		}
	}
	
	public boolean remove(Object info) {
		Noh p = busca(info);
		if(p == null)
			return false;
		if(p.getAnt() == null) {
			inicio = p.getProx();
			if(inicio != null)
				inicio.setAnt(null);
		}else if(p.getProx() == null) {
			p.getAnt().setProx(null);
			fim = p.getAnt();
		}else {
			p.getAnt().setProx(p.getProx());
			p.getProx().setAnt(p.getAnt());
		}
		return true;
	}
	
	public Noh busca(Object info) {
		Noh resultado = null;
		for(Noh i = inicio; i != null && i.getInfo() != info; i = i.getProx()) {
			if(i == info) {
				resultado = i;
			}
		}return resultado;
	}
	
	public int tamanho() {
		int cont = 0;
		for(Noh i = inicio; i != null; i.getProx()) {
			cont++;
		}
		return cont;
	}
	
	public void imprimeInicioFim() {
		for(Noh i = inicio; i != null; i.getProx()) {
			System.out.println(i.toString() + "\n");
		}
	}
	
	public void imprimeFimInicio() {
		for(Noh i = fim; i !=null; i.getAnt()) {
			System.out.println(i.toString() + "\n");
		}
	}
	}
