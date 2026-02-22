import java.util.*;

public class OnboardingService {
    private final StudentRepository db;

    public OnboardingService(FakeDb db) { this.db = db; }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        OnboardingPrinter printer = new OnboardingPrinter();

        // parsing
        RawInputParser parse = new RawInputParser();

        ParseStudentData p = parse.parse(raw);

        // validation inline, printing inline
        StudentValidator valid = new StudentValidator();
        List<String> error = valid.validate(p);

        if(!error.isEmpty()){
            printer.printErrors(error);
            return;
        }

        // Generating id
        String id = IdUtil.nextStudentId(db.count());
        // Creating student record
        StudentRecord rec = new StudentRecord(id, p.name, p.email, p.phone, p.program);
        // saving in FakeDb
        db.save(rec);
        // printing
        printer.print(raw, id, rec, db.count());
    }
}
