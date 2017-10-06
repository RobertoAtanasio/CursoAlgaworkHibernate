package com.algaworks.cursojsf2.financeiro.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public enum TipoPessoa {

	FISICA("F", "Física"),
	JURIDICA("J","Jurídica");
	
	private final String tipoPessoa;
	private final String nomeTipoPessoa;
	
	private TipoPessoa(String tipoPessoa, String nomeTipoPessoa) {
		this.tipoPessoa = tipoPessoa;
		this.nomeTipoPessoa = nomeTipoPessoa;
	}
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	public String getNomeTipoPessoa() {
		return nomeTipoPessoa;
	}
	
}
