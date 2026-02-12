package com.ipi.jva350.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class SalarieAideADomicileTest {
    @Test
    public void TestaLegalementDroitADesCongesPayes(){
        //Given
        SalarieAideADomicile sa = new SalarieAideADomicile();
        sa.setJoursTravaillesAnneeNMoins1(11);
        Assertions.assertNotNull(sa);
        //When
        Boolean aLeDroit = sa.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(true, aLeDroit);
    }

    @Test
    public void TestaLegalementDroitADesCongesPayes_10jr(){
        //Given
        SalarieAideADomicile sa = new SalarieAideADomicile();
        sa.setJoursTravaillesAnneeNMoins1(9);
        Assertions.assertNotNull(sa);
        //When
        Boolean aLeDroit = sa.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(false, aLeDroit);
    }

    @ParameterizedTest
    @CsvSource({
            "2025-11-01,2025-12-01"
    })
    public void testCalculeJoursDeCongeDecomptesPourPlageRight(String debut, String fin) {
        // Given
        SalarieAideADomicile unSalarie = new SalarieAideADomicile();
        LocalDate dateDebut = LocalDate.parse(debut);
        LocalDate dateFin = LocalDate.parse(fin);

        // When
        LinkedHashSet<LocalDate> joursDeConges = unSalarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);

        // Then
        Assertions.assertEquals(24, joursDeConges.size());
    }


    @ParameterizedTest
    @CsvSource({
            "2025-11-01,2025-12-01"
    })
    public void testCalculeJoursDeCongeDecomptesPourPlageWrong(String debut, String fin) {
        // Given
        SalarieAideADomicile unSalarie = new SalarieAideADomicile();
        LocalDate dateDebut = LocalDate.parse(debut);
        LocalDate dateFin = LocalDate.parse(fin);

        // When
        LinkedHashSet<LocalDate> joursDeConges = unSalarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);

        // Then
        Assertions.assertNotEquals(20, joursDeConges.size());
    }
}
