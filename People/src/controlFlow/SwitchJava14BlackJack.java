package controlFlow;

/**
 * Purpose of black jack is get 21 points or closely. If you get higher, you fail.
 * Ace is for two possible values depends on your current total value. When is better for you to get 1, you get 1, otherwise 11.
 *
 */
public class SwitchJava14BlackJack {
    public static void main(String[] args) {
        String card = "ace";
        int currentTotalValue = 15;

        int currentValue = switch (card) {
            case "king", "queen", "jack" -> 10;
            case "ace" -> {
                if (currentTotalValue < 11) {
                    yield 11;
                } else {
                    yield 1;
                }
            }
            default -> Integer.parseInt(card);
        };

        System.out.printf("Current Card Value: %d%n", currentValue);
        System.out.printf("Total value: %d%n", currentTotalValue+currentValue);
    }
}
