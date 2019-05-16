package com.intellect.mycalculatoedemo;

import java.util.Stack;

public class Calculation {
    char[] bodmas= { '*' , '/' , '+' , '-' };
    int[] num= {0,0,1,1,2,2,3,3};

    public boolean isOperator(char t)
    {
        int i;
        for(i=0; i< bodmas.length ; i++) {
            if (t == bodmas[i])
                return true;
        }
        return false;
    }

    float calculate(String expression) {
        try {
            char[] tokens = expression.toCharArray();

            Stack<Float> values = new Stack<Float>();

            Stack<Character> bracket = new Stack<Character>();

            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i] == ' ')
                    continue;

                if (!isOperator(tokens[i])) {
                    StringBuilder s = new StringBuilder();
                    while (i < tokens.length && tokens[i] != ' ' && !isOperator(tokens[i]))
                        s.append(tokens[i++]);
                    values.push(Float.parseFloat(s.toString()));
                } else if (tokens[i] == '(')
                    bracket.push(tokens[i]);

                else if (tokens[i] == ')') {
                    while (bracket.peek() != '(')
                        values.push(applyOp(bracket.pop(), values.pop(), values.pop()));
                    bracket.pop();
                } else if (isOperator(tokens[i])) {
                    while (!bracket.empty() && hasPrecedence(tokens[i], bracket.peek()))
                        values.push(applyOp(bracket.pop(), values.pop(), values.pop()));
                    bracket.push(tokens[i]);
                }
            }
            while (!bracket.empty())
                values.push(applyOp(bracket.pop(), values.pop(), values.pop()));

            return values.pop();
        }catch (Exception ee){
            return -1;
        }
    }

    public boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        int op1p = getPrecedence(op1);
        int op2p = getPrecedence(op2);
        if (op2p > op1p)
            return false;
        else
            return true;
    }

    public float applyOp(char op, float b, float a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;

        }
        return 0;
    }

    public int getPrecedence(char c) {
        int i;
        for (i = 0; i < bodmas.length; i++) {
            if (c == bodmas[i])
                break;
        }
        return num[i];
    }
}

