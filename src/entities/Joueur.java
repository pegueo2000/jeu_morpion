package entities;

public class Joueur {
    protected String symbole;
    protected  Boolean tour;

    public Joueur() {
    }

    public Joueur(String symbole, Boolean tour) {
        this.symbole = symbole;
        this.tour = tour;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public Boolean getTour() {
        return tour;
    }

    public void setTour(Boolean tour) {
        this.tour = tour;
    }
}
