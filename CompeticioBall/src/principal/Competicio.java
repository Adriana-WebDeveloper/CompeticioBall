/*
 * Classe que defineix una competició de balls de saló. Una competició es defineix 
 * per l’edició, l’any en què es realitza i la població on es realitza (no es realitzarà
 * en la mateixa població cada any). A més, contindrà vectors amb jutges, ballarins/es
 * i modalitats. 
 */
package principal;

import components.Ballari;
import components.Jutge;
import components.ParellaBall;
import java.util.Scanner;

/**
 *
 * @author Adriana Serrano
 */
public class Competicio {

    private int edicio;
    private static int proximaEdicio = 1; //La pròxima edició a assignar
    private int any;
    private String poblacio;
    private Ballari[] ballarins = new Ballari[1000];
    private int posicioBallarins = 0; //Priemra posició buida del vector ballarins
    private Jutge[] jutges = new Jutge[100];
    private int posicioJutges = 0; //Priemra posició buida del vector jutges
    private Modalitat[] modalitats = new Modalitat[100];
    private int posicioModalitats = 0; //Possició actual buida del vector modalitats
    static Scanner DADES = new Scanner(System.in);

    /*
     TODO
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys els vectors i l'edició.
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     - Assignar a l'atribut edicio el valor de l'atribut proximaEdicio i actualitzar
     proximaEdicio amb la següent edició a assignar.
     */
    public Competicio(int _any, String _poblacio) {
        this.edicio = this.proximaEdicio;
        this.proximaEdicio++;
        this.any = _any;
        this.poblacio = _poblacio;
    }

    /*
     TODO Mètodes accessors    
     */
    public int getEdicio() {
        return this.edicio;
    }

    public int getProximaEdicio() {
        return this.proximaEdicio;
    }

    public int getAny() {
        return this.any;
    }

    public String getPoblacio() {
        return this.poblacio;
    }

    public int getPosicioBallarins() {
        return this.posicioBallarins;
    }

    public int getPosicioJutges() {
        return this.posicioJutges;
    }

    public int getPosicioModalitats() {
        return this.posicioModalitats;
    }

    public Modalitat[] getModalitat() {
        return this.modalitats;
    }

    public Jutge[] getJutge() {
        return this.jutges;
    }

    public Ballari[] getBallari() {
        return this.ballarins;
    }

    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova competició. Les dades
     a demanar són les que li passem per paràmetre al constructor.
     - Heu de tenir en compte que la població pot ser una frases, per exemple, Sant Andreu de la Barca.
     Retorn: La nova competició creada.
     */
    public static Competicio addCompeticio() {
        System.out.println("Introdueix l'any i la població de la competició: ");
        int any = DADES.nextInt();
        String poblacio = DADES.next();

        Competicio novaCompeticio = new Competicio(any, poblacio);
        return novaCompeticio;
    }

    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     no es pot modificar el contingut dels vectors, només els dels atributs 
     any i poblacio. Evidentment, tampoc podeu modificar l'edició.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los.
     Retorn: cap
     */
    public void updateCompeticio() {     
        showCompeticio();

        System.out.println("Introdueix l'any i la població de la competició per actualitzar-la: ");
        int any = DADES.nextInt();
        String poblacio = DADES.next();
        this.any = any;
        this.poblacio = poblacio;

    }

    public void showCompeticio() {
        System.out.println("\nLes dades de la competició edició " + edicio + " són:");
        System.out.println("\nAny: " + any);
        System.out.println("\nPoblacio: " + poblacio);
    }

    /*
     BALLARI
     */
 /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix un nou ballarí o ballarina al vector de ballarins de la competició actual
     si aquest o aquesta no existeix. Per crear-lo heu de demanar les dades a l'usuari
     mitjançant el mètode escaient de la classe Ballari i per comprovar la seva existència 
     el mètode d'aquesta classe que ens ajuda en aquesta tasca. Abans d'afegir-lo, se l'ha
     d'assignar la modalitat mitjançant el mètode escaient d'aquesta classe.
     - actualitza la posició del vector de ballarins si s'afegeix el ballarí o ballarina.
     - mostra el missatge "El ballarí o ballarina ja existeix" si no s'ha afegit el
     ballarí o ballarina.
     Retorn: cap
     */
    public void addBallari() {
        
        Ballari nouBallari = Ballari.addBallari();
        if (selectBallari(nouBallari.getNif()) == -1) {
            ballarins[posicioBallarins] = nouBallari;
            posicioBallarins++;
        } else {
            System.out.println("El ballari ja existeix.");
        }

    }

    public int selectBallari(String nif) {

        if (nif == null) {
            System.out.println("\nNIF del ballarí o ballarina?:");
            nif = DADES.next();
        }

        for (int i = 0; i < posicioBallarins; i++) {
            if (ballarins[i].getNif().equals(nif)) {
                return i;
            }
        }

        return -1;
    }

