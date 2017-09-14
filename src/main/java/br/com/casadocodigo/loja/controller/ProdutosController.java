package br.com.casadocodigo.loja.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;
import br.com.casadocodigo.loja.validator.ProdutoValidator;

@Controller
@RequestMapping("produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private FileSaver saver;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
		binder.addValidators(new ProdutoValidator());
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Produto produto){
		
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
	public ModelAndView gravar(MultipartFile sumario ,@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return form(produto);
		}
		
		//System.out.println(sumario.getOriginalFilename() );
		String path = saver.writer("arquivos", sumario);
        produto.setSumarioPath(path);
			
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
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("/produtos/detalhe");
		Produto produto = produtoDAO.find(id);
		modelAndView.addObject("produto", produto);
		return modelAndView;
	}

}
