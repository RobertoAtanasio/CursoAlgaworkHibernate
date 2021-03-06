package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.RamoAtividade;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.model.TipoPessoa;
import com.algaworks.cursojsf2.financeiro.service.GestaoPessoas;
import com.algaworks.cursojsf2.financeiro.service.GestaoRamosAtividades;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();

	private List<RamoAtividade> ramosAtividades = new ArrayList<RamoAtividade>();
	private RamoAtividade ramoAtiv = new RamoAtividade();
	
	private boolean alterouPessoa = false;
	
	public boolean isAlterouPessoa() {
		return alterouPessoa;
	}

	public void setAlterouPessoa(boolean alterouPessoa) {
		this.alterouPessoa = alterouPessoa;
	}

	@PostConstruct
	public void init() {
		GestaoPessoas gestaoPessoas = new GestaoPessoas();
		this.pessoas = gestaoPessoas.listarTodas();
		
		GestaoRamosAtividades gestaoRamosAtividades = new GestaoRamosAtividades();
		this.ramosAtividades = gestaoRamosAtividades.listarTodas();
	}
	
	public List<RamoAtividade> getRamosAtividades() {
		return ramosAtividades;
	}

	public void setRamosAtividades(List<RamoAtividade> ramosAtividades) {
		this.ramosAtividades = ramosAtividades;
	}

	public RamoAtividade getRamoAtiv() {
		return ramoAtiv;
	}

	public void setRamoAtiv(RamoAtividade ramoAtiv) {
		this.ramoAtiv = ramoAtiv;
	}
	
	public void alterouPessoaSelecionada(ValueChangeEvent event) {
		
		Pessoa pessoa = (Pessoa) event.getNewValue();
		
		System.out.println("Pessoa: "+ pessoa.getNomePessoa());

		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public void cadastrar() {
		System.out.println("Tipo: " + this.lancamento.getTipo());
		System.out.println("Pessoa: " + this.lancamento.getPessoa().getNomePessoa());
		System.out.println("Descrição: " + this.lancamento.getDescricao());
		System.out.println("Valor: " + this.lancamento.getValor());
		System.out.println("Data vencimento: " + this.lancamento.getDataVencimento());
		System.out.println("Conta paga: " + this.lancamento.isPago());
		System.out.println("Data pagamento: " + this.lancamento.getDataPagamento());

		this.lancamento = new Lancamento();
		
		String msg = "Cadastro efetuado com sucesso!";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}
	
	public TipoPessoa[] getTiposPessoas() {
		return TipoPessoa.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
}
