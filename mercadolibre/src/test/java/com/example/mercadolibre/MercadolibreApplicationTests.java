package com.example.mercadolibre;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

@SpringBootTest
class MercadolibreApplicationTests {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Test
	void checkMutantInvalidLetter() {

		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("ATGCGA\nCHGTGC\nCAGTGC\nTTATGT\nAGAAGG\nCCCCTA\nTCACTG\n".getBytes());
		System.setIn(in);

		System.setErr(new PrintStream(errContent));

		Assertions.assertDoesNotThrow(MercadolibreApplication::checkMutant);
		Assertions.assertTrue(errContent.toString().contains("La cadena ingresada 'CHGTGC' solo debe contener los siguientes caracteres ATCG"));

		System.setErr(originalErr);
		System.setIn(sysInBackup);
	}

	@Test
	void checkMutantInvalidSize() {

		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("ATGCGA\nHOLA SOY UNA SUPER CADENA\nCAGTGC\nTTATGT\nAGAAGG\nCCCCTA\nTCACTG\n".getBytes());
		System.setIn(in);

		System.setErr(new PrintStream(errContent));

		Assertions.assertDoesNotThrow(MercadolibreApplication::checkMutant);
		Assertions.assertTrue(errContent.toString().contains("La cadena ingresada debe de tener 6 caracteres"));

		System.setErr(originalErr);
		System.setIn(sysInBackup);
	}

}
