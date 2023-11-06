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

            String[] success = {
                    "ATGCGA",
                    "CAGTGC",
                    "TTATGT",
                    "AGAAGG",
                    "CCCCTA",
                    "TCACTG"
            };

            Assertions.assertTrue(mutantService.isMutant(success));

        }

        @Test
        void isMutantSuccessTwo() {

            String[] success = {
                    "ATGCGA",
                    "CAGTGC",
                    "TTATCT",
                    "AGAAGG",
                    "CCCCTA",
                    "TCACTG"
            };

            Assertions.assertTrue(mutantService.isMutant(success));

        }

        @Test
        void isMutantSuccessAllLettersEquals() {

            String[] success = {
                    "AAAAAA",
                    "AAAAAA",
                    "AAAAAA",
                    "AAAAAA",
                    "AAAAAA",
                    "AAAAAA"
            };

            Assertions.assertTrue(mutantService.isMutant(success));

        }

        @Test
        void isMutantSuccessFour() {

            String[] success = {
                    "ATGCGA",
                    "CAGTGA",
                    "TTATGA",
                    "AGAAGG",
                    "CCCCTA",
                    "AAAAAG"
            };

            Assertions.assertTrue(mutantService.isMutant(success));

        }

        @Test
        void isMutantFailedOnlyOne() {

            String[] failed = {
                    "ATGCGA",
                    "CAGTGC",
                    "TTATAT",
                    "AGATGG",
                    "CCCCTA",
                    "TCACTG"
            };

            Assertions.assertFalse(mutantService.isMutant(failed));

        }

        @Test
        void isMutantFailedZero() {

            String[] failed = {
                    "ATGCGA",
                    "CAGTGC",
                    "TTATGT",
                    "AGATGG",
                    "CCGCTA",
                    "TCACTG"
            };

            Assertions.assertFalse(mutantService.isMutant(failed));

        }

        @Test
        void isMutantSuccessThreeHorizontal() {

            String[] success = {
                    "AAAAGA",
                    "CAGTGC",
                    "TTTTAT",
                    "AGATGG",
                    "CCCCTA",
                    "TCACTG"
            };

            Assertions.assertTrue(mutantService.isMutant(success));

        }

        @Test
        void isMutantSuccessThreeVertical() {

            String[] success = {
                    "AGATGA",
                    "CGGTGA",
                    "TGTTAA",
                    "AGATGA",
                    "CCGCTA",
                    "TCACTG"
            };

            Assertions.assertTrue(mutantService.isMutant(success));

        }

        @Test
        void isMutantSuccessThreeOblique() {

            String[] success = {
                    "ATGCGA",
                    "CAGTGC",
                    "TCATTT",
                    "ATCAGG",
                    "CCTCTA",
                    "TCATTG"
            };

            Assertions.assertTrue(mutantService.isMutant(success));

        }
    }

