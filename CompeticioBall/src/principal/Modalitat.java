/*
 * Classe que defineix una modalitat.Una modalitat es defineix per un codi i un nom. A més, contindrà 
 * un vector de jutges i un altre de parelles de ball
 */
package principal;

import components.Jutge;
import components.ParellaBall;
import java.util.Scanner;

/**
 *
 * @author Adriana Serrano
 */
public class Modalitat {

    private String codi;
    private int numInscripcioParella;
    private static int proximNumInscripcioParella = 1; //El número d'inscripció de la següent parella inscrita
    private String nom;
    private ParellaBall[] parelles = new ParellaBall[50];
    private int posicioParelles = 0; //Priemra posició buida del vector parelles
    private Jutge[] jutges = new Jutge[7];
    private int posicioJutges = 0; //Primera posició buida del vector de jutges
    static Scanner DADES = new Scanner(System.in);

    /*
     TODO
     CONSTRUCTOR
     Paràmetres: el nom i codi
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres.
     - La resta d'atributs ja estan inicialitzats en la declaració, per tant, no
     els heu de tenir en compte en el constructor.
     */
    public Modalitat(String _codi, String _nom) {
        this.codi = _codi;
        this.nom = _nom;
    }

    /*
     TODO Mètodes accessors    
     */
    public String getCodi() {
        return this.codi;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPosicioParelles() {
        return this.posicioParelles;
    }

    public ParellaBall[] getParelles() {
        return this.parelles;
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova modalitat. Les 
     dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que el nom pot ser una frase, per exemple, 
     Vals Vienès.
     Retorn: La nova modalitat creada.
     */
    public static Modalitat addModalitat() {
        System.out.println("Introdueix la modalitat: ");
        System.out.println("/nCodi: ");
        System.out.println("/nNom: ");

        String codi = DADES.next();
        String nom = DADES.next();

        Modalitat novaModalitat = new Modalitat(codi, nom);

        return novaModalitat;
    }

    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     només es pot modificar el codi i nom de la modalitat.
     Retorn: cap
     */
    public void updateModalitat() {
        showModalitat();

        System.out.println("Introdueix el codi i el nom de la modalitat per actualitzar-la: ");
        String codi = DADES.next();
        String nom = DADES.next();
        this.codi = codi;
        this.nom = nom;
    }

    /*
     TODO
     Paràmetres: parella de ball a afegir
     Accions:
     - assignar a l'atribut numInscripcioParella el valor de l'atribut proximNumInscripcioParella.
     - assigna a la parella passada per paràmetre el número d'inscripció fent servir
     el mètode escaient de la classe ParellaBall.
     - actualitzar l'atribut proximNumInscripcioParella amb el pròxim número d'inscripció a assignar.
     - afegeix al vector parelles de la modalitat actual la parella de ball passada
     per paràmetre.
     - actualitza la posició del vector parelles.
     Retorn: cap
     */
    public void addParella(ParellaBall parella) {

        numInscripcioParella = proximNumInscripcioParella;
        parella.setNumInscripcio(numInscripcioParella);
        proximNumInscripcioParella++;
        parelles[posicioParelles] = parella;
        posicioParelles++;
    }

    /*
     TODO
     Paràmetres: jutge a afegir
     Accions:
     - afegeix al vector jutges de la modalitat actual el o la jutge passada
     per paràmetre.
     - Recordeu que hi ha d'haver un mínim de tres jutges i un màxim de 7. Si volem
     introduir més jutges del compte, avisarem a l'usuari amb el missatge "\nLa modalitat
     ja té tots els o les jutges necessaris/es", i mentre no hi hagi el mínim de jutges
     assignats, un cop s'ha afegit el o la jutge, avisarem a l'usuari amb el missatge
     "\n N jutges assignats", on N seran els jutges que hi ha assignats.
     - actualitza la posició del vector parelles.   
     Retorn: cap
     */
    public void addJutge(Jutge jutge) {
        if (posicioJutges == 7) {
            System.out.println("La modalitat\n" + "ja té tots els o les jutges necessaris/es");
        } else {
            jutges[posicioJutges] = jutge;
            posicioJutges++;
            if (posicioJutges < 3) {
                System.out.println("\n" + posicioJutges + " jutges assignats");
            }
        }
    }

    public void showModalitat() {
        System.out.println("\nLes dades de la modalitat amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);

        if (posicioParelles != 0) {
            for (int i = 0; i < posicioParelles; i++) {
                parelles[i].showParellaBall();
            }
        } else {
            System.out.println("\nNo hi ha cap parella inscrita.");
        }

        if (posicioJutges != 0) {
            for (int i = 0; i < posicioJutges; i++) {
                jutges[i].showJutge();
            }
        } else {
            System.out.println("\nNo hi ha cap jutge assignat.");
        }

    }

}
