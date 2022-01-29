import java.util.Scanner;

public class KettleKitten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] in = sc.nextLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int volume = Integer.parseInt(in[1]);

        int smallestI = -1;
        double smallestV = Double.POSITIVE_INFINITY;

        for (int i = 0; i < n; i++) {
            in = sc.nextLine().split(" ");

            int h = Integer.parseInt(in[0]);
            int r = Integer.parseInt(in[1]);

            double cvol = Math.PI * r * r * h;

            if (volume > cvol) continue;

            if (cvol <= smallestV) {
                smallestV = cvol;
                smallestI = i;
            }
        }

        System.out.println(smallestI != -1 ? smallestI + 1 : "impossible");
    }
}
