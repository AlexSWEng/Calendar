package calendrier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalendrierGUI {

    static Calendrier  calendrier;

    int                monthEntered = 0;
    int                yearEntered  = 0;

    private JFrame     frame;
    private JLabel     labelTitre;
    private JButton    buttonForward;
    private JButton    buttonBack;
    private JPanel     panelCentre;
    private JLabel     labelLundi;
    private JLabel     labelMardi;
    private JLabel     labelMercredi;
    private JLabel     labelJeudi;
    private JLabel     labelVendredi;
    private JLabel     labelSamedi;
    private JLabel     labelDimanche;
    private JLabel     label00;
    private JLabel     label01;
    private JLabel     label02;
    private JLabel     label03;
    private JLabel     label04;
    private JLabel     label05;
    private JLabel     label06;
    private JLabel     label10;
    private JLabel     label11;
    private JLabel     label12;
    private JLabel     label13;
    private JLabel     label14;
    private JLabel     label15;
    private JLabel     label16;
    private JLabel     label20;
    private JLabel     label21;
    private JLabel     label22;
    private JLabel     label23;
    private JLabel     label24;
    private JLabel     label25;
    private JLabel     label26;
    private JLabel     label30;
    private JLabel     label31;
    private JLabel     label32;
    private JLabel     label33;
    private JLabel     label34;
    private JLabel     label35;
    private JLabel     label36;
    private JLabel     label40;
    private JLabel     label41;
    private JLabel     label42;
    private JLabel     label43;
    private JLabel     label44;
    private JLabel     label45;
    private JLabel     label46;
    private JLabel     label50;
    private JLabel     label51;
    private JLabel     label52;
    private JLabel     label53;
    private JLabel     label54;
    private JLabel     label55;
    private JLabel     label56;

    private JPanel     panelFooter;
    private JButton    buttonToday;
    private JTextField txtFieldYear;
    private JTextField txtFieldMonth;
    private JButton    buttonAfficher;

    /*
     * Launch the application.
     */
    public static void main( String[] args ) {

        calendrier = new Calendrier();

        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    CalendrierGUI window = new CalendrierGUI();
                    window.frame.setVisible( true );
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }

    /*
     * Create the application.
     */
    public CalendrierGUI() {

        calendrier.resetInit();
        build();
        initialize();
        draw();

    }

    /*
     * The method build() will prepare the ArrayLists to be drawn into the
     * calendar GUI.
     */
    public void build() {
        calendrier.resetTemp();
        calendrier.fillDaysOfTheMonthArrayList();
        calendrier.defineStart();
        calendrier.mergeWithTemp();
    }

    /*
     * The method draw() will transfer the content of the ArrayList temp into
     * each label of he calendar. It will also display the title of the calendar
     * on top.
     */
    public void draw() {
        labelTitre.setText( calendrier.getTitleDate() );
        label00.setText( calendrier.temp.get( 0 ) );
        label01.setText( calendrier.temp.get( 1 ) );
        label02.setText( calendrier.temp.get( 2 ) );
        label03.setText( calendrier.temp.get( 3 ) );
        label04.setText( calendrier.temp.get( 4 ) );
        label05.setText( calendrier.temp.get( 5 ) );
        label06.setText( calendrier.temp.get( 6 ) );
        label10.setText( calendrier.temp.get( 7 ) );
        label11.setText( calendrier.temp.get( 8 ) );
        label12.setText( calendrier.temp.get( 9 ) );
        label13.setText( calendrier.temp.get( 10 ) );
        label14.setText( calendrier.temp.get( 11 ) );
        label15.setText( calendrier.temp.get( 12 ) );
        label16.setText( calendrier.temp.get( 13 ) );
        label20.setText( calendrier.temp.get( 14 ) );
        label21.setText( calendrier.temp.get( 15 ) );
        label22.setText( calendrier.temp.get( 16 ) );
        label23.setText( calendrier.temp.get( 17 ) );
        label24.setText( calendrier.temp.get( 18 ) );
        label25.setText( calendrier.temp.get( 19 ) );
        label26.setText( calendrier.temp.get( 20 ) );
        label30.setText( calendrier.temp.get( 21 ) );
        label31.setText( calendrier.temp.get( 22 ) );
        label32.setText( calendrier.temp.get( 23 ) );
        label33.setText( calendrier.temp.get( 24 ) );
        label34.setText( calendrier.temp.get( 25 ) );
        label35.setText( calendrier.temp.get( 26 ) );
        label36.setText( calendrier.temp.get( 27 ) );
        label40.setText( calendrier.temp.get( 28 ) );
        label41.setText( calendrier.temp.get( 29 ) );
        label42.setText( calendrier.temp.get( 30 ) );
        label43.setText( calendrier.temp.get( 31 ) );
        label44.setText( calendrier.temp.get( 32 ) );
        label45.setText( calendrier.temp.get( 33 ) );
        label46.setText( calendrier.temp.get( 34 ) );
        label50.setText( calendrier.temp.get( 35 ) );
        label51.setText( calendrier.temp.get( 36 ) );
        label52.setText( calendrier.temp.get( 37 ) );
        label53.setText( calendrier.temp.get( 38 ) );
        label54.setText( calendrier.temp.get( 39 ) );
        label55.setText( calendrier.temp.get( 40 ) );
        label56.setText( calendrier.temp.get( 41 ) );
    }

    /*
     * This method is used in conjunction with labelDateOut() to make the month
     * labels appear BOLD when the mouse cursor is hovering over them
     */
    public void labelDateIn( JLabel label ) {
        label.setFont( new Font( "Tahoma", Font.BOLD, 22 ) );
    }

    /*
     * This method is used in conjunction with labelDateIn() to make the month
     * labels appear PLAIN when the mouse cursor is not hovering over them
     */
    public void labelDateOut( JLabel label ) {
        label.setFont( new Font( "Tahoma", Font.PLAIN, 20 ) );
    }

    /*
     * Initialize the contents of the frame. Add listeners to the buttons.
     */
    private void initialize() {

        frame = new JFrame();
        frame.getContentPane().setBackground( new Color( 173, 216, 230 ) );
        frame.setBounds( 100, 100, 450, 450 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( new BorderLayout( 0, 0 ) );

        labelTitre = new JLabel( calendrier.titleDate );
        labelTitre.setFont( new Font( "Tahoma", Font.BOLD, 30 ) );
        labelTitre.setHorizontalAlignment( SwingConstants.CENTER );
        frame.getContentPane().add( labelTitre, BorderLayout.NORTH );

        buttonForward = new JButton( ">" );
        buttonForward.setBackground( new Color( 210, 180, 140 ) );
        buttonForward.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );
        buttonForward.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                calendrier.monthPlus();
                build();
                draw();
            }
        } );
        frame.getContentPane().add( buttonForward, BorderLayout.EAST );

        buttonBack = new JButton( "<" );
        buttonBack.setBackground( new Color( 210, 180, 140 ) );
        buttonBack.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );
        buttonBack.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                calendrier.monthMinus();
                build();
                draw();
            }
        } );
        frame.getContentPane().add( buttonBack, BorderLayout.WEST );

        panelCentre = new JPanel();
        panelCentre.setBackground( new Color( 250, 235, 215 ) );
        frame.getContentPane().add( panelCentre, BorderLayout.CENTER );
        panelCentre.setLayout( new GridLayout( 0, 7, 0, 0 ) );

        labelLundi = new JLabel( "Lu" );
        labelLundi.setFont( new Font( "Dialog", Font.BOLD, 20 ) );
        panelCentre.add( labelLundi );

        labelMardi = new JLabel( "Ma" );
        labelMardi.setFont( new Font( "Dialog", Font.BOLD, 20 ) );
        panelCentre.add( labelMardi );

        labelMercredi = new JLabel( "Me" );
        labelMercredi.setFont( new Font( "Dialog", Font.BOLD, 20 ) );
        panelCentre.add( labelMercredi );

        labelJeudi = new JLabel( "Je" );
        labelJeudi.setFont( new Font( "Dialog", Font.BOLD, 20 ) );
        panelCentre.add( labelJeudi );

        labelVendredi = new JLabel( "Ve" );
        labelVendredi.setFont( new Font( "Dialog", Font.BOLD, 20 ) );
        panelCentre.add( labelVendredi );

        labelSamedi = new JLabel( "Sa" );
        labelSamedi.setFont( new Font( "Dialog", Font.BOLD, 20 ) );
        labelSamedi.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( labelSamedi );

        labelDimanche = new JLabel( "Di" );
        labelDimanche.setFont( new Font( "Dialog", Font.BOLD, 20 ) );
        labelDimanche.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( labelDimanche );

        label00 = new JLabel( calendrier.init.get( 0 ) );
        label00.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label00.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label00 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label00 );
            }
        } );
        panelCentre.add( label00 );

        label01 = new JLabel( calendrier.init.get( 1 ) );
        label01.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label01.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label01 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label01 );
            }
        } );
        panelCentre.add( label01 );

        label02 = new JLabel( calendrier.init.get( 2 ) );
        label02.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label02.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label02 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label02 );
            }
        } );
        panelCentre.add( label02 );

        label03 = new JLabel( calendrier.init.get( 3 ) );
        label03.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label03.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label03 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label03 );
            }
        } );
        panelCentre.add( label03 );

        label04 = new JLabel( calendrier.init.get( 4 ) );
        label04.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label04.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label04 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label04 );
            }
        } );
        panelCentre.add( label04 );

        label05 = new JLabel( calendrier.init.get( 5 ) );
        label05.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label05.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label05 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label05 );
            }
        } );
        label05.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label05 );

        label06 = new JLabel( calendrier.init.get( 6 ) );
        label06.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label06.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label06 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label06 );
            }
        } );
        label06.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label06 );

        label10 = new JLabel( calendrier.init.get( 7 ) );
        label10.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label10.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label10 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label10 );
            }
        } );
        panelCentre.add( label10 );

        label11 = new JLabel( calendrier.init.get( 8 ) );
        label11.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label11.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label11 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label11 );
            }
        } );
        panelCentre.add( label11 );

        label12 = new JLabel( calendrier.init.get( 9 ) );
        label12.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label12.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label12 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label12 );
            }
        } );
        panelCentre.add( label12 );

        label13 = new JLabel( calendrier.init.get( 10 ) );
        label13.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label13.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label13 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label13 );
            }
        } );
        panelCentre.add( label13 );

        label14 = new JLabel( calendrier.init.get( 11 ) );
        label14.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label14.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label14 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label14 );
            }
        } );
        panelCentre.add( label14 );

        label15 = new JLabel( calendrier.init.get( 12 ) );
        label15.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label15.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label15 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label15 );
            }
        } );
        label15.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label15 );

        label16 = new JLabel( calendrier.init.get( 13 ) );
        label16.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label16.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label16 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label16 );
            }
        } );
        label16.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label16 );

        label20 = new JLabel( calendrier.init.get( 14 ) );
        label20.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label20.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label20 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label20 );
            }
        } );
        panelCentre.add( label20 );

        label21 = new JLabel( calendrier.init.get( 15 ) );
        label21.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label21.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label21 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label21 );
            }
        } );
        panelCentre.add( label21 );

        label22 = new JLabel( calendrier.init.get( 16 ) );
        label22.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label22.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label22 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label22 );
            }
        } );
        panelCentre.add( label22 );

        label23 = new JLabel( calendrier.init.get( 17 ) );
        label23.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label23.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label23 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label23 );
            }
        } );
        panelCentre.add( label23 );

        label24 = new JLabel( calendrier.init.get( 18 ) );
        label24.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label24.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label24 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label24 );
            }
        } );
        panelCentre.add( label24 );

        label25 = new JLabel( calendrier.init.get( 19 ) );
        label25.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label25.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label25 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label25 );
            }
        } );
        label25.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label25 );

        label26 = new JLabel( calendrier.init.get( 20 ) );
        label26.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label26.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label26 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label26 );
            }
        } );
        label26.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label26 );

        label30 = new JLabel( calendrier.init.get( 21 ) );
        label30.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label30.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label30 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label30 );
            }
        } );
        panelCentre.add( label30 );

        label31 = new JLabel( calendrier.init.get( 22 ) );
        label31.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label31.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label31 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label31 );
            }
        } );
        panelCentre.add( label31 );

        label32 = new JLabel( calendrier.init.get( 23 ) );
        label32.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label32.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label32 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label32 );
            }
        } );
        panelCentre.add( label32 );

        label33 = new JLabel( calendrier.init.get( 24 ) );
        label33.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label33.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label33 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label33 );
            }
        } );
        panelCentre.add( label33 );

        label34 = new JLabel( calendrier.init.get( 25 ) );
        label34.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label34.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label34 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label34 );
            }
        } );
        panelCentre.add( label34 );

        label35 = new JLabel( calendrier.init.get( 26 ) );
        label35.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label35.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label35 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label35 );
            }
        } );
        label35.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label35 );

        label36 = new JLabel( calendrier.init.get( 27 ) );
        label36.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label36.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label36 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label36 );
            }
        } );
        label36.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label36 );

        label40 = new JLabel( calendrier.init.get( 28 ) );
        label40.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label40.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label40 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label40 );
            }
        } );
        panelCentre.add( label40 );

        label41 = new JLabel( calendrier.init.get( 29 ) );
        label41.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label41.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label41 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label41 );
            }
        } );
        panelCentre.add( label41 );

        label42 = new JLabel( calendrier.init.get( 30 ) );
        label42.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label42.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label42 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label42 );
            }
        } );
        panelCentre.add( label42 );

        label43 = new JLabel( calendrier.init.get( 31 ) );
        label43.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label43.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label43 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label43 );
            }
        } );
        panelCentre.add( label43 );

        label44 = new JLabel( calendrier.init.get( 32 ) );
        label44.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label44.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label44 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label44 );
            }
        } );
        panelCentre.add( label44 );

        label45 = new JLabel( calendrier.init.get( 33 ) );
        label45.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label45.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label45 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label45 );
            }
        } );
        label45.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label45 );

        label46 = new JLabel( calendrier.init.get( 34 ) );
        label46.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label46.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label46 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label46 );
            }
        } );
        label46.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label46 );

        label50 = new JLabel( calendrier.init.get( 35 ) );
        label50.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label50.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label50 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label50 );
            }
        } );
        panelCentre.add( label50 );

        label51 = new JLabel( calendrier.init.get( 36 ) );
        label51.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label51.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label51 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label51 );
            }
        } );
        panelCentre.add( label51 );

        label52 = new JLabel( calendrier.init.get( 37 ) );
        label52.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label52.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label52 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label52 );
            }
        } );
        panelCentre.add( label52 );

        label53 = new JLabel( calendrier.init.get( 38 ) );
        label53.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label53.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label53 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label53 );
            }
        } );
        panelCentre.add( label53 );

        label54 = new JLabel( calendrier.init.get( 39 ) );
        label54.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label54.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label54 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label54 );
            }
        } );
        panelCentre.add( label54 );

        label55 = new JLabel( calendrier.init.get( 40 ) );
        label55.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label55.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label55 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label55 );
            }
        } );
        label55.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label55 );

        label56 = new JLabel( calendrier.init.get( 41 ) );
        label56.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
        label56.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseEntered( MouseEvent e ) {
                labelDateIn( label56 );
            }

            @Override
            public void mouseExited( MouseEvent e ) {
                labelDateOut( label56 );
            }
        } );
        label56.setForeground( new Color( 0, 0, 255 ) );
        panelCentre.add( label56 );

        panelFooter = new JPanel();
        frame.getContentPane().add( panelFooter, BorderLayout.SOUTH );

        buttonToday = new JButton( "Aujourd'hui" );
        buttonToday.setBackground( new Color( 135, 206, 250 ) );
        buttonToday.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );
        buttonToday.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                calendrier.resetTemp();
                calendrier.resetToToday();
                calendrier.defineStart();
                calendrier.mergeWithTemp();
                draw();
            }
        } );
        panelFooter.setLayout( new GridLayout( 0, 4, 0, 0 ) );
        panelFooter.add( buttonToday );

        txtFieldMonth = new JTextField();
        txtFieldMonth.setText( "12" );
        panelFooter.add( txtFieldMonth );
        txtFieldMonth.setColumns( 10 );

        txtFieldYear = new JTextField();
        txtFieldYear.setText( "1983" );
        panelFooter.add( txtFieldYear );
        txtFieldYear.setColumns( 10 );

        buttonAfficher = new JButton( "Afficher" );
        buttonAfficher.setBackground( new Color( 135, 206, 250 ) );
        buttonAfficher.addMouseListener( new MouseAdapter() {

            @Override
            public void mouseClicked( MouseEvent e ) {

                // if (!txtFieldMonth.getText().equalsIgnoreCase("") &&
                // !txtFieldYear.getText().equalsIgnoreCase("")) {
                // int monthEntered = Integer.parseInt(txtFieldMonth.getText());
                // int yearEntered = Integer.parseInt(txtFieldYear.getText());
                // if (monthEntered > 0 && monthEntered <= 12 && yearEntered >=
                // -1000000 && yearEntered <= 1000000) {
                // calendrier.month = monthEntered;
                // calendrier.year = yearEntered;
                // calendrier.resetTemp();
                // calendrier.defineStart();
                // calendrier.mergeWithTemp();
                // draw();
                // } else {
                // txtFieldMonth.setText("Mois ?");
                // txtFieldYear.setText("Année ?");
                // }
                // }

                try {

                    verifyForm();
                    calendrier.month = monthEntered;
                    calendrier.year = yearEntered;
                    calendrier.resetTemp();
                    calendrier.defineStart();
                    calendrier.fillDaysOfTheMonthArrayList();
                    calendrier.mergeWithTemp();
                    draw();
                } catch ( NumberFormatException e1 ) { // si on rentre autre
                                                       // chose que des nombres
                    txtFieldMonth.setText( "Entrez un chiffre" );
                } catch ( WrongDateException e2 ) { // si le mois est inférieur
                                                    // ou supérieur à 12
                    txtFieldMonth.setText( e2.getMsg() );
                }

            }

            private void verifyForm() throws WrongDateException {

                // On vérifie le txtFieldMonth
                // On commence par vérifier si c'est un chiffre
                // Comme verifyForm() throws NumberFormatException, si le
                // programme se plante
                // ici, il récupérera l'Exception dans le catch de la méthode
                // appelante
                // C'est pour ça qu'il n'y a pas de catch ici, mais un throw à
                // la place

                monthEntered = Integer.parseInt( txtFieldMonth.getText() );

                // Puis on vérifie si ce chiffre est bien compris entre 1 et 12
                // inclus
                // Si ce n'est pas le cas, on crée une nouvelle Exception avec
                // un msg en
                // parmètre
                // cet objet Exception est renvoyé à la méthode appelante du
                // verifyForm()

                if ( monthEntered < 1 ) {
                    throw new WrongDateException( "trop petit" );
                } else if ( monthEntered > 12 ) {
                    throw new WrongDateException( "trop grand" );
                }

                // Maintenant on vérifie le txtFieldYear
                // Pareil, si le programme se plante il throw
                // NumberFormatException à la méthode
                // appelante
                yearEntered = Integer.parseInt( txtFieldYear.getText() );
            }

        } );

        panelFooter.add( buttonAfficher );

    }
}
