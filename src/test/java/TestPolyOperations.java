import dataModels.Operations;
import dataModels.Polynomial;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class TestPolyOperations {
    @Test
    public void testAddition() {
        Operations op=new Operations();
        Polynomial operand1 = new Polynomial();
        operand1=operand1.toPoly("2X^3");
        Polynomial operand2 = new Polynomial();
        operand2=operand2.toPoly("5X^1");
        Polynomial resultAddition = op.addition(operand1, operand2);
        assertEquals("2X^3 + 5X^1 ",resultAddition.toString());
    }

    @Test
    public void testSubtraction() {
        Operations op=new Operations();
        Polynomial operand1 = new Polynomial();
        operand1=operand1.toPoly("2X^3");
        Polynomial operand2 = new Polynomial();
        operand2=operand2.toPoly("5X^1");
        Polynomial resultSubtraction = op.subtraction(operand1, operand2);
        assertEquals("2X^3 -5X^1 ",resultSubtraction.toString());

    }



    @Test
    public void testMultiplication() {
        Operations op=new Operations();
        Polynomial operand1 = new Polynomial();
        operand1=operand1.toPoly("2X^3");
        Polynomial operand2 = new Polynomial();
        operand2=operand2.toPoly("5X^1");
        Polynomial resultMultiplication = op.multiply(operand1, operand2);
        assertEquals("10X^4 ",resultMultiplication.toString());

    }

    @Test
    public void testDivision() {
        Operations op=new Operations();
        Polynomial operand1 = new Polynomial();
        operand1=operand1.toPoly("6X^3+3X^1");
        Polynomial operand2 = new Polynomial();
        operand2=operand2.toPoly("2X^3+1X^0");
        ArrayList<Polynomial> resultDivision = op.division(operand1, operand2);
        assertEquals("3X^0 ",resultDivision.get(0).toString());
        assertEquals("3X^1 -3X^0 ",resultDivision.get(1).toString());

    }


    @Test
    public void testDerivation() {
        Operations op=new Operations();
        Polynomial operand = new Polynomial();
        operand=operand.toPoly("2X^3");
        Polynomial resultDerivation = op.derivate(operand);
        assertEquals("6X^2 ",resultDerivation.toString());

    }


    @Test
    public void testIntegration() {
        Operations op=new Operations();
        Polynomial operand = new Polynomial();
        operand=operand.toPoly("5X^2");
        Polynomial resultIntegration = op.integrate(operand);
        assertEquals("2.5X^3 ",resultIntegration.toStringDouble());

    }


}
