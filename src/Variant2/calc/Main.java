package Variant2.calc;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Поддерживаемые операциии
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
                int result = calculateExpression(input);
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

            // Проверяем что выражение состоит из трех частей
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
        private static int calculateExpression(String expression) {
            String[] parts = expression.split("\\s+");
            int a = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int b = Integer.parseInt(parts[2]);

            // Выбор операции в зависимости от оператора
            switch (operator) {
                case "+": return sum(a, b);
                case "-": return sub(a, b);
                case "*": return multiply(a, b);
                case "/": return div(a, b);
                case "//": return integdiv(a, b);
                case "^": return power(a, b);
                case "%": return modulus(a, b);
                default: throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
            }
        }    //сложение
    public static int sum(int a, int b) {
        return a + b;
    }

    //вычитание
    public static int sub(int a, int b) {
        return a - b;
    }
    //умножение
    public static int multiply(int a, int b) {
        return a * b;
    }
    //деление
    public static int div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("деление на 0");
        }
        return a / b;
    }
    //целочисленное деление
    public static int integdiv(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("целочисленное деление на 0");
        }
        return a / b;
    }
    //возведение в степень
    public static int power(int a, int b) {
        if (b < 0) {
            throw new ArithmeticException("отрицательная степень не поддерживается");
        }
        return (int) Math.pow(a, b);
    }
    //остаток от деления
    public static int modulus(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("остаток от деления на 0");
        }
        return a % b;
    }
    }