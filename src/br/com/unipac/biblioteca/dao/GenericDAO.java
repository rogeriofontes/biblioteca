package br.com.unipac.biblioteca.dao;

import java.util.List;

public interface GenericDAO<T> {
	void salvar(T t);
	void alterar(T t);
	void remover(T t);
	List<T> listarTodos();
	void createTable();
}
