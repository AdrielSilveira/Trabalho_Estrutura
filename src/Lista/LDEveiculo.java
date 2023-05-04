package Lista;

import Base.Veiculo;
import Noh.Noh;
import Noh.Nohveiculo;
import Base.Arquivo;
import Base.Categoria;
import interfaceUsuario.OperacoesCategoria;

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
		for (Nohveiculo i = inicio; i != null; i = i.getProx()) {
			if (i.getInfo().getPlaca().equals(info.getPlaca()))
				return i;
		}
		return resultado;
	}

	public Nohveiculo busca(String placa) {
		Nohveiculo resultado = null;
		for (Nohveiculo i = inicio; i != null; i = i.getProx()) {
			if (i.getInfo().getPlaca().equals(placa))
				resultado = i;
		}
		return resultado;
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
	
	public boolean catEstaVinculada(int id) {
		for (Nohveiculo i = inicio; i != null; i = i.getProx()) {
			if (i.getInfo().getCategoria().getId() == id)
				return true;
		}
		return false;
	}
	
	public boolean contem(String placa) {
		if (busca(placa) != null)
			return true;
		return false;
	}

	
	public Veiculo get(String placa) {
		Nohveiculo noh = busca(placa);
		if (noh != null)
			return noh.getInfo();
		return null;
	}
	public boolean atualizarListaArquivo(String arquivo) {
		try {
			LDE Lista = Arquivo.getLinhas(arquivo);
			Noh noh = Lista.getIncio();
			do {
				// os dados devem vir do arquivo no formato:
				// placa;modelo;marca;ano;potencia;lugares;categoria
				String linha = (String) noh.getInfo();
				String dados[] = linha.split(";");
				if (dados.length == 7) {
					Categoria cat = OperacoesCategoria.getOperacoes().get(Integer.parseInt(dados[6]));
					insereFim(new Veiculo(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]),
							Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), cat));
				} else {
					System.out.println("Formato do arquivo de veículos inválido!");
					return false;
				}
				noh = noh.getProx();

			} while (noh != null);

		} catch (Exception e) {
			System.out.println("Erro ao ler Veículos:" + e.getMessage());
		}
		return true;
	}

	public boolean gravarArquivo(String arquivo) {
		String conteudo = "placa;modelo;marca;ano;potencia;lugares;categoria\n";
		for (Nohveiculo i = inicio; i != null; i = i.getProx()) {
			Veiculo vei = i.getInfo();
			conteudo += vei.getPlaca() + ";" + vei.getModelo() + ";" + vei.getMarca() + ";" + vei.getAno() + ";"
					+ vei.getPotencia() + ";" + vei.getNlugares() + ";" + vei.getCategoria().getId() + "\n";
		}
		try {
			Arquivo.gravar(conteudo, arquivo);
		} catch (Exception e) {
			System.out.println("Erro ao gravar o arquivo de Veículos!");
			return false;
		}
		return true;
	}
}
