package eu.kudljo.blackjack;

public enum Suit {
    CLUBS('\u2667'),
    DIAMONDS('\u2662'),
    HEARTS('\u2661'),
    SPADES('\u2664');

    private char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return Character.toString(this.symbol);
    }
}
