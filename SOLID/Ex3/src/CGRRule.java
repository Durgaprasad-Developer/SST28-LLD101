import java.util.List;

public class CGRRule implements EligibilityRule {
    public void check(StudentProfile s, List<String> reasons){
        if (s.cgr < 8.0) {
            reasons.add("CGR below 8.0");
        }
    }
    
}
