package JunitTask;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;

class Tests {
    private static long startTime;

    @BeforeAll
    static void testSetup() {
        startTime = System.currentTimeMillis();
    }

    @AfterAll
    static void tearDown() {
        float testRunDuration = (System.currentTimeMillis() - startTime) / 1000f;
        System.out.println(System.lineSeparator()
                + "Test run took: "
                + testRunDuration
                + " sec"
                + System.lineSeparator());
    }

    @CsvSource(value = {"4.44,2.22", "2, 2.5", "3.50, 6.50"})
    @DisplayName("Multiply test using CsvSource(Positive)")
    @ParameterizedTest(name = "Multiply between {0} and {1}")
    void multiply1(Double firstNumber, Double secondNumber) {
        final TestData test = new TestData(firstNumber, secondNumber, "multiply");
        final Double actualResult = test.calculate();
        final Double expectedResult = (test.getFirstDoubleNumber() * test.getSecondDoubleNumber());

        MatcherAssert.assertThat("actual result matches expected result", actualResult, is(expectedResult));
    }

    @CsvSource(value = {"-1,2.22", "2, -3.22", "-1.22,-3.58"})
    @DisplayName("Multiply test using CsvSource(Negative)")
    @ParameterizedTest(name = "Multiply between {0} and {1}")
    void multiply2(Double firstNumber, Double secondNumber) {
        final TestData test = new TestData(firstNumber, secondNumber, "multiply");
        final Double actualResult = test.calculate();
        final Double expectedResult = (test.getFirstDoubleNumber() * test.getSecondDoubleNumber());

        MatcherAssert.assertThat("actual result matches expected result", !actualResult.equals(expectedResult));
    }

    @CsvSource(value = {"0,2.22", "2.88, 0"})
    @DisplayName("Multiply test using CsvSource(Using 0)")
    @ParameterizedTest(name = "Multiply between {0} and {1}")
    void multiply3(Double firstNumber, Double secondNumber) {
        final TestData test = new TestData(firstNumber, secondNumber, "multiply");
        final Double actualResult = test.calculate();
        final Double expectedResult = (test.getFirstDoubleNumber() * test.getSecondDoubleNumber());

        MatcherAssert.assertThat("actual result matches expected result", actualResult, is(expectedResult));
    }

    @CsvSource(value = {"5.0,2.0", "8.0, 4.0", "25.0, 6.50"})
    @DisplayName("Divide test using CsvSource(Positive)")
    @ParameterizedTest(name = "Multiply between {0} and {1}")
    void divide1(Double firstNumber, Double secondNumber) {
        final TestData test = new TestData(firstNumber, secondNumber, "divide");
        final Double actualResult = test.calculate();
        final Double expectedResult = (test.getFirstDoubleNumber() / test.getSecondDoubleNumber());

        MatcherAssert.assertThat("actual result matches expected result", actualResult, is(expectedResult));
    }

    @CsvSource(value = {"2.0,8.0", "-2.0, 4.0", "25.0, -6.50"})
    @DisplayName("Divide test using CsvSource(Negative)")
    @ParameterizedTest(name = "Multiply between {0} and {1}")
    void divide2(Double firstNumber, Double secondNumber) {
        final TestData test = new TestData(firstNumber, secondNumber, "divide");
        final Double actualResult = test.calculate();
        final Double expectedResult = (test.getFirstDoubleNumber() / test.getSecondDoubleNumber());

        MatcherAssert.assertThat("actual result matches expected result", !actualResult.equals(expectedResult));
    }

    @CsvSource(value = {"12.0,8.0", "22.0, 4.0", "25.0, 6.50"})
    @DisplayName("Subtract test using CsvSource(Positive)")
    @ParameterizedTest(name = "Multiply between {0} and {1}")
    void subtract1(Double firstNumber, Double secondNumber) {
        final TestData test = new TestData(firstNumber, secondNumber, "subtract");
        final Double actualResult = test.calculate();
        final Double expectedResult = (test.getFirstDoubleNumber() - test.getSecondDoubleNumber());

        MatcherAssert.assertThat("actual result matches expected result", actualResult, is(expectedResult));
    }

    @CsvSource(value = {"2.0,8.0", "-2.0, 4.0", "25.0, -6.50"})
    @DisplayName("Subtract test using CsvSource(Negative)")
    @ParameterizedTest(name = "Multiply between {0} and {1}")
    void subtract2(Double firstNumber, Double secondNumber) {
        final TestData test = new TestData(firstNumber, secondNumber, "subtract");
        final Double actualResult = test.calculate();
        final Double expectedResult = (test.getFirstDoubleNumber() - test.getSecondDoubleNumber());

        MatcherAssert.assertThat("actual result matches expected result", !actualResult.equals(expectedResult));
    }

