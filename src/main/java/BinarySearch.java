public class BinarySearch {

    public static void main(String[] args) {
        int[] list = new int[]{1, 3, 5, 7, 9};

        System.out.println(binarySearch(list, 7));
    }

    public static int binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        int mid;
        int guess;

        while (low <= high) {
            mid = (high + low) / 2;
            guess = list[mid];

            if (guess == item) {
                return mid;
            } else if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
