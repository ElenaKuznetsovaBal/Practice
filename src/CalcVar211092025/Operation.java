package CalcVar211092025;

abstract class Operation {
    protected int operand1;
    protected int operand2;

    public Operation(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public abstract int execute();
}

// Конкретные реализации операций
class Addition extends Operation {
    public Addition(int a, int b) { super(a, b); }
    @Override public int execute() { return operand1 + operand2; }
}

class Subtraction extends Operation {
    public Subtraction(int a, int b) { super(a, b); }
    @Override public int execute() { return operand1 - operand2; }
}

class Multiplication extends Operation {
    public Multiplication(int a, int b) { super(a, b); }
    @Override public int execute() { return operand1 * operand2; }
}

class Division extends Operation {
    public Division(int a, int b) { super(a, b); }
    @Override public int execute() {
        if (operand2 == 0) throw new ArithmeticException("деление на 0");
        return operand1 / operand2;
    }
}

class IntegerDivision extends Operation {
    public IntegerDivision(int a, int b) { super(a, b); }
    @Override public int execute() {
        if (operand2 == 0) throw new ArithmeticException("целочисленное деление на 0");
        return operand1 / operand2;
    }
}

class Power extends Operation {
    public Power(int a, int b) { super(a, b); }
    @Override public int execute() {
        if (operand2 < 0) throw new ArithmeticException("отрицательная степень не поддерживается");
        return (int) Math.pow(operand1, operand2);
    }
}

class Modulus extends Operation {
    public Modulus(int a, int b) { super(a, b); }
    @Override public int execute() {
        if (operand2 == 0) throw new ArithmeticException("остаток от деления на 0");
        return operand1 % operand2;
    }
}
