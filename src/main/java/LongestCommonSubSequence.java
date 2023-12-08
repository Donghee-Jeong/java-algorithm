public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String input = "fosh";
        String fish = "fish";
        String fort = "fort";

        int same1 = check(input, fish);
        System.out.println("same1 = " + same1);
        int same2 = check(input, fort);
        System.out.println("same2 = " + same2);
    }

    public static int check(String input, String another) {
        int[][] cell = new int[input.length()][another.length()];

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < another.length(); j++) {
                if (input.charAt(i) == another.charAt(j)) {
                    if (i != 0 && j != 0) {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    } else {
                        cell[i][j] = 1;
                    }
                } else {
                    cell[i][j] = Math.max(cell[Math.max(i - 1, 0)][j], cell[i][Math.max(j - 1, 0)]);
                }
            }
        }

        return cell[input.length() - 1][another.length() - 1];
    }
}
