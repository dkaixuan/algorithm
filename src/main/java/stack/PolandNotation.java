package stack;

import java.util.Stack;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020年5月7日 下午10:06
 * 逆波兰表达式（后缀表达式）实现计算器
 * 如果当前位置是 数字，则直接入栈，如果是操作符，则从栈中pop出两个数，进行计算，并将计算出的结果push到栈中
 */
public class PolandNotation {

    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";
        split(suffixExpression);

    }




    public static void split(String suffixExpression) {
        String[] s = suffixExpression.split(" ");
        Stack<Integer> stack = new Stack();
        for (String item : s) {
            if (item.matches("\\d+")){
                stack.push(Integer.parseInt(item));
            }else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = calculate(num1, num2, item);
                stack.push(result);
            }
        }
        //栈中的最后一个数就是结果
        Integer pop = stack.pop();
        System.out.println(pop);

    }


    public static int calculate(int num1,int num2,String item) {
        int result=0;
        if ("+".equals(item)) {
            result=num1+num2;
        } else if ("-".equals(item)) {
            result=num2-num1;
        } else if ("*".equals(item)) {
            result = num1 * num2;
        } else if ("/".equals(item)) {
            result = num2 / num1;
        }
        return result;
    }

}
