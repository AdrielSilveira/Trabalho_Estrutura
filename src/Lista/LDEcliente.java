package Lista;

import Base.Arquivo;
import Base.Cliente;
import Noh.Noh;
import Noh.Nohcliente;

public class LDEcliente {
	private Nohcliente inicio;
	private Nohcliente fim;
	
	public LDEcliente() {
		this.inicio = null;
		this.fim = null;
	}
	
	public void insereInicio(Cliente info) {
		Nohcliente novo = new Nohcliente(info);
		if(inicio == null) {
			inicio = novo;
			fim = novo;
		}else {
			novo.setProx(inicio);
			inicio.setAnt(novo);
			inicio = novo;
		}
	}
	
	public void insereFim(Cliente info) {
		Nohcliente novo = new Nohcliente(info);
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
	
	public boolean remove(Cliente info) {
		Nohcliente p = busca(info);
		if(p == null)
			return false;
		if(p.getAnt() == null) {
			inicio.getProx();
			if(inicio != null) {
				p.setAnt(null);
			}else if(p.getProx() == null) {
				p.getProx().setAnt(null);
				fim = p.getAnt();
			}else {
				p.getAnt().setProx(p.getProx());
				p.getAnt().setAnt(p.getAnt());
			}
		}return true;
	}
	
	public Nohcliente busca(Cliente info) {
		Nohcliente resultado = null;
		for(Nohcliente i = inicio; i != null; i.getProx()) {
			if(i.getInfo().getCNH() == info.getCNH()) {
				return i;
			}
		}return resultado;
	}
	
	public Nohcliente busca(Long CPF) {
		Nohcliente resultado = null;
		for(Nohcliente i = inicio; i != null ; i.getProx()) {
			if(i.getInfo().getCPF() == CPF ) {
				return i;
			}
		}return resultado;
	}
	
	
	public Cliente get(Long CPF) {
		Nohcliente noh = busca(CPF);
		if(noh != null)
			return noh.getInfo();
		return null;
	}
	
	public boolean contem (Long CPF) {
		if(busca(CPF) != null) {
			return true;
		}return false;
	}
	
	public int tamanho() {
		int count = 0;
		for(Nohcliente i = inicio; i != null; i.getProx()) {
			count++;
		}return count;
	}
	
	public void imprimeInicio() {
		for(Nohcliente i = inicio; i != null; i.getProx()) {
			System.out.println(i.toString() + "\n");
		}
	}
	
	public void imprimeFim() {
		for(Nohcliente i = fim; i != null; i.getAnt()) {
			System.out.println(i.toString() + "\n");
		}
	}
	
	public boolean atualizarListaArquivo(String arquivo) {
		try {
			
			LDE lista = Arquivo.getLinhas(arquivo);
			Noh noh = lista.getIncio();
			
			do {
				String linha =(String) noh.getInfo();
				String dados[] = linha.split(";");
				if(dados.length == 4) {
					insereFim(new Cliente(dados[0], Long.parseLong(dados[2]), Long.parseLong(dados[3]), Long.parseLong(dados[1])));
				}else {
					System.out.println("Formato do Arquivo de Cliente Invalido!");
					return false;
				}
				noh = noh.getProx();
			}while (noh != null);
		} catch (Exception e) {
			System.out.println("Erro ao ler Cliente" + e.getMessage());
		}return true;
	}
	
	public boolean gravarArquivo(String arquivo) {
		String conteudo = "nome; CPF; CNH; Telefone\n";
		for(Nohcliente i = inicio; i != null; i.getProx()) {
			Cliente cli =i.getInfo();
			conteudo += cli.getNome() + ";" + cli.getCPF() + ";" + cli.getCNH() + ";" + cli.getTelefone() + ";" + "\n";
		} try {
			Arquivo.gravar(conteudo, arquivo);
		} catch (Exception e) {
			System.out.println("Erro ao gravar o Arquivo Cliente!");
			return false;
		}return true;
	}
}
