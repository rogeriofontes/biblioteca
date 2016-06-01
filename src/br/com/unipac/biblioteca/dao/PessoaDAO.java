package br.com.unipac.biblioteca.dao;

import br.com.unipac.biblioteca.model.domain.Pessoa;

public interface PessoaDAO<T> extends GenericDAO<T, Long> {
	Pessoa listarPorNome(String nomePessoa);
}
