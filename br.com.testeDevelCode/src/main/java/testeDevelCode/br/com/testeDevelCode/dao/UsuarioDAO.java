package testeDevelCode.br.com.testeDevelCode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import testeDevelCode.br.com.testeDevelCode.entidades.Usuarios;

public interface UsuarioDAO extends JpaRepository<Usuarios, Long> {

	java.util.List<Usuarios> findByNome(String nome);

	@Query("SELECT e FROM Usuario e WHERE e.nome = :nome")
	java.util.List<Usuarios> buscaPeloNome(@Param("nome") String nome);

}
