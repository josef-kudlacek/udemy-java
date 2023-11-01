package text;

public class Split {
    public static void main(String[] args) {
        String text = """
                Smith,Fred,1/1/79,1111,ABC St.,Apple,CA
                McGuire,Jerry,2/2/80,2222 DEF St.,Orange,NV
                Flintstone,Fred,3/3/81,3333 GHI St.,Pear,MO
                Rubble,Barney,4/4/82,4444 JKL St.,Pineapple,IL
                Jetson,George,5/5/83,5555 MNO St.,Grapefruit,NY
                """;

        String[] people = text.split("\n", 3); // 0-1-2 and rest
        System.out.println(people.length);

        System.out.println(people[2]);
        String[] george = people[2].split(",");
        System.out.println(george[3]);
    }
}
