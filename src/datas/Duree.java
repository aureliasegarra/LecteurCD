package datas;

public class Duree {
    private long leTemps;

    public Duree(long millisec){
        if (millisec > 0){
            this.leTemps = millisec;
        }
        else{
            System.out.println("Mauvais format de durée !");
        }
    }

    public long getLeTemps(){
        return this.leTemps;
    }
}
