package Lista;

import Base.Categoria;
import Noh.Noh;
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
	
	public Categoria get(int id) {
		Nohcategoria noh = busca(id);
		if (noh != null)
			return noh.getInfo();
		return null;
	}

	public boolean contem(int id) {
		if (busca(id) != null)
			return true;
		return false;
	}
	
	public Nohcategoria busca(Categoria info) {
		Nohcategoria resultado = null;
		for (Nohcategoria i = inicio; i != null; i = i.getProx()) {
			if (i.getInfo().getId() == info.getId())
				resultado = i;
		}
		return resultado;
	}

	public Nohcategoria busca(int id) {
		Nohcategoria resultado = null;
		for (Nohcategoria i = inicio; i != null; i = i.getProx()) {
			if (i.getInfo().getId() == id)
				resultado = i;
		}
		return resultado;
	}
	
	public boolean atualizarListaArquivo(String arquivo) {
		try {
			LDE Lista = Arquivo.getLinhas(arquivo);
			Noh noh = Lista.getIncio();
			do {
				String linha = (String) noh.getInfo();
				String dados[] = linha.split(";");
				if (dados.length == 2) {
					insereFim(new Categoria(Integer.parseInt(dados[0]), dados[1]));
				} else {
					System.out.println("Formato do arquivo de categorias inválido!");
					return false;
				}
				noh = noh.getProx();

			} while (noh != null);

		} catch (Exception e) {
			System.out.println("Erro ao ler Clientes:" + e.getMessage());
		}
		return true;
	}

	public boolean gravarArquivo(String arquivo) {
		String conteudo = "id;nome\n";
		for (Nohcategoria i = inicio; i != null; i = i.getProx()) {
			Categoria cat = i.getInfo();
			conteudo += cat.getId() + ";" + cat.getNome()+ "\n";
		}
		try {
			Arquivo.gravar(conteudo, arquivo);
		} catch (Exception e) {
			System.out.println("Erro ao gravar o arquivo das Categorias!");
			return false;
		}
		return true;
	}
}
