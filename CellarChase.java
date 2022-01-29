import java.util.Scanner;

public class CellarChase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dg = sc.nextLine();

        dg = dg.replace("()", "1");

        System.out.println(eval(dg));
    }

    public static long eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            long parse() {
                nextChar();
                long x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            //        | functionName `(` expression `)` | functionName factor
            //        | factor `^` factor

            long parseExpression() {
                long x = parseTerm();
                for (;;) {
                    if      (eat('+')) x = Math.max(x, parseTerm()); // addition //todo
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            long parseTerm() {
                long x = parseFactor();
                for (;;) {
                    if      (eat('*')) x += parseFactor(); // multiplication //todo
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            long parseFactor() {
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                long x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Long.parseLong(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                    if (func.equals("sqrt")) x = (long) Math.sqrt(x);
                    else if (func.equals("sin")) x = (long) Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = (long) Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = (long) Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = (long) Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
