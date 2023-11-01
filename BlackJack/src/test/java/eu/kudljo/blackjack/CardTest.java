package eu.kudljo.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    public void canGetValueOfTwoCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.TWO);

        assertEquals(2, card1.getValue());
    }

    @Test
    public void canGetValueOfThreeCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.THREE);

        assertEquals(3, card1.getValue());
    }

    @Test
    public void canGetValueOfAnAceCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.ACE);

        assertEquals(1, card1.getValue());
    }

    @Test
    public void canGetValueOfAnJackCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.JACK);

        assertEquals(10, card1.getValue());
    }

    @Test
    public void canGetValueOfAnQueenCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.QUEEN);

        assertEquals(10, card1.getValue());
    }

    @Test
    public void canGetValueOfAnKingCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.KING);

        assertEquals(10, card1.getValue());
    }
}