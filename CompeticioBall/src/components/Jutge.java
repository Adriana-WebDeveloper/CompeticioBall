/*
 * Classe que defineix un jutge. Un/a jutge es defineix pel seu NIF i nom.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author Adriana Serrano
 */
public class Jutge {

    static Scanner DADES = new Scanner(System.in);
    private String nif;
    private String nom;

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public Jutge(String _nif, String _nom) {
        this.nif = _nif;
        this.nom = _nom;
    }


    /*
     TODO Mètodes accessors    
     */
    public String getNif() {
        return this.nif;
    }

    public String getNom() {
        return this.nom;
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou o nova jutge.
     Les dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que el nom pot ser una frase, per exemple, 
     Francesc Xavier.
     Retorn: El nou o nova jutge creat/da.
     */
    public static Jutge addJutge() {
        System.out.println("Introdueix les dades del nou jutge:");
        System.out.println("/nNom:");
        System.out.println("/nNif:");
        String nom = DADES.nextLine();
        String nif = DADES.next();
        Jutge nouJutge = new Jutge(nif, nom);
        return nouJutge;
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     Retorn: cap
     */
    public void updateJutge() {
        showJutge();

        System.out.println("Introdueix el nif i el nom per actualitzar el jutge: ");
        String nif = DADES.next();
        String nom = DADES.next();
        this.nif = nif;
        this.nom = nom;

    }

    public void showJutge() {
        System.out.println("\nLes dades del jutge o de la jutge amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
    }
}
