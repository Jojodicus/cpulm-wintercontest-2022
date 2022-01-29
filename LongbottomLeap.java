import java.util.Scanner;

public class LongbottomLeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] in = sc.nextLine().toCharArray();

        int iFirst = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == '1') {
                iFirst = i;
                break;
            }
        }

        int iLast = in.length - 1;
        for (int i = in.length - 1; i >= 0; i--) {
            if (in[i] == '1') {
                iLast = i;
                break;
            }
        }

        int dif = iLast - iFirst + 1;

        int span = 32;
        StringBuilder res = new StringBuilder("long");
        while (span < dif) {
            res.append(" long");
            span <<= 1;
        }

        System.out.println(res);
    }
}
