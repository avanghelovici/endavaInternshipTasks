package JunitTask;

import org.testng.Assert;

class TestData {

    private double firstDoubleNumber;
    private double secondDoubleNumber;
    private String method;

    double getFirstDoubleNumber() {
        return firstDoubleNumber;
    }

    double getSecondDoubleNumber() {
        return secondDoubleNumber;
    }

    private String getMethod() {
        return method;
    }

    TestData(double firstDoubleNumber, double secondDoubleNumber, String method) {
        this.firstDoubleNumber = firstDoubleNumber;
        this.secondDoubleNumber = secondDoubleNumber;
        this.method = method;
    }

    public double multiply(double firstNumber, double secondNumber) {
        if ((firstNumber >= 0 && firstNumber <= 100) && (secondNumber >= 0 && secondNumber <= 100)) {
            return firstNumber * secondNumber;
        } else return 0;
    }

    private double subtract(double firstNumber, double secondNumber) {
        if ((firstNumber>=0&&secondNumber>=0)&&(firstNumber > secondNumber)) {
            return firstNumber - secondNumber;
        } else {
            return -1;
        }
    }

    private double divide(double firstDoubleNumber, double secondDoubleNumber) {
        if ((firstDoubleNumber > 0 && secondDoubleNumber > 0) && (firstDoubleNumber >= secondDoubleNumber)) {
            return firstDoubleNumber / secondDoubleNumber;}
        else
        return 0;
    }
    Double calculate() {
        Double result = null;
        switch (getMethod()) {
            case "multiply":
                result = multiply(getFirstDoubleNumber(), getSecondDoubleNumber());
                break;
            case "divide":
                result = divide(getFirstDoubleNumber(), getSecondDoubleNumber());
                break;
            case "subtract":
                result = subtract(getFirstDoubleNumber(), getSecondDoubleNumber());
                break;
            default:
                System.out.println("No such method");
                break;
        }
        return result;
    }
}

