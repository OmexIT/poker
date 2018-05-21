package com.omexit.poker;

import junit.framework.TestCase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestHand extends TestCase {
    Method getBestPokerHand;
    private String fiveOfKind, straightFlush, fourOfKind, fullHouse, flush, straight,
            threeOfKind,onePair,twoPair, highCard;


    protected void setUp() throws NoSuchMethodException {
        getBestPokerHand = Hand.class.getDeclaredMethod("getBestPokerHand");
        getBestPokerHand.setAccessible(true);
        onePair = "10S, 10H, 8S, 7H, 4C";
        twoPair = "AS, 10C, 10H, 3D, 3S";
        fiveOfKind = "AS, AC, AH, AD, J";
        straightFlush = "JC, 10C, 9C, 8C, 7C";
        fourOfKind = "5C, 5D, 5H, 5S, 2D";
        fullHouse = "6S, 6H, 6D, KC, KH";
        flush = "JD, 9D, 8D, 4D, 3D";
        straight = "10D, 9S, 8H, 7D, 6C";
        threeOfKind = "QC, QS, QH, 9H, 2S";
        highCard = "KD, QD, 7S, 4S, 3H";
    }

    public void testFiveOfKind() throws InvocationTargetException,
            IllegalAccessException {
        Hand hand = Util.getHand(fiveOfKind);
        String output = (String) getBestPokerHand.invoke(hand);
        assertEquals("Five of a kind", output);
    }

    public void testTwoPair() throws InvocationTargetException,
            IllegalAccessException {
        Hand hand = Util.getHand(twoPair);
        String output = (String) getBestPokerHand.invoke(hand);
        assertEquals("Two pair", output);
    }

    public void testOnePair() throws InvocationTargetException,
            IllegalAccessException {
        Hand hand = Util.getHand(onePair);
        String output = (String) getBestPokerHand.invoke(hand);
        assertEquals("One pair", output);
    }

    public void testStraightFlush() throws InvocationTargetException,
            IllegalAccessException {
        Hand hand = Util.getHand(straightFlush);
        String output = (String) getBestPokerHand.invoke(hand);
        assertEquals("Straight flush", output);
    }

    public void testFourofKind() throws InvocationTargetException,
            IllegalAccessException {
        Hand hand = Util.getHand(fourOfKind);
        String output = (String) getBestPokerHand.invoke(hand);
        assertEquals("Four of a kind", output);
    }

    public void testFullHouse() throws InvocationTargetException,
            IllegalAccessException {
        Hand hand = Util.getHand(fullHouse);
        String output = (String) getBestPokerHand.invoke(hand);
        assertEquals("Full house", output);
    }

    public void testFlush() throws InvocationTargetException,
            IllegalAccessException {
        Hand hand = Util.getHand(flush);
        String output = (String) getBestPokerHand.invoke(hand);
        assertEquals("Flush", output);
    }

    public void testStraight() throws InvocationTargetException,
            IllegalAccessException {
        Hand hand = Util.getHand(straight);
        String output = (String) getBestPokerHand.invoke(hand);
        assertEquals("Straight", output);
    }

    public void testThreeOfKind() throws InvocationTargetException,
            IllegalAccessException {
        Hand hand = Util.getHand(threeOfKind);
        String output = (String) getBestPokerHand.invoke(hand);
        assertEquals("Three of a kind", output);
    }

    public void testHighCard() throws InvocationTargetException,
            IllegalAccessException {
        Hand hand = Util.getHand(highCard);
        String output = (String) getBestPokerHand.invoke(hand);
        assertEquals("High card", output);
    }
}
