package dataModels;

import java.util.Comparator;

//IntMonomial este o clasa care o folosesc atat la polinomii introdusi de care utilizator cat si la operatiile de adunare,scadere,derivare
//si la orice alta metoda care nu foloseste monoeme cu coef reali
public class IntMonomial extends Monomial{
    private int  coefficient; //coeficientul monomului

    //constructor
    public IntMonomial(int coefficient, int pow) {
        this.coefficient = coefficient;
        this.pow = pow;
    }

    // constructor pt un monom
    public IntMonomial(int coefficient) {
        this.coefficient = coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public void addMonomCoef(int coefInt) {
        this.coefficient += coefInt;
    }

    public int getCoefficient() {
        return coefficient;
    }

    //metoda pe care o folosesc pentru compararea a doua monoame cu coeficienti intregi in functie de putere
    public static Comparator<Monomial> compareExponentsIntCoeff() {
        Comparator<Monomial> comp = new Comparator<Monomial>(){
            @Override
            public int compare(Monomial monomial1, Monomial monomial2) {
                return Integer.compare(monomial1.getPow(), monomial2.getPow());
            }
        };
        return comp;
    }

    //metoda toString suprasrisa care ajuta la afisraea monoamelor
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.coefficient + "X^" + this.pow);
        return sb.toString();
    }



}
