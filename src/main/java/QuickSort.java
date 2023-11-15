import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {

    public static void main(String[] args) {
        System.out.println(qSort(Arrays.asList(5, 3, 2, 4, 6, 1)));
    }

    public static List<Integer> qSort(List<Integer> array) {
        if (array.size() < 2) {
            return array;
        } else {
            Integer pivot = array.get(array.size() / 2);
            List<Integer> less = array.stream()
                    .filter(arr -> arr < pivot)
                    .collect(Collectors.toList());
            List<Integer> greater = array.stream()
                    .filter(arr -> arr > pivot)
                    .collect(Collectors.toList());

            List<Integer> lessQSort = qSort(less);
            List<Integer> greaterQSort = qSort(greater);

            List<Integer> result = new ArrayList<>(lessQSort);
            result.add(pivot);
            result.addAll(greaterQSort);
            return result;
        }
    }
}
