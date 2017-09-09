package br.com.casadocodigo.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;

@Controller
@RequestMapping("produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/form")
	public ModelAndView form(){
		
		ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        /*
        Produto p = new Produto();
        p.setTitulo("Teste");
        p.setDescricao("Teste");
        p.setPagina(50);
        Precos pr1 = new Precos();
        pr1.setTipo(TipoPreco.Ebook);
        pr1.setValor(new BigDecimal(20));
        p.setPrecos(new ArrayList<Precos>());
        p.getPrecos().add(pr1);
		modelAndView.addObject("p", p);
        */
		return modelAndView;
    }	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(Produto produto, RedirectAttributes attributes) {
		System.out.println("Titulo:" + produto.getTitulo());
		System.out.println("Descricao:" + produto.getDescricao());
		System.out.println("Nº de Páginas:" + produto.getPagina());
		
		produtoDAO.gravar(produto);
		
		attributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso! =)");
		
		return new ModelAndView("redirect:/produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {		
		List<Produto> produtos = produtoDAO.listar();
		ModelAndView modelAndView = new ModelAndView("/produtos/lista");
		modelAndView.addObject("produtos", produtos);
		
		return modelAndView;
	}

}
