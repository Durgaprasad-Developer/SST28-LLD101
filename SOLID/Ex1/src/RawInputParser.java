import java.util.LinkedHashMap;
import java.util.Map;

class ParseStudentData{
    String name;
    String email;
    String phone;
    String program;

    ParseStudentData(String name, String email, String phone, String program){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.program = program;
    }
}

public class RawInputParser {

    public ParseStudentData  parse(String raw){
            Map<String,String> kv = new LinkedHashMap<>();
        String[] parts = raw.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        }

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        ParseStudentData t = new ParseStudentData(name, email, phone, program);
        return t;


    }  
}
