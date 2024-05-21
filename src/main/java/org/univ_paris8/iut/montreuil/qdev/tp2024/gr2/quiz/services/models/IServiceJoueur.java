package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.ParametresCreationJoueurException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.PseudoExistantException;

import java.util.List;

public interface IServiceJoueur {

    //ajouter un joueur sans ses centres d’intérêts
    void ajouterJoueur(String prenom, String pseudo, int dateNaissance, LangueEnum languePreferee) throws ParametresCreationJoueurException, PseudoExistantException;

    //ajouter un joueur avec les centres d’intérêts
    void ajouterJoueur(String prenom, String pseudo, int dateNaissance, LangueEnum languePreferee, List<String> centreInterets) throws ParametresCreationJoueurException, PseudoExistantException;
}
