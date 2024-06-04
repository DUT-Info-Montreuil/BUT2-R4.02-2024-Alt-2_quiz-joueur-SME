package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.ScoreDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.ParametresCreationJoueurException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.PseudoExistantException;

import java.util.ArrayList;
import java.util.List;

public class ServiceJoueurtestCasReussiMOCK implements IServiceJoueur {
    private List<JoueurDTO> lesJoueurs;

    public ServiceJoueurtestCasReussiMOCK() {
        this.lesJoueurs = new ArrayList<>();
    }

    public

    @Override
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int dateNaissance, LangueEnum languePreferee) throws ParametresCreationJoueurException, PseudoExistantException {
        List<String> centreInterets;
        centreInterets = new ArrayList<>();
        return ajouterJoueur(prenom, pseudo, dateNaissance, languePreferee, centreInterets);
    }

    @Override
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int dateNaissance, LangueEnum languePreferee, List<String> centreInterets) throws ParametresCreationJoueurException, PseudoExistantException {
        List<ScoreDTO> scores = new ArrayList<>();
        JoueurDTO joueurDTO = new JoueurDTO(prenom, pseudo, dateNaissance, centreInterets, languePreferee, scores);
        lesJoueurs.add(joueurDTO);
        return joueurDTO;
    }

    @Override
    public List<JoueurDTO> getLesJoueurs() {
        return lesJoueurs;
    }
}
