package br.com.casadocodigo.loja.model;

import javax.persistence.Entity;

@Entity
public class Produto {
	
	private String titulo;
	private String descricao;
	private Integer pagina;
	
	
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public Integer getPagina() {
		return pagina;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	
	

}
