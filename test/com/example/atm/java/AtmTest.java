package com.example.atm.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtmTest {
    @Test
    public  void testBalance(){
        Atm machine = new Atm(0,0,0);
        float result = machine.add(20, 30);
        assertEquals(50, result);
    }

    @Test
    public void testDeposit(){
        Atm machine = new Atm(0,0,0);
        float result = machine.deposit( 0, 20000, 40000, 150000);
        assertEquals(20000, result);

    }

    @Test
    public  void testWithdrwal(){
        Atm machine = new Atm(0,0,0);

        float result = machine.withdraw( 20000, 20000, 20000, 50000);
        assertEquals(40000, result);
    };

}
