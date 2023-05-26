package interfaceUsuario;

public class Main {
	
	private static String arqCat = ".\\src\\Categorias.csv";
	private static String arqCli = ".\\src\\Clientes.csv";
	private static String arqVei = ".\\src\\Veiculos.csv";

	public static void main(String[] args) {
		OperacoesCategoria.getOperacoes().atualizarListaArquivo(arqCat);
		OperacoesCliente.getOperacoes().atualizarListaArquivo(arqCli);
		OperacoesVeiculo.getOperacoes().atualizarListaArquivo(arqVei);
		
		System.out.println("Bem vindo à PampaLoca & Cia LTDA!\n");
		
		InteracaoUsuario interacao = new InteracaoUsuario();
		interacao.PainelInicial();
		
		OperacoesCategoria.getOperacoes().gravarArquivo(arqCat);
		OperacoesCliente.getOperacoes().garavarArquivo(arqCli);
		OperacoesVeiculo.getOperacoes().gravarArquivo(arqVei);
	}

}
