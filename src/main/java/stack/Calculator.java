package stack;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020年5月7日 下午1:44
 * 栈实现综合计算器 中缀表达式
 * 思路: 两个栈，一个操作数栈，一个操作符栈，操作符往栈里push的时候，判断栈是否为空，为空直接push，不为空，判断要加入的操作符
 * 和栈顶的操作符优先级进行比较，如果小于等于，就pop出两个数，和栈顶的操作符进行运算，计算完成，再把计算完成的数push回去，再把要加入的计算符
 * push到操作符栈，如果大于就直接入栈，
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "100+2*5-6";

        Stack2 operatorStack = new Stack2(10);
        Stack2 numStack = new Stack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int result = 0;
        char c = ' ';
        String num = "";
        while (true) {
            //取出表达式的每一个字符
            c = expression.substring(index, index+1).charAt(0);
            //判断当前字符是否是操作符
            if (operatorStack.isOperator(c)) {
                //如果为空直接入栈
                if (operatorStack.isEmpty()) {
                    operatorStack.push(c);
                }else {
                    //如果当前操作符优先级小于栈顶操作符，从数栈中pop两个数，从操作符栈顶pop一个运算符
                    if (operatorStack.priority(c) <= operatorStack.priority(operatorStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operatorStack.pop();
                        result = operatorStack.calculator(num1, num2, operator);
                        numStack.push(result);
                        operatorStack.push(c);
                    }else {
                        //优先级比栈中操作符大直接push
                        operatorStack.push(c);
                    }
                }
            } else {
                //如果当前不是操作符，是数字直接入栈,因为字符c是字符，和数字ASCII差了48
                //numStack.push(c-48);
                //bugFix解决不能多位数的加减乘除
                num+=c;
                //如果c已经到了expression的最后一位，则直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.valueOf(num));
                }else {
                    char c1 = expression.substring(index+1,index+2).charAt(0);
                    if (numStack.isOperator(c1)) {
                        numStack.push(Integer.valueOf(num));
                        num = "";
                    }
                }


            }
            index++;
            //如果index==expression.length，退出
            if (index == expression.length()) {
                break;
            }
        }

        //计算栈中剩余的值
        while (true) {
            if (operatorStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operatorStack.pop();
            result = operatorStack.calculator(num1, num2, operator);
            numStack.push(result);
            //到最后数栈中只有一个结果
        }
        System.out.println(numStack.peek());


    }


}


class Stack2 {

    private int maxTop;
    //top表示栈顶
    private int top = -1;
    private int[] arr;

    public Stack2(int maxTop) {
        this.maxTop = maxTop;
        this.arr = new int[maxTop];
    }

    public boolean isFull() {
        return top == maxTop - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 返回操作符优先级
     *
     * @param operator
     * @return
     */
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 计算方法
     *
     * @param num1
     * @param num2
     * @param operator
     * @return
     */
    public int calculator(int num1, int num2, int operator) {
        int result = 0;
        if (operator == '+') {
            result = num2 + num1;
        } else if (operator == '-') {
            result = num2 - num1;
        } else if (operator == '*') {
            result = num2 * num1;
        } else if (operator == '/') {
            result = num2 / num1;
        }
//
//        switch (operator) {
//            case '+':
//                result = num2 + num1;
//            case '-':
//                result = num2 - num1;
//            case '*':
//                result = num2 * num1;
//            case '/':
//                result = num2 / num1;
//            default:
//                break;
//
//        }
        return result;
    }

    public boolean isOperator(char val) {
        if (val == '+' || val == '-' || val == '*' || val == '/') {
            return true;
        }
        return false;
    }


    public void push(int n) {
        if (isFull()) {
            throw new RuntimeException("栈空间已满");
        }

        arr[++top] = n;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空间为空");
        }
        int value = arr[top];
        top--;

        return value;
    }


    /**
     * 返回栈顶的元素
     *
     * @return
     */
    public int peek() {
        return arr[top];
    }

    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }


}