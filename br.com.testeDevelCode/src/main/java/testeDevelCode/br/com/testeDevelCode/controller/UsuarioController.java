package testeDevelCode.br.com.testeDevelCode.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import testeDevelCode.br.com.testeDevelCode.controller.dto.UsuarioDTO;
import testeDevelCode.br.com.testeDevelCode.controller.dto.UsuarioValidacao;
import testeDevelCode.br.com.testeDevelCode.dao.UsuarioDAO;
import testeDevelCode.br.com.testeDevelCode.entidades.Usuarios;

@RestController
@RequestMapping("/teste")
public class UsuarioController {

		@Autowired
		private UsuarioDAO usuarioDAO;

		@GetMapping
		public List<UsuarioDTO> lista(String nome) {

			if (nome == null) {
				List<Usuarios> user = usuarioDAO.findAll();
				return new UsuarioDTO().converter(user);
			} else {
				List<Usuarios> user1 = usuarioDAO.findByNome(nome);
				return new UsuarioDTO().converter(user1);
			}

		}

		@GetMapping("/{codigo}")
		public ResponseEntity<UsuarioDTO> unicoUsuario(@PathVariable Long codigo) {
			try {
				Usuarios usuario = usuarioDAO.getOne(codigo);
				return ResponseEntity.ok(new UsuarioDTO(usuario));
			} catch (Exception e) {
				return ResponseEntity.notFound().build();
			}
		}

		@PostMapping
		@Transactional
		public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioValidacao usuarioValidacao,
				UriComponentsBuilder uriBuilder) {

			Usuarios usuario = usuarioValidacao.converter();
			usuarioDAO.save(usuario);

			URI uri = uriBuilder.path("/teste/{codigo}").buildAndExpand(usuario.getCodigo()).toUri();
			return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));

		}

		@PutMapping("/{codigo}")
		@Transactional
		public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long codigo,
				@RequestBody UsuarioValidacao usuarioValidacao) {

			try {
				Usuarios usuario = usuarioDAO.getOne(codigo);

				usuario.setDtNascimento(usuarioValidacao.getDtNascimento());
				usuario.setNome(usuarioValidacao.getNome());
				usuario.setFoto(usuarioValidacao.getFoto());

				return ResponseEntity.ok(new UsuarioDTO(usuario));

			} catch (Exception e) {
				return ResponseEntity.notFound().build();
			}
		}

		@DeleteMapping("/{codigo}")
		@Transactional
		public ResponseEntity<?> excluir(@PathVariable Long codigo) {

			try {
				usuarioDAO.deleteById(codigo);
				return ResponseEntity.ok().build();

			} catch (Exception e) {
				return ResponseEntity.notFound().build();
			}

		}
	

}
