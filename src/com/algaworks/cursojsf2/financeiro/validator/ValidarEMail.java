package com.algaworks.cursojsf2.financeiro.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

@FacesValidator("com.algaworks.ValidadorEMail")
public class ValidarEMail implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		String mens = "";
		String email = (String) value;
		Object label = MessageFactory.getLabel(context, component);
		
		if (value != null && !("".equals(email))) {
			
			if (!email.contains("@")) {
				mens = label + " inválido.";
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, mens, mens);
				throw new ValidatorException(mensagem);
			}
			
		    char primeiraLetra = email.charAt(0);
		    char ultimaLetra = email.charAt(email.length() - 1);
		    
		    if (!Character.isAlphabetic(primeiraLetra)) {
		    	mens = "A primeira letra do " + label + " deve ser alfabética.";
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, mens, mens);
				throw new ValidatorException(mensagem);
		    }
			
		    if (!Character.isAlphabetic(ultimaLetra)) {
		    	mens = "A última letra do " + label + " deve ser alfabética.";
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, mens, mens);
				throw new ValidatorException(mensagem);
		    }
		    
		}
 
	}
	
	

}
