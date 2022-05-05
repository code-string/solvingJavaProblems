package leetcodeProblems;

import java.util.Stack;

public class ReversePolishNotion {
    /***
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
     *
     * Note that division between two integers should truncate toward zero.
     *
     * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
     */

    public static int evaluateRPN(String[] array){
        int returnValue = 0;
        String operators = "-+*/";
        Stack<String> valueStack = new Stack<>();
        for(String item : array){
            if(!operators.contains(item)){
                valueStack.push(item);
            }else{
                int a = Integer.parseInt(valueStack.pop());
                int b = Integer.parseInt(valueStack.pop());
                int operatorIndex = operators.indexOf(item);
                switch (operatorIndex) {
                    case 0 -> valueStack.push(String.valueOf(b - a));
                    case 1 -> valueStack.push(String.valueOf(b + a));
                    case 2 -> valueStack.push(String.valueOf(b * a));
                    case 3 -> valueStack.push(String.valueOf(b / a));
                }
            }
        }
        returnValue = Integer.parseInt(valueStack.pop());
        return returnValue;
    }
}
