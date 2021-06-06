import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//tanito projektek


public class Gui extends JFrame {

    JPanel meterPanel, kmhPanel, mindenesPanel;
    JButton kiszamol,bhelp;
    JTextField percfield, mpfield, kmhfield, meterfield, qpercfield,qmpfield;
    JRadioButton b400, b1000, b3200, bkmh, bmindenes;
    JLabel lperc, lmp, eredmeny, lkmh, lmeter;

    double percszam, mpszam, kmhszam, meterszam, qpercszam,qmpszam;


    public Gui() {

        Color szurke = new Color(0,0,0, 0.84F);
        Color feher = new Color(240,240,240 );
        Color kozSzurke = new Color(0,0,0, 0.76F);


        this.setSize(600, 600);
        this.setLocationRelativeTo(null);//roviditett forma h a kepernyo kozepen jelenjen meg
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Futás kalkulátor");// az mga a boxra vonatkozik
        this.setLayout(new BorderLayout());
        this.setIconImage(new ImageIcon("res/logo.png").getImage());
        JPanel thePanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // ebbe lesz minden beleteve

        thePanel.setBackground(Color.gray);

        b400 = new JRadioButton("400m");
        b400.setBackground(Color.black); b400.setForeground(feher);
        b1000 = new JRadioButton("1000m");
        b1000.setBackground(Color.black); b1000.setForeground(feher);
        b3200 = new JRadioButton("3200m");
        b3200.setBackground(Color.black); b3200.setForeground(feher);
        bkmh = new JRadioButton("km/h");
        bkmh.setBackground(Color.black); bkmh.setForeground(feher);
        bmindenes = new JRadioButton("egyéni");
        bmindenes.setBackground(Color.black); bmindenes.setForeground(feher);

        //ezzel van csoportositva
        ButtonGroup operation = new ButtonGroup(); // valasztasi lehetőség(csak1)
        operation.add(b400);
        operation.add(b1000);
        operation.add(b3200);
        operation.add(bkmh);
        operation.add(bmindenes);

        b400.addActionListener(new ListenforButton());
        b1000.addActionListener(new ListenforButton());
        b3200.addActionListener(new ListenforButton());
        bkmh.addActionListener(new ListenforButton());
        bmindenes.addActionListener(new ListenforButton());

        JPanel operPanel = new JPanel();
        operPanel.add(b400);
        operPanel.add(b1000);
        operPanel.add(b3200);
        operPanel.add(bkmh);
        operPanel.add(bmindenes);


        operPanel.setBackground(szurke);
        operPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        this.add(operPanel,BorderLayout.NORTH);

        //************** help  ALSÓ PANEL

        JPanel alsoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // ebbe lesz minden beleteve
        bhelp= new JButton("help");
        bhelp.addActionListener(new ListenforButton());


        //lhelp.setVisible(false);

        alsoPanel.add(bhelp);
        alsoPanel.setBackground(szurke);
        this.add(alsoPanel,BorderLayout.SOUTH);

        //********************


        kiszamol = new JButton("SZÁMOLJ!");// gomb felirata
        kiszamol.setFont(new Font("Courier", Font.BOLD,25));
        kiszamol.setBackground(Color.black);
        kiszamol.setForeground(feher);
        kiszamol.setToolTipText("Kalkulátor indítása");
        ListenforButton lforButton = new ListenforButton();
        kiszamol.addActionListener(lforButton);
        thePanel.add(kiszamol);

        //*************** BAL PANEL

        //todo thepanel--> alsoPanel, balPanel>>meterpanel,kmpanel
        JPanel balPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // BALPANEL
        balPanel.setBackground(kozSzurke);
        balPanel.setPreferredSize(new Dimension(160,20));
        this.add(balPanel,BorderLayout.WEST);


        meterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //METERPANEL
        meterPanel.setBackground(Color.black);
        //---percek a meterpanelen belul
        lperc = new JLabel("Perc:"); lperc.setForeground(feher); lperc.setFont( new Font("Courier", Font.BOLD,16));
        percfield = new JTextField("0", 4);//hely ahova irni lehet
        meterPanel.add(lperc);meterPanel.add(percfield);
        //---mp a meterpanelen belul
        lmp = new JLabel("Másodperc:"); lmp.setForeground(feher); lmp.setFont( new Font("Courier", Font.BOLD,16));
        mpfield = new JTextField("0", 4);//hely ahova irni lehet
        meterPanel.add(lmp);meterPanel.add(mpfield);
        //System.out.println(mpfield);

        balPanel.add(meterPanel); //meterpanel hozzaadasa
        meterPanel.setPreferredSize(new Dimension(150,90));
        meterPanel.setVisible(false);

        //---kmh panel
        kmhPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //METERPANEL
        kmhPanel.setBackground(Color.black);

        lkmh = new JLabel("km/h:"); lkmh.setForeground(feher); lkmh.setFont( new Font("Courier", Font.BOLD,16));
        kmhfield = new JTextField("0",4);
        kmhfield.setToolTipText("A tizedesvesszőt itt ponttal kell írni");
        kmhPanel.add(lkmh); kmhPanel.add(kmhfield);

        balPanel.add(kmhPanel); //meterpanel hozzaadasa
        kmhPanel.setPreferredSize(new Dimension(150,90));
        kmhPanel.setVisible(false);

        //...mindenes panel




        mindenesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //METERPANEL
        mindenesPanel.setBackground(Color.black);

        //todo
        lperc = new JLabel("Perc:"); lperc.setForeground(feher); lperc.setFont( new Font("Courier", Font.BOLD,16));
        qpercfield = new JTextField("0", 4);//hely ahova irni lehet
        mindenesPanel.add(lperc);mindenesPanel.add(qpercfield);
        //---mp a meterpanelen belul
        lmp = new JLabel("Másodperc:"); lmp.setForeground(feher); lmp.setFont( new Font("Courier", Font.BOLD,16));
        qmpfield = new JTextField("0", 4);//hely ahova irni lehet
        mindenesPanel.add(lmp);mindenesPanel.add(qmpfield);
        //todo

        lmeter = new JLabel("Méter:"); lmeter.setForeground(feher); lmeter.setFont( new Font("Courier", Font.BOLD,16));
        meterfield = new JTextField("0",4);
        mindenesPanel.add(lmeter); mindenesPanel.add(meterfield);


        balPanel.add(mindenesPanel); //meterpanel hozzaadasa
        mindenesPanel.setPreferredSize(new Dimension(150,90));
        mindenesPanel.setVisible(false);






        //*******************


        //b400.setSelected(true); //ez lesz a default kiválasztva
        //ha semmi se lenne kivalsztva  akkor meniden sesetben 0 at adna vissza a z eredmnyere

        eredmeny= new JLabel();
        eredmeny.setFont( new Font("Courier", Font.BOLD,16));
        eredmeny.setLocation(300,200);
        thePanel.add(eredmeny);
        thePanel.setPreferredSize(new Dimension(300,20));





        this.add(thePanel,BorderLayout.CENTER);
        setVisible(true);
        //percfield.requestFocus();

    }

