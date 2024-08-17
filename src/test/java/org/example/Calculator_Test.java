package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Calculator_Test {
    Calculator calc = Calculator.instance.get();


    @Test
    public void minusTest() {
        // given:
        int a = 5;
        int b = 6;
        int c = -1;
        // when:
        int res = calc.minus.apply(a, b);
        // then:
        assertThat(c, equalTo(res));
    }

    @MethodSource("devideTest")
    @ParameterizedTest
    public void devideTestParam(int a, int b, int ex) {
        // when:
        int res = calc.devide.apply(a, b);
        // then:
        assertThat(ex, equalTo(res));
    }

    public static Stream<Arguments> devideTest() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(-4, 2, -3),//сделано специально для тестирования
                Arguments.of(1, 0, 0),
                Arguments.of(100, 5, 20)
        );
    }

    @Test
    public void plusTest() {
        // given:
        int a = 2;
        int b = 2;
        int c = 5;
        // when:
        int res = calc.plus.apply(a, b);
        // then:
        assertThat(c, not(res));
    }

    @Test
    public void isCalcTest() {
        // given:
        Calculator c = calc;
        // when:
        Class<Calculator> res = Calculator.class;
        // then:
        assertThat(c.getClass(), typeCompatibleWith(res));
    }

    @Test
    public void abcTest() {
        // given:
        int a = -2;
        int c = 2;
        // when:
        int res = calc.abs.apply(a);
        // then:
        assertThat(c, equalTo(res));
    }
}

