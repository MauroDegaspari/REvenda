package br.com.mauro.model;

public class ProdutoModel {
	
	private int  codigo;
	private String nomeProduto;
	private double precoProduto;
	private int qtdProduto;
	private FornecedoresModel fornecedores;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	public int getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	public FornecedoresModel getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(FornecedoresModel fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	
	
	

}
