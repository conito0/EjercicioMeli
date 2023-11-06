package com.example.mercadolibre;

import com.example.mercadolibre.services.MutantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MercadolibreApplication {

	public static final int LINES_QUANTITY = 6;
	public static final int LINES_LONG = 6;
	public static final String ALLOWED_CHARACTERS = "ATCG";





	public static MutantService mutantService = new MutantService();

	public static void checkMutant() {

		System.out.println("=== Analisis de mutantes ===");
		System.out.println("Ingrese las cadenas de ADN:");

		Scanner scanner = new Scanner(System.in);

		List<String> dna = new ArrayList<>();

		while (dna.size() < LINES_QUANTITY) {

			System.out.printf("[Linea %d] ", dna.size() + 1);
			String line = scanner.nextLine();

			if(line.length() != LINES_LONG) {
				System.err.printf("La cadena ingresada debe de tener %d caracteres%n", LINES_LONG);
				continue;
			}

			if(!line.chars()
					.mapToObj(c -> (char) c)
					.allMatch(c -> ALLOWED_CHARACTERS.contains(String.valueOf(c)))) {
				System.err.printf("La cadena ingresada '%s' solo debe contener los siguientes caracteres %s%n", line, ALLOWED_CHARACTERS);
				continue;
			}

			dna.add(line);

		}

		boolean isMutant = mutantService.isMutant(dna.toArray(new String[0]));

		System.out.println(isMutant ? "!!!El ADN ingresado es de un mutante!!!" : "El ADN ingresado es de un humano");

	}

	public static void main(String[] args) {
		SpringApplication.run(MercadolibreApplication.class, args);

		MercadolibreApplication.checkMutant();

	}

}
