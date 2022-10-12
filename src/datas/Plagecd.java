package datas;

/**
 * This class defines a music track belonging to a CD. A track has a duration and can be played.
 * It is characterized by a title (title of the track) and an interpreter(s) (singer, musicians, ...)
 * @author Aurelia Segarra
 */
public class Plagecd {
    /**
     * Track duration
     */
    private final Duree laDuree;

    /**
     * Track title
     */
    private final String leTitre;

    /**
     * Track interpreter
     */
    private final String lInterprete;


    /**
     * Constructor for a "plage" corresponding to a music track
     * @param duree Track Duration (⚠️!type Duree)
     * @param titre Track title
     * @param interprete Track interpreter
     */
    public Plagecd (Duree duree, String titre, String interprete){
        this.laDuree = duree;
        this.leTitre = titre;
        this.lInterprete = interprete;
    }

    /**
     * GETTER
     * @return duration (⚠️type Duree)
     */
    public Duree getLaDuree(){
        return this.laDuree;
    }

    /**
     * GETTER
     * @return title
     */
    public String getLeTitre(){
        return this.leTitre;
    }

    /**
     * GETTER
     * @return interpreter
     */
    public String getLInterprete(){
        return this.lInterprete;
    }

    /**
     * Method giving the complete description of the track :
     * <ul>
     *     <li>Description</li>
     *     <li>Title</li>
     *     <li>Interpreter</li>
     *     <li>Duration</li>
     * </ul>
     * @return this description
     */
    public String getFicheComplete(){

        return "Description de la plage de musique\n"
                + "Titre : " + this.leTitre + "\n"
                + "Interprete : " + this.lInterprete + "\n"
                + "Duree : " + this.laDuree.enTexte('S');
    }


    /**
     * Method giving a textual summary : title-interpreter-duration(SSS.MMM sec)
     * @return this summary
     */
    @Override
    public String toString(){
        return getLeTitre() + " - " + getLInterprete() + " - " + laDuree.enTexte('S');
    }
}