    public class ListenforButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {



            if(e.getSource() == b400 || e.getSource() == b1000 || e.getSource() == b3200) {
                meterPanel.setVisible(true); kmhPanel.setVisible(false); mindenesPanel.setVisible(false);


            } else if(e.getSource() == bkmh) {
                meterPanel.setVisible(false);  kmhPanel.setVisible(true); mindenesPanel.setVisible(false);

            } else  if (e.getSource()== bmindenes) {
                meterPanel.setVisible(false); kmhPanel.setVisible(false); mindenesPanel.setVisible(true);
            }

            if (e.getSource() == bhelp ){
                eredmeny.setText("segítségért írj: molnaradam8466@gmail.com címre");
            }

            if (e.getSource() == kiszamol) {

                percszam=0.0;
                mpszam=0.0;
                kmhszam=0.0;
                meterszam=0.0;
                qpercszam= 0.0;
                qmpszam = 0.0;



                try {
                    //meterszam = Double.parseDouble(meterfield.getText());

                    percszam = Double.parseDouble(percfield.getText());
                    mpszam = Double.parseDouble(mpfield.getText());
                    kmhszam = Double.parseDouble(kmhfield.getText());

                    qpercszam = Double.parseDouble(qpercfield.getText());
                    qmpszam = Double.parseDouble(qmpfield.getText());
                    meterszam = Double.parseDouble(meterfield.getText());


                    /*meterszam = Double.parseDouble(meterfield.getText());
                    qpercszam = Double.parseDouble(qpercfield.getText());
                    qmpszam = Double.parseDouble(qmpfield.getText());*/
                    //percszam = Double.parseDouble(qpercfield.getText());
                    //mpszam = Double.parseDouble(mpfield.getText());




                } catch (NumberFormatException ex) {
                    //JOptionPane.showMessageDialog(Gui.this, "Ellenőrizd ,valamit rosszul írtál", "Error", JOptionPane.ERROR_MESSAGE);
                    //System.exit(0);
                }

                if (b400.isSelected()) {
                    eredmeny.setText(meterTOkmh(percszam ,mpszam, 400));
                } else if (b1000.isSelected()) {
                    eredmeny.setText(meterTOkmh(percszam ,mpszam, 1000));
                } else if (b3200.isSelected()) {
                    eredmeny.setText(meterTOkmh(percszam ,mpszam, 3200));
                } else if (bkmh.isSelected()) {
                    eredmeny.setText(kmhTOmeter(kmhszam));
                } else if (bmindenes.isSelected()) {
                    eredmeny.setText(meterTOkmh(qpercszam,qmpszam,meterszam));
                }



                }

            }
        }



    public static String meterTOkmh(double perc, double mp, double szam) {


        double idomp = perc*60 +mp; //mp

        double egysegido = idomp/szam; // 1 méter alatt mennyit halad mp/m

        return "400m: " + (int)(egysegido*400)/60 +":"+ (int)(egysegido*400)%60 + "  \n" +
                "1000m: " + (int)(egysegido*1000)/60 +":"+ (int)(egysegido*1000)%60 + "  \n" +
                "3200m: " + (int)(egysegido*3200)/60 +":"+ (int)(egysegido*3200)%60 + "  \n" +
                "km/h: " + String.format( "%.2f",(1/egysegido)*3.6)  + "  \n";
    }


    public static String kmhTOmeter(double kmh) {

        double percperm = 3600*(1/kmh)/1000;//perc per méter

        return "400m: " + (int)(percperm*400)/60 +":"+ +(int)(percperm*400)%60 + "  \n" +
                "1000m: " + (int)(percperm*1000)/60 +":"+ (int)(percperm*1000)%60 + "  \n" +
                "3200m: " + (int)(percperm*3200)/60 +":"+ (int)(percperm*3200)%60 + "  \n" +
                "km/h: " + kmh +"  \n";
    }

/*
    public class ListenForValaszto implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == b400 || e.getSource() == b1000 || e.getSource() == b3200) {
                lkmh.setVisible(false);
                lmp.setVisible(true);
                lperc.setVisible(true);
            } else if(e.getSource() == bkmh) {
                lkmh.setVisible(true);
                lmp.setVisible(false);
                lperc.setVisible(false);
            }
        }
    }*/


}