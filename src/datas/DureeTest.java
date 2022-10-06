package datas;

public class DureeTest {
    public static void main (String[] args){
        //Test du constructeur (long millisec)
        System.out.println("***Test du constructeur***");
        testConstruct1();
    }

    private static void testConstruct1(){
        System.out.println("Test cas normal, millisec > 0");
        Duree d1 = new Duree (2000);
        long tps1 = d1.getLeTemps();

        if (tps1 == 2000){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Erreur ! Echec du test !");
        }

        System.out.println("Test cas d'erreur, millisec < 0, OK si message d'erreur");
        Duree d2 = new Duree (-2000);
        long tps2 = d2.getLeTemps();

        if (tps2 == -2000){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Erreur ! Echec du test !");
        }
    }

}
