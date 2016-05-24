package br.com.unipac.biblioteca.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.unipac.biblioteca.dao.EmprestimoDAO;
import br.com.unipac.biblioteca.model.domain.Emprestimo;
import br.com.unipac.biblioteca.model.domain.Livro;
import br.com.unipac.biblioteca.model.domain.Pessoa;
import br.com.unipac.infra.GetConnection;

public class EmprestimoDAOImpl extends GetConnection implements EmprestimoDAO<Emprestimo> {
	
	@Override
	public void createTable() {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS emprestimo (id bigint(size) zerofill not null auto_increment, id_livro int, id_pessoa int, emprestimo timestamp, devolucao timestamp)");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public void salvar(Emprestimo emprestimo) {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			//Insert
			stmt.executeUpdate("INSERT INTO emprestimo ( id_livro, id_pessoa, emprestimo, devolucao ) VALUES ( '" + emprestimo.getLivro().getId() + "', '" + emprestimo.getPessoa().getId() + "', '"+ emprestimo.getEmprestimo() + "', '"+ emprestimo.getDevolucao() + "'  )");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public List<Emprestimo> listarTodos() {
		List<Emprestimo> emprestimos = new ArrayList<>();
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM livro");
			Emprestimo emprestimo = null;
			while (rs.next()) {
				emprestimo = new Emprestimo();
				Long id = rs.getLong("id");
				String titulo = rs.getString("id_livro");
				String autor = rs.getString("id_pessoa");
				boolean emprestado = rs.getBoolean("emprestado");
				
				
				emprestimos.add(emprestimo);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		closeConexao();
		
		return emprestimos;
	}

	@Override
	public void remover(Emprestimo emprestimo) {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			//Insert
			//stmt.executeUpdate("DELETE FROM livro WHERE id = " + emprestimo.getId());
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public void alterar(Emprestimo emprestimo) {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			//Insert
			//stmt.executeUpdate("UPDATE pessoa SET name = '" + emprestimo.getNome() + "', email = '"+ emprestimo.getEmail() + "' WHERE id = " + emprestimo.getId());
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

}
