package eu.kudljo.sec8_more_oop.ex1;

public enum DayOfWeekType {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    @Override
    public String toString() {
        String name = this.name();
        return String.format("%s%s", name.charAt(0), name.substring(1).toLowerCase());
    }

    public String print() {
        String name = this.name();
        int middleIndex = name.length() / 2;
        return String.format("%s%s%s", name.substring(0, middleIndex).toLowerCase(),
                name.substring(middleIndex, ++middleIndex),
                name.substring(middleIndex).toLowerCase());
    }
}
