package Lista;

import Base.Categoria;
import Noh.Nohcategoria;

public class LDEcategoria {

	private Nohcategoria inicio;
	private Nohcategoria fim;
	
	public LDEcategoria() {
		this.inicio = null;
		this.fim = null;
	}
	
	public void insereInicio(Categoria info) {
		Nohcategoria novo = new Nohcategoria(info);
		if(inicio == null) {
			inicio = novo;
			fim = novo;
		}else {
			novo.setProx(inicio);
			inicio.setAnt(novo);
			inicio = novo;
		}
	}
	
	public void insereFim(Categoria info) {
		Nohcategoria novo = new Nohcategoria(info);
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
	
	public boolean remove(Categoria info) {
		Nohcategoria p = busca(info);
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
	
	public Nohcategoria busca(Categoria info) {
		Nohcategoria resultado = null;
		for(Nohcategoria i = inicio; i != null && i.getInfo() != info; i = i.getProx()) {
			if(i.getInfo().getId() == info.getId()) {
				resultado = i;
			}
		}return resultado;
	}
	
	public int tamanho() {
		int count = 0;
		for(Nohcategoria i = inicio; i != null; i.getProx()) {
			count++;
		}
		return count;
	}
	
	public void imprimeInicio() {
		for(Nohcategoria i = inicio; i != null; i.getProx()) {
			System.out.println(i.toString() + "\n");
		}
	}
	
	public void imprimeFim() {
		for(Nohcategoria i = fim; i !=null; i.getAnt()) {
			System.out.println(i.toString() + "\n");
		}
	}
}
