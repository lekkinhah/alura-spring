package br.com.casadocodigo.loja.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.model.Produto;

public class ProdutoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors erros) {
		ValidationUtils.rejectIfEmpty(erros, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(erros, "descricao", "field.required");
		
		Produto produto = (Produto) target;
		if(produto.getPagina() <= 0) {
			erros.rejectValue("pagina", "field.required");
		}
	}

}
