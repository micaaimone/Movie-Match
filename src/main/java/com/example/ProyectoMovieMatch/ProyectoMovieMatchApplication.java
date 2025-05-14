package com.example.ProyectoMovieMatch;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class ProyectoMovieMatchApplication {


	public static void main(String[] args) {
		SpringApplication.run(ProyectoMovieMatchApplication.class, args);
		Dotenv dotenv = Dotenv.load();
		String port = dotenv.get("PORT");
		System.out.println("Puerto: " + port);
	}
}