    /*
     JUTGE
     */
 /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix un nou o nova jutge al vector de jutges de la competició actual
     si aquest o aquesta no existeix. Per crear-lo heu de demanar les dades a l'usuari
     mitjançant el mètode escaient de la classe Jutge i per comprovar la seva existència 
     el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - actualitza la posició del vector de jutges si s'afegeix el o la jutge.
     - mostra el missatge "El o la jutge ja existeix" si no s'ha afegit el o la jutge.
     Retorn: cap
     */
    public void addJutge() {
        
        Jutge nouJutge = Jutge.addJutge();
        if (selectJutge(nouJutge.getNif()) == -1) {
            jutges[posicioJutges] = nouJutge;
            posicioJutges++;
        } else {
            System.out.println("El jutge ja existeix.");
        }
    }

    public int selectJutge(String nif) {
        
        if (nif == null) {
            System.out.println("\nNIF del o de la jutge?:");
            nif = DADES.next();
        }

        for (int i = 0; i < posicioJutges; i++) {
            if (jutges[i].getNif().equals(nif)) {
                return i;
            }
        }

        return -1;
    }

    /*
     MODALITAT
     */
 /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix una nova modalitat al vector de modalitats de la competició actual
     si aquesta no existeix. Per crear-la heu de demanar les dades a l'usuari
     mitjançant el mètode escaient de la classe Modalitat i per comprovar la seva existència 
     el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - actualitza la posició del vector de modalitats si s'afegeix la modalitat.
     - mostra el missatge "La modalitat ja existeix" si no s'ha afegit la modalitat.
     Retorn: cap
     */
    public void addModalitat() {
        
        Modalitat novaModalitat = Modalitat.addModalitat();
        if (selectModalitat(novaModalitat.getCodi()) == -1) {
            modalitats[posicioModalitats] = novaModalitat;
            posicioModalitats++;
        } else {
            System.out.println("La modalitat ja existeix.");
        }
    }

    public int selectModalitat(String codi) {
        
        if (codi == null) {
            System.out.println("\nCodi de la modalitat?:");
            codi = DADES.next();
        }

        for (int i = 0; i < posicioModalitats; i++) {
            if (modalitats[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }

    public void addJutgeModalitat() {
        
        int posModalitat = selectModalitat(null);

        if (posModalitat >= 0) {

            int posJutge = selectJutge(null);

            if (posJutge >= 0) {
                getModalitat()[posModalitat].addJutge(getJutge()[posJutge]);
            } else {
                System.out.println("\nNo existeix aquest o aquesta jutge");
            }

        } else {
            System.out.println("\nNo existeix aquesta modalitat");
        }

    }

    public void addCodiModalitatBallari(Ballari ballari) {
        
        int pos = selectModalitat(null);

        if (pos >= 0) {
            ballari.setModalitat(getModalitat()[pos].getCodi());
        } else {
            System.out.println("\nNo existeix aquesta modalitat");
        }

    }

    public void addParellaBallModalitat() {

        int pos = selectModalitat(null);

        if (pos >= 0) {

            Ballari nouBallari = null;
            Ballari novaBallarina = null;
            Boolean parellaCreada = false;

            for (int i = 0; i < posicioBallarins && !parellaCreada; i++) {

                if (getBallari()[i].getModalitat().equals(getModalitat()[pos].getCodi()) && !getBallari()[i].isEmparellat()) {

                    if (getBallari()[i].getSexe().equals("H")) {
                        nouBallari = getBallari()[i];
                    } else {
                        novaBallarina = getBallari()[i];
                    }

                    if (nouBallari != null && novaBallarina != null) {
                        nouBallari.setEmparellat(true);
                        novaBallarina.setEmparellat(true);
                        getModalitat()[pos].addParella(new ParellaBall(nouBallari, novaBallarina));
                        parellaCreada = true;
                    }
                }
            }

            if (!parellaCreada) {
                System.out.println("\nNo s'ha pogut crear una parella per aquesta modalitat.");
            }

        } else {
            System.out.println("\nNo existeix aquesta modalitat");
        }

    }

    public void addPuntuacioParellesBall() {

        int pos = selectModalitat(null);

        if (pos >= 0) {

            if (getModalitat()[pos].getPosicioParelles() != 0) {

                for (int i = 0; i < getModalitat()[pos].getPosicioParelles(); i++) {

                    System.out.println("\nParella amb número d'inscripció " + getModalitat()[pos].getParelles()[i].getNumInscripcio());

                    System.out.println("\nPuntuació de la parella:");

                    getModalitat()[pos].getParelles()[i].setPuntuacio(DADES.nextInt());

                    DADES.nextLine();
                }

            } else {
                System.out.println("\nAquesta modalitat no té parelles");
            }

        } else {
            System.out.println("\nNo existeix aquesta modalitat");
        }

    }
}
