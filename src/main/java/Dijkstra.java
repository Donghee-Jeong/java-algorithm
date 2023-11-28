import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    private static final Map<String, Map<String, Integer>> graph = new HashMap<>();
    private static final Map<String, Integer> costs = new HashMap<>();
    private static final Map<String, String> parents = new HashMap<>();
    private static final List<String> processed = new ArrayList<>();

    public static void main(String[] args) {
        init();

        String node = findLowestCostNode(costs);

        while (node != null) {
            Integer cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);
            for (String n : neighbors.keySet()) {
                Integer newCost = cost + neighbors.get(n);
                if (costs.get(n) > newCost) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs);
        }

        System.out.println(graph);
        System.out.println(costs);
        System.out.println(parents);
        System.out.println(processed);
    }

    private static String findLowestCostNode(Map<String, Integer> costs) {
        Integer lowestCost = 9999;
        String lowestCostNode = null;

        for (String node : costs.keySet()) {
            Integer cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }

    private static void init() {
        Map<String, Integer> start = graph.computeIfAbsent("start", k -> new HashMap<>());
        start.put("a", 6);
        start.put("b", 2);

        System.out.println(graph.get("start").keySet());
        System.out.println(graph.get("start").get("a"));

        Map<String, Integer> a = graph.computeIfAbsent("a", k -> new HashMap<>());
        a.put("fin", 1);

        Map<String, Integer> b = graph.computeIfAbsent("b", k -> new HashMap<>());
        b.put("a", 3);
        b.put("fin", 5);

        Map<String, Integer> fin = graph.computeIfAbsent("fin", k -> new HashMap<>());

        // costs
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", 9999);

        // parents
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);
    }

}
