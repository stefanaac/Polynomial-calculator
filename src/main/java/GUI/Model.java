package GUI;

import dataModels.Operations;
import dataModels.Polynomial;

import java.util.ArrayList;

public class Model {
    private Polynomial calculationAddValue;
    private Polynomial calculationSubValue;
    private Polynomial calculationMulValue;
    private ArrayList<Polynomial> calculateDivValue;
    private Polynomial calculateDerivValue;
    private Polynomial calculateIntegrValue;


    public void addTwoPoly(Polynomial first, Polynomial second){

        Operations op=new Operations();
        calculationAddValue = op.addition(first,second);

    }

    public void subTwoPoly(Polynomial first, Polynomial second){
        Operations op=new Operations();
        calculationSubValue = op.subtraction(first,second);

    }

    public void mulTwoPoly(Polynomial first, Polynomial second){
        Operations op=new Operations();
        calculationMulValue = op.multiply(first,second);

    }

    public void divTwoPoly(Polynomial first, Polynomial second){
        Operations op=new Operations();
        calculateDivValue = op.division(first,second);

    }

    public void derivPoly(Polynomial pol){
        Operations op=new Operations();
        calculateDerivValue = op.derivate(pol);

    }

    public void integrPoly(Polynomial pol){
        Operations op=new Operations();
        calculateIntegrValue = op.integrate(pol);

    }

    public Polynomial getCalculationAddValue() {
        return calculationAddValue;
    }

    public Polynomial getCalculationSubValue() {
        return calculationSubValue;
    }

    public Polynomial getCalculationMulValue() {
        return calculationMulValue;
    }

    public ArrayList<Polynomial> getCalculateDivValue() {
        return calculateDivValue;
    }

    public Polynomial getCalculateDerivValue() {
        return calculateDerivValue;
    }

    public Polynomial getCalculateIntegrValue() {
        return calculateIntegrValue;
    }
}
