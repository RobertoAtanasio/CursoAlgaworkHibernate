package com.algaworks.cursojsf2.financeiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algaworks.cursojsf2.financeiro.model.RamoAtividade;

public class GestaoRamosAtividades {

	private static Map<Integer, RamoAtividade> ramoAtividadeMap = new HashMap<Integer, RamoAtividade>();

	static {
		ramoAtividadeMap.put(1, new RamoAtividade(1, "Professor"));
		ramoAtividadeMap.put(2, new RamoAtividade(2, "Estudate"));
		ramoAtividadeMap.put(3, new RamoAtividade(3, "Engenheiro Civil"));
		ramoAtividadeMap.put(4, new RamoAtividade(4, "Médico Pediatra"));
	}
	
	public List<RamoAtividade> listarTodas (){
		List<RamoAtividade> lista = new ArrayList<RamoAtividade>();
		lista.addAll(GestaoRamosAtividades.ramoAtividadeMap.values());
		return lista;
	}
	
	public RamoAtividade buscarPorCodigo (Integer codigo) {
		return ramoAtividadeMap.get(codigo);
	}
	
}
