package br.com.casadocodigo.loja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
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
