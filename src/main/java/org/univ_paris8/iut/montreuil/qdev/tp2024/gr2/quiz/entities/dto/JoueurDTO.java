package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;

import java.util.List;

public class JoueurDTO {
    private String prenom;
    private String pseudo;
    private int dateNaissance;
    private List<String> centresInterets;
    private LangueEnum languePreferee;
    private List<ScoreDTO> lesScores;

    public JoueurDTO(String prenom, String pseudo, int dateNaissance, List<String> centresInterets, LangueEnum languePreferee, List<ScoreDTO> lesScores) {
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.dateNaissance = dateNaissance;
        this.centresInterets = centresInterets;
        this.languePreferee = languePreferee;
        this.lesScores = lesScores;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(int dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<String> getCentresInterets() {
        return centresInterets;
    }

    public void setCentresInterets(List<String> centresInterets) {
        this.centresInterets = centresInterets;
    }

    public LangueEnum getLanguePreferee() {
        return languePreferee;
    }

    public void setLanguePreferee(LangueEnum languePreferee) {
        this.languePreferee = languePreferee;
    }

    public List<ScoreDTO> getLesScores() {
        return lesScores;
    }

    public void setLesScores(List<ScoreDTO> lesScores) {
        this.lesScores = lesScores;
    }
}
