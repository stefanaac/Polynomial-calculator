package dataModels;

//Aceasta clasa reprezinta un monom. O s-o folosc la polinom deoarece un polinom este format din unul sau mai multe monoame.
//Am folosit-o ca si clasa parinte pentru 2 clase: IntMonomial(pt monoame cu coef intregi) si DoubleMonomial(pt monoame cu coef double).
//Am ales sa fac aceste 2 clase deoarece la integrarea a doua polinoame putem obtine coeficienti double
public class Monomial {
    int pow;
    int op; //folosesc aceasta variabila pt operatii;atunci cand trebuie sa adun/scad
    //0 -folosit 1-nefolosit
    //getteri si setteri
    public int getPow() {
        return pow;
    }
    public void setPow(int pow) {
        this.pow = pow;
    }
    public int getOp() {
        return op;
    }
    public void setOp(int op) {
        this.op = op;
    }
}
