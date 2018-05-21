package com.omexit.poker;

import junit.framework.TestCase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestUtil extends TestCase {

    private String input;

    protected void setUp() throws NoSuchMethodException {
        input = "AS, 10C, 10H, 3D, 3S";
    }

    public void testGetHand() {
        Hand output = Util.getHand(input);

        Hand expectedOuput = new Hand();
        Card card =new Card("a","s");
        expectedOuput.addCard(card);

        card =new Card("10","c");
        expectedOuput.addCard(card);

        card =new Card("10","h");
        expectedOuput.addCard(card);

        card =new Card("3","d");
        expectedOuput.addCard(card);

        card =new Card("3","s");
        expectedOuput.addCard(card);

        assertEquals(expectedOuput.toString(),output.toString());
    }

    public void testRemoveLastChar() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method removeLastChar = Util.class.getDeclaredMethod("removeLastChar", String.class);
        removeLastChar.setAccessible(true);
        String output = (String) removeLastChar.invoke(Util.class, "10S");
        assertEquals("10", output);
    }
}
