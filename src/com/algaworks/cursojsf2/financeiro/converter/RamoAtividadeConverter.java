package com.algaworks.cursojsf2.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.cursojsf2.financeiro.model.RamoAtividade;
import com.algaworks.cursojsf2.financeiro.service.GestaoRamosAtividades;

@FacesConverter(forClass=RamoAtividade.class)
public class RamoAtividadeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		RamoAtividade retorno = null;
		
		if (value != null) {
			GestaoRamosAtividades gestaoRamoAtividade = new GestaoRamosAtividades();
			return gestaoRamoAtividade.buscarPorCodigo(new Integer(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((RamoAtividade) value).getCodigo().toString();
		}
		return null;
	}

}
