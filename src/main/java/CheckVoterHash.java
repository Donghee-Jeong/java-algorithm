import java.util.HashMap;
import java.util.Map;

public class CheckVoterHash {

    public static final Map<String, Boolean> voted = new HashMap<>();

    public static void main(String[] args) {
        checkVoter("동희");
        checkVoter("동희");
    }

    public static void checkVoter(String name) {
        if (voted.get(name) == null) {
            voted.put(name, true);
            System.out.println("투표하게 하세요.");
        } else {
            System.out.println("쫒아내세요!");
        }
    }
}
