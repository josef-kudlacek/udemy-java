package eu.kudljo.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void printHeart() {
        assertEquals("\u2661", Suit.HEARTS.toString());
    }

    @Test
    void printDiamonds() {
        assertEquals("\u2662", Suit.DIAMONDS.toString());
    }

    @Test
    void printSpades() {
        assertEquals("\u2664", Suit.SPADES.toString());
    }

    @Test
    void printClubs() {
        assertEquals("\u2667", Suit.CLUBS.toString());
    }
}