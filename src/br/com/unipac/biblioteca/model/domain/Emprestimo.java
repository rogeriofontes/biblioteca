package br.com.unipac.biblioteca.model.domain;

import java.util.Date;

public class Emprestimo {
	private Livro livro;
	private Pessoa pessoa;
	private Date emprestimo;
	private Date Devolucao;

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
		return Devolucao;
	}

	public void setDevolucao(Date devolucao) {
		Devolucao = devolucao;
	}

}
