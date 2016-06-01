package br.com.unipac.main;

import java.util.Date;
import java.util.List;

import br.com.unipac.biblioteca.dao.EmprestimoDAO;
import br.com.unipac.biblioteca.dao.LivroDAO;
import br.com.unipac.biblioteca.dao.PessoaDAO;
import br.com.unipac.biblioteca.dao.impl.EmprestimoDAOImpl;
import br.com.unipac.biblioteca.dao.impl.LivroDAOImpl;
import br.com.unipac.biblioteca.dao.impl.PessoaDAOImpl;
import br.com.unipac.biblioteca.model.domain.Emprestimo;
import br.com.unipac.biblioteca.model.domain.Livro;
import br.com.unipac.biblioteca.model.domain.Pessoa;

public class Application {
	public static void main(String[] args) {
		PessoaDAO<Pessoa> daoPessoa = new PessoaDAOImpl();
		LivroDAO<Livro> daoLivro = new LivroDAOImpl();
		EmprestimoDAO<Emprestimo> daoEmprestimo = new EmprestimoDAOImpl();

		daoLivro.createTable();
		daoPessoa.createTable();
		daoEmprestimo.createTable();

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("João");
		pessoa.setEmail("joao@localhost");

		daoPessoa.salvar(pessoa);

		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("João");
		pessoa1.setEmail("joao@localhost");

		daoPessoa.salvar(pessoa);

		Livro livro = new Livro();
		livro.setTitulo("diarios de um banana");
		livro.setAutor("banana");
		livro.setEmprestado(false);

		daoLivro.salvar(livro);

		Livro livro2 = new Livro();
		livro2.setTitulo("diarios de um banana \2");
		livro2.setAutor("banana");
		livro2.setEmprestado(false);

		daoLivro.salvar(livro2);

		Livro livro3 = new Livro();
		livro3.setTitulo("diarios de um banana 3");
		livro3.setAutor("banana");
		livro3.setEmprestado(false);

		daoLivro.salvar(livro2);
		
		Emprestimo emprestimo = new Emprestimo();
		Pessoa resultadoPessoa = daoPessoa.listarPorNome("João");
		emprestimo.setPessoa(resultadoPessoa);
		
		Livro resultadoLivro = daoLivro.listarPorNome("diarios de um banana 3");
		emprestimo.setLivro(resultadoLivro);
		
		emprestimo.setEmprestimo(new Date());
		
		emprestimo.setDevolucao(null);
		
		daoEmprestimo.salvar(emprestimo);

		List<Pessoa> pessoas = daoPessoa.listarTodos();

		for (Pessoa p : pessoas) {
			System.out.println("Nome: " + p.getNome());
			System.out.println("Email: " + p.getEmail());
		}

		List<Livro> livros = daoLivro.listarTodos();
		for (Livro l : livros) {
			System.out.println("Id: " + l.getId());
			System.out.println("Titulo: " + l.getTitulo());
			System.out.println("Autor: " + l.getAutor());
			System.out.println("Emprestado: " + l.isEmprestado());

		}

	}
}
