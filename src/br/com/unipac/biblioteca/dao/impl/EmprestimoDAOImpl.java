package br.com.unipac.biblioteca.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.unipac.biblioteca.dao.EmprestimoDAO;
import br.com.unipac.biblioteca.model.domain.Emprestimo;
import br.com.unipac.infra.GetConnection;

public class EmprestimoDAOImpl extends GetConnection implements EmprestimoDAO<Emprestimo> {
	
	@Override
	public void createTable() {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS emprestimo ( nome_livro varchar(50) )");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public void salvar(Emprestimo t) {
	}

	@Override
	public List<Emprestimo> listarTodos() {
		return null;
	}

	@Override
	public void remover(Emprestimo t) {
		
	}

	@Override
	public void alterar(Emprestimo t) {
		// TODO Auto-generated method stub
		
	}

}
