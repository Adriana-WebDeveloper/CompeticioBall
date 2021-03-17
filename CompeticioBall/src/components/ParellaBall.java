/*
 * Classe que defineix una parella de ball. Una parella de ball es defineix per el
 * número d'inscripció, un ballarí, una ballarina i la puntuació obtinguda en la competició.
 */
package components;

/**
 *
 * @author Adriana Serrano
 */
public class ParellaBall {

    private int numInscripcio;
    private Ballari ballari;
    private Ballari ballarina;
    private int puntuacio;

    /*
     TODO CONSTRUCTOR
     Paràmetres: Els corresponents als atributs menys la puntuació i número d'inscripció
     Accions:
     - Assignarem 0 al número d'inscripció, ja que quan es crea una parella
     encara no està inscrita a cap modalitat.
     - En el cas de l'atribut puntuacio, s'ha d'inicialitzar a 0, ja que quan es
     crea una parella de ball encara ha de competir i per tant no té puntuació
     */
    public ParellaBall(Ballari _ballari, Ballari _ballarina) {
        this.ballari = _ballari;
        this.ballarina = _ballarina;
        this.numInscripcio = 0;
        this.puntuacio = 0;
    }

    /*
    TODO Mètodes accessors    
     */
    public Ballari getBallari() {
        return this.ballari;
    }

    public Ballari getBallarina() {
        return this.ballarina;
    }

    public int getNumInscripcio() {
        return this.numInscripcio;
    }

    public int getPuntuacio() {
        return this.puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public void setNumInscripcio(int numInscripcio) {
        this.numInscripcio = numInscripcio;
    }

    public void showParellaBall() {
        System.out.println("\nLes dades de la parella de ball amb número d'inscripció " + numInscripcio + " són:");

        if (ballari != null) {
            ballari.showBallari();
        } else {
            System.out.println("\nEncara no hi ha ballarí assignat");
        }

        if (ballarina != null) {
            ballarina.showBallari();
        } else {
            System.out.println("\nEncara no hi ha ballarina assignada");
        }

        System.out.println("\nPuntuació: " + puntuacio);
    }
}
