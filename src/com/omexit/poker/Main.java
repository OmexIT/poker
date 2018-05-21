package com.omexit.poker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("===============================================================");
            System.out.println("Enter cards on hand separated by comma and press enter e.g.:");
            System.out.println("'AS, 10C, 10H, 3D, 3S'");
            System.out.println("Enter 'q' to quit poker app");
            System.out.println("===============================================================\n");
            System.out.println("Poker Input : ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting poker!");
                exit = true;
            } else {
                String[] strCards = input.split(",");
                Hand hand = new Hand();

                for (String strCard : strCards) {
                    Card card = null;
                    strCard = strCard.trim();
                    if(strCard.length() < 2 || strCard.length() > 3){
                        throw new IllegalArgumentException("Invalid input: " + strCard);
                    } else {
                        // Suit is always the last one character
                        String suit = strCard.substring(strCard.length() - 1).toLowerCase();
                        String rank = removeLastChar(strCard).toLowerCase();
                        card = new Card(rank, suit);
                        hand.addCard(card);
                    }
                }

                hand.displayPokerHand();
            }

            System.out.println();
        }
    }

    private static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }
}
