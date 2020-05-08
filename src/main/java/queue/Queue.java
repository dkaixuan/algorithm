package queue;

/**
 * @author kaixuan
 * @version 1.0
 * @date 27/4/2020 下午3:55
 * 数组实现队列
 */
public class Queue {


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);

        System.out.println("取出一个数据");
        System.out.println(arrayQueue.getQueue());
        System.out.println("显示所有数据");
        arrayQueue.showQueue();
        System.out.println("取出头数据");
        System.out.println(arrayQueue.headQueue());
    }





}



class ArrayQueue{
    //最大容量
    private int maxSize;
    //指向队列头的前一个数据
    private int front;
    //指向队列尾的数据
    private int rear;
    //模拟队列数组
    private int[]arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr=new int [maxSize];
        this.front=-1;
        this.rear=-1;
    }

    public boolean isFull() {
        return rear==maxSize-1;
    }

    public boolean isEmpty() {
        return rear==front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }

        arr[++rear]=n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }

    //显示剩下的全部队列
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front+1; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }




}
