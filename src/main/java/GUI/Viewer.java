package GUI;



import dataModels.Polynomial;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionListener;

public class Viewer extends Component {
    JFrame frame;
    JPanel myPanel;
    JLabel pol1Label;
    JLabel pol2Label;
    JLabel title;
    JLabel result;
    JButton additionButton;
    JButton subtractionButton;
    JButton multiplyButton;
    JButton divisionButton;
    JButton derivativeButton;
    JButton integrationButton;
    JButton clear;
    private JTextField firstTextfield;
    private JTextField secondTextfield;
    private JLabel resultLabel;
    private JLabel remainderLabel;
    public Viewer() {

        frame = new JFrame("Polynomial Calculator");
        myPanel=new JPanel();
        myPanel.setBackground(Color.BLACK);
        myPanel.setBounds(0,0,500,620);
        myPanel.setLayout(null);
        Border border2=BorderFactory.createLineBorder(new Color(255, 158, 102),5);
        Border border=BorderFactory.createLineBorder(new Color(255, 158, 102),20);
        myPanel.setBorder(border);

        resultLabel=new JLabel();
        //resultLabel.setText("aici");
        resultLabel.setFont(new Font("MV Boly",Font.ITALIC,20));
        resultLabel.setBounds(25,455,250,70);
        resultLabel.setForeground(Color.WHITE);

        myPanel.add(resultLabel);


        remainderLabel=new JLabel();
        //resultLabel.setText("aici");
        remainderLabel.setFont(new Font("MV Boly",Font.ITALIC,20));
        remainderLabel.setBounds(25,525,250,70);
        remainderLabel.setForeground(Color.WHITE);

        myPanel.add(remainderLabel);



        title=new JLabel("POLYNOMIAL");
        title.setBounds(120,20,200,70);
        title.setFont(new Font("Monospaced",Font.BOLD,30));
        title.setForeground(Color.GRAY);
        myPanel.add(title);

        JLabel title2=new JLabel("C A L C U L A T O R");
        title2.setBounds(50,70,400,70);
        title2.setFont(new Font("Monospaced",Font.BOLD,30));
        title2.setForeground(Color.GRAY);
        myPanel.add(title2);

        JLabel calc=new JLabel("\uD83D\uDDA9");
        calc.setBounds(330,0,400,100);
        calc.setFont(new Font("Monospaced",Font.PLAIN,100));
        calc.setForeground(new Color(255, 158, 102));
        myPanel.add(calc);


        pol1Label=new JLabel("Type here a polynom:");
        pol1Label.setBounds(25,170,400,70);
        pol1Label.setFont(new Font("Monospaced",Font.BOLD,20));
        pol1Label.setForeground(Color.GRAY);
        myPanel.add(pol1Label);

        firstTextfield=new JTextField();
        firstTextfield.setBounds(25,225,300,50);
        firstTextfield.setFont(new Font("MV Boly",Font.PLAIN,20));
        firstTextfield.setBackground(Color.GRAY);
        firstTextfield.setForeground(Color.WHITE);
        firstTextfield.setBorder(border2);
        myPanel.add(firstTextfield);


        secondTextfield=new JTextField();
        secondTextfield.setBounds(25,375,300,50);
        secondTextfield.setFont(new Font("MV Boly",Font.PLAIN,20));
        secondTextfield.setForeground(Color.WHITE);
        secondTextfield.setBackground(Color.GRAY);
        secondTextfield.setBorder(border2);
        myPanel.add(secondTextfield);




        pol2Label=new JLabel("Type another polynom:");
        pol2Label.setBounds(25,325,400,70);
        pol2Label.setFont(new Font("Monospaced",Font.BOLD,20));
        pol2Label.setForeground(Color.GRAY);
        myPanel.add(pol2Label);



        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(515, 657);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.add(myPanel);
        frame.setVisible(true);








        additionButton=new JButton("\u2795");
        additionButton.setBounds(350,175,120,25);
        additionButton.setBackground(new Color(255, 158, 102));
        additionButton.setFont(new Font("MV Boly",Font.BOLD,20));
        additionButton.setForeground(Color.DARK_GRAY);
        additionButton.setFocusable(false);


        myPanel.add(additionButton);
        subtractionButton=new JButton("\u2796");
        subtractionButton.setBounds(350,225,120,25);
        subtractionButton.setFont(new Font("MV Boly",Font.BOLD,20));
        subtractionButton.setBackground(new Color(255, 158, 102));
        subtractionButton.setFocusable(false);
        subtractionButton.setForeground(Color.DARK_GRAY);
        myPanel.add(subtractionButton);

        multiplyButton=new JButton("x");
        multiplyButton.setBounds(350,275,120,25);
        multiplyButton.setBackground(new Color(255, 158, 102));
        multiplyButton.setFont(new Font("MV Boly",Font.BOLD,20));
        multiplyButton.setFocusable(false);
        multiplyButton.setForeground(Color.DARK_GRAY);
        myPanel.add(multiplyButton);
        divisionButton=new JButton("\u2797");
        divisionButton.setBounds(350,325,120,25);
        divisionButton.setBackground(new Color(255, 158, 102));
        divisionButton.setFont(new Font("MV Boly",Font.BOLD,20));
        divisionButton.setFocusable(false);
        divisionButton.setForeground(Color.DARK_GRAY);
        myPanel.add(divisionButton);
        derivativeButton=new JButton("\u2202");
        derivativeButton.setBounds(350,375,55,130);
        derivativeButton.setBackground(new Color(255, 158, 102));
        derivativeButton.setFont(new Font("Arial",Font.BOLD,35));
        derivativeButton.setFocusable(false);
        derivativeButton.setForeground(Color.DARK_GRAY);
        myPanel.add(derivativeButton);
        integrationButton=new JButton(	"\u222B");
        integrationButton.setBounds(420,375,55,130);
        integrationButton.setBackground(new Color(255, 158, 102));
        integrationButton.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        integrationButton.setFocusable(false);
        integrationButton.setForeground(Color.DARK_GRAY);

        myPanel.add(integrationButton);

        result=new JLabel("\u23CE");
        result.setBounds(275,455,70,70);
        result.setFont(new Font("MV Boly",Font.BOLD,70));
        result.setForeground(Color.WHITE);
        myPanel.add(result);

        clear=new JButton("\u232B");
        clear.setBounds(350,525,120,40);
        clear.setBackground(new Color(255, 158, 102));
        clear.setFont(new Font("MV Boly",Font.BOLD,30));
        clear.setFocusable(false);
        clear.setForeground(Color.DARK_GRAY);
        myPanel.add(clear);

    }

