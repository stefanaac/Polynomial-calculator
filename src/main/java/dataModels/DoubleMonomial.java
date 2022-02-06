package dataModels;

import java.util.Comparator;
// DoubleMonomial este o clasa care o folosesc pentru rezultat al operatii de integrare sau in orice alta metoda care foloseste
// monoame cu coeficienti reali
public class DoubleMonomial extends Monomial{
    private double coefficient; //coeficientul monomului

    //constructori
    public DoubleMonomial(double coefficient, int pow) {
        this.coefficient = coefficient;
        this.pow = pow;
    }
    public DoubleMonomial(double coefficient) {
        this.coefficient = coefficient;
    }

    //getter si setter
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    public double getCoefficient() {
        return coefficient;
    }


    //metoda care adauga la coeficientul monomului
    public void addMonomCoef(double coefDouble) {
        this.coefficient += coefDouble;
    }

    //metoda pe care o folosesc pentru compararea a doua monoame cu coeficienti reali in functie de putere
    public static Comparator<Monomial> compareExponentsDoubleCoeff() {
        Comparator<Monomial> comp = new Comparator<Monomial>(){
            @Override
            public int compare(Monomial monomial1, Monomial monomial2) {
                return Double.compare(monomial1.getPow(), monomial2.getPow());
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
