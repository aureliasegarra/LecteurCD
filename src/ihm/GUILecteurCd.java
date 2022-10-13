package ihm;

import control.Ecouteur;
import datas.LecteurCd;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.io.IOException;


public class GUILecteurCd extends JFrame {

    private final LecteurCd leLecteur;

    // All widgets in attribute
    private final JButton buttonPlay = new JButton();
    private final JButton buttonStop = new JButton();
    private final JButton buttonNext = new JButton();
    private final JButton buttonPrevious = new JButton();
    private final JButton buttonChargerCD = new JButton("Charger le CD");

    private final JTextField tempsTotal = new JTextField("");
    private final JTextField nbPlages = new JTextField("");
    private final JTextField plageCourante = new JTextField("");
    private final JTextField infoTrack = new JTextField("");
    private final JTextField dureePlageCourante = new JTextField("");

    private ImageIcon image;
    private JLabel jImage;


    public GUILecteurCd(String title){
        super(title);
        this.leLecteur = new LecteurCd();
        graphicLayout();
        addListeners();
        setSize(600,800);
        setVisible(true);
        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void addListeners(){
        // Listen to click mouse
        this.buttonPlay.addActionListener(new Ecouteur(this));
        this.buttonStop.addActionListener(new Ecouteur(this));
        this.buttonNext.addActionListener(new Ecouteur(this));
        this.buttonPrevious.addActionListener(new Ecouteur(this));
        this.buttonChargerCD.addActionListener(new Ecouteur(this));
    }

    public void graphicLayout(){
        this.setLayout(new GridLayout(2, 1));
        this.add(up());
        this.add(down());
    }

    // *********************
    // ***** DOWN *****
    // *********************

    private JPanel down() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        panel.add(upSide());
        panel.add(middleSide());
        panel.add(downSide());

        return panel;
    }

    private JPanel upSide() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        panel.add(buttonChargerCD);
        panel.add(new JLabel());
        panel.add(new JLabel("Temps total"));
        panel.add(tempsTotal);
        panel.add(new JLabel("Nombre de plages"));
        panel.add(nbPlages);

        return panel;
    }

    private JPanel middleSide(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(plageCourante, BorderLayout.WEST);
        panel.add(infoTrack, BorderLayout.CENTER);
        panel.add(dureePlageCourante, BorderLayout.EAST);

        /* Modification de la taille des fenêtres*/
        plageCourante.setPreferredSize(new Dimension(50,100));
        dureePlageCourante.setPreferredSize(new Dimension(100,100));

        /* Modification de la couleur de fond des fenêtres*/

        plageCourante.setBackground(Color.WHITE);
        dureePlageCourante.setBackground(Color.WHITE);
        infoTrack.setBackground(Color.WHITE);

        /* Texte des fenêtres centrées*/
        plageCourante.setHorizontalAlignment(JTextField.CENTER);
        dureePlageCourante.setHorizontalAlignment(JTextField.CENTER);
        infoTrack.setHorizontalAlignment(JTextField.CENTER);

        return panel;
    }

    private JPanel downSide(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,4));

        ImageIcon icon1 = new ImageIcon("images/play.png");
        buttonPlay.setIcon(icon1);
        ImageIcon icon2 = new ImageIcon("images/next.png");
        buttonNext.setIcon(icon2);
        ImageIcon icon3 = new ImageIcon("images/previous.png");
        buttonPrevious.setIcon(icon3);
        ImageIcon icon4 = new ImageIcon("images/stop.png");
        buttonStop.setIcon(icon4);


        panel.add(buttonStop);
        panel.add(buttonPrevious);
        panel.add(buttonPlay);
        panel.add(buttonNext);


        return panel;
    }




    // ***********************
    // ***** UP ******
    // ***********************

    private JPanel up(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));
        image = new ImageIcon("images/illustration.jpg");
        ImageIcon icon = new ImageIcon(image.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
        jImage = new JLabel(icon);
        panel.add(jImage);

        return panel;
    }

    // *******************
    // ***** GETTERS *****
    // *******************


    public LecteurCd getLeLecteur() { return this.leLecteur; }

    public JButton getButtonPlay() {
        return buttonPlay;
    }

    public JButton getButtonStop() {
        return buttonStop;
    }

    public JButton getButtonNext() {
        return buttonNext;
    }

    public JButton getButtonPrevious() {
        return buttonPrevious;
    }

    public JButton getButtonChargerCD() {
        return buttonChargerCD;
    }

    public JTextField getTempsTotal() {
        return tempsTotal;
    }

    public JTextField getNbPlages() {
        return nbPlages;
    }

    public JTextField getPlageCourante() {
        return plageCourante;
    }

    public JTextField getInfoTrack() {
        return infoTrack;
    }

    public JTextField getDureePlageCourante() {
        return dureePlageCourante;
    }

    public ImageIcon getImage() {
        return image;
    }

    public JLabel getJImage() {
        return jImage;
    }


    // *******************
    // ***** SETTERS *****
    // *******************



    public void setButtonChargerCD(){
        if(leLecteur.estCharge()){
            buttonChargerCD.setText("Retirer le CD");
        }
        else{
            buttonChargerCD.setText("Charger le CD");
        }
    }

    public void setImage(String fichier) {
        if (this.leLecteur.estCharge()){
            ImageIcon cdCover = new ImageIcon(fichier);
            ImageIcon imageResized = new ImageIcon(cdCover.getImage().getScaledInstance(380, 380, Image.SCALE_DEFAULT));
            jImage.setIcon(imageResized);
        } else {
            image = new ImageIcon("images/illustration.jpg");
            ImageIcon icon = new ImageIcon(image.getImage().getScaledInstance(380, 380, Image.SCALE_DEFAULT));
            jImage.setIcon(icon);
        }
    }

    public void setTempsTotal(String temps){
        tempsTotal.setText(temps);
    }

    public void setNbPlages(String nbPlage){
        nbPlages.setText(nbPlage);
    }

    public void setPlageCourante(String plage){
        plageCourante.setText(plage);
    }

    public void setInfoTrack(String info){
        infoTrack.setText(info);
    }

    public void setDureePlageCourante(String infoDuree){
        dureePlageCourante.setText(infoDuree);
    }


    // *******************
    // ***** MAIN *****
    // *******************


    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        GUILecteurCd app = new GUILecteurCd("CD Player");

    }
}
