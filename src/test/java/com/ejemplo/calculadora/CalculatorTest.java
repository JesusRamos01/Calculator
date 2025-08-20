package com.ejemplo.calculadora;
import com.ejemplo.core.CalculatorService;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.Assert.assertEquals;




public class CalculatorTest {

    private final CalculatorService cs = new CalculatorService();

    @Test
    public void testSumar() {
        assertEquals(5.0, cs.sumar(2.0, 3.0), 0.0001);
        assertEquals(-1.0, cs.sumar(-2.0, 1.0), 0.0001);
    }

    @Test
    public void testRestar() {
        assertEquals(1.0, cs.restar(3.0, 2.0), 0.0001);
        assertEquals(-3.0, cs.restar(-2.0, 1.0), 0.0001);
    }

    @Test
    public void testMultiplicar() {
        assertEquals(6.0, cs.multiplicar(2.0, 3.0), 0.0001);
        assertEquals(-2.0, cs.multiplicar(-2.0, 1.0), 0.0001);
    }

    @Test
    public void testDividir() {
        assertEquals(2.0, cs.dividir(6.0, 3.0), 0.0001);
        assertEquals(-2.0, cs.dividir(-4.0, 2.0), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDividirPorCero() {
        cs.dividir(5.0, 0.0);
    }
}
