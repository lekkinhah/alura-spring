package br.com.casadocodigo.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.model.CarrinhoCompras;
import br.com.casadocodigo.loja.model.CarrinhoItem;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired 
	private CarrinhoCompras carrinho; 
	
	
	@RequestMapping("/add")
	public ModelAndView add(Integer id, TipoPreco tipo) {
		ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
		CarrinhoItem carrinhoItem = criaItem(id, tipo);
		carrinho.add(carrinhoItem);
		return modelAndView;
		
	}
	
	public CarrinhoItem criaItem(Integer id, TipoPreco tipo) {
		
		Produto produto = produtoDAO.find(id);
		CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipo);
		return carrinhoItem;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView itens(){
	    return new ModelAndView("/carrinho/itens");
	}
	
	@RequestMapping("/remover/{id}/{tipo}")
	public ModelAndView remover(@PathVariable("id") Integer id, @PathVariable("tipo") TipoPreco tipo) {
				
		ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
		CarrinhoItem carrinhoItem = criaItem(id, tipo);
		carrinho.remover(carrinhoItem);
		return modelAndView;
	}
}
