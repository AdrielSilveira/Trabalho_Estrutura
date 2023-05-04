package interfaceUsuario;

public class Main {
	
	private static String arqCat = ".\\src\\Categorias.csv";
	private static String arqCli = ".\\src\\Clientes.csv";
	private static String arqVei = ".\\src\\Veiculos.csv";

	public static void main(String[] args) {
		OperacoesCategoria.getOperacoes().atualizarListaComArquivo(arqCat);
		OperacoesCliente.getOperacoes().atualizarListaComArquivo(arqCli);
		OperacoesVeiculo.getOperacoes().atualizarListaComArquivo(arqVei);
		
		System.out.println("Bem vindo à PampaLoca & Cia LTDA!\n");
		
		InteracaoUsuario interacao = new InteracaoUsuario();
		interacao.PainelInicial();
		
		OperacoesCategoria.getOperacoes().gravarEmArquivo(arqCat);
		OperacoesCliente.getOperacoes().garavarEmArquivo(arqCli);
		OperacoesVeiculo.getOperacoes().gravarEmArquivo(arqVei);
	}

}
