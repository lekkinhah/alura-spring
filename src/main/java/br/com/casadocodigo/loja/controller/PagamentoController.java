package br.com.casadocodigo.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.model.CarrinhoCompras;

@Component
@RequestMapping("/pagamento")
public class PagamentoController {

	
	@Autowired
	 CarrinhoCompras carrinho;
	
	@RequestMapping(value="/finalizar", method=RequestMethod.POST)
	public ModelAndView finalizar(RedirectAttributes model) {
		
		System.out.println(carrinho.getTotal());
		
		model.addFlashAttribute("sucesso", "Pagamento Realizado com Sucesso");
		
		ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
		return modelAndView;
	}
}
