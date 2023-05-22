package Calculatrice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Calculatrice
{

    public static void main(String[] args) {
        String inputFile = "Calculs.txt";
        String outputFile = "CalculsResolus.txt";
        List<String> lines = readInputFile(inputFile);
        List<String> results = new ArrayList<>();

        for (String line : lines)
        {
            double result = calculate(line);
            String formattedResult = line + " = " + new DecimalFormat("#.##").format(result);
            results.add(formattedResult);
        }

        writeOutputFile(outputFile, results);
    }

    public static List<String> readInputFile(String path)
    {
        try
        {
            return Files.readAllLines(Paths.get(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static void writeOutputFile(String path, List<String> lines)
    {
        try
        {
            Files.write(Paths.get(path), lines);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

   /* public static double calculate(String expression)
    {
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int openParentheses = 0;
        int closedParentheses = 0;
        boolean unary = true;

        for (int i = 0; i < expression.length(); i++)
        {
            char c = expression.charAt(i);

            if(Character.isWhitespace(c))
            {
                continue;
            }

            if(!Character.isDigit(c) && c != '.' && c != '(' && c != ')' && c != '+' && c != '-' && c != '*' && c != '/')
            {
                throw new IllegalArgumentException("Invalid character in expression: " + c);
            }

            if(c == '(')
            {
                ops.push(c);
                openParentheses++;
                unary = true;
            }
            else if (c == ')')
            {
                if(openParentheses <= closedParentheses)
                {
                    throw new IllegalArgumentException("Invalid expression: unbalanced parentheses");
                }

                while (ops.peek() != '(')
                {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }

                ops.pop();
                closedParentheses++;
                unary = false;
            }
            else if(c == '+' || c == '*'|| c == '/')
            {
                while (!ops.empty() && hasPrecedence(c, ops.peek()))
                {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(c);
                unary = true;
            }
            else if(c == '-')
            {
                if (unary || (i == 0 || expression.charAt(i-1) == '(' || expression.charAt(i-1) == '+'
                        || expression.charAt(i-1) == '-' || expression.charAt(i-1) == '*' || expression.charAt(i-1) == '/'))
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append('-');
                    i++;
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.'))
                    {
                        sb.append(expression.charAt(i++));
                    }

                    i--;
                    values.push(Double.parseDouble(sb.toString()));
                }
                else
                {
                    while (!ops.empty() && hasPrecedence(c, ops.peek()))
                    {
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    }
                    ops.push(c);
                }
                unary = false;
            }
            else
            {
                StringBuilder sb = new StringBuilder();

                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.'))
                {
                    sb.append(expression.charAt(i++));
                }

                i--;
                values.push(Double.parseDouble(sb.toString()));
                unary = false;
            }
        }

        if(openParentheses != closedParentheses)
        {
            throw new IllegalArgumentException("Invalid expression: unbalanced parentheses");
        }

        while(!ops.empty())
        {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }*/

/*    public static double calculate(String expression)
    {
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int openParentheses = 0;
        int closedParentheses = 0;
        boolean unary = true;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (!Character.isDigit(c) && c != '.' && c != '(' && c != ')' && c != '+' && c != '-' && c != '*' && c != '/') {
                throw new IllegalArgumentException("Invalid character in expression: " + c);
            }

            if (c == '(') {
                ops.push(c);
                openParentheses++;
                unary = true;
            } else if (c == ')') {
                if (openParentheses <= closedParentheses) {
                    throw new IllegalArgumentException("Invalid expression: unbalanced parentheses");
                }

                while (!ops.empty() && ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }

                if (ops.empty()) {
                    throw new IllegalArgumentException("Invalid expression: empty operator stack");
                }

                ops.pop();
                closedParentheses++;
                unary = false;
            } else if (c == '+' || c == '*' || c == '/') {
                while (!ops.empty() && hasPrecedence(c, ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(c);
                unary = true;
            } else if (c == '-') {
                if (unary || (i == 0 || expression.charAt(i - 1) == '(' || expression.charAt(i - 1) == '+'
                        || expression.charAt(i - 1) == '-' || expression.charAt(i - 1) == '*' || expression.charAt(i - 1) == '/'))
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append('-');
                    i++;
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        sb.append(expression.charAt(i++));
                    }

                    i--;
                    values.push(Double.parseDouble(sb.toString()));
                } else {
                    while (!ops.empty() && hasPrecedence(c, ops.peek())) {
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    }
                    ops.push(c);
                }
                unary = false;
            } else {
                StringBuilder sb = new StringBuilder();

                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }

                i--;
                values.push(Double.parseDouble(sb.toString()));
                unary = false;
            }

            System.out.println("values: " + values.toString());
            System.out.println("ops: " + ops.toString());
        }

        if (openParentheses != closedParentheses) {
            throw new IllegalArgumentException("Invalid expression: unbalanced parentheses");
        }

        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        if (values.empty()) {
            throw new IllegalArgumentException("Invalid expression: empty value stack");
        }

        return values.pop();
    }*/
public static double calculate(String expression)
{

    Stack<Double> values = new Stack<>();
    Stack<Character> ops = new Stack<>();
    int openParentheses = 0;
    int closedParentheses = 0;
    boolean unary = true;

    if (expression == null || expression.trim().isEmpty()) {
        throw new IllegalArgumentException("Invalid expression: empty or contains only whitespace");
    }

    for (int i = 0; i < expression.length(); i++) {
        char c = expression.charAt(i);

        if (Character.isWhitespace(c)) {
            continue;
        }

        if (!Character.isDigit(c) && c != '.' && c != '(' && c != ')' && c != '+' && c != '-' && c != '*' && c != '/') {
            throw new IllegalArgumentException("Invalid character in expression: " + c);
        }

        if (c == '(') {
            ops.push(c);
            openParentheses++;
            unary = true;
        } else if (c == ')') {
            if (openParentheses <= closedParentheses) {
                throw new IllegalArgumentException("Invalid expression: unbalanced parentheses");
            }

            while (!ops.empty() && ops.peek() != '(') {
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));
            }

            if (ops.empty()) {
                throw new IllegalArgumentException("Invalid expression: empty operator stack");
            }

            ops.pop();
            closedParentheses++;
            unary = false;
        } else if (c == '+' || c == '*' || c == '/') {
            while (!ops.empty() && hasPrecedence(c, ops.peek())) {
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));
            }
            ops.push(c);
            unary = true;
        } else if (c == '-') {
            if (unary || (i == 0 || expression.charAt(i - 1) == '(' || expression.charAt(i - 1) == '+'
                    || expression.charAt(i - 1) == '-' || expression.charAt(i - 1) == '*' || expression.charAt(i - 1) == '/'))
            {
                StringBuilder sb = new StringBuilder();
                sb.append('-');
                i++;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }

                i--;
                values.push(Double.parseDouble(sb.toString()));
            } else {
                while (!ops.empty() && hasPrecedence(c, ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(c);
            }
            unary = false;
        }
        else
        {
            StringBuilder sb = new StringBuilder();

            while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                sb.append(expression.charAt(i++));
            }

            i--;
            values.push(Double.parseDouble(sb.toString()));
            unary = false;
        }

        System.out.println("values: " + values.toString());
        System.out.println("ops: " + ops.toString());
    }

    if (openParentheses != closedParentheses)
    {
        throw new IllegalArgumentException("Invalid expression: unbalanced parentheses");
    }

    while (!ops.empty()) {
        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
    }

    if (values.empty()) {
        throw new IllegalArgumentException("Invalid expression: empty value stack");
    }

    double result = values.pop();

    if (!values.empty()) {
        throw new IllegalArgumentException("Invalid expression: leftover values in stack");
    }

    return result;
}

    public static boolean hasPrecedence(char op1, char op2)
    {
        if(op2 == '(' || op2 == ')')
        {
            return false;
        }
        if((op1 == '*' || op1 == '/') &&(op2 == '+' || op2 == '-'))
        {
            return false;
        }
        return true;
    }
    public static double applyOp(char op, double b, double a)
    {
        switch (op)
        {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;

        }
        return 0;
    }

}


