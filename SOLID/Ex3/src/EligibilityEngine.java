import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store) {
         this.store = store;
         this.rules = List.of(
            new DisciplinaryRule(), 
            new CGRRule(), 
            new AttendenceRule(), 
            new CreditRule(),
            new InternshipRule()
        );
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s); // giant conditional inside
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        
        for (EligibilityRule rule : rules){
            rule.check(s, reasons);
        }

        String status = reasons.isEmpty()? "ELIGIBLE" : "NOT_ELIGIIBLE";

        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;
    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}
