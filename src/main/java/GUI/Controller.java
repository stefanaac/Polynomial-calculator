package GUI;

import app.MyApplication;
import dataModels.Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private Viewer theView;
    private Model theModel;

    public Controller(Viewer theView, Model theModel) {
        this.theView = theView;
        this.theModel = theModel;



        this.theView.addCalculateListener(new CalculateListener());
        this.theView.subCalculateListener(new CalculateListener2());
        this.theView.multiplyCalculateListener(new CalculateListener3());
        this.theView.derivationCalculateListener(new CalculateListener4());
        this.theView.integrationCalculateListener(new CalculateListener5());
        this.theView.divisionCalculateListener(new CalculateListener6());
        this.theView.clearListener(new ClearCalcListener());
    }
    class CalculateListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            Polynomial firstPoly=new Polynomial();
            Polynomial secondPoly=new Polynomial();
            firstPoly = theView.getFirstPoly();
            //System.out.println(firstPoly+firstPoly.printPoly());
            secondPoly = theView.getSecondPoly();
            //System.out.println(secondPoly+secondPoly.printPoly());
            theModel.addTwoPoly(firstPoly, secondPoly);
            theView.setCalcSolution(theModel.getCalculationAddValue());

        }

    }

    class CalculateListener2 implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            Polynomial firstPoly=new Polynomial();
            Polynomial secondPoly=new Polynomial();
            firstPoly = theView.getFirstPoly();
            //System.out.println(firstPoly+firstPoly.printPoly());
            secondPoly = theView.getSecondPoly();
            //System.out.println(secondPoly+secondPoly.printPoly());
            theModel.subTwoPoly(firstPoly, secondPoly);
            theView.setCalcSolution(theModel.getCalculationSubValue());

        }

    }
    class CalculateListener3 implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            Polynomial firstPoly=new Polynomial();
            Polynomial secondPoly=new Polynomial();
            firstPoly = theView.getFirstPoly();
            secondPoly = theView.getSecondPoly();
            theModel.mulTwoPoly(firstPoly,secondPoly);
            theView.setCalcSolution(theModel.getCalculationMulValue());

        }

    }


    class CalculateListener6 implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            Polynomial firstPoly=new Polynomial();
            Polynomial secondPoly=new Polynomial();
            firstPoly = theView.getFirstPoly();
            secondPoly = theView.getSecondPoly();
            theModel.divTwoPoly(firstPoly,secondPoly);
            ArrayList<Polynomial> p= theModel.getCalculateDivValue();
            theView.setCalcSolution3(p.get(0),p.get(1));

        }

    }

    class CalculateListener4 implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            Polynomial myPoly=new Polynomial();
            myPoly = theView.getFirstPoly();
            theModel.derivPoly(myPoly);
            theView.setCalcSolution(theModel.getCalculateDerivValue());

        }

    }
    class CalculateListener5 implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            Polynomial myPoly=new Polynomial();
            myPoly = theView.getFirstPoly();
            theModel.integrPoly(myPoly);
            theView.setCalcSolution2(theModel.getCalculateIntegrValue());

        }

    }

    class ClearCalcListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            theView.frame.dispose();
            theView=new Viewer();
        }

    }




}
