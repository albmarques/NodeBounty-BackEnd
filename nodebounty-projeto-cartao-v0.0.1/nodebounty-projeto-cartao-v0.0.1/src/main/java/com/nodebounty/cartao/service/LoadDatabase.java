package com.nodebounty.cartao.service;

import java.time.LocalDate;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.nodebounty.cartao.model.Cartao;
import com.nodebounty.cartao.model.ICartaoRepository;

@Configuration
public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDatabase(ICartaoRepository repository) {
        return args -> {
            LocalDate validade1 = LocalDate.of(2023, 12, 31);
            LocalDate validade2 = LocalDate.of(2024, 6, 30);
            LocalDate validade3 = LocalDate.of(2024, 9, 15);

            Cartao cartao1 = new Cartao(1L, "João Silva", validade1, "1234567890123456", (short) 123);
            Cartao cartao2 = new Cartao(2L, "Maria Souza", validade2, "9876543210987654", (short) 456);
            Cartao cartao3 = new Cartao(3L, "José Pereira", validade3, "5555666677778888", (short) 789);

            repository.saveAll(Arrays.asList(cartao1, cartao2, cartao3));

            logger.info(">>>>> loaddatabase -> cadastro de 3 cartões realizado.");
        };
    }
}