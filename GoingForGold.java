import java.util.Arrays;
import java.util.Scanner;

public class GoingForGold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        
        int[] scores = new int[n];
        int[] part = new int[n];

        String[] in = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(in[i]);
        }
        in = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            scores[i] *= Integer.parseInt(in[i]);
        }

        part[0] = 1;
        for (int i = n; i > 1; i--) {
            int c = findLowestScore(scores, part);
            scores[c] *= i;
            part[c] = i;
        }

        if (firstMin(scores)) {
            System.out.print(part[0]);
            for (int i = 1; i < n; i++) {
                System.out.printf(" %d", part[i]);
            }
            System.out.flush();
        } else {
            System.out.println("impossible");
        }
    }

    private static int findLowestScore(int[] scores, int[] participated) {
        int low = -1;
        int lowV = -1;

        for (int i = 0; i < scores.length; i++) {
            if (participated[i] != 0) continue;

            if (low == -1 || lowV > scores[i]) {
                low = i;
                lowV = scores[i];
            }
        }
        
        return low;
    }

    private static boolean firstMin(int[] scores) {
        int hog = scores[0];

        int min = scores[0];
        for (int score : scores) {
            min = Math.min(min, score);
        }

        return hog == min;
    }
}
