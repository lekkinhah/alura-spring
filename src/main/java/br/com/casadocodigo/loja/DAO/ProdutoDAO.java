package br.com.casadocodigo.loja.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.model.Produto;

@Repository
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Produto produto) {
		manager.persist(produto);
	}
}
