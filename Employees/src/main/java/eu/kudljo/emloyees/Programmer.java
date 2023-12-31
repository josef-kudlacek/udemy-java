package eu.kudljo.emloyees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee implements IEmployee, DummyInterface, Chef {

    private int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;

    private final String progRegex = "\\w+=(?<locpd>\\w+),\\w+=(?<yoe>\\w+),\\w+=(?<iq>\\w+)";
    private final Pattern progPattern = Pattern.compile(progRegex);

    public Programmer(String personText) {
        super(personText);

        Matcher progMatcher = progPattern.matcher(peopleMatcher.group("details"));
        if (progMatcher.find()) {
            this.linesOfCode = Integer.parseInt(progMatcher.group("locpd"));
            this.yearsOfExp = Integer.parseInt(progMatcher.group("yoe"));
            this.iq = Integer.parseInt(progMatcher.group("iq"));
        }
    }

    @Override
    public int getSalary() {
        // salary = 3000 + locpd * yoe * iq;
        return 3000 + linesOfCode * yearsOfExp * iq;
    }

    public int getLinesOfCode() {
        return linesOfCode;
    }

    public void setLinesOfCode(int linesOfCode) {
        this.linesOfCode = linesOfCode;
    }

    public int getYearsOfExp() {
        return yearsOfExp;
    }

    public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
