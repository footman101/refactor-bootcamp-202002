package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public static int calculate(int position) {
        if (position < 1 || position > 50) {
            return -1;
        }

        if (position == 1 || position == 2) {
            return 1;
        }

        return 0;
    }
}
