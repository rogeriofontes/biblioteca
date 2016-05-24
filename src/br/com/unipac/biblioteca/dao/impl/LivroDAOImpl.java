package br.com.unipac.biblioteca.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unipac.biblioteca.dao.LivroDAO;
import br.com.unipac.biblioteca.model.domain.Livro;
import br.com.unipac.infra.GetConnection;

public class LivroDAOImpl extends GetConnection implements LivroDAO<Livro> {

	@Override
	public void createTable() {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS livro (id bigint(size) zerofill not null auto_increment, titulo varchar(50), autor varchar(50), emprestado boolean )");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public void salvar(Livro livro) {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			//Insert
			stmt.executeUpdate("INSERT INTO livro ( id, titulo, autor, emprestado ) VALUES ( '" + livro.getId() + "', '" + livro.getTitulo() + "', '"+ livro.getAutor() + "', '"+ livro.isEmprestado() + "'  )");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public List<Livro> listarTodos() {
		List<Livro> livros = new ArrayList<>();
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM livro");
			Livro livro = null;
			while (rs.next()) {
				livro = new Livro();
				Long id = rs.getLong("id");
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				boolean emprestado = rs.getBoolean("emprestado");
				
				livro.setId(id);
				livro.setTitulo(titulo);
				livro.setAutor(autor);
				livro.setEmprestado(emprestado);
				
				livros.add(livro);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		closeConexao();
		
		return livros;
	}

	@Override
	public void remover(Livro livro) {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			//Insert
			stmt.executeUpdate("DELETE FROM livro WHERE id = " + livro.getId());
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public void alterar(Livro livro) {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			//Insert
			stmt.executeUpdate("UPDATE livro SET id = '" + livro.getId() + "', titulo = '" + livro.getTitulo() + "', autor = '"+ livro.getAutor() + "', emprestado = '"+ livro.isEmprestado() + "' WHERE id = " + livro.getId());
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
		
	}

}
