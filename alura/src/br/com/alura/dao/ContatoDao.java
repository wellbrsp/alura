package br.com.alura.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
