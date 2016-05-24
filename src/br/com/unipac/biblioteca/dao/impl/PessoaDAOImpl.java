package br.com.unipac.biblioteca.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.unipac.biblioteca.dao.PessoaDAO;
import br.com.unipac.biblioteca.model.domain.Pessoa;
import br.com.unipac.infra.GetConnection;

public class PessoaDAOImpl extends GetConnection implements PessoaDAO<Pessoa> {

	@Override
	public void createTable() {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE pessoa ( nome varchar(50), email varchar(50) )");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public void salvar(Pessoa pessoa) {

	}

	@Override
	public List<Pessoa> listarTodos() {
		return null;
	}

	@Override
	public void remover(Pessoa t) {

	}

	@Override
	public void alterar(Pessoa t) {
		// TODO Auto-generated method stub
		
	}
}
