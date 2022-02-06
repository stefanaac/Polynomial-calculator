package dataModels;



import java.awt.*;
import java.util.ArrayList;

public class Operations {
    public Polynomial addition(Polynomial p1,Polynomial p2)
    {
        Polynomial additionResult=new Polynomial();//aci retin rezultatul final
        p1.reduceIntegerPolynom();
        p2.reduceIntegerPolynom();
        //parcurg polinoamele de adunat si adun monoamele cu aceeasi putere
        for (Monomial monomial1:p1.getElements()) {
            for (Monomial monomial2:p2.getElements()) {
                //verific daca X are aceeasi putere
                if(monomial1.getPow()==monomial2.getPow())
                {
                    if((monomial1.getOp()==0) && (monomial2.getOp()==0))
                    {
                        int coefRez=(((IntMonomial)monomial1).getCoefficient())+(((IntMonomial)monomial2).getCoefficient());
                        monomial1.setOp(1);
                        monomial2.setOp(1);
                        IntMonomial monomAddition=new IntMonomial(coefRez,monomial2.getPow());
                        additionResult.addMonomToPoly(monomAddition);
                    }
                }
            }
        }
        //parcurg polinoamele de adunat si adun monomele cu puterea care se afla doar in primul/al doilea polinom
        for (Monomial monomial1:p1.getElements()) {
            if (monomial1.getOp()==0) { additionResult.addMonomToPoly(monomial1); }
        }
        for (Monomial monomial2:p2.getElements()) {
            if (monomial2.getOp()==0) { additionResult.addMonomToPoly(monomial2); }
        }
        additionResult.reduceIntegerPolynom();
        return additionResult;
    }

    //in mare parte se face ca si adunarea, numai ca scadem coeficinetii
    //daca in cel de-al 2-lea polinoam exista monoame cu exponenti care nu se afla in celalt polinom,il trecem cu -
    public Polynomial subtraction(Polynomial p1,Polynomial p2)
    {
        Polynomial subtractionResult=new Polynomial();//aici retin rezultatul final
        p1.reduceIntegerPolynom();
        p2.reduceIntegerPolynom();
        for (Monomial monomial1:p1.getElements()) {
            for (Monomial monomial2:p2.getElements()) {
                //verific daca X are aceeasi putere
                if(monomial1.getPow()==monomial2.getPow())
                {
                    //scad coef si marchez monoamele ca folosite la scadere
                    int coefRez=(((IntMonomial)monomial1).getCoefficient())-(((IntMonomial)monomial2).getCoefficient());
                    monomial1.setOp(1);
                    monomial2.setOp(1);
                    IntMonomial monomSubtraction=new IntMonomial(coefRez,monomial2.getPow());
                    subtractionResult.addMonomToPoly(monomSubtraction);
                }
            }
        }
        //parcurg polinoamele de adunat si adun monomele cu puterea care se afla doar in primul/al doilea polinom
        for (Monomial monomial1:p1.getElements()) {
            if (monomial1.getOp()==0) { subtractionResult.addMonomToPoly(monomial1); }
        }
        for (Monomial monomial2:p2.getElements()) {
            if (monomial2.getOp()==0) {
                int aux=-(((IntMonomial)monomial2).getCoefficient());
                ((IntMonomial)monomial2).setCoefficient(aux);
                subtractionResult.addMonomToPoly(monomial2); }
        }
        subtractionResult.reduceIntegerPolynom();
        return subtractionResult;
    }
    public Polynomial multiply(Polynomial p1,Polynomial p2){
        Polynomial multiplicationResult=new Polynomial();//aici retin rezultatul final
        p1.reduceIntegerPolynom();
        p2.reduceIntegerPolynom();
        for (Monomial monomial1:p1.getElements()) {
            for (Monomial monomial2:p2.getElements()) {
                int coefRez=(((IntMonomial)monomial1).getCoefficient())*(((IntMonomial)monomial2).getCoefficient());
                int expRez=(((IntMonomial)monomial1).getPow())+(((IntMonomial)monomial2).getPow());
                IntMonomial monomMultiplication=new IntMonomial(coefRez,expRez);
                multiplicationResult.addMonomToPoly(monomMultiplication);
                multiplicationResult.reduceIntegerPolynom();
            }
        }
        return multiplicationResult;
    }

    public static Polynomial copyPoly(Polynomial p) {
        Polynomial result = new Polynomial();
        for (Monomial m : p.elements) {
            IntMonomial m1 = new IntMonomial(((IntMonomial) m).getCoefficient(),m.getPow() );
            result.elements.add(m1); // copiaza fiecare termen a lui p in result
        }
        return result;
    }

    
    public ArrayList<Polynomial> division(Polynomial polynom1,Polynomial polynom2) {
        Polynomial result = new Polynomial();
        Polynomial remainder = new Polynomial();
        IntMonomial m0 = new IntMonomial(0,0);
        result.elements.add(m0); //catul e initial 0
        remainder = copyPoly(polynom1); // // restul e egal initial cu deimpartitul
        IntMonomial mRest = remainder.maxMonom(); // monomul cu gradul maxim din remainder
        IntMonomial mP2 = polynom2.maxMonom(); // monomul cu gradul maxim din polynom2
        Operations op=new Operations();
        while( !remainder.isEmpty() && mRest.getPow() >= mP2.getPow()) {
            int coef=((IntMonomial) mRest).getCoefficient() /((IntMonomial) mP2).getCoefficient();
            int exp=mRest.getPow() - mP2.getPow();
            Polynomial aux = copyPoly(polynom2);
            IntMonomial m1 = new IntMonomial(coef,exp);
            result.addMonomToPoly(m1);
            aux.mulMonom(m1);
            remainder = subtraction(remainder,aux );
            mRest = remainder.maxMonom();
        }
        ArrayList<Polynomial> poly =new ArrayList<>();
        poly.add(result);
        poly.add(remainder);
        return poly;

    }


    public Polynomial derivate(Polynomial p){
        Polynomial derivateResult=new Polynomial();//aici retin rezultatul final
        for (Monomial monomial:p.getElements()) {
            int newCoef=((IntMonomial)monomial).getCoefficient()*monomial.getPow();
            int newExp=(monomial.getPow())-1;
            IntMonomial monom=new IntMonomial(newCoef,newExp);
            derivateResult.addMonomToPoly(monom);
        }
        return derivateResult;
    }

    public Polynomial integrate(Polynomial p){
        Polynomial integralResult=new Polynomial();//aici retin rezultatul final
        for (Monomial monomial:p.getElements()) {
            double newCoef=((IntMonomial)monomial).getCoefficient()/(monomial.getPow()*1.00);
            int newExp=(monomial.getPow())+1;
            DoubleMonomial monom=new DoubleMonomial(newCoef,newExp);
            integralResult.addMonomToPoly(monom);
        }
        return integralResult;
    }
}
