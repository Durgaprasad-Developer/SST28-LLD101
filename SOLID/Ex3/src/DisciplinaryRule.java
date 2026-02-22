import java.util.List;
public class DisciplinaryRule implements EligibilityRule {
        public void check(StudentProfile s, List<String> reasons){
            if (s.disciplinaryFlag != LegacyFlags.NONE) {
            reasons.add("disciplinary flag present");
        }
        }
}
