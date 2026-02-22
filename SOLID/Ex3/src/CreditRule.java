import java.util.List;

public class CreditRule implements EligibilityRule {
    public void check(StudentProfile s, List<String> reasons){
        if (s.earnedCredits < 20) {
            reasons.add("credits below 20");
        }
    }
}
