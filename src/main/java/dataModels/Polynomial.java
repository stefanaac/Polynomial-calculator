package dataModels;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    int degree; //gradul intregului polinom
    List<Monomial> elements; //lista de monoame
    //constructor
    public Polynomial() { this.elements = new ArrayList<>(); }
    //getteri si setteri
    public int getDegree() {
        return degree;
    }
    public void setDegree(int degree) {
        this.degree = degree;
    }
    public List<Monomial> getElements() {
        return elements;
    }
    public void setElements(List<Monomial> elements) {
        this.elements = elements;
    }

    //metoda care adauga un monom la lista de monome
    public void addMonomToPoly(Monomial monom)
    {
        this.elements.add(monom);
    }

    //metoda care afiseaza un polinom sub forma P(X)=
    public String printPoly()
    {
        String result="P(X)=";
        String strNew="";
        for (Monomial el:this.elements
        ) {
            result=result+el+"+";
        }
        if (result.charAt(result.length()-1) == '+')
        {
            strNew = result.substring(0, result.length()-1);
        }
        System.out.println(strNew);
        if(result=="")
        {
            System.out.println("CEAU");
        }
        return strNew;
    }

    //functie care sorteaza un polinom si il reduce
    //de ex daca P(X)=x^3+4x^3, dupa ce o apelam pentru P P(X)=5x^3
    public void reduceIntegerPolynom()
    {
        for(int i=0;i<this.elements.size();i++) {
            int putere =this.elements.get(i).getPow();
            for(int j=i+1;j<this.elements.size();j++) {
                int temp_putere = this.elements.get(j).getPow();
                if(putere == temp_putere) {
                    ((IntMonomial)elements.get(i)).addMonomCoef(((IntMonomial)elements.get(j)).getCoefficient());
                    this.elements.remove(j);
                }
            }
        }
        //folosesc clasa Collections pt a sorta polinomul in functie de putere
        Collections.sort(this.elements, IntMonomial.compareExponentsIntCoeff().reversed());
    }

    //este la fel ca metoda reduceIntegerPolynom doar ca pentru monoame cu coeficienti reali
    public void reduceDoublePolynom()
    {
        for(int i=0;i<this.elements.size();i++) {
            int putere =this.elements.get(i).getPow();
            for(int j=i+1;j<this.elements.size();j++) {
                int temp_putere = this.elements.get(j).getPow();
                if(putere == temp_putere) {
                    ((DoubleMonomial)elements.get(i)).addMonomCoef(((DoubleMonomial)elements.get(j)).getCoefficient());
                    this.elements.remove(j);
                }
            }
        }
        //folosesc clasa Collections pt a sorta polinomul in functie de putere
        Collections.sort(this.elements,DoubleMonomial.compareExponentsDoubleCoeff().reversed());
    }

    //metoda care afla monomul cu puterea maxima
    public IntMonomial maxMonom()
    {
        int max=0;
        IntMonomial maxx=new IntMonomial(0,0);
        for (Monomial m:this.elements) {
            if(m.getPow()>max && ((IntMonomial)m).getCoefficient()!=0)
            {
                max=m.getPow();
                maxx=(IntMonomial)m;
            }

        }
        return maxx;

    }

    //metoda pe are o folosesc la impartirea polinoamelor si care verifica daca polinomul este gol
    public boolean isEmpty()
    {
        for(Monomial m:this.elements)
        {
            if(((IntMonomial)m).getCoefficient()!=0)
            {
                return false;
            }
        }
        return true;

    }

    //este aceeasi metoda ca cea precedenta doar pentru polinom cu coef reali
    public boolean isEmptyDouble()
    {
        for(Monomial m:this.elements)
        {
            if(((DoubleMonomial)m).getCoefficient()!=0)
            {
                return false;
            }
        }
        return true;

    }

    //afla cea mai mare putere din polinom
    public int maxPow() {
        int max = 0;
        for( Monomial m : this.elements) {
            if (m.getPow() > max &&  ((IntMonomial) m).getCoefficient() != 0) {
                max = m.getPow();
            }
        }
        return max;
    }


    //afla cea mai mare putere din polinom cu coef reali
    public int maxPowDouble() {
        int max = 0;
        for( Monomial m : this.elements) {
            if (m.getPow() > max &&  ((DoubleMonomial) m).getCoefficient() != 0) {
                max = m.getPow();
            }
        }
        return max;
    }

    //inmulteste fiecrae termen cu monomul dat ca parametru
    public void mulMonom(IntMonomial m1) {

        for(Monomial m : this.elements) {
            ((IntMonomial) m).setCoefficient(((IntMonomial) m).getCoefficient() * m1.getCoefficient());
            m.setPow(m.getPow() + m1.getPow());
        }
    }


    //metoda care returneaza un string(transforma un polinom intr-un sir)
    public String toString() {
        String coef, power;
        String result ="";
        if (this.isEmpty()) {
            result = result.concat("0x^0");  // daca polinomul e gol returneaza 0x^0
        }else {
            for( Monomial m : this.elements) {
                coef =Integer.toString(((IntMonomial)m).getCoefficient());
                power = Integer.toString(m.getPow());
                if( ((IntMonomial) m).getCoefficient() < 0 ) {
                    result = result.concat(coef + "X^" + power + " ");
                }
                else {
                    if (((IntMonomial) m).getCoefficient() != 0) {
                        if( m.getPow() == this.maxPow()) {
                            result = result.concat(coef + "X^" + power + " ");
                        }
                        else {
                            result = result.concat("+" + " " + coef + "X^" + power + " ");
                        }
                    }
                }
            }
        }
        return result;
    }

    //metoda care returneaza un string(transforma un polinom intr-un sir) pt pol cu coef double
    public String toStringDouble() {
        String coef, power;
        String result ="";
        if (this.isEmptyDouble()) {
            result = result.concat("0x^0");  // daca polinomul e gol returneaza 0x^0
        }else {
            for( Monomial m : this.elements) {
                coef =Double.toString(((DoubleMonomial)m).getCoefficient());
                power = Integer.toString(m.getPow());
                if( ((DoubleMonomial) m).getCoefficient() < 0 ) {
                    result = result.concat(coef + "X^" + power + " ");
                }
                else {
                    if (((DoubleMonomial) m).getCoefficient() != 0) {
                        if( m.getPow() == this.maxPowDouble()) {
                            result = result.concat(coef + "X^" + power + " ");
                        }
                        else {
                            result = result.concat("+" + " " + coef + "X^" + power + " ");
                        }
                    }
                }
            }
        }
        return result;
    }


    //metoda care transforma un String intr-un polinom
    public Polynomial toPoly(String s)
    {
        Polynomial resultingPoly=new Polynomial();
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(s);
        ArrayList<String> monoms = new ArrayList<String>();

        if(monoms.size()==1)
        {
            IntMonomial m=new IntMonomial(0,0);
            m.setCoefficient(Integer.parseInt(s));
            m.setPow(0);
        }
        else
        {
            while(matcher.find())
            {
                monoms.add(matcher.group(1));
                String mon=matcher.group(1);
                int index=mon.indexOf("X");
                System.out.println("Index "+index+ ": ");
                System.out.println(index);
                if (index!=-1)
                {
                    int index2=mon.indexOf("^");
                    if(index2!=-1)
                    {
                        IntMonomial m=new IntMonomial(0,0);
                        String coef=mon.substring(0,index);
                        System.out.println(coef);
                        String pow=mon.substring(index2+1,mon.length());
                        System.out.println(pow);
                        m.setCoefficient(Integer.parseInt(coef));
                        m.setPow(Integer.parseInt(pow));
                        resultingPoly.addMonomToPoly(m);
                    }
                    else
                    {
                        IntMonomial m=new IntMonomial(0,0);
                        String coef=mon.substring(0,index);
                        m.setCoefficient(Integer.parseInt(coef));
                        m.setPow(1);
                        resultingPoly.addMonomToPoly(m);
                    }

                }
                else
                {
                    IntMonomial m=new IntMonomial(0,0);
                    String coef=mon.substring(0,mon.length());
                    m.setCoefficient(Integer.parseInt(coef));
                    m.setPow(0);
                    resultingPoly.addMonomToPoly(m);
                }
            }
        }
        resultingPoly.reduceIntegerPolynom();
        return resultingPoly;

    }

}
