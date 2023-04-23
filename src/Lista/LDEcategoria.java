package Lista;

import Base.Categoria;
import Noh.Nohcategoria;
import Base.Arquivo;

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
	
	
}
