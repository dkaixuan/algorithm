package stack;

/**
 * @author kaixuan
 * @version 1.0
 * @date 6/5/2020 下午10:24
 * 数组模拟栈
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();

        System.out.println(stack.pop());
        stack.list();
    }


}

class Stack {

    private int maxTop;
    //top表示栈顶
    private int top=-1;
    private int[] arr;

    public Stack(int maxTop) {
        this.maxTop = maxTop;
        this.arr = new int[maxTop];
    }

    public boolean isFull() {
        return top == maxTop-1;
    }

    public boolean isEmpty() {
        return top==0;
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

    public void list() {
        for (int i = top; i>=0; i--) {
            System.out.println(arr[i]);
        }
    }


}
