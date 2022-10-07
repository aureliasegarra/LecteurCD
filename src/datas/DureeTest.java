package datas;

public class DureeTest {
    public static void main (String[] args){
        //Test du constructeur (long millisec)
        System.out.println("***Test du constructeur (long millisec)***");
        testConstruct1();

        System.out.println("***Test du constructeur (int H/M/S)***");
        testConstruct2();

        System.out.println("***Test du constructeur (Duree autreDuree)***");
        testConstruct3();

        System.out.println("***Test de la méthode compareA()***");
        testCompareA();

        System.out.println("***Test de la méthode ajoute()***");
        testAjoute();

        System.out.println("***Test de la méthode enTexte()***");
        testEnTexte();
    }

    private static void testConstruct1(){
        System.out.println("Test cas normal, millisec > 0");
        Duree d1 = new Duree (2000);
        long tps1 = d1.getLeTemps();

        if (tps1 == 2000){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }

        System.out.println("Test cas d'erreur, millisec < 0, OK si message d'erreur");
        Duree d2 = new Duree (-2000);
        long tps2 = d2.getLeTemps();

        if (tps2 == -2000){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }
    }

    private static void testConstruct2(){
        System.out.println("Test cas normal, int > 0");

        Duree d1 = new Duree(1,5,54);
        long tps1 = d1.getLeTemps();
        long tpsCalc = ((3600)+(5*60)+54)*1000;

        if (tpsCalc == tps1){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }

        System.out.println("Test cas d'erreur, heure < 0, OK si message d'erreur");
        Duree d2 = new Duree(-1,5,54);

        System.out.println("Test cas d'erreur, minutes < 0, OK si message d'erreur");
        Duree d3 = new Duree(1,-5,54);

        System.out.println("Test cas d'erreur, secondes < 0, OK si message d'erreur");
        Duree d4 = new Duree(1,5,-54);

        System.out.println("Test cas d'erreur, minutes > 59, OK si message d'erreur");
        Duree d5 = new Duree(1,62,54);

        System.out.println("Test cas d'erreur, secondes > 59, OK si message d'erreur");
        Duree d6 = new Duree(1,5,125);

    }

    private static void testConstruct3() {
        System.out.println("Test cas normal, millisec > 0");
        Duree d1 = new Duree(1500);
        Duree d2 = new Duree(d1);

        if(d1.getLeTemps() == d2.getLeTemps()){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }

        System.out.println("Test cas d'erreur, millisec < 0, OK si message d'erreur");
        Duree d3 = new Duree (-2000);
        Duree d4 = new Duree(d3);
    }

    private static void testCompareA(){
        System.out.println("Test cas normaux");
        Duree d1 = new Duree(1);
        Duree d2 = new Duree(2);

        int compare1 = d1.compareA(d2); // should be -1
        int compare2 = d1.compareA(d1); // should be 0
        int compare3 = d2.compareA(d1); // should be 1

        if (compare1 == -1 && compare2 == 0 && compare3 == 1){
            System.out.println("Test OK");
        }

        System.out.println("Test cas d'erreur, OK si message d'erreur");
        Duree d3 = new Duree(-2);
        int compare4 = d1.compareA(d3);
    }

    private static void testAjoute(){
        System.out.println("Test cas normaux");
        Duree d1 = new Duree(2);
        Duree d2 = new Duree(5);

        d1.ajoute(d2); // d1.getLetemps() = 7

        if (d1.getLeTemps()== 7){
            System.out.println("Test OK");
        }

        System.out.println("Test cas d'erreur, OK si message d'erreur");
        Duree d3 = new Duree (2);
        Duree d4 = new Duree(-1);
        d3.ajoute(d4);
    }

    private static void testEnTexte(){
        System.out.println("Test cas normal");
        Duree d1 = new Duree(95470842); // = 1 jour 2 h 31 min 10 sec 842 ms

        String texteJ = d1.enTexte('J');
        //Display texteJ
        if (texteJ.equals("1 jour(s) 2 h")){
            System.out.println("Test jours  OK");
        }

        String texteH = d1.enTexte('H');
        //Display texteH
        if (texteH.equals("26:31:10")){
            System.out.println("Test heures OK");
        }

        String texteS = d1.enTexte('S');
        //Display texteS
        if (texteS.equals("95470.842 sec")){
            System.out.println("Test secondes OK");
        }

        String texteM = d1.enTexte('M');
        //Display texteM
        if (texteM.equals("95470842 millisec")){
            System.out.println("Test millisecondes OK");
        }
    }



}
