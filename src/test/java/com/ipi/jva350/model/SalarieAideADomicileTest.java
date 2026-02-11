package com.ipi.jva350.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testCalculeJoursDeCongeDecomptesPourPlageRight() {
        //Given
        SalarieAideADomicile sa = new SalarieAideADomicile();
        LocalDate dateDebut = LocalDate.parse("2025-11-01");
        LocalDate dateFin = LocalDate.parse("2025-12-01");

        //When
        LinkedHashSet<LocalDate> joursDeConges = sa.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
        //Then
        Assertions.assertEquals(24, joursDeConges.size());
    }

    @Test
    public void testCalculeJoursDeCongeDecomptesPourPlageWrong() {
        //Given
        SalarieAideADomicile sa = new SalarieAideADomicile();
        LocalDate dateDebut = LocalDate.parse("2025-11-01");
        LocalDate dateFin = LocalDate.parse("2025-12-01");

        //When
        LinkedHashSet<LocalDate> joursDeConges = sa.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
        //Then
        Assertions.assertNotEquals(20, joursDeConges.size());
    }
}
