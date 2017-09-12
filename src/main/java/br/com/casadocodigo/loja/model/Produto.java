package br.com.casadocodigo.loja.model;

import java.util.List;

import javax.persistence.ElementCollection;
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
	private int pagina;
	
	@ElementCollection
	private List<Precos> precos;
	
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public int getPagina() {
		return pagina;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Precos> getPrecos() {
		return precos;
	}
	public void setPrecos(List<Precos> precos) {
		this.precos = precos;
	}	

}
