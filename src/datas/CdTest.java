package datas;

public class CdTest {
    public static void main (String[] args){

        //Test du constructeur CD (String interpreteCD, String titreCD)
        System.out.println("***Test constructeur CD***");
        testConstruct();

        //Test de la méthode graverCD()
        System.out.println("***Test de la méthode graverCD())***");
        testGraverCD();

        //Test de la méthode getDureeTotal()
        System.out.println("***Test de la méthode getDureeTotal())***");
        testGetDureeTotal();

        //Test de la méthode graverCD(drDre)
        System.out.println("***Test de la méthode graverCD(leFich))***");
        testGraverCDFichier();

    }

    public static void testConstruct(){
        System.out.println("Test cas normal");
        Cd cd = new Cd("Metallica", "Black Album");

        if((cd.getLInterpreteCD().equals("Metallica")) && (cd.getLeTitre().equals("Black Album"))){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }
    }

    public static void testGraverCD(){
        System.out.println("Test cas normal");
        Cd cd = new Cd("Compile","Compile");
        String titre1 = cd.getUnePlage(1).getLeTitre();
        String interprete1 = cd.getUnePlage(1).getLInterprete();
        long duree1 = cd.getUnePlage(1).getLaDuree().getLeTemps();
        Duree d1 = new Duree(180000);
        long temps1 = d1.getLeTemps();

        if((titre1.equals("TNT")) && (interprete1.equals("ACDC")) && (duree1==temps1)){
            System.out.println("Test 1 OK");
        }
        else{
            System.out.println("Test 1 KO");
        }

        String titre2 = cd.getUnePlage(2).getLeTitre();
        String interprete2 = cd.getUnePlage(2).getLInterprete();
        long duree2 = cd.getUnePlage(2).getLaDuree().getLeTemps();
        Duree d2 = new Duree(360000);
        long temps2 = d2.getLeTemps();

        if((titre2.equals("Don't Speak")) && (interprete2.equals("No Doubt")) && (duree2==temps2)){
            System.out.println("Test 2 OK");
        }
        else{
            System.out.println("Test 2 KO");
        }
    }

    public static void testGetDureeTotal(){
        System.out.println("Test cas normal");

        Cd cd = new Cd("Compile","Artistes");
        Duree d1 = cd.getDureeTotal();
        long t1 = d1.getLeTemps();

        if(t1==1310500){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }
    }

    public static void testGraverCDFichier(){

        Cd cd = new Cd("drDre.txt");

        if((cd.getLeTitre().equals("Chronic 2001")) && (cd.getLInterpreteCD().equals("Dr.Dre"))){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test KO");
        }
    }

}
