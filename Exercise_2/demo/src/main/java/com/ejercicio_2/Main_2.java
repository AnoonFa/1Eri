package com.ejercicio_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2 {

    private static final Map<Character, Integer> precedence = new HashMap<>();

    static {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión matemática para evaluar");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo de la calculadora...");
                break;
            }

            try {
                String rpn = infixToRPN(input);
                double resultado = evaluateRPN(rpn);
                System.out.println("Resultado: " + resultado);
            } catch (Exception e) {
                System.out.println("Error al evaluar la expresión: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static String infixToRPN(String expression) throws Exception {
        StringBuilder output = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);

            if (Character.isWhitespace(token)) {
                continue;
            }

            if (Character.isDigit(token) || token == '.') {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                output.append(numBuilder).append(' ');
                i--;
            } else if (token == '(') {
                operators.push(token);
            } else if (token == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.append(operators.pop()).append(' ');
                }
                if (operators.isEmpty() || operators.pop() != '(') {
                    throw new Exception("Paréntesis desbalanceados");
                }
            } else if (precedence.containsKey(token)) {
                while (!operators.isEmpty() && precedence.get(token) <= precedence.getOrDefault(operators.peek(), 0)) {
                    output.append(operators.pop()).append(' ');
                }
                operators.push(token);
            } else {
                throw new Exception("Carácter inválido en la expresión");
            }
        }

        while (!operators.isEmpty()) {
            char op = operators.pop();
            if (op == '(' || op == ')') {
                throw new Exception("Paréntesis desbalanceados");
            }
            output.append(op).append(' ');
        }

        return output.toString();
    }

    private static double evaluateRPN(String rpn) throws Exception {
        Stack<Double> stack = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(rpn);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (token.length() == 1 && "+-*/".contains(token)) {
                if (stack.size() < 2) {
                    throw new Exception("Expresión inválida");
                }
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                    default: throw new Exception("Operador desconocido");
                }
            } else {
                throw new Exception("Token inválido en la expresión");
            }
        }

        if (stack.size() != 1) {
            throw new Exception("Expresión inválida");
        }

        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
