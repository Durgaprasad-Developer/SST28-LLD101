import java.util.List;
public class OnboardingPrinter {
    public void printErrors(List<String> error){
                    System.out.println("ERROR: cannot register");
            for(String e : error) System.out.println("- " + e);
    }
    public void print(String raw, String id, StudentRecord rec, int db) {
        System.out.println("INPUT: " + raw);
        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + count);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
