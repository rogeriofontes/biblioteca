package br.com.unipac.biblioteca.dao;

import br.com.unipac.biblioteca.model.domain.Livro;

public interface LivroDAO<T> extends GenericDAO<T, Long> {
	Livro listarPorNome(String nomeLivro);
}
