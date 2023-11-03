package eu.kudljo.sec8_more_oop.ex2;

public enum LunchScheduleType {
    MONDAY("spaghetti"),
    TUESDAY("tacos"),
    WEDNESDAY("chicken"),
    THURSDAY("meatloaf"),
    FRIDAY("hamburgers"),
    SATURDAY("pizza"),
    SUNDAY("pot roast");

    private final String meal;

    LunchScheduleType(String meal) {
        this.meal = meal;
    }

    public String getMeal() {
        return meal;
    }

    @Override
    public String toString() {
        String name = this.name().substring(0, 1).concat(this.name().substring(1).toLowerCase());
        String[] words = this.meal.split(" ");
        StringBuilder mealWords = new StringBuilder();
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            String word = words[wordIndex];
            mealWords.append(word.substring(0, 1).toUpperCase()
                    .concat(word.substring(1))
            );

            if (wordIndex < words.length - 1) {
                mealWords.append(" ");
            }
        }

        return String.format("We eat %s on %s", mealWords, name);
    }
}
