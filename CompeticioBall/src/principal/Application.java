package principal;

import java.util.Scanner;

/**
 *
 * @author Adriana Serrano
 */
public class Application {

    static private Competicio[] competicions = new Competicio[25];
    static Scanner DADES = new Scanner(System.in);
    static private int posicioCompeticions = 0;
    static private Competicio competicioActual = null;

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de competicions");
            System.out.println("\n2. Gestió de modalitats");
            System.out.println("\n3. Gestió de ballarins o ballarines");
            System.out.println("\n4. Gestió de jutges");
            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuCompeticions();
                    break;
                case 2:
                    if (competicioActual != null) {
                        menuModalitats();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la competició al menú Gestió de competicions");
                    }
                    break;
                case 3:
                    if (competicioActual != null) {
                        menuBallarins();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la competició al menú Gestió de competicions");
                    }
                    break;
                case 4:
                    if (competicioActual != null) {
                        menuJutges();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la competició al menú Gestió de competicions");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuCompeticions() {
        int opcio = 0;

        do {
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Crear nova competició");
            System.out.println("\n2. Seleccionar competició");
            System.out.println("\n3. Modificar competició");
            System.out.println("\n4. Llista de competicions");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    competicions[posicioCompeticions] = Competicio.addCompeticio();
                    posicioCompeticions++;
                    break;
                case 2:
                    indexSel = selectCompeticio();
                    if (indexSel >= 0) {
                        competicioActual = competicions[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquesta competició");
                    }
                    break;
                case 3:
                    indexSel = selectCompeticio();
                    if (indexSel >= 0) {
                        competicions[indexSel].updateCompeticio();
                    } else {
                        System.out.println("\nNo existeix aquesta competició");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioCompeticions; i++) {
                        competicions[i].showCompeticio();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menuBallarins amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut competicioActual no és null
       
     Opció 0. Sortir -->      Surt del menú i retorna al menú principal
     Opció 1. Alta -->        Crea un ballarí o ballarina en la competició actual. Penseu que Competicio sap crear ballarins o ballarines        
     Opció 2. Modificar ->    Permet modificar un ballarí o ballarina que està inscrit a la bossa de ballarins i ballarines de la competició actual
     (per comprovar l'existència del ballarí o ballarina tenim un mètode en la classe Competició que ens ajuda)
     Opció 3. Llista de ballarins i ballarines -> Imprimeix les dades dels ballarins i ballarines de la competició actual
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de la gestió d'excepcions que veurem més endavant
     */
    public static void menuBallarins() {
        int opcio = 0;
        do {
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista de ballarins i ballarines");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    competicions[posicioCompeticions] = Competicio.addCompeticio();
                    posicioCompeticions++;
                    break;
                case 2:
                    indexSel = competicioActual.selectBallari(null);
                    if (indexSel >= 0) {
                        competicioActual.getBallari()[indexSel].updateBallari();
                    } else {
                        System.out.println("\nNo existeix aquest ballari.");
                    }
                    break;
                case 3:
                    for (int i = 0; i < competicioActual.getPosicioBallarins(); i++) {
                        competicioActual.getBallari()[i].showBallari();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);

    }

    /*
     TODO Heu de desenvolupar el menuJutges amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut competicioActual no és null
       
     Opció 0. Sortir -->      Surt del menú i retorna al menú principal
     Opció 1. Alta -->        Crea un o una jutge en la competició actual. Penseu que Competicio sap crear jutges        
     Opció 2. Modificar ->    Permet modificar un o una jutge que està inscrit a la bossa de jutges de la competició actual
     (per comprovar l'existència del o de la jutge tenim un mètode en la classe Competició que ens ajuda)
     Opció 3. Llista de jutges -> Imprimeix les dades dels i de les jutges de la competició actual
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de la gestió d'excepcions que veurem més endavant
     */
    public static void menuJutges() {
        int opcio = 0;
        do {
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista de jutges");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    competicioActual.addJutge();
                    break;
                case 2:
                    indexSel = competicioActual.selectJutge(null);
                    if (indexSel >= 0) {
                        competicioActual.getJutge()[indexSel].updateJutge();
                    } else {
                        System.out.println("\nNo existeix aquesta modalitat.");
                    }
                    break;
                case 3:
                    for (int i = 0; i < competicioActual.getPosicioJutges(); i++) {
                        competicioActual.getJutge()[i].showJutge();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);

    }

    /*
     TODO Heu de desenvolupar el menuModalitats amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut estudiActual no és null
     
     Opció 0. Sortir -->      Surt del menú i retorna al menú principal
     Opció 1. Alta -->        Crea una nova modalitat en la competició actual. Penseu que Competicio sap crear modalitats        
     Opció 2. Modificar ->    Permet modificar una modalitat que està afegida a la competició actual
     (per comprovar l'existència de la modalitat tenim un mètode en la classe Competició que ens ajuda)
     Opció 3. Assignar jutge ->   Assigna un o una jutge a una modalitat, però penseu que Competició sap com fer-ho.
     Opció 4. Assignar parella de ball ->   Assigna una parella de ball a una modalitat, però penseu que Competició sap com fer-ho.
     Opció 5. Assignar puntuació a les parelles de ball -> Assigna la puntuació a les parelles de ball, però penseu que Competicio sap com  	 fer-ho.
     Opció 6. Llista de modalitats-> Imprimeix les dades de les modalitats de la competició actual.
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de la gestió d'excepcions que veurem més endavant
     */
    public static void menuModalitats() {
        int opcio = 0;
        do {
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Assignar jutge");
            System.out.println("\n4. Assignar parella de ball");
            System.out.println("\n5. Assignar puntuació a les parelles de ball");
            System.out.println("\n6. Llista de modalitats");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    competicioActual.addModalitat();
                    break;
                case 2:
                    indexSel = competicioActual.selectModalitat(null);
                    if (indexSel >= 0) {
                        competicioActual.getModalitat()[indexSel].updateModalitat();
                    } else {
                        System.out.println("\nNo existeix aquesta modalitat.");
                    }
                    break;
                case 3:
                    indexSel = selectCompeticio();
                    if (indexSel >= 0) {
                        competicions[indexSel].updateCompeticio();
                    } else {
                        System.out.println("\nNo existeix aquesta competició");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioCompeticions; i++) {
                        competicions[i].showCompeticio();
                    }
                    break;
                case 5:
                    for (int i = 0; i < posicioCompeticions; i++) {
                        competicions[i].showCompeticio();
                    }
                    break;
                case 6:
                    for (int i = 0; i < posicioCompeticions; i++) {
                        competicions[i].showCompeticio();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);

    }

    public static Integer selectCompeticio() {

        System.out.println("\nEdició de la competició?:");
        int edicio = DADES.nextInt();

        for (int i = 0; i < posicioCompeticions; i++) {
            if (competicions[i].getEdicio() == edicio) {
                return i;
            }
        }
        return -1;
    }
}
