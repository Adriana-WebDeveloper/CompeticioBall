/*
 * Classe que defineix un ballarí o ballarina. Un/a ballarí/na es defineix 
 * pel seu NIF, nom, sexe i un vector amb el codi de les modalitats en les quals 
 * pot participar.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author Adriana Serrano
 */
public class Ballari {

    static Scanner DADES = new Scanner(System.in);
    private String nif;
    private String nom;
    private String sexe;
    private String modalitat;
    private boolean emparellat;

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys els atributs modalitat
     i emparellat
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a modalitat
    i emparellat.
    - En el cas de modalitat, li assignarem el valor null, ja que quan es crea un Ballari
    aquest encara no té assignada la modalitat.
    - En el cas d'emparellat el valor serà fals, ja que quan es crea un Ballari aquest 
    encara no té parella.
     */
    public Ballari(String _nif, String _nom, String _sexe) {
        this.nif = _nif;
        this.nom = _nom;
        this.sexe = _sexe;
        this.modalitat = null;
        this.emparellat = false;
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

    public String getSexe() {
        return this.sexe;
    }

    public String getModalitat() {
        return this.modalitat;
    }

    public boolean isEmparellat() {
        return this.emparellat;
    }

    public void setModalitat(String modalitat) {
        this.modalitat = modalitat;
    }

    public void setEmparellat(boolean emparellat) {
        this.emparellat = emparellat;
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou ballarí o nova
     ballarina. Les dades a demanar són les que passem per paràmetre en el constructor.
     - En el cas de l'atribut sexe, li heu de demanar que si és un ballarí introdueixi
     H i si és una ballarina D.
     - També heu de tenir en compte que el nom pot ser una frase, per exemple, 
     Francesc Xavier.
     Retorn: El nou ballarí o nova ballarina creat/da.
     */
    public static Ballari addBallari() {
        System.out.println("Introdueix les dades del nou ballari:");
        System.out.println("/nNif:");
        System.out.println("/nNom:");
        System.out.println("/nSexe: D (dona) H (home)");
        String nif = DADES.next();
        String nom = DADES.nextLine();
        String sexe = DADES.next();

        Ballari nouBallari = new Ballari(nif, nom, sexe);
        return nouBallari;

    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     -  En el cas de l'atribut sexe, li heu de demanar que si és un ballarí introdueixi
     H i si és una ballarina D.
     - En el cas de l'atribut emparellat, li heu de demanar que si està emparellat/ada introdueixi
     1 i en cas contari 0. 
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut sexe, li heu de mostrar el missatge: "\nÉs un ballarí",
     si es tracta d'un ballarí, i el missatge "\nÉs una ballarina", si es tracta d'una ballarina.
     En el cas de l'atribut emparellat, li heu de mostrar el missatge: "\nTé parella",
     si està emparellat/ada, i "\nNo té parella" en cas contari.
     Retorn: cap
     */
    public void updateBallari() {
        showBallari();

        System.out.println("Introdueix el nif, el nom i el sexe per actualitzar el ballari: ");
        String nif = DADES.next();
        String nom = DADES.next();
        String sexe = DADES.next();
        this.nif = nif;
        this.nom = nom;
        this.sexe = sexe;

    }

    public void showBallari() {
        System.out.println("\nLes dades del ballarí o ballarina amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);

        if (sexe.equals("H")) {
            System.out.println("\nÉs un ballarí");
        } else {
            System.out.println("\nÉs una ballarina");
        }

        if (emparellat) {
            System.out.println("\nTé parella");
        } else {
            System.out.println("\nNo té parella");
        }

        System.out.println("\nEl codi de la seva modalitat és: " + modalitat);
    }

}
