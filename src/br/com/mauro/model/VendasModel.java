package br.com.mauro.model;

public class VendasModel {

	private int codigo;
	private ClienteModel cliente;
	private String dataVendas;
	private String ObsVendas;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	public String getDataVendas() {
		return dataVendas;
	}
	public void setDataVendas(String dataVendas) {
		this.dataVendas = dataVendas;
	}
	public String getObsVendas() {
		return ObsVendas;
	}
	public void setObsVendas(String obsVendas) {
		ObsVendas = obsVendas;
	}
	
	
	
}
