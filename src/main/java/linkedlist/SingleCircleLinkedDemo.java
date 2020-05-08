package linkedlist;

/**
 * @author kaixuan
 * @version 1.0
 * @date 6/5/2020 下午4:01
 * 约瑟夫问题：设编号为1，2...n的n个人围坐一圈，约定编号为k的人从1开始报数，数到m的那个人出列，它的下一位又从1开始 报数，
 * 数到m的那个人又出列，以此类推，直到所有人出列,打印出列的所有人
 * <p>
 * 单向循环列表 解决约瑟夫问题
 */
public class SingleCircleLinkedDemo {
    public static void main(String[] args) {
        SingleCircleLinked singleCircleLinked = new SingleCircleLinked();
        singleCircleLinked.addNodes(10);
        singleCircleLinked.list();

        singleCircleLinked.printCount(2,2);
    }


}

class SingleCircleLinked {

    Node3 first = null;
    //创建一个辅助变量帮助遍历
    Node3 temp = null;
    Node3 node = null;

    /**
     * temp辅助变量指向最后一个元素，first指针和temp指针一起移动
     * @param k
     * @param m
     */
    public void printCount(int k,int m) {
        //此时temp已经指向了最后
        if (k < 1||m<1) {
            throw new RuntimeException("参数错误");
        }
        //报数前，temp和first移动k-1次
        for (int i = 1; i < k; i++) {
            temp=temp.next;
            first=first.next;
        }
        //报数时，temp指针和first指针同时移动m-1次，直到剩下最后一个节点
        while (true) {
            if (first.next ==first) {
                break;
            }
            for (int j = 1; j < m; j++) {
                temp=temp.next;
                first=first.next;
            }
            System.out.println("出圈的元素=>>>"+first.no);
            //first指针指向的元素就是出圈的元素
            //将出圈的 链断开
            first=first.next;
            temp.next=first;
        }
        System.out.println("最后留在圈中的编号：=>>"+first.no);


    }



    public void addNodes(int num) {
        if (num < 1) {
            throw new RuntimeException("输入的值不正确");
        }
        for (int i = 1; i <= num; i++) {
            node = new Node3(i);
            //创建first头结点
            if (i == 1) {
                first = node;
                first.next = first;
                temp = first;
            } else {
                temp.next = node;
                node.next = first;
                //直到temp指向最后
                temp = node;
            }
        }
    }

    //打印环形列表
    public void list() {
        if (first == null) {
            throw new RuntimeException("链表为空");
        }
        temp = first;
        while (true) {
            System.out.println(temp);

            if (temp.next == first) {
                break;
            }

            temp = temp.next;
        }
    }

}


class Node3 {
    public int no;
    public Node3 next;

    public Node3(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node3{" +
                "no=" + no +
                '}';
    }
}
