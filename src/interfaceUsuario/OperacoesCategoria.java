package interfaceUsuario;

import Base.Categoria;
import Lista.LDEcategoria;

public class OperacoesCategoria {

	private static OperacoesCategoria operacoes = new OperacoesCategoria();
	private LDEcategoria categorias;

	private OperacoesCategoria() {
		categorias = new LDEcategoria();
	}

	public static OperacoesCategoria getOperacoes() {
		return operacoes;
	}

	public void criaCategoria() {
		int id;
		do {
			id = SysIn.pedeIdCat();
			if (contem(id))
				System.out.println("Id já cadastrado!");
		} while (contem(id));
		String nome = SysIn.pedeNome();
		categorias.insereFim(new Categoria(id, nome));
		System.out.println("Categoria Registrada com sucesso!");
	}

	public Categoria get(int id) {
		return categorias.get(id);
	}

	public void alterarNome(int id) {
		if (contem(id)) {
			String nome = SysIn.inString("Qual é o novo nome da categoria?");
			categorias.get(id).setNome(nome);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Categoria não encontrado!");
	}

	public void excluiCategoria(int id) {
		if (contem(id)) {
			if(!OperacoesVeiculo.getOperacoes().catEstaVinculada(id)) {
			categorias.remove(categorias.get(id));
			System.out.println("Categoria excluida.");
			}else System.out.println("Categoria Vinculada a veículos!\n Ação cancelada!");
		} else
			System.out.println("Categoria não encontrada!");
	}

	public boolean contem(int id) {
		return categorias.contem(id);
	}

	public boolean gravarArquivo(String arquivo) {
		return categorias.gravarArquivo(arquivo);
	}

	public boolean atualizarListaArquivo(String arquivo) {
		return categorias.atualizarListaArquivo(arquivo);
	}
	
	public void imprimeInicioAFim() {
		categorias.imprimeInicio();
	}

	public void imprimeFimAInicio() {
		categorias.imprimeFim();
	}

}
