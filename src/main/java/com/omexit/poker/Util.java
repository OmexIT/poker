package com.omexit.poker;

public class Util {
    public static Hand getHand(String input) {
        String[] strCards = input.split(",");
        Hand hand = new Hand();

        for (String strCard : strCards) {
            Card card = null;
            strCard = strCard.trim();
            if (strCard.length() == 1 && strCard.equalsIgnoreCase("j")) {
                strCard = " " + strCard;
            }
            if (strCard.length() < 2 || strCard.length() > 3) {
                throw new IllegalArgumentException("Invalid input: " + strCard);
            } else {
                // Suit is always the last one character
                String suit = strCard.substring(strCard.length() - 1).toLowerCase();
                String rank = removeLastChar(strCard).toLowerCase();
                card = new Card(rank, suit);
                hand.addCard(card);
            }
        }
        return hand;
    }

    private static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }
}
