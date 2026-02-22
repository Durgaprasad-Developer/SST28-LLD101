import java.util.List;
public class AttendenceRule implements EligibilityRule {
    public void check(StudentProfile s, List<String> reasons){
        if (s.attendancePct < 75) {
            reasons.add("attendance below 75");
        }
    }
}
