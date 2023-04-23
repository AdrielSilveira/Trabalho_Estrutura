package Base;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Locacao {
	private long CNH;
	private String placa;
	private Date datInicio;
	private Date datFim;
	private double valor;
	
	public Locacao(long cNH, String placa, Date datInicio, Date datFim, double valor) {
		super();
		CNH = cNH;
		this.placa = placa;
		this.datInicio = datInicio;
		this.datFim = datFim;
		this.valor = valor;
	}

	public long getCNH() {
		return CNH;
	}

	public void setCNH(long cNH) {
		CNH = cNH;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getDatInicio() {
		return datInicio;
	}

	public void setDatInicio(Date datInicio) {
		this.datInicio = datInicio;
	}

	public Date getDatFim() {
		return datFim;
	}

	public void setDatFim(Date datFim) {
		this.datFim = datFim;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		String dInicio, dFim;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		dInicio = formato.format(datInicio);
		if (datFim != null) {
			dFim = formato.format(datFim);
		} else
			dFim = "n/a";

		return "Locacoes: \n CNH: " + CNH + "; \n Placa: " + placa + "; \n Data de Inicio: " + dInicio
				+ "; \n Data do Fim: " + dFim + "; \n Valor: " + valor + ". \n";
	}
}
