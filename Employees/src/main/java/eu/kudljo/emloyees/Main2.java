package eu.kudljo.emloyees;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Main2 {
    record Programmer(String lastName, String firstName, LocalDate dob, int locpd, int yoe, int iq) {
    }

    record Manager(String lastName, String firstName, LocalDate dob, int orgSize, int dr) {
    }

    record Analyst(String lastName, String firstName, LocalDate dob, int projectCount) {
    }

    record CEO(String lastName, String firstName, LocalDate dob, BigDecimal avgStockPrice) {
    }

    public static void main(String[] args) {
//        Object employee = null;
//        Object employee = new Programmer("Martin", "Terry", LocalDate.of(1974, 9, 23), 10000, 25, 145);
        Object employee = new Programmer("Woods", "Johnny", LocalDate.of(1974, 9, 23), 5, 23, 120);

        switch (employee) {
            case null:
                System.out.println("You supplied nothing");
                break;
            case Programmer(_, var f, _, var locpd, _, _) when
                    locpd < 50:
                System.out.println(STR."\{f}, you only write \{locpd} lines per day. You're better than this!!!");
                break;
            case Programmer(_, var f, _, var locpd, _, _) when
                    locpd >= 50:
                System.out.println(STR."\{f}, you write a whopping \{locpd} lines per day. Way to go!!!");
                break;
            default:
                System.out.println("No matches found");
        }
    }
}
