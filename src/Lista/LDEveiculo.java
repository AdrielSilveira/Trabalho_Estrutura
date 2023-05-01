package Lista;

import Base.Veiculo;
import Noh.Nohveiculo;

public class LDEveiculo {

	private Nohveiculo inicio;
	private Nohveiculo fim;
	
	public LDEveiculo() {
		this.inicio = null;
		this.fim = null;
	}
	
	public void insereInicio(Veiculo info) {
		Nohveiculo novo = new Nohveiculo(info);
		if(inicio == null) {
			inicio = novo;
			fim = novo;
		}else {
			novo.setProx(inicio);
			inicio.setAnt(novo);
			inicio = novo;
		}
	}
	
	public void insereFim(Veiculo info) {
		Nohveiculo novo = new Nohveiculo(info);
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
	
	public boolean remove(Veiculo info) {
		Nohveiculo p = busca(info);
		if(p == null)
			return false;
		if(p.getAnt() == null) {
			inicio = p.getAnt();
		}else if(p.getProx() == null) {
			p.getAnt().setProx(null);
			fim = p.getAnt();
		}else {
			p.getAnt().setProx(p.getProx());
			p.getAnt().setAnt(p.getAnt());
		}return true;
	}
	
	public Nohveiculo busca(Veiculo info) {
		Nohveiculo resultado = null;
		for(Nohveiculo i = inicio; i != null && i.getInfo() != null; i.getInfo()) {
			if(i.getInfo().getPlaca() == info.getPlaca()) {
				resultado = i;
			}
		}return resultado;
	}
	
	public int tamanho() {
		int count = 0;
		for(Nohveiculo i = inicio; i != null; i.getProx()) {
			count++;
		}return count;
	}
	
	public void imprimeInicio() {
		for(Nohveiculo i = inicio; i != null; i.getProx()) {
			System.out.println(i.toString() + "\n");
		}
	}
	
	public void imprimeFim() {
		for(Nohveiculo i = fim; i != null; i.getAnt()) {
			System.out.println(i.toString() + "\n");
		}
	}
}
