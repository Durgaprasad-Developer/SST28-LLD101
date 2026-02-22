import java.util.*;
public interface EligibilityRule {
    void check(StudentProfile s, List<String> reasons);
}
