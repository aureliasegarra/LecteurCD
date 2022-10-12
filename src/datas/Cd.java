package datas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A CD is a set of music tracks. The CD is characterized by a title, an interpreter(s).
 * When it is created, the CD is empty.
 * By engraving it, it will be filled progressively of tracks
 * @author Aurelia Segarra
 */
public class Cd {
    /**
     * Array of CD tracks
     */
    private final ArrayList<Plagecd> lesPlages = new ArrayList<Plagecd>();

    /**
     * CD title
     */
    private String leTitreCD;

    /**
     * CD interpreter
     */
    private String lInterpreteCD;

    /**
     * Constructor for a CD, 2 steps :
     * <ol>
     *     <li>Creation of the CD</li>
     *     <li>Engraving the CD with the private method "graverCD()"</li>
     * </ol>
     * @param interpreteCD  CD interpreter
     * @param titreCD CD title
     */
    public Cd(String interpreteCD, String titreCD){
        this.lInterpreteCD = interpreteCD;
        this.leTitreCD = titreCD;
        this.graverCD();
    }

    /**
     * Constructor for a CD from a text file
     * <ul>
     *     <li>CD title and interpreter</li>
     *     <li>The different tracks as follow  TitrePlage/ InterpretePlage/ X min/ Y sec</li>
     * </ul>
     * The private method "graverCD (String drDre)" read the text file
     * @param leFich The text file
     */
    public Cd(String leFich){
        graverCD(leFich);
    }

    /**
     * GETTER
     * @return number total of tracks
     */
    public int getNbrPlages(){
        return lesPlages.size();
    }

    /**
     * GETTER
     * @return CD title
     */
    public String getLeTitre(){
        return leTitreCD;
    }

    /**
     * GETTER
     * @return CD interpreter
     */
    public String getLInterpreteCD(){
        return lInterpreteCD;
    }

    /**
     * GETTER
     * @return CD total duration
     */
    public Duree getDureeTotal(){
        Duree laDureeTot = new Duree(0);
        for(Plagecd plage : lesPlages){
            laDureeTot.ajoute(plage.getLaDuree());
        }
        return laDureeTot;
    }

    /**
     * Method returning the CD track (n°index)
     * ⚠️ First track at index 1.
     * @param index number of the track to return
     * @return the track of the array (index-1)
     */
    public Plagecd getUnePlage(int index){
        return lesPlages.get(index-1);
    }


    /**
     * Private method to engrave the CD from a file.
     * The CD have a title, an interpreter and a list of tracks
     * @param leFich the text file to read
     */
    private void graverCD(String leFich){
        String[] mesLignes;
        String tmp;
        BufferedReader tampon;

        try{
            tampon = new BufferedReader(new FileReader(leFich));
            tmp = tampon.readLine();
            mesLignes = tmp.split("/");
            if(tampon.readLine() != null) {
                leTitreCD = mesLignes[0];
                lInterpreteCD = mesLignes[1];
            }
            String ligne;

            while((ligne = tampon.readLine()) != null){

                mesLignes = ligne.split("/");
                int min =  Integer.parseInt(mesLignes[2]);
                int sec = Integer.parseInt(mesLignes[3]);
                Duree minutes = new Duree ( min *60*1000L);
                Duree secondes = new Duree(sec* 1000L);

                minutes.ajoute(secondes);

                String titre = mesLignes[0];
                String interprete = mesLignes[1];

                Plagecd plage = new Plagecd(minutes, titre, interprete);
                lesPlages.add(plage);
            }
            tampon.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Private method to engrave the CD.
     * Simplified version with tracks created and added to the CD
     */
    private void graverCD(){
        Plagecd plage1 = new Plagecd(new Duree(84000),"Lolo","Dr.Dre");
        Plagecd plage2 = new Plagecd(new Duree(195600),"The Watcher","Dr.Dre");
        Plagecd plage3 = new Plagecd(new Duree(195000),"Fuck You","Dr.Dre");
        Plagecd plage4 = new Plagecd(new Duree(258000),"Still D.R.E.","Dr.Dre");

        lesPlages.add(plage1);
        lesPlages.add(plage2);
        lesPlages.add(plage3);
        lesPlages.add(plage4);
    }


}
