package eu.kudljo.oop.array;

public class Play {
    public static void main(String[] args) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        System.out.println(daysOfWeek.length);
        System.out.println(daysOfWeek[3]);

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        char[][] ticTacToe = new char[3][3];
        ticTacToe[0][0] = 'O';
        ticTacToe[0][1] = 'X';
        ticTacToe[0][2] = 'X';
        ticTacToe[1][0] = 'X';
        ticTacToe[1][1] = 'O';
        ticTacToe[1][2] = 'O';
        ticTacToe[2][0] = 'X';
        ticTacToe[2][1] = 'O';
        ticTacToe[2][2] = 'O';

        for (int ticTacToeRow = 0; ticTacToeRow < 3; ticTacToeRow++) {
            for (int ticTacToeColumn = 0; ticTacToeColumn < 3; ticTacToeColumn++) {
                System.out.print(ticTacToe[ticTacToeRow][ticTacToeColumn]);
                if (ticTacToeColumn < 2) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        printParams("This", "is", "a", "test");
    }

    private static void printParams(String... param) {
        for (int i = 0; i < param.length; i++) {
            System.out.print(param[i] + " ");
        }
    }
}
