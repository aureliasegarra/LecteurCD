package datas;

import java.util.Objects;

public class PlagecdTest {

    public static void main(String[] var0) {
        System.out.println("***Test du contructeur Plagecd***");
        testConstruct();

        System.out.println("***Test du toString)***");
        testToString();
    }

    private static void testConstruct() {
        System.out.println("Test cas normal");
        Duree var0 = new Duree(250L);
        Plagecd var1 = new Plagecd(var0, "TNT", "ACDC");
        if (var1.getLaDuree().getLeTemps() == 250L && Objects.equals(var1.getLeTitre(), "TNT") && Objects.equals(var1.getLInterprete(), "AC~DC")) {
            System.out.println("Test OK");
        } else {
            System.out.println("Test KO");
        }

    }

    private static void testToString() {
        System.out.println("Test cas normal méthode");
        Duree d0 = new Duree(18000);
        Plagecd d1 = new Plagecd(d0, "TNT", "ACDC");
        String d2 = d1.toString();
        if (d2.equals("TNT - ACDC - 18000")) {
            System.out.println("Test OK");
        } else {
            System.out.println("Test KO");
        }

    }
}
