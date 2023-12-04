import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Greedy {
    public static void main(String[] args) {
        Set<String> statesNeeded = new HashSet<>(Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

        Map<String, Set<String>> stations = new HashMap<>();
        stations.put("kone", Set.of("id", "nv", "ut"));
        stations.put("ktwo", Set.of("wa", "id", "mt"));
        stations.put("kthree", Set.of("or", "nv", "ca"));
        stations.put("kfour", Set.of("nv", "ut"));
        stations.put("kfive", Set.of("ca", "az"));

        Set<String> finalStations = new HashSet<>();

        while (statesNeeded.size() > 0) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();

            for (Map.Entry<String, Set<String>> stationsItems : stations.entrySet()) {
                String station = stationsItems.getKey();
                Set<String> statesForStation = stationsItems.getValue();

                HashSet<String> covered = new HashSet<>(statesNeeded);
                covered.retainAll(statesForStation);
                if (covered.size() > statesCovered.size()) {
                    bestStation = station;
                    statesCovered = covered;
                }
            }
            statesNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }

        System.out.println(finalStations);
    }
}
