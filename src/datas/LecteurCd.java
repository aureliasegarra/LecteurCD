package datas;

/**
 * The LecteurCd class simulates in a simplified way the functionalities of a CD player :
 * <ul>
 *     <li>Loading a CD</li>
 *     <li>PLAY</li>
 *     <li>STOP</li>
 *     <li>NEXT</li>
 *     <li>PREVIOUS</li>
 * </ul>
 * @author Aurelia Segarra
 */
public class LecteurCd {

    /**
     * Is there any CD in the player ?
     */
    private boolean estCharge;

    /**
     * Index of the current track (1 <= index <= nbrPlages ou zero)
     */
    private int indexPlage;

    /**
     * Current CD (in the player)
     */
    private Cd leCDCourant;

    /**
     * Constructor for a CD player. No CD at the end of the construction (leCDCourant=null).
     * Loading a CD needs the "chargerUnCD()" method.
     */
    public LecteurCd(){
        this.estCharge = false;
        this.indexPlage = 0;
        this.leCDCourant= null;
    }

    /**
     * GETTER
     * @return Total duration of a CD
     */
    public String getTempsTotal(){

        String dureeTot = "";
        Duree duree = leCDCourant.getDureeTotal();
        dureeTot = duree.enTexte('H');
        return dureeTot;
    }

    /**
     * GETTER
     * @return number of the tracks (-1 if no CD loaded)
     */
    public int getNbrPlages(){
        int nbPlage;
        if(!estCharge){
            nbPlage = -1;
        }else{
            nbPlage = leCDCourant.getNbrPlages();
        }
        return nbPlage;
    }

    /**
     * GETTER
     * 1 <=Index < nbrPlages
     * @return index of the current track (0 if no CD loaded)
     */
    public int getIndexCourant(){
        return indexPlage;
    }

    /**
     * GETTER
     * @return the current track (null if no CD loaded)
     */
    public Plagecd getPlageCourante(){
        Plagecd plage;
        if(!estCharge){
            plage = null;
        }else{
            plage = leCDCourant.getUnePlage(getIndexCourant());
        }
        return plage;
    }

    /**
     * GETTER
     * @return true if a CD is loaded
     */
    public boolean estCharge(){
        return estCharge;
    }

    /**
     * GETTER
     * @return the current CD or null if there is no CD
     */
    public Cd getCD(){
        Cd cd;
        if (estCharge){
            cd = leCDCourant;
        }else {
            cd = null;
        }
        return cd;
    }

    /**
     * SETTER
     * The boolean "estCharge" turn to false and "leCDCourant" turn to null
     */
    public void setDecharger(){
        estCharge=false;
        leCDCourant=null;
    }

    /**
     * METHOD
     * The method should create a CD and turn the boolean "estCharge" to true
     */
    public void chargerUnCD(){
        leCDCourant = new Cd("un interprete","un titre");
        this.estCharge = true;
    }

    /**
     * METHOD
     * Should load a CD into the player. the CD is created from a text file
     */
    public void chargerUnCD(String leFich){
        leCDCourant = new Cd(leFich);
        this.estCharge = true;
    }

    /**
     * METHOD
     * Simulate the STOP button (turn the index of the track to 1)
     * Nothing happens if no CD loaded
     */
    public void stop(){
        if(estCharge){
            this.indexPlage=1;
        }
    }

    /**
     * METHOD
     * Simulate the PLAY button (turn the index of the track to 1)
     * Nothing happens if no CD loaded
     */
    public void play(){
        if(estCharge){
            this.indexPlage=1;
        }
    }

    /**
     * METHOD
     * Simulate the NEXT button (increment the index of the track)
     * Nothing happens if no CD loaded
     */
    public void next(){
        if((estCharge) && (getIndexCourant()<leCDCourant.getNbrPlages())){
            this.indexPlage = indexPlage + 1;
        }
    }

    /**
     * METHOD
     * Simulate the PREVIOUS button (decrease the index of the track)
     * Nothing happens if no CD loaded
     */
    public void previous(){
        if((estCharge) && getIndexCourant()>1){
            this.indexPlage = indexPlage - 1;
        }
    }

}
