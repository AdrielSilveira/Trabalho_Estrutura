package Base;

public class Veiculo {
	private String placa;
	private String modelo, marca;
	private int ano, potencia, nlugares;
	private Categoria categoria;
	
	public Veiculo(String placa, String modelo, String marca, int ano, int potencia, int nlugares,
			Categoria categoria) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.potencia = potencia;
		this.nlugares = nlugares;
		this.categoria = categoria;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getNlugares() {
		return nlugares;
	}

	public void setNlugares(int nlugares) {
		this.nlugares = nlugares;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	public String toString() {
		if(categoria != null) {
			return "Veiculos: \n Placa: " + placa + "; \n Modelo: " + modelo + "; \n Marca: " + marca + "; \n Ano: " + ano + "; \n Potencia: "
	                + potencia + "; \n Numero de lugares: " + nlugares + "; \n Categoria: " + categoria.getNome() + ". \n";
		}else return "Veiculos: \n Placa: " + placa + "; \n Modelo: " + modelo + "; \n Marca: " + marca + "; \n Ano: " + ano + "; \n Potencia: "
        + potencia + "; \n Numero de lugares: " + nlugares + "; \n Categoria: " + "Desconhecida" + ". \n";
	}
}
