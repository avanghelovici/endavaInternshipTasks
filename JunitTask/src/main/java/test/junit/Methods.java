package junit;

class Methods {

    private double firstDoubleNumber;
    private double secondDoubleNumber;
    private int firstNumber;
    private int secondNumber;
    private String method;


    int getFirstNumber() {
        return firstNumber;
    }

    int getSecondNumber() {
        return secondNumber;
    }

    double getFirstDoubleNumber() {
        return firstDoubleNumber;
    }

    double getSecondDoubleNumber() {
        return secondDoubleNumber;
    }

    private String getMethod() {
        return method;
    }

    Methods(int firstNumber, int secondNumber, String method) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.method = method;
    }

    Methods(double firstDoubleNumber, double secondDoubleNumber, String method) {
        this.firstDoubleNumber = firstDoubleNumber;
        this.secondDoubleNumber = secondDoubleNumber;
        this.method = method;
    }

    private double multiply(double firstNumber, double secondNumber) {
        if ((firstNumber >= 0 && firstNumber <= 100) && (secondNumber >= 0 && secondNumber <= 100)) {
            return firstNumber * secondNumber;
        } else return 0;
    }

    private int subtract(int firstNumber, int secondNumber) {
        if ((firstNumber >= 0 && secondNumber >= 0) && (firstNumber > secondNumber)) {
            return firstNumber - secondNumber;
        } else {
            return -1;
        }
    }

    private double divide(double firstNumber, double secondNumber) {
        if ((firstNumber >= 0 && secondNumber >= 0) && firstNumber >= secondNumber) {
            if (firstNumber / secondNumber == Double.POSITIVE_INFINITY) {
                throw new ArithmeticException("divide by zero");
            } else {
                return firstNumber / secondNumber;
            }
        } else return 0;
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
                result = (double) subtract(getFirstNumber(), getSecondNumber());
                break;
            default:
                System.out.println("No such method");
                break;
        }
        return result;
    }


}

