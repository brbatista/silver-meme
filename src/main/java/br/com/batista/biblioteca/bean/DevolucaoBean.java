package br.com.batista.biblioteca.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.batista.biblioteca.dao.DevolucaoDAO;
import br.com.batista.biblioteca.dao.EmprestimoDAO;
import br.com.batista.biblioteca.modelo.Devolucao;
import br.com.batista.biblioteca.modelo.Emprestimo;

@Named
@ViewScoped
public class DevolucaoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Emprestimo emprestimo;
	private Integer id;
	private Devolucao devolucao = new Devolucao();

	@Inject
	private EmprestimoDAO emprestimoDao;

	@Inject
	private DevolucaoDAO devolucaoDao;

	public void carregaEmprestimo() {
		this.emprestimo = emprestimoDao.buscaPorId(id);
		devolucao.setEmprestimo(emprestimo);
	}

	@Transactional
	public String efetuaDevolucao() {
		devolucaoDao.salvar(devolucao);
		return "/sistema/historico?faces-redirect=true";
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Devolucao getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
