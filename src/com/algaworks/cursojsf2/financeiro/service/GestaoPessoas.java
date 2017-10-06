package com.algaworks.cursojsf2.financeiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;

public class GestaoPessoas {

	private static Map<Integer, Pessoa> pessoasMap = new HashMap<Integer, Pessoa>();
	
	static {
		pessoasMap.put(1, new Pessoa(1, "João da Silva"));
		pessoasMap.put(2, new Pessoa(2, "Lava-jato Água e Sabão Ltda"));
		pessoasMap.put(3, new Pessoa(3, "Sebastião Mendes de Souza"));
	}
	
	public List<Pessoa> listarTodas() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(GestaoPessoas.pessoasMap.values());
		return pessoas;
	}
	
	public Pessoa buscarPorCodigo(Integer codigo) {
		return pessoasMap.get(codigo);
	}
	
}