package queue;

/**
 * @author kaixuan
 * @version 1.0
 * @date 27/4/2020 下午8:42
 * 数组实现环形队列
 */
public class CircleQueueDemo {

    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4);
        circleArray.addQueue(1);
        circleArray.addQueue(2);
        circleArray.addQueue(3);
        System.out.println("取出的数据：==============");
        System.out.println(circleArray.getQueue());

        System.out.println("剩余的数据================");
        circleArray.showQueue();

    }
}


class CircleArray{
    //最大容量
    private int maxSize;
    //指向队列的第一个元素，初始值为0
    private int front;
    //指向队列的后一个元素的后一个位置，初始值为0
    private int rear;
    //模拟队列数组
    private int[]arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr=new int [maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }


    public boolean isEmpty() {
        return rear==front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value =arr[front];
        front=(front+1)%maxSize;
        return value;
    }


    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //队列中有效的数据个数
        int size = (rear + maxSize - front) % maxSize;
        for (int i = front; i <front+size; i++) {
            System.out.println(arr[i%maxSize]);
        }
    }


}