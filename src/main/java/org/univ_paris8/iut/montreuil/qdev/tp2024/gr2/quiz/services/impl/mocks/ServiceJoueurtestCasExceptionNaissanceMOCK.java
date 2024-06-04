package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.AnneeDeNaissanceException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.ParametresCreationJoueurException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.PseudoExistantException;

import java.util.ArrayList;
import java.util.List;

public class ServiceJoueurtestCasExceptionNaissanceMOCK implements IServiceJoueur {
    @Override
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int dateNaissance, LangueEnum languePreferee) throws ParametresCreationJoueurException, PseudoExistantException {
        throw new AnneeDeNaissanceException();
    }

    @Override
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int dateNaissance, LangueEnum languePreferee, List<String> centreInterets) throws ParametresCreationJoueurException, PseudoExistantException {
        throw new AnneeDeNaissanceException();
    }

    @Override
    public List<JoueurDTO> getLesJoueurs() {
        return new ArrayList<>();
    }
}
