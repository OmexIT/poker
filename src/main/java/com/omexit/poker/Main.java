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
                Hand hand = Util.getHand(input);

                hand.displayPokerHand();
            }

            System.out.println();
        }
    }


}
