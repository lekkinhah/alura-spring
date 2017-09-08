package br.com.casadocodigo.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/produtos/form")
	public String form(){
        return "produtos/form";
    }	
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto ) {
		System.out.println("Titulo:" + produto.getTitulo());
		System.out.println("Descricao:" + produto.getDescricao());
		System.out.println("Nº de Páginas:" + produto.getPagina());
		
		produtoDAO.gravar(produto);
		
		return "/produtos/ok";
	}

}
