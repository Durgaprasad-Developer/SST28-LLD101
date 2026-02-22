import java.util.ArrayList;
import java.util.List;

public class StudentValidator {
    public List<String> validate(ParseStudentData p){
        List<String> errors = new ArrayList<>();

        if (p.name.isBlank()) errors.add("name is required");
        if (p.email.isBlank() || !p.email.contains("@")) errors.add("email is invalid");
        if (p.phone.isBlank() || !p.phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(p.program.equals("CSE") || p.program.equals("AI") || p.program.equals("SWE"))) errors.add("program is invalid");

        return errors;
    }
}
