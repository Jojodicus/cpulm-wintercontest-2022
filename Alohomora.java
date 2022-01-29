import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alohomora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] in = sc.nextLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

//        List<List<Integer>> matrix = new ArrayList<>(n);
        int[] numlinks = new int[n];
        boolean[] neighbour = new boolean[n];

        for (int i = 0; i < m; i++) {
            in = sc.nextLine().split(" ");

            int a = Integer.parseInt(in[0]) - 1;
            int b = Integer.parseInt(in[1]) - 1;

            if(numlinks[a] > 2 || numlinks[b] > 2) {
                System.out.println("no");
                return;
            }

            numlinks[a]++;
            numlinks[b]++;


        }
    }
}
