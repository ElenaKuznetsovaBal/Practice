package CalcVar211092025;

public class Calculator {

    // Публичные методы для обратной совместимости
    public int sum(int a, int b) {
        return createOperation("+", a, b).execute();
    }

    public int sub(int a, int b) {
        return createOperation("-", a, b).execute();
    }

    public int multiply(int a, int b) {
        return createOperation("*", a, b).execute();
    }

    public int div(int a, int b) {
        return createOperation("/", a, b).execute();
    }

    public int integdiv(int a, int b) {
        return createOperation("//", a, b).execute();
    }

    public int power(int a, int b) {
        return createOperation("^", a, b).execute();
    }

    public int modulus(int a, int b) {
        return createOperation("%", a, b).execute();
    }

    // Приватный метод создания операций (инкапсуляция)
    private Operation createOperation(String operator, int a, int b) {
        switch (operator) {
            case "+": return new Addition(a, b);
            case "-": return new Subtraction(a, b);
            case "*": return new Multiplication(a, b);
            case "/": return new Division(a, b);
            case "//": return new IntegerDivision(a, b);
            case "^": return new Power(a, b);
            case "%": return new Modulus(a, b);
            default: throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }
    }
}
