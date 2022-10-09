package datas;

public class LecteurCdTest {
    public static void main(String[] args) {

        System.out.println("***Test du constructeur LecteurCD()***");
        testConstruct();

        System.out.println("***Test de la méthode play()***");
        testPlay();

        System.out.println("***Test de la méthode next()***");
        testNext();

        System.out.println("***Test de la méthode previous()***");
        testPrev();

        System.out.println("***Test de la méthode stop()***");
        testStop();
    }

    public static void testConstruct(){
        System.out.println("Test cas normal");
        LecteurCd lecteur = new LecteurCd();

        if ((!lecteur.estCharge()) && (lecteur.getIndexCourant()==0) && (lecteur.getCD()==null)){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }
    }

    public static void testPlay(){
        System.out.println("Test cas normal");
        LecteurCd lecteur = new LecteurCd();
        lecteur.chargerUnCD();
        lecteur.play();

        if ((lecteur.estCharge()) && (lecteur.getIndexCourant()==1)){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }
    }

    public static void testNext(){
        System.out.println("Test cas normal");
        LecteurCd lecteur = new LecteurCd();
        lecteur.chargerUnCD();
        lecteur.play();
        System.out.println(lecteur.getIndexCourant());
        lecteur.next();
        System.out.println(lecteur.getIndexCourant());
        System.out.println(lecteur.estCharge());

        if ((lecteur.estCharge()) && (lecteur.getIndexCourant()==2)){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }
    }

    public static void testPrev(){
        System.out.println("Test cas normal");
        LecteurCd lecteur = new LecteurCd();
        lecteur.chargerUnCD();
        lecteur.play();
        lecteur.next();
        lecteur.previous();

        String interprete = "un interprete";
        String titre = "un titre";

        if ((lecteur.estCharge()) && (lecteur.getIndexCourant()==1)
                && (interprete.equals(lecteur.getCD().getLInterpreteCD()))
                && (titre.equals(lecteur.getCD().getLeTitre()))){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }
    }

    public static void testStop(){
        System.out.println("Test cas normal");
        LecteurCd lecteur = new LecteurCd();
        lecteur.chargerUnCD();
        lecteur.play();
        lecteur.next();
        lecteur.stop();

        boolean estCharge = true;
        int index = 1;

        if ((lecteur.estCharge()) && (lecteur.getIndexCourant()==1)){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }
    }
}
