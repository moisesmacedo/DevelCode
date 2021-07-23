package testeDevelCode.br.com.testeDevelCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import testeDevelCode.br.com.testeDevelCode.dao.UsuarioDAO;

@SpringBootApplication
public class Application {

	@Autowired
	private UsuarioDAO usuarioDao;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}
