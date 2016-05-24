package br.com.unipac.main;

import java.util.List;

import br.com.unipac.biblioteca.dao.LivroDAO;
import br.com.unipac.biblioteca.dao.impl.LivroDAOImpl;
import br.com.unipac.biblioteca.model.domain.Livro;
public class Application {
	public static void main(String[] args) {
		
		LivroDAO dao = new LivroDAOImpl();
		
		dao.createTable();
		
		Livro livro = new Livro();
		livro.setId(1l);
		livro.setTitulo("diarios de um banana");
		livro.setAutor("banana");
		livro.setEmprestado(false);
		
		dao.salvar(livro);
		
		Livro livro2 = new Livro();
		livro2.setId(2l);
		livro2.setTitulo("diarios de um banana \2");
		livro2.setAutor("banana");
		livro2.setEmprestado(false);
		
		dao.salvar(livro2);
		
		Livro livro3 = new Livro();
		livro3.setId(2l);
		livro3.setTitulo("diarios de um banana 3");
		livro3.setAutor("banana");
		livro3.setEmprestado(false);
		
		dao.salvar(livro2);
		
		List<Livro> livros = dao.listarTodos();
		for (Livro l : livros) {
			System.out.println("Id: " + l.getId());
			System.out.println("Titulo: " + l.getTitulo());
			System.out.println("Autor: " + l.getAutor());
			System.out.println("Emprestado: " + l.isEmprestado());
	
		}
		
	}
}
