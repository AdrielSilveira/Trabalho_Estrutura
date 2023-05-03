package interfaceUsuario;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Base.Locacao;
import Lista.LDElocacao;

public class OperacoesLocacoes {

	private static OperacoesLocacoes operacoes = new OperacoesLocacoes();
	private LDElocacao locacoes;

	private OperacoesLocacoes() {
		locacoes = new LDElocacao();
	}

	public static OperacoesLocacoes getOperacoes() {
		return operacoes;
	}

	public boolean iniciarLocacao() {
		String placa = SysIn.pedePlaca();
		long CNH = SysIn.pedeCNH();
		Date datInicio = Calendar.getInstance().getTime();
		Date datFim = null;
		double valor = 0;
		locacoes.insereFim(new Locacao(CNH, placa, datInicio, datFim, valor));
		System.out.println("Veículo locado!");
		return true;
	}

	public void encerraLocacao() {
		String placa = SysIn.pedePlaca();
		if(estahLocado(placa)) {
			String dataInicial = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(locacoes.get(placa).getDatInicio());
			double valor = SysIn.inDouble("Qual é o valor da locação realizada desde " + dataInicial + "?");
			locacoes.get(placa).setDatFim(Calendar.getInstance().getTime());
			locacoes.get(placa).setValor(valor);
			System.out.println("Locação encerrada com sucesso!");
		}else System.out.println("Este veiculo não está locado!");
	}
	
	public Locacao get(String placa) {
		return locacoes.get(placa);
	}
	
	public boolean estahLocado(String placa) {
		return locacoes.estaLocado(placa);
	}
	
	public boolean estahLocado(long CNH) {
		return locacoes.estaLocado(CNH);
	}
	
	public void imprime() {
		String placa = SysIn.pedePlaca();
		Locacao loc = locacoes.get(placa);
		if (loc != null) {
			System.out.println(loc.toString());
			System.out.println("Alteração concluída!");
		} else
			System.out.println("veiculo não encontrado!");
	}
	
	public void imprimeInicio() {
		locacoes.imprimeInicio();
	}

	public void imprimeFim() {
		locacoes.imprimeFim();
	}
	
}