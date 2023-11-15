import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(7);
        list.add(9);

        List<Integer> sortedList = sort(list);
        System.out.println(sortedList);
    }

    public static List<Integer> sort(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();

        int size = list.size();
        for (int i = 0; i < size; i++) {
            int smallest = findSmallest(list);
            newList.add(list.remove(smallest));
        }

        return newList;
    }

    private static int findSmallest(List<Integer> list) {
        int smallest = list.get(0);
        int smallestIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < smallest) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }
}
