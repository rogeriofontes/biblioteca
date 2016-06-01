package br.com.unipac.biblioteca.model.domain;

import java.util.Date;

public class Emprestimo {
	private Long id;
	private Livro livro;
	private Pessoa pessoa;
	private Date emprestimo;
	private Date devolucao;

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Date emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Date getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
