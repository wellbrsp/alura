package br.com.alura.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.model.Contato;
import br.com.alura.util.ConnectionFactory;

public class ContatoDao {

	private Connection conn;

	public ContatoDao() {
		this.conn = new ConnectionFactory().getConexao();
	}

	public void adiciona(Contato c) {
		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";
		Date dataNasc = new Date(c.getDataNascimento().getTime());
		PreparedStatement pstm = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getEmail());
			pstm.setString(3, c.getEndereco());
			pstm.setDate(4, dataNasc);
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Contato> getListaContato() {
		List<Contato> listaContatos = new ArrayList<Contato>();
		String sql = "select * from contatos";
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Contato c = new Contato();
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				c.setDataNascimento(rs.getDate("dataNascimento"));

				listaContatos.add(c);
			}
			return listaContatos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public boolean fechaConexao() {
		try {
			this.conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
