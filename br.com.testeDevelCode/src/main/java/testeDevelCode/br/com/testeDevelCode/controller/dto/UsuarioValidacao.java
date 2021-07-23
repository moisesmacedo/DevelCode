package testeDevelCode.br.com.testeDevelCode.controller.dto;

import java.sql.Date;

import com.sun.istack.NotNull;

import testeDevelCode.br.com.testeDevelCode.entidades.Usuarios;

public class UsuarioValidacao {

	@NotNull
	
	private String nome;

	private Date dtNascimento;

	private byte[] foto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


	public Usuarios converter() {
		return new Usuarios(nome, dtNascimento, foto);
	}

}
