public class LongestCommonSubString {
    public static void main(String[] args) {
        String input = "hish";
        String fish = "fish";
        String vista = "vista";

        int same1 = check(input, fish);
        System.out.println("same1 = " + same1);
        int same2 = check(input, vista);
        System.out.println("same2 = " + same2);
    }

    private static int check(String input, String diff) {

        int[][] cell = new int[input.length()][diff.length()];
        int max = 0;

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < diff.length(); j++) {
                if (input.charAt(i) == diff.charAt(j)) {
                    if (i == 0 || j == 0) {
                        cell[i][j] = 1;
                    } else {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    }
                    if (max < cell[i][j]) {
                        max = cell[i][j];
                    }
                } else {
                    cell[i][j] = 0;
                }
            }
        }

        return max;
    }
}
