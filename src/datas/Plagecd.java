package datas;

public class Plagecd {
    private Duree laDuree;
    private String leTitre;
    private String lInterprete;


    public Plagecd (Duree duree, String titre, String interprete){
        this.laDuree = duree;
        this.leTitre = titre;
        this.lInterprete = interprete;
    }

    public Duree getLaDuree(){
        return laDuree;
    }

    public String getLeTitre(){
        return this.leTitre;
    }

    public String getLInterprete(){
        return this.lInterprete;
    }

    public String getFicheComplete(){

        return "Description de la plage de musique\n"
                + "Titre : " + this.leTitre + "\n"
                + "Interprete : " + this.lInterprete + "\n"
                + "Duree : " + this.laDuree;
    }


    @Override
    public String toString(){

        return getLeTitre() + " - " + getLInterprete() + " - " + laDuree;
    }
}
