package br.com.lavanderia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.lavanderia.repository.UsuarioRepository;

@SpringBootApplication
public class LavanderiaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LavanderiaApiApplication.class, args);
	}

	@Bean
	CommandLineRunner testarConexao(
        UsuarioRepository usuarioRepository) {

    return args -> {
        System.out.println(
            "Total de usuários: "
            + usuarioRepository.count()
        );
    };
}
}