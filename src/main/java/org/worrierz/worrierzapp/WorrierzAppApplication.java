package org.worrierz.worrierzapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorrierzAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorrierzAppApplication.class, args);
	}

	@Bean
	WorrierCharacterGenerator worrierCharacterGenerator(final DictionaryHandler dictionaryHandler) {
		return new WorrierCharacterGeneratorImpl(dictionaryHandler);
	}

}
