package br.com.unipac.biblioteca.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	void salvar(T t);
	void alterar(T t);
	void remover(T t);
	List<T> listarTodos();
	void createTable();
	T listarPorId(ID id);
}
