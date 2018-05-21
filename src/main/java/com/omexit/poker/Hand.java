package com.omexit.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Hand {

    private ArrayList<Card> cards;
    private int[] ranks = new int[14];

    Hand() {
        cards = new ArrayList<Card>();
        // Initialize ranks
        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = 0;
        }
    }

    public void addCard(Card card) {
        if (cards.size() < 5) {
            cards.add(card);
        }
    }

    private String getBestPokerHand() {
        String pokerHand = "";
        int sameCards = 0;
        int sameCards2 = 0;
        boolean flushPoint = true;
        boolean straightPoint = true;

        // Sort our cards
        Collections.sort(cards);
        // Count card rank occurrence and flush
        Card first = cards.get(0);
        Card previousCard = null;
        for (Card card : cards) {
            int cardValue = card.getValue();
            int rankValue = ranks[cardValue];
            ranks[cardValue] = ++rankValue;

            //Check if flush
            if (flushPoint) {
                if (!Objects.equals(card.getSuit(), first.getSuit())) flushPoint = false;
            }

            if (straightPoint) {
                if (previousCard != null) {
                    if (previousCard.getValue() - card.getValue() != 1) {
                        straightPoint = false;
                    }
                }
                previousCard = card;
            }
        }

        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i] == 5) {
                sameCards = 5;
            } else if (ranks[i] == 4) {
                sameCards = 4;
            } else if (ranks[i] == 3) {
                if (sameCards == 0) {
                    sameCards = 3;
                } else {
                    sameCards2 = 3;
                }
            } else if (ranks[i] == 2) {
                if (sameCards == 0) {
                    sameCards = 2;
                } else {
                    sameCards2 = 2;
                }
            }
        }

        if (sameCards == 5) {
            pokerHand = "Five of a kind";
        } else if (sameCards == 4) {
            // If 4 Ace & a joker
            if (ranks[0] == 1 && ranks[1] == 4) {
                pokerHand = "Five of a kind";
            } else {
                pokerHand = "Four of a kind";
            }
        } else if (sameCards == 3) {
            if (sameCards2 == 2) {
                pokerHand = "Full house";
            } else {
                pokerHand = "Three of a kind";
            }
        } else if (sameCards == 2) {
            if (sameCards2 == 3) {
                pokerHand = "Full house";
            } else if (sameCards2 == 2) {
                pokerHand = "Two pair";
            } else {
                pokerHand = "One pair";
            }
        } else {
            if (flushPoint) {
                pokerHand = "Flush";
            } else if (straightPoint) {
                pokerHand = "Straight";
            }else {
                pokerHand = "High card";
            }
        }

        return pokerHand;
    }

    public void displayPokerHand() {
        String pokerHand =getBestPokerHand();

        System.out.println(this);
        System.out.println(pokerHand);
    }

    @Override
    public String toString() {
        return "cards=" + cards;
    }
}
