package com.example.atm.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtmTest {
    @Test
    public  void testBalance(){
        Atm machine = new Atm(0,0,0);
    }

    @Test
    public void testDeposit(){
        Atm machine = new Atm(0,0,0);

        float result = machine.deposit( 20000, 20000);
        assertEquals(40000, result);

    }

}
