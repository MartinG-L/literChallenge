package com.example.literchallenge.literchallenge;

import com.example.literchallenge.literchallenge.principal.Principal;
import com.example.literchallenge.literchallenge.repository.AutorRepository;
import com.example.literchallenge.literchallenge.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterchallengeApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiterchallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroRepository,autorRepository);
		principal.mostrarMenu();
	}
}
