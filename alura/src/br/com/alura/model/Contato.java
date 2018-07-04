package br.com.alura.model;

import java.util.Date;

public class Contato {
	private String nome;
	private String email;
	private String endereco;
	private Date dataNascimento;
	
	public Contato(String nome, String email, String endereco, Date dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
}
