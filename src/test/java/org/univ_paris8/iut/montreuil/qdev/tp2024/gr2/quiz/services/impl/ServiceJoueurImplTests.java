package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks.*;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceJoueurImplTests {

    private IServiceJoueur serviceJoueur;

    private static String prenomValide = "Jean";
    private static String pseudoValide = "jean12";
    private static int anneeValide = 1995;
    private static LangueEnum langueValide = LangueEnum.english;
    private static List<String> interetsValide = new ArrayList<>();

    @BeforeAll
    public static void init() {
        interetsValide.add("football");
        interetsValide.add("nature");
    }

    @BeforeEach
    public void setUp() {
        //À décommenter - Mock
        serviceJoueur = ServiceJoueurImpl.getUniqueInstance();
        serviceJoueur.getLesJoueurs().clear();
    }

    @AfterEach
    public void tearDown() {
        serviceJoueur = null;
    }

    @Test
    public void testAjoutJoueurCasReussi() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasReussiMOCK();

        JoueurDTO joueur = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                        prenomValide,
                        pseudoValide,
                        anneeValide,
                        langueValide,
                        interetsValide),
                "Tous les paramètres sont valides, aucune exception est attendue");

        assertEquals(prenomValide, joueur.getPrenom());
        assertEquals(pseudoValide, joueur.getPseudo());
        assertEquals(anneeValide, joueur.getDateNaissance());
        assertEquals(langueValide, joueur.getLanguePreferee());
        int i = 0;
        for (String interet : interetsValide) {
            assertEquals(interet, joueur.getCentresInterets().get(i));
            i++;
        }
        assertEquals(0, joueur.getLesScores().size());
        assertTrue(serviceJoueur.getLesJoueurs().contains(joueur));
    }

    @Test
    public void testAjoutJoueurCasPrenomValide() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasReussiMOCK();

        JoueurDTO joueurPrenomDeuxLettres = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                "Ao",
                "pseudo1",
                anneeValide,
                langueValide,
                interetsValide));
        assertEquals("Ao", joueurPrenomDeuxLettres.getPrenom());

        JoueurDTO joueurPrenomLettreFra = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                "François",
                "pseudo2",
                anneeValide,
                langueValide,
                interetsValide));
        assertEquals("François", joueurPrenomLettreFra.getPrenom());

        JoueurDTO joueurPrenomLettreEng = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                "emily",
                "pseudo3",
                anneeValide,
                langueValide,
                interetsValide));
        assertEquals("emily", joueurPrenomLettreEng.getPrenom());

        JoueurDTO joueurPrenomLettreAllemand = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                "Kißlägg",
                "pseudo4",
                anneeValide,
                langueValide,
                interetsValide));
        assertEquals("Kißlägg", joueurPrenomLettreAllemand.getPrenom());

        JoueurDTO joueurPrenomLettreItalien = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                "Iacopó",
                "pseudo5",
                anneeValide,
                langueValide,
                interetsValide));
        assertEquals("Iacopó", joueurPrenomLettreItalien.getPrenom());

        JoueurDTO joueurPrenomLettreEspagnol = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                "Toño",
                "pseudo6",
                anneeValide,
                langueValide,
                interetsValide));
        assertEquals("Toño", joueurPrenomLettreEspagnol.getPrenom());

        JoueurDTO joueurPrenomCompose = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                "Jean-Pierre",
                "pseudo7",
                anneeValide,
                langueValide,
                interetsValide));
        assertEquals("Jean-Pierre", joueurPrenomCompose.getPrenom());
    }

    @Test
    public void testAjoutJoueurCasPseudoValide() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasReussiMOCK();

        JoueurDTO joueurPseudoDeuxCaracteres = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                prenomValide,
                "oO",
                anneeValide,
                langueValide,
                interetsValide));
        assertEquals("oO", joueurPseudoDeuxCaracteres.getPseudo());

        JoueurDTO joueurPseudoAvecTiret = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                prenomValide,
                "ilo-o",
                anneeValide,
                langueValide,
                interetsValide));
        assertEquals("ilo-o", joueurPseudoAvecTiret.getPseudo());
        ;

        JoueurDTO joueurPseudoAvecUnderscore = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                prenomValide,
                "ilo__t",
                anneeValide,
                langueValide,
                interetsValide));
        assertEquals("ilo__t", joueurPseudoAvecUnderscore.getPseudo());
        ;

    }

    @Test
    public void testAjoutJoueurCasAnneeValide() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasReussiMOCK();

        JoueurDTO joueurAnneeEnCours = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                prenomValide,
                pseudoValide,
                2024,
                langueValide,
                interetsValide));
        assertEquals(2024, joueurAnneeEnCours.getDateNaissance());
    }

    @Test
    public void testAjoutJoueurCasInteretsValide() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasReussiMOCK();

        List<String> interetAvecVide = new ArrayList<>();
        JoueurDTO joueurInteretVide = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                prenomValide,
                "pseudo1",
                anneeValide,
                langueValide,
                interetAvecVide));
        assertEquals(0, joueurInteretVide.getCentresInterets().size());

        List<String> interetDeuxLettres = new ArrayList<>();
        interetDeuxLettres.add("football");
        interetDeuxLettres.add("Ao");
        JoueurDTO joueurInteretDeuxLettres = assertDoesNotThrow(() -> serviceJoueur.ajouterJoueur(
                prenomValide,
                "pseudo2",
                anneeValide,
                langueValide,
                interetDeuxLettres));
        assertEquals("football", joueurInteretDeuxLettres.getCentresInterets().get(0));
        assertEquals("Ao", joueurInteretDeuxLettres.getCentresInterets().get(1));
    }

    @Test
    public void testAjoutJoueurCasInvalidePseudoExistant() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasExceptionPseudoExistantMOCK();

        assertDoesNotThrow(() -> {
            serviceJoueur.ajouterJoueur(prenomValide, "toto12", anneeValide, langueValide, interetsValide);
        }, "Le pseudo est censé ne pas exister");

        assertThrows(PseudoExistantException.class, () -> {
            serviceJoueur.ajouterJoueur(prenomValide, "toto12", anneeValide, langueValide, interetsValide);
        }, "Le pseudo existe déjà, une exception est attendue");
    }

    @Test
    public void testAjoutJoueurCasPseudoCaseSensible() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasExceptionPseudoExistantMOCK();

        assertDoesNotThrow(() -> {
            serviceJoueur.ajouterJoueur(prenomValide, "toto12", anneeValide, langueValide, interetsValide);
        }, "Le pseudo est censé ne pas exister");

        assertDoesNotThrow(() -> {
            serviceJoueur.ajouterJoueur(prenomValide, "TOTO12", anneeValide, langueValide, interetsValide);
        }, "Le pseudo est censé être accepté");

    }

    @Test
    public void testAjoutJoueurCasPrenomInvalide() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasExceptionPrenomMOCK();

        assertThrows(PrenomInvalideException.class, () -> serviceJoueur.ajouterJoueur(
                        "",
                        pseudoValide,
                        anneeValide,
                        langueValide,
                        interetsValide),
                "Prénom vide");

        assertThrows(PrenomInvalideException.class, () -> serviceJoueur.ajouterJoueur(
                        "u",
                        pseudoValide,
                        anneeValide,
                        langueValide,
                        interetsValide),
                "Prénom de taille 1");

        assertThrows(PrenomInvalideException.class, () -> serviceJoueur.ajouterJoueur(
                "pierre1",
                pseudoValide,
                anneeValide,
                langueValide,
                interetsValide), "Prénom avec chiffre");

        assertThrows(PrenomInvalideException.class, () -> serviceJoueur.ajouterJoueur(
                "+zen",
                pseudoValide,
                anneeValide,
                langueValide,
                interetsValide), "Prénom avec caractère interdit");
    }

    @Test
    public void testAjoutJoueurCasPseudoInvalide() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasExceptionPseudoInvalideMOCK();

        assertThrows(PseudoInvalideException.class, () -> serviceJoueur.ajouterJoueur(
                prenomValide,
                "",
                anneeValide,
                langueValide,
                interetsValide), "Pseudo vide");

        assertThrows(PseudoInvalideException.class, () -> serviceJoueur.ajouterJoueur(
                prenomValide,
                "A",
                anneeValide,
                langueValide,
                interetsValide), "Pseudo de taille un");

        assertThrows(PseudoInvalideException.class, () -> serviceJoueur.ajouterJoueur(
                prenomValide,
                "t*to",
                anneeValide,
                langueValide,
                interetsValide), "Pseudo avec caractère interdit");

        assertThrows(PseudoInvalideException.class, () -> serviceJoueur.ajouterJoueur(
                prenomValide,
                "Michèle12",
                anneeValide,
                langueValide,
                interetsValide), "Pseudo avec alphabet non latin");
    }

    @Test
    public void testAjoutJoueurCasDateInvalide() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasExceptionNaissanceMOCK();

        assertThrows(AnneeDeNaissanceException.class, () -> serviceJoueur.ajouterJoueur(
                prenomValide,
                pseudoValide,
                -2002,
                langueValide,
                interetsValide), "Année négative");

        assertThrows(AnneeDeNaissanceException.class, () -> serviceJoueur.ajouterJoueur(
                prenomValide,
                pseudoValide,
                2025,
                langueValide,
                interetsValide), "Année du futur");

        assertThrows(AnneeDeNaissanceException.class, () -> serviceJoueur.ajouterJoueur(
                prenomValide,
                pseudoValide,
                1907,
                langueValide,
                interetsValide), "Année inférieur à 1907");
    }

    @Test
    public void testAjoutJoueurCasCentreInteretsInvalide() {
        //Mock
        //serviceJoueur = new ServiceJoueurtestCasExceptionInteretsMOCK();

        List<String> interetAvecTailleInvalide = new ArrayList<>();
        interetAvecTailleInvalide.add("football");
        interetAvecTailleInvalide.add("A");

        assertThrows(CentresInteretsInvalidesException.class, () -> serviceJoueur.ajouterJoueur(
                prenomValide,
                pseudoValide,
                anneeValide,
                langueValide,
                interetAvecTailleInvalide), "Liste avec un centre d'intérêt de taille inférieure à deux");


        List<String> interetAvecCaractereInvalide = new ArrayList<>();
        interetAvecCaractereInvalide.add("fo^tball");
        interetAvecCaractereInvalide.add("yoga");
        assertThrows(CentresInteretsInvalidesException.class, () -> serviceJoueur.ajouterJoueur(
                prenomValide,
                pseudoValide,
                anneeValide,
                langueValide,
                interetAvecCaractereInvalide), "Liste avec un centre d'intérêt contenant un caractère invalide");

        List<String> interetAvecChiffre = new ArrayList<>();
        interetAvecChiffre.add("footb4ll");
        interetAvecChiffre.add("yoga");
        assertThrows(CentresInteretsInvalidesException.class, () -> serviceJoueur.ajouterJoueur(
                prenomValide,
                pseudoValide,
                anneeValide,
                langueValide,
                interetAvecChiffre), "Liste avec un centre d'intérêt contenant un chiffre");
    }
}
