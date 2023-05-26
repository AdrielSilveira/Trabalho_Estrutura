package interfaceUsuario;

import Base.Cliente;
import Lista.LDEcliente;

public class OperacoesCliente {

	private static OperacoesCliente operacoes = new OperacoesCliente();
	private LDEcliente clientes;

	private OperacoesCliente() {
		clientes = new LDEcliente();
	}

	public static OperacoesCliente getOperacoes() {
		return operacoes;
	}

	public void criarCliente() {
		String nome = SysIn.pedeNome();
		long CNH = SysIn.pedeCNH(), telefone = SysIn.pedeTelefone(), CPF = SysIn.pedeCPF();
		clientes.insereFim(new Cliente(nome, CNH, telefone, CPF));
		System.out.println("Cliente registrado!");
	}

	public void removerCliente(long CPF) {
		if (contem(CPF)) {
			if (!OperacoesLocacoes.getOperacoes().estahLocado(CPF)) {
				clientes.remove(clientes.get(CPF));
			} else
				System.out.println("Não é possível excluir um cliente com locação ativa!");
		} else
			System.out.println("Cliente não encontrado!");
	}

	public boolean contem(long CPF) {
		return clientes.contem(CPF);
	}

	public Cliente get(long CPF) {
		return clientes.get(CPF);
	}

	public void alterarNome(long CPF) {
		if (contem(CPF)) {
			String nome = SysIn.inString("Qual é o novo nome?");
			clientes.get(CPF).setNome(nome);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Cliente não encontrado!");
	}

	public void alterarCNH(long CPF) {
		if (contem(CPF)) {
			long cnh = SysIn.inLong("Digite o novo CPF:");
			clientes.get(CPF).setCNH(cnh);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Cliente não encontrado!");
	}

	public void alterarTelefone(long CPF) {
		if (contem(CPF)) {
			long telefone = SysIn.inLong("Digite o novo Telefone:");
			clientes.get(CPF).setTelefone(telefone);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Cliente não encontrado!");
	}

	public void imprime(long CPF) {
		Cliente cli = clientes.get(CPF);
		if (cli != null) {
			System.out.println(cli.toString());
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Cliente não encontrado!");
	}

	public void imprimeInicioAFim() {
		clientes.imprimeInicio();
	}

	public void imprimeFimAInicio() {
		clientes.imprimeFim();
	}

	public boolean atualizarListaArquivo(String arquivo) {
		return clientes.atualizarListaArquivo(arquivo);
	}
	
	public boolean garavarArquivo(String arquivo) {
		return clientes.gravarArquivo(arquivo);
	}

}
