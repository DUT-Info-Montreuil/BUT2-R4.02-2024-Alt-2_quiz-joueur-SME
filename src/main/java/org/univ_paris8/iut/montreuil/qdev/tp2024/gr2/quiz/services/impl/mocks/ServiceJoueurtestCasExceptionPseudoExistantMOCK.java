package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.ScoreDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.ParametresCreationJoueurException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.PseudoExistantException;

import java.util.ArrayList;
import java.util.List;

public class ServiceJoueurtestCasExceptionPseudoExistantMOCK implements IServiceJoueur {
    private List<String> listePseudo;
    private List<JoueurDTO> lesJoueurs;

    public ServiceJoueurtestCasExceptionPseudoExistantMOCK() {
        this.listePseudo = new ArrayList<>();
        lesJoueurs = new ArrayList<>();
    }

    @Override
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int dateNaissance, LangueEnum languePreferee) throws ParametresCreationJoueurException, PseudoExistantException {
        List<String> centreInterets;
        centreInterets = new ArrayList<>();
        return ajouterJoueur(prenom, pseudo, dateNaissance, languePreferee, centreInterets);
    }

    @Override
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int dateNaissance, LangueEnum languePreferee, List<String> centreInterets) throws ParametresCreationJoueurException, PseudoExistantException {
        if (listePseudo.contains(pseudo)) {
            throw new PseudoExistantException();
        } else {
            listePseudo.add(pseudo);
            List<ScoreDTO> scores = new ArrayList<>();
            JoueurDTO joueurDTO = new JoueurDTO(prenom, pseudo, dateNaissance, centreInterets, languePreferee, scores);
            lesJoueurs.add(joueurDTO);
            return joueurDTO;
        }
    }

    @Override
    public List<JoueurDTO> getLesJoueurs() {
        return lesJoueurs;
    }
}
