import java.util.*;

public class Graph {
    private final static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) {
        graph.put("you", List.of("alice", "bob", "claire"));
        graph.put("bob", List.of("anuj", "peggy"));
        graph.put("alice", List.of("peggy"));
        graph.put("claire", List.of("thom", "jonny"));
        graph.put("anuj", List.of());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());

        boolean search = search("you");
        System.out.println(search);
    }

    public static boolean search(String name) {
        Deque<String> searchedQueue = new ArrayDeque<>();
        searchedQueue.addAll(graph.get(name));
        List<String> searched = new ArrayList<>();

        while (!searchedQueue.isEmpty()) {
            String person = searchedQueue.pop();
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    searchedQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }

        return false;
    }

    public static boolean personIsSeller(String name) {
        return name.charAt(name.length() - 1) == 'm';
    }
}
