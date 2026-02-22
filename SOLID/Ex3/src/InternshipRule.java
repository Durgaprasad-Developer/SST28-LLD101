import java.util.List;
public class InternshipRule implements EligibilityRule {
    public void check(StudentProfile s, List<String> reasons){
        if(!s.completedInternship){
            reasons.add("internship not completed");
        }
    }
}
