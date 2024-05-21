package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto;

public class ScoreDTO {
    private int nbQuestionsTotal;
    private int nbQuestionsReussies;
    private int temps;

    public ScoreDTO(int nbQuestionsTotal, int nbQuestionsReussies, int temps) {
        this.nbQuestionsTotal = nbQuestionsTotal;
        this.nbQuestionsReussies = nbQuestionsReussies;
        this.temps = temps;
    }

    public int getNbQuestionsTotal() {
        return nbQuestionsTotal;
    }

    public void setNbQuestionsTotal(int nbQuestionsTotal) {
        this.nbQuestionsTotal = nbQuestionsTotal;
    }

    public int getNbQuestionsReussies() {
        return nbQuestionsReussies;
    }

    public void setNbQuestionsReussies(int nbQuestionsReussies) {
        this.nbQuestionsReussies = nbQuestionsReussies;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

}
