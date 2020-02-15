package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FibonacciTest {
    @Test
    public void should_return_negative_1_when_calculate_given_position_is_less_than_1() {
        assertThat(Fibonacci.calculate(0), is(-1));
    }

    @Test
    public void should_return_negative_1_when_calculate_given_position_is_greater_than_50() {
        assertThat(Fibonacci.calculate(51), is(-1));
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        assertThat(Fibonacci.calculate(1), is(1));
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2() {
        assertThat(Fibonacci.calculate(2), is(1));
    }

    @Test
    public void should_return_144_when_calculate_given_position_is_12() {
        assertThat(Fibonacci.calculate(12), is(144));
    }
}
