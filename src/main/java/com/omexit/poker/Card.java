package com.omexit.poker;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>{

    private String rank;
    private String suit;
    private int value;
    private String rankName;
    private String suitName;

    private static Map<String, String> suitNames;
    private static Map<String, String> rankNames;
    private static Map<String, Integer> rankValues;

    static {
        //Initialize 4 suits name hash map
        suitNames = new HashMap<>();
        suitNames.put("h", "hearts");
        suitNames.put("s", "spades");
        suitNames.put("d", "diamonds");
        suitNames.put("c", "clubs");
        suitNames.put("j", "joker");

        //Initialize 13 ranks name hash map
        rankNames = new HashMap<>();
        rankNames.put("a", "Ace");
        rankNames.put("2", "2");
        rankNames.put("3", "3");
        rankNames.put("4", "4");
        rankNames.put("5", "5");
        rankNames.put("6", "6");
        rankNames.put("7", "7");
        rankNames.put("8", "8");
        rankNames.put("9", "9");
        rankNames.put("10", "10");
        rankNames.put("j", "Jack");
        rankNames.put("q", "Queen");
        rankNames.put("k", "King");

        //Initialize 13 ranks name hash map
        rankValues = new HashMap<>();
        rankValues.put("joker", 0);
        rankValues.put("a", 1);
        rankValues.put("2", 2);
        rankValues.put("3", 3);
        rankValues.put("4", 4);
        rankValues.put("5", 5);
        rankValues.put("6", 6);
        rankValues.put("7", 7);
        rankValues.put("8", 8);
        rankValues.put("9", 9);
        rankValues.put("10", 10);
        rankValues.put("j", 11);
        rankValues.put("q", 12);
        rankValues.put("k", 13);
    }

    Card(String rank, String suit) {
        this.rankName = rankNames.get(rank);
        if(rank.equals(" ") && suit.equals("j")){
            this.rankName = "joker";
            rank = "joker";
        }
        if (this.rankName == null){
            throw new IllegalArgumentException("Invalid rank: " + rank);
        }

        this.suitName = suitNames.get(suit);
        if (this.suitName == null){
            throw new IllegalArgumentException("Invalid suit: " + suit);
        }

        this.value = rankValues.get(rank);
        this.rank = rank;
        this.suit = suit;
    }


    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getRankName() {
        return rankName;
    }

    public String getSuitName() {
        return suitName;
    }

    @Override
    public String toString() {
        return rankName + " of " + suitName;
    }

    @Override
    public int compareTo(Card o) {
        //descending order
        return o.getValue() - value;
    }
}
