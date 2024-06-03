package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.ScoreDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.ParametresCreationJoueurException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.PseudoExistantException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
//TODO : Je mets en TODO les changements que j'ai fait
public class ServiceJoueurImpl implements IServiceJoueur {

    private List<JoueurDTO> lesJoueurs = new ArrayList<>();

    //Variable static pour contrôler l'unicité
    private static ServiceJoueurImpl uniqueInstance;

    //Constructeur private pour initialiser les attributs de la classe
    private ServiceJoueurImpl() {}

    // Methode pour créer l'unique instance du Service Joueur
    public static ServiceJoueurImpl getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ServiceJoueurImpl();
        }
        return uniqueInstance;
    }


    //MÉTHODES
    @Override
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int dateNaissance, LangueEnum languePreferee) throws ParametresCreationJoueurException, PseudoExistantException {
        return ajouterJoueur(prenom, pseudo, dateNaissance, languePreferee, new ArrayList<>());
    }

    @Override
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int dateNaissance, LangueEnum languePreferee, List<String> centreInterets) throws ParametresCreationJoueurException, PseudoExistantException {
        // Vérification des paramètres
        validerParametres(prenom, pseudo, dateNaissance, centreInterets);
        // Vérification de la contrainte du pseudo unique
        if (siJoueurExiste(pseudo)) {
            throw new PseudoExistantException("Le pseudo existe déjà.");
        }
        // Ajout du joueur
        JoueurDTO nouveauJoueur = new JoueurDTO(prenom, pseudo, dateNaissance, centreInterets, languePreferee, new ArrayList<ScoreDTO>());
        lesJoueurs.add(nouveauJoueur);
        return nouveauJoueur;
    }

    //MÉTHODES PRIVATE
    private void validerParametres(String prenom, String pseudo, int dateNaissance, List<String> centresInterets) throws ParametresCreationJoueurException {
        if (prenom == null || prenom.length() < 2 || !prenom.matches("[a-zA-ZáÁàÀâÂäÄçÇéÉèÈêÊëËóÓòÒôÔöÖúÚùÙûÛüÜíÍìÌîÎïÏýÝÿŸñÑẞßæÆœŒ'\\-]+")) {
            throw new ParametresCreationJoueurException("Prénom invalide : doit avoir au moins 2 caractères et ne contenir que des lettres, des tirets ou des apostrophes.");
        }

        if (pseudo == null || pseudo.length() < 2 || !pseudo.matches("[a-zA-Z0-9áÁàÀâÂäÄçÇéÉèÈêÊëËóÓòÒôÔöÖúÚùÙûÛüÜíÍìÌîÎïÏýÝÿŸñÑẞßæÆœŒ\\-_]+")) {
            throw new ParametresCreationJoueurException("Pseudo invalide : doit avoir au moins 2 caractères et ne contenir que des lettres, des chiffres, des tirets ou des underscores.");
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (dateNaissance < 1907 || dateNaissance > currentYear) {
            throw new ParametresCreationJoueurException("Date de naissance invalide : doit être entre 1907 et l'année actuelle.");
        }

        for (String interet : centresInterets) {
            if (interet == null || interet.length() < 2 || !interet.matches("[a-zA-ZáÁàÀâÂäÄçÇéÉèÈêÊëËóÓòÒôÔöÖúÚùÙûÛüÜíÍìÌîÎïÏýÝÿŸñÑẞßæÆœŒ'\\-]+")) {
                throw new ParametresCreationJoueurException("Centre d'intérêt invalide : chaque intérêt doit avoir au moins 2 caractères et ne contenir que des lettres des cinq alphabets définis.");
            }
        }

    }

    private boolean siJoueurExiste(String pseudo) {
        for (JoueurDTO joueur : lesJoueurs) {
            if (joueur.getPseudo().equalsIgnoreCase(pseudo)) {
                return true;
            }
        }
        return false;
    }

    //GETTERS & SETTERS
    public List<JoueurDTO> getLesJoueurs() {
        return lesJoueurs;
    }

    public void setLesJoueurs(List<JoueurDTO> lesJoueurs) {
        this.lesJoueurs = lesJoueurs;
    }
}
