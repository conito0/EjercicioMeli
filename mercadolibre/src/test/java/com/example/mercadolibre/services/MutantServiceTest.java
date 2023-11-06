package com.example.mercadolibre.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MutantServiceTest {

    MutantService mutantService = new MutantService();

    @Test
    void isMutantFailed() {

        String[] failed = {
                "ATGCGA",
                "CAGTGC",
                "TTGTGA",
                "AGAAGG",
                "CTCCCA",
                "TCACTG"
        };

        Assertions.assertFalse(mutantService.isMutant(failed));

    }

    @Test
    void isMutantSuccess() {

        String[] failed = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };

        Assertions.assertTrue(mutantService.isMutant(failed));

    }

}