package datas;
/**
 * This class defines a temporal duration. It allows the manipulation of time intervals.
 *  * A duration is expressed in milliseconds.
 * @author Aurelia Segarra
 */
public class Duree {
    /**
     * The duration is expressed in milliseconds
     */
    private long leTemps;

    /**
     * Constructor with initialization in milliseconds
     * @param millisec Duration expressed in milliseconds
     */
    public Duree(long millisec){
        if (millisec > 0){
            this.leTemps = millisec;
        }
        else{
            System.out.println("Mauvais format de durée !");
        }
    }

    /**
     * Constructor from hours, minutes, seconds
     * @param heures Number of hours
     * @param minutes Number of minutes
     * @param secondes Number of secondes
     */
    public Duree(int heures, int minutes, int secondes){
        if(heures>0 && minutes>0 && secondes>0){
            if (minutes < 60 && secondes < 60){
                this.leTemps = (heures*3600L + minutes*60 + secondes)*1000;
                System.out.println("OK");
            }
            else {
                System.out.println("Mauvais format de durée !");
            }
        }

        else {
            System.out.println("Mauvais format de durée !");
        }
    }

    /**
     * Constructor with a duration given in parameter
     * @param autreDuree Duration to copy
     */
    public Duree (Duree autreDuree){
        this.leTemps = autreDuree.getLeTemps();
    }

    /**
     * GETTER
     * @return the value of the duration in milliseconds
     */
    public long getLeTemps(){
        return this.leTemps;
    }

    /**
     * Modifier that adds a duration to the current duration
     * @param autreDuree Duration to add
     */
    public void ajoute(Duree autreDuree){
        this.leTemps = this.leTemps + autreDuree.getLeTemps();
    }


    /**
     * Method that compares the current duration and another duration
     * @param autreDuree Duration to compare to the current duration
     * @return an integer that takes the following values :
     *          <ul><li> -1 : if current duration < autreDuree
     *              <li> 0 : if current duration = autreDuree
     *              <li> 1 : if current duration > autreDuree
     *          </ul>
     */
    public int compareA(Duree autreDuree){
        int rep;
        if (this.leTemps != autreDuree.getLeTemps()){
            if (this.leTemps < autreDuree.getLeTemps()){
                rep = -1;
            }else{
                rep = 1;
            }
        }else{
            rep = 0;
        }
        return rep;
    }

    /**
     * Private method that divides the time into intervals (days, hours, minutes, seconds, milliseconds)
     * @return an array of integers
     */
    private int[] enJHMS(){

        int[] temps = new int[5];

        int jours;
        int heures;
        int minutes;
        int sec;
        int millisec;
        int reste;

        jours = (int)this.leTemps / 86400000; //1j = 86400000 milliseconds
        reste = (int)(this.leTemps % 86400000);
        heures = reste / 3600000; //1h = 3600000 milliseconds
        reste = reste % 3600000;
        minutes = reste / 60000; //1 minute = 60000 millisec
        reste = reste % 60000;
        sec = reste / 1000; // 1sec = 1000 millisec
        reste = reste % 1000;
        millisec = reste;

        temps[0] = jours;
        temps[1] = heures;
        temps[2] = minutes;
        temps[3] = sec;
        temps[4] = millisec;

        return temps;
    }


    /**
     * Method that returns the current duration as a string
     * @param mode -The string format depends on the selected "mode" (given in parameter)
     * <ul>
*    *      <li> if mode == 'J' => "JJJ jours HH h"
     *      <li> if mode == 'H' => "HHH:MM:SS"
     *      <li> if mode == 'S' => "SSS.MMM sec"
     *      <li> if mode == 'M' => "MMMMMM millisec"
*    * </ul>
     * @return the duration as a string
     */
    public String enTexte(char mode){

        String texte = "";
        int[] temps = enJHMS();
        int jour = temps[0];
        int heure = temps[1];
        int heureTot = (jour*24) + heure;
        int minute = temps[2];
        int sec = temps[3];
        int secTot =  (jour*24*60*60) + (heure*60*60) + (minute*60) + sec ;
        int millisec = temps[4];
        int millisecTot = (jour*24*60*60*1000) + (heure*60*60*1000) + (minute*60*1000) + (sec*1000) + millisec;

        switch (mode) {
            case 'J' -> texte = texte + jour + " jour(s) " + heure + " h";
            case 'H' -> texte = texte + heureTot + ":" + minute + ":" + sec;
            case 'S' -> texte = texte + secTot + "." + millisec + " sec";
            case 'M' -> texte = texte + millisecTot + " millisec";
        }
        return texte;
    }

}
