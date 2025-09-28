package CalcVar211092025;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("КОНСОЛЬНЫЙ КАЛЬКУЛЯТОР");
        System.out.println("Поддерживаемые операции: + (сложение), - (вычитание), * (умножение), / (деление), // (целочисленное деление), ^ (степень), % (остаток)");
        System.out.println("Для выхода введите 'exit'");

        // Основной цикл работы калькулятора
        while (true) {
            System.out.print("Введите выражение разделитель пробел: ");
            String input = scanner.nextLine().trim();

            // Проверка на выход из программы
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Выход...");
                break;
            }

            // Проверка корректности выражения
            if (!isValidExpression(input)) {
                System.out.println("Неверное выражение. Введите еще раз:");
                continue;
            }

            try {
                // Вычисление результата
                int result = calculateExpression(input, calculator);
                System.out.println("Результат: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Ошибка - " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }

    /*
     Проверяет корректность математического выражения
     expression - введенное выражение. return = true если выражение корректно, иначе = false
     */
    private static boolean isValidExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            return false;
        }

        // Разбиваем выражение на части по пробелам
        String[] parts = expression.split("\\s+");

        // Проверяем что выражение состоит из трех части
        if (parts.length != 3) {
            return false;
        }

        // Проверяем что первая и третья части - целые числа
        try {
            Integer.parseInt(parts[0]);
            Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        // Проверяем что оператор поддерживается
        String operator = parts[1];
        return operator.equals("+") || operator.equals("-") ||
                operator.equals("*") || operator.equals("/") ||
                operator.equals("//") || operator.equals("^") ||
                operator.equals("%");
    }

    /*
     Вычисляет результат математического выражения
     expression - строка с выражением
     return результат вычисления
     throws ArithmeticException при арифметических ошибках
     */
    private static int calculateExpression(String expression, Calculator calculator) {
        String[] parts = expression.split("\\s+");
        int a = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int b = Integer.parseInt(parts[2]);

        // Выбор операции в зависимости от оператора
        switch (operator) {
            case "+": return calculator.sum(a, b);
            case "-": return calculator.sub(a, b);
            case "*": return calculator.multiply(a, b);
            case "/": return calculator.div(a, b);
            case "//": return calculator.integdiv(a, b);
            case "^": return calculator.power(a, b);
            case "%": return calculator.modulus(a, b);
            default: throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }
    }
}

