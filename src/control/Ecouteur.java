package control;

import ihm.GUILecteurCd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.String.valueOf;

public class Ecouteur implements ActionListener {

    private final GUILecteurCd lecteur;

    public Ecouteur(GUILecteurCd unLecteur) {
        this.lecteur = unLecteur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == lecteur.getButtonChargerCD()){
            //TODO
        }

        if(e.getSource()==lecteur.getButtonPlay()){
            if (lecteur.getLeLecteur().estCharge() && lecteur.getLeLecteur().getCD() != null){
                lecteur.getLeLecteur().play();
                // Track number in WEST side
                int trackNumber = lecteur.getLeLecteur().getIndexCourant();
                lecteur.setPlageCourante(String.valueOf(trackNumber));
                // Track information in the CENTER side
                String info = lecteur.getLeLecteur().getCD().getUnePlage(trackNumber).toString();
                lecteur.setInfoTrack(info);
                // Track duration in EAST side
                String duree = lecteur.getLeLecteur().getCD().getUnePlage(trackNumber).getLaDuree().enTexte('H');
                lecteur.setDureePlageCourante(duree);
            }
        }

        if (e.getSource() == lecteur.getButtonStop()){
            //TODO
        }

        if (e.getSource() == lecteur.getButtonNext()){
            //TODO
        }

        if (e.getSource() == lecteur.getButtonPrevious()){
            //TODO
        }


    }
}
