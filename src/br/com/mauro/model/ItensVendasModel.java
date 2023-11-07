package br.com.mauro.model;

public class ItensVendasModel {

	private int codigo;
	private VendasModel vendas;
	private ProdutoModel produto;
	private int qtdItensVendas;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public VendasModel getVendas() {
		return vendas;
	}
	public void setVendas(VendasModel vendas) {
		this.vendas = vendas;
	}
	public ProdutoModel getProduto() {
		return produto;
	}
	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}
	public int getQtdItensVendas() {
		return qtdItensVendas;
	}
	public void setQtdItensVendas(int qtdItensVendas) {
		this.qtdItensVendas = qtdItensVendas;
	}
	
	
}
