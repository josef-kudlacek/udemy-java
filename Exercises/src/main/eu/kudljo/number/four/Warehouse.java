package eu.kudljo.number.four;

public class Warehouse {
    private int[] items = {13, 49, 90, 130, 175, 181, 255, 310, 330, 359};
    private static int index = 0;

    private static int getCategory(int daysInWareHouse) {
        return (int) Math.ceil(daysInWareHouse / 90);
    }

    public int next() {
        if (index >= 10) {
            throw new RuntimeException();
        }

        return getCategory(items[index++]);
    }
}