    @CsvSource(value = {"0,2.22", "2, 0", "-1.22,0"})
    @DisplayName("Divide test using CsvSource(Negative)")
    @ParameterizedTest(name = "divide between {0} and {1}")
    void exceptionThrowsTest(Double firstNumber, Double secondNumber) {
        final TestData test = new TestData(firstNumber, secondNumber, "divide");
        final Double actualResult = test.calculate();
        final Double expectedResult = (test.getFirstDoubleNumber() / test.getSecondDoubleNumber());
        MatcherAssert.assertThat("actual result matches expected result", !actualResult.equals(expectedResult));
        Assert.assertThrows(NullPointerException.class, ()-> test.calculate());
    }

    @MethodSource("TestMultiply")
    @DisplayName("Test using MethodSource multiply (Positive)")
    @ParameterizedTest(name = "{2} test on values {0} and {1}")
    void methodsUsing1(Double firstNumber, Double secondNumber, String method, Matcher<Double> matcher) {
        final TestData test = new TestData(firstNumber, secondNumber, method);
        final Double actualResult = test.calculate();
        MatcherAssert.assertThat(actualResult, matcher);
    }

    private static Stream<Arguments> TestMultiply() {
        return Stream.of(
                Arguments.of(6.0, 5.0, "multiply", is(30.0)),
                Arguments.of(10.0, 5.0, "multiply", is(50.0)),
                Arguments.of(11.0, 5.0, "multiply", is(55.0))
        );
    }

    @MethodSource("TestMultiply2")
    @DisplayName("Test using MethodSource multiply (Negative)")
    @ParameterizedTest(name = "{2} tests on values {0} and {1}")
    void methodsUsing2(Double firstNumber, Double secondNumber, String method, Matcher<Double> matcher) {
        final TestData test = new TestData(firstNumber, secondNumber, method);
        final Double actualResult = test.calculate();
        MatcherAssert.assertThat(actualResult, matcher);
    }

    private static Stream<Arguments> TestMultiply2() {
        return Stream.of(
                Arguments.of(-1.0, 5.0, "multiply", is(0.0)),
                Arguments.of(-2.0, -2.0, "multiply", is(0.0)),
                Arguments.of(-6.0, -20.0, "multiply", is(0.0))
        );
    }

    @MethodSource("TestDivide1")
    @DisplayName("Test using MethodSource divide (Positive)")
    @ParameterizedTest(name = "{2} tests on values {0} and {1}")
    void methodsUsing3(Double firstNumber, Double secondNumber, String method, Matcher<Double> matcher) {
        final TestData test = new TestData(firstNumber, secondNumber, method);
        final Double actualResult = test.calculate();
        MatcherAssert.assertThat(actualResult, matcher);
    }

    private static Stream<Arguments> TestDivide1() {
        return Stream.of(
                Arguments.of(30.0, 5.0, "divide", is(6.0)),
                Arguments.of(6.0, 2.0, "divide", is(3.0)),
                Arguments.of(60.0, 2.0, "divide", is(30.0))
        );
    }

    @MethodSource("TestDivide2")
    @DisplayName("Test using MethodSource divide (Negative)")
    @ParameterizedTest(name = "{2} tests on values {0} and {1}")
    void methodsUsing4(Double firstNumber, Double secondNumber, String method, Matcher<Double> matcher) {
        final TestData test = new TestData(firstNumber, secondNumber, method);
        final Double actualResult = test.calculate();
        MatcherAssert.assertThat(actualResult, matcher);
    }

    private static Stream<Arguments> TestDivide2() {
        return Stream.of(
                Arguments.of(-30.0, 5.0, "divide", is(0.0)),
                Arguments.of(6.0, 12.0, "divide", is(0.0)),
                Arguments.of(60.0, -2.0, "divide", is(0.0))
        );
    }

    @MethodSource("TestSubtract1")
    @DisplayName("Test using MethodSource subtract (Negative)")
    @ParameterizedTest(name = "{2} tests on values {0} and {1}")
    void methodsUsing5(Integer firstNumber, Integer secondNumber, String method, Matcher<Double> matcher) {
        final TestData test = new TestData(firstNumber, secondNumber, method);
        final Double actualResult = test.calculate();
        MatcherAssert.assertThat(actualResult, matcher);
    }

    private static Stream<Arguments> TestSubtract1() {
        return Stream.of(
                Arguments.of(30, 5, "subtract", is(25.0)),
                Arguments.of(6, 2, "subtract", is(4.0)),
                Arguments.of(60, 2, "subtract", is(58.0))
        );
    }

    @MethodSource("TestSubtract2")
    @DisplayName("Test using MethodSource subtract (Positive)")
    @ParameterizedTest(name = "{2} tests on values {0} and {1}")
    void methodsUsing6(Integer firstNumber, Integer secondNumber, String method, Matcher<Double> matcher) {
        final TestData test = new TestData(firstNumber, secondNumber, method);
        final Double actualResult = test.calculate();
        MatcherAssert.assertThat(actualResult, matcher);
    }

    private static Stream<Arguments> TestSubtract2() {
        return Stream.of(
                Arguments.of(-10, -5, "subtract", is(-1.0)),
                Arguments.of(2, 6, "subtract", is(-1.0)),
                Arguments.of(0, 0, "subtract", is(-1.0))
        );
    }
}




