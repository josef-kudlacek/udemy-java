package eu.kudljo.sec2_basic_oop;

public class Friends {
    public static final String names[] = {"Joe", "Jack", "William"};

    public String[] getFriends() {
        return Friends.names;
    }

    public static void main(String[] args) {
        Friends friends = new Friends();

        System.out.println(friends.getFriends()[0]);
        System.out.println(friends.getFriends()[1]);
        System.out.println(friends.getFriends()[2]);

        Friends friends2 = new Friends();

        System.out.println(friends2.getFriends()[0]);
        System.out.println(friends2.getFriends()[1]);
        System.out.println(friends2.getFriends()[2]);
    }
}
