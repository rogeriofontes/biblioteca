package br.com.unipac.biblioteca.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS pessoa (id bigint(size) zerofill not null auto_increment, nome varchar(50), email varchar(50) )");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public void salvar(Pessoa pessoa) {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			//Insert
			stmt.executeUpdate("INSERT INTO pessoa ( nome, email ) VALUES ( '" + pessoa.getNome() + "', '"+ pessoa.getEmail() + "')");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public List<Pessoa> listarTodos() {
		List<Pessoa> pessoas = new ArrayList<>();
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM pessoa");
			Pessoa pessoa = null;
			while (rs.next()) {
				pessoa = new Pessoa();
				Long id = rs.getLong("id");
				String name = rs.getString("nome");
				String email = rs.getString("email");
				
				pessoa.setId(id);
				pessoa.setNome(name);
				pessoa.setEmail(email);
				
				pessoas.add(pessoa);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		closeConexao();
		return null;
	}

	@Override
	public Pessoa listarPorId(Long idPessoa) {
		Connection connection = abreConexao();
		Pessoa pessoa = null;
		try {
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM pessoa WHERE id_pessoa = " + idPessoa);
			
			if (rs.next()) {
				pessoa = new Pessoa();
				Long id = rs.getLong("id");
				String name = rs.getString("nome");
				String email = rs.getString("email");
				
				pessoa.setId(id);
				pessoa.setNome(name);
				pessoa.setEmail(email);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		closeConexao();
		return pessoa;
	}
	
	@Override
	public Pessoa listarPorNome(String nomePessoa) {
		Connection connection = abreConexao();
		Pessoa pessoa = null;
		try {
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM pessoa WHERE nome = " + nomePessoa);
			
			if (rs.next()) {
				pessoa = new Pessoa();
				Long id = rs.getLong("id");
				String name = rs.getString("nome");
				String email = rs.getString("email");
				
				pessoa.setId(id);
				pessoa.setNome(name);
				pessoa.setEmail(email);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		closeConexao();
		return pessoa;
	}
	
	@Override
	public void remover(Pessoa pessoa) {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			//Insert
			stmt.executeUpdate("DELETE FROM pessoa WHERE id = " + pessoa.getId());
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();

	}

	@Override
	public void alterar(Pessoa pessoa) {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			//Insert
			stmt.executeUpdate("UPDATE pessoa SET name = '" + pessoa.getNome() + "', email = '"+ pessoa.getEmail() + "' WHERE id = " + pessoa.getId());
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
		
	}
}
