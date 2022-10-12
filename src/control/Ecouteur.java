package control;

import datas.Duree;
import ihm.GUILecteurCd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;

import static java.lang.String.valueOf;

public class Ecouteur implements ActionListener {

    private final GUILecteurCd lecteur;

    public Ecouteur(GUILecteurCd unLecteur) {
        this.lecteur = unLecteur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == lecteur.getButtonChargerCD()){

            if (!this.lecteur.getLeLecteur().estCharge()) {
                JFileChooser fileChooser = new JFileChooser(new File("."));
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File fichierAudio = fileChooser.getSelectedFile();
                    String nomFichier = fichierAudio.toString();
                    this.lecteur.getLeLecteur().chargerUnCD(nomFichier);
                }
                this.lecteur.setButtonChargerCD();
                this.lecteur.setNbPlages(String.valueOf(this.lecteur.getLeLecteur().getNbrPlages()));
                this.lecteur.setTempsTot(this.lecteur.getLeLecteur().getTempsTotal());
            } else {
                this.lecteur.getLeLecteur().setDecharger();
                this.lecteur.setButtonChargerCD();
                this.lecteur.setNbPlages(null);
                this.lecteur.setTempsTot(null);
                this.lecteur.setImage(null);
            }
        }

        if(e.getSource()==lecteur.getButtonPlay()){
            lecteur.getLeLecteur().play();
            // Track number in WEST side
            int trackNumber = lecteur.getLeLecteur().getIndexCourant();
            lecteur.setPlageCourante(valueOf(trackNumber));
            // Track information in the CENTER side
            String info = lecteur.getLeLecteur().getCD().getUnePlage(trackNumber).toString();
            lecteur.setInfoTrack(info);
            // Track duration in EAST side
            String duree = lecteur.getLeLecteur().getCD().getUnePlage(trackNumber).getLaDuree().enTexte('H');
            lecteur.setDureePlageCourante(duree);
        }

        if (e.getSource() == lecteur.getButtonStop()){
            lecteur.getLeLecteur().stop();
            lecteur.setPlageCourante(null);
            lecteur.setInfoTrack(null);
            lecteur.setDureePlageCourante(null);
        }

        if (e.getSource() == lecteur.getButtonNext()){
            lecteur.getLeLecteur().next();

            // Update Track number in WEST side
            int trackNumber = lecteur.getLeLecteur().getIndexCourant();
            lecteur.setPlageCourante(valueOf(trackNumber));

            // Update Track information in the CENTER side
            String info = lecteur.getLeLecteur().getCD().getUnePlage(trackNumber).toString();
            lecteur.setInfoTrack(info);

            // Update Track duration
            String duree = lecteur.getLeLecteur().getCD().getUnePlage(trackNumber).getLaDuree().enTexte('H');
            lecteur.setDureePlageCourante(duree);

        }

        if (e.getSource() == lecteur.getButtonPrevious()){
            lecteur.getLeLecteur().previous();

            // Update Track number in WEST side
            int trackNumber = lecteur.getLeLecteur().getIndexCourant();
            lecteur.setPlageCourante(valueOf(trackNumber));

            // Update Track information in the CENTER side
            String info = lecteur.getLeLecteur().getCD().getUnePlage(trackNumber).toString();
            lecteur.setInfoTrack(info);

            // Update Track duration
            String duree = lecteur.getLeLecteur().getCD().getUnePlage(trackNumber).getLaDuree().enTexte('H');
            lecteur.setDureePlageCourante(duree);
        }


    }
}
