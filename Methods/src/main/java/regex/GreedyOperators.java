package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// greedy operator takes everything from back
public class GreedyOperators {
    public static void main(String[] args) {
        String transcript = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;

        String regex = """
        Student\\sNumber:\\s(?<studentNumber>\\d{10}).* # Get's student number
        Grade:\\s+(?<grade>\\d{1,2}).* # Get's grade
        Birthdate:\\s+(?<birthDate>(?:\\d{2}\\/){2}\\d{4}).* # Get's student birthdate
        Gender:\\s+(?<gender>\\w+)\\b.* # Get's gender
        State\\sID:\\s+(?<stateId>\\d{10}).*? # Get's state ID
        Cumulative.*?(?<weightedGPA>[\\d\\.]+)\\b.* # Get's cumulative GPA Weighted
        #Unweighted\\)\\s+(?<unweightedGPA>\\d{1,}\\.\\d{1,})\\b.* # Get's cumulative GPA Unweighted
        (.*) # Rest of transcript
        """;

        // Pattern.DOTALL - symbol '.' represents end of lines too
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS);

        Matcher matcher = pattern.matcher(transcript);
        if (matcher.matches()) {
            System.out.println("studentNumber: " + matcher.group("studentNumber"));
            System.out.println("grade: " + matcher.group("grade"));
            System.out.println("birthDate: " + matcher.group("birthDate"));
            System.out.println("gender: " + matcher.group("gender"));
            System.out.println("stateId: " + matcher.group("stateId"));
            System.out.println("weightedGPA: " + matcher.group("weightedGPA"));
            // System.out.println("unweightedGPA: " + matcher.group("unweightedGPA"));
        }
    }
}
