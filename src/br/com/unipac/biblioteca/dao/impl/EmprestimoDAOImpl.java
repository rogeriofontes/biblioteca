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
	LivroDAOImpl daoLivro = new LivroDAOImpl();
	PessoaDAOImpl daoPessoa = new PessoaDAOImpl();

	@Override
	public void createTable() {
		Connection connection = abreConexao();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS emprestimo "
					+ "(id bigint(size) zerofill not null auto_increment, id_livro int, id_pessoa int, emprestimo timestamp, devolucao timestamp)");
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
			// Insert
			stmt.executeUpdate("INSERT INTO emprestimo ( id_livro, id_pessoa, emprestimo, devolucao ) VALUES ( '"
					+ emprestimo.getLivro().getId() + "', '" + emprestimo.getPessoa().getId() + "', '"
					+ emprestimo.getEmprestimo() + "', '" + emprestimo.getDevolucao() + "'  )");
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

			ResultSet rs = stmt.executeQuery("SELECT * FROM emprestimo");
			Emprestimo emprestimo = null;
			while (rs.next()) {
				emprestimo = new Emprestimo();
				Long id = rs.getLong("id");
				emprestimo.setId(id);

				Long idLivro = rs.getLong("id_livro");
				Livro livro = daoLivro.listarPorId(idLivro);
				emprestimo.setLivro(livro);

				Long idPessoa = rs.getLong("id_pessoa");
				Pessoa pessoa = daoPessoa.listarPorId(idPessoa);
				emprestimo.setPessoa(pessoa);

				Date emprestado = rs.getDate("emprestimo");
				emprestimo.setEmprestimo(emprestado);

				Date devolucao = rs.getDate("devolucao");
				emprestimo.setDevolucao(devolucao);

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
			// Insert
			stmt.executeUpdate("DELETE FROM emprestimo WHERE id = " + emprestimo.getId());
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
			// Insert
			stmt.executeUpdate(
					"UPDATE emprestimo SET " + "id_livro = '" + emprestimo.getLivro().getId() + "', id_pessoa = '"
							+ emprestimo.getPessoa().getId() + "', emprestimo = '" + emprestimo.getEmprestimo()
							+ "', devolucao = '" + emprestimo.getDevolucao() + "' WHERE id = " + emprestimo.getId());
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		closeConexao();
	}

	@Override
	public Emprestimo listarPorId(Long emprestimoId) {
		Connection connection = abreConexao();
		Emprestimo emprestimo = new Emprestimo();
		try {
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM emprestimo WHERE id_emprestimo =" + emprestimoId);
			if (rs.next()) {

				Long id = rs.getLong("id");
				emprestimo.setId(id);

				Long idLivro = rs.getLong("id_livro");
				Livro livro = daoLivro.listarPorId(idLivro);
				emprestimo.setLivro(livro);

				Long idPessoa = rs.getLong("id_pessoa");
				Pessoa pessoa = daoPessoa.listarPorId(idPessoa);
				emprestimo.setPessoa(pessoa);

				Date emprestado = rs.getDate("emprestimo");
				emprestimo.setEmprestimo(emprestado);

				Date devolucao = rs.getDate("devolucao");
				emprestimo.setDevolucao(devolucao);

			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		closeConexao();

		return emprestimo;
	}

}
