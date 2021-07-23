package testeDevelCode.br.com.testeDevelCode.controller.dto;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import testeDevelCode.br.com.testeDevelCode.entidades.Usuarios;

public class UsuarioDTO {

	private Long codigo;
	private String nome;
	private Date dtNascimento;

	public UsuarioDTO(Usuarios user) {
		this.codigo = user.getCodigo();
		this.nome = user.getNome();
		this.dtNascimento = user.getDtNascimento();
			
	}

	public UsuarioDTO() {

	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public List<UsuarioDTO> converter(List<Usuarios> usuarios) {
		if (usuarios != null && usuarios.isEmpty()) {
			return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
		} else {
			return null;

		}
	}

}