    //metoda care ia din al doilea textField si transforma stringul in polinom --pt pol1
    public Polynomial getFirstPoly(){

        String p1=firstTextfield.getText();
        Polynomial pol1=new Polynomial();
        pol1=pol1.toPoly(p1);
        System.out.println("Primul polinom");
        pol1.printPoly();
        //pol1.toString();
        return pol1;


    }


    //metoda care ia din al doilea textField si transforma stringul in polinom --pt pol2
    public Polynomial getSecondPoly(){

        String p2=secondTextfield.getText();
        Polynomial pol2=new Polynomial();
        pol2=pol2.toPoly(p2);
        System.out.println("Al doilea polinom");
        pol2.printPoly();
        return pol2;

    }


    //daca un anumit buton este apasat se executa metoda  "actionPerformed " in clasa Controller
    void addCalculateListener(ActionListener listenForCalcButton){

        additionButton.addActionListener(listenForCalcButton);

    }

    void subCalculateListener(ActionListener listenForCalcButton){

        subtractionButton.addActionListener(listenForCalcButton);

    }

    void multiplyCalculateListener(ActionListener listenForCalcButton){
        multiplyButton.addActionListener(listenForCalcButton);

    }

    void divisionCalculateListener(ActionListener listenForCalcButton){

        divisionButton.addActionListener(listenForCalcButton);

    }

    void derivationCalculateListener(ActionListener listenForCalcButton){

        derivativeButton.addActionListener(listenForCalcButton);

    }


    void integrationCalculateListener(ActionListener listenForCalcButton){

        integrationButton.addActionListener(listenForCalcButton);

    }

    void clearListener(ActionListener listenForClearButton)
    {
        clear.addActionListener(listenForClearButton);
    }

    public void setCalcSolution(Polynomial solution){


        String s="P(X)="+solution.toString();
        resultLabel.setText(s);


    }

    public void setCalcSolution2(Polynomial solution){

        String s="P(X)="+solution.toStringDouble();
        resultLabel.setText(s);


    }

    public void setCalcSolution3(Polynomial solution,Polynomial rest)
    {
        String s="Q(X)="+solution.toString();
        resultLabel.setText(s);

        String ss="R(X)="+rest.toString();
       remainderLabel.setText(ss);

    }

}
