package ihm;

import datas.LecteurCd;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;


public class GUILecteurCd extends JFrame {

    private LecteurCd leLecteur;

    // ALL fields and button in attribute
    private final JButton buttonPlay = new JButton("PLAY");
    private final JButton buttonStop = new JButton("STOP");
    private final JButton buttonNext = new JButton("NEXT");
    private final JButton buttonPrevious = new JButton("PREVIOUS");
    private final JButton buttonChargerCD = new JButton("Charger un CD");

    private final JTextField tempsTotal = new JTextField("");
    private final JTextField nbPlages = new JTextField("");
    private final JTextField plageCourante = new JTextField("");
    private final JTextField infoTrack = new JTextField("");
    private final JTextField dureePlageCourante = new JTextField("");

    private ImageIcon image;
    private JLabel jImage;


    public GUILecteurCd(String title){
        super(title);
        LecteurCd leLecteur = new LecteurCd();
        graphicLayout();
        setSize(800,400);
        setVisible(true);
        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /*private void addListeners(){
        //écouter d'actions de souris
        this.buttonPlay.addActionListener(new Ecouteur(this));
        this.buttonStop.addActionListener(new Ecouteur(this));
        this.buttonNext.addActionListener(new Ecouteur(this));
        this.buttonPrevious.addActionListener(new Ecouteur(this));
        this.buttonChargerCD.addActionListener(new Ecouteur(this));
    }*/

    public void graphicLayout(){
        this.setLayout(new GridLayout(1, 3));
        this.add(leftLayout());
        this.add(rightLayout());
    }

    private JPanel leftLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        panel.add(upSide());
        panel.add(middleSide());
        panel.add(downSide());

        return panel;
    }

    private JPanel rightLayout(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));
        image = new ImageIcon("images/equalizer.jpg");
        ImageIcon icon = new ImageIcon(image.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
        jImage = new JLabel(icon);
        panel.add(jImage);

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

    private JPanel downSide(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,4));
        panel.add(buttonStop);
        panel.add(buttonPlay);
        panel.add(buttonNext);
        panel.add(buttonPrevious);

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

        plageCourante.setBackground(Color.GRAY);
        dureePlageCourante.setBackground(Color.GRAY);
        infoTrack.setBackground(Color.GRAY);

        /* Texte des fenêtres centrées*/
        plageCourante.setHorizontalAlignment(JTextField.CENTER);
        dureePlageCourante.setHorizontalAlignment(JTextField.CENTER);
        infoTrack.setHorizontalAlignment(JTextField.CENTER);

        return panel;
    }


    // *******************
    // ***** GETTERS *****
    // *******************

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

    public JLabel getjImage() {
        return jImage;
    }


    // *******************
    // ***** SETTERS *****
    // *******************

    public void setButton(){
        if(leLecteur.estCharge()){
            buttonChargerCD.setText("Retirer le CD");
        }
        else{
            buttonChargerCD.setText("Charger le CD");
        }
    }

    public void setImage(ImageIcon image) { this.image = image; }

    public void setTempsTot(String temps){
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


    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        GUILecteurCd app = new GUILecteurCd("CD Player");

    }
}
