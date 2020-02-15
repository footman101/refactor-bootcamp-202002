package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public static int calculate(int position) {
        if (position < 1 || position > 50) {
            return -1;
        }

        if (position == 1 || position == 2) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int cur = 3;
        while (cur != position) {
            int temp = a + b;
            a = b;
            b = temp;
            cur++;
        }

        return a + b;
    }
}
