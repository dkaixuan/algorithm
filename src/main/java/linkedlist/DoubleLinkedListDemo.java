package linkedlist;

import java.beans.beancontext.BeanContext;

/**
 * @author kaixuan
 * @version 1.0
 * @date 30/4/2020 下午9:14
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node1 node1 = new Node1(1,"kaikai");
        Node1 node2= new Node1(2,"太牛了");
        Node1 node3= new Node1(3,"hhhh");

//        DoubleLinkedList.add(node1);
//        DoubleLinkedList.add(node2);
//        DoubleLinkedList.add(node3);
//        DoubleLinkedList.delete(1);
//        DoubleLinkedList.list();

        DoubleLinkedList.addOrderByNo(node3);
        DoubleLinkedList.addOrderByNo(node2);
        DoubleLinkedList.addOrderByNo(node1);
        DoubleLinkedList.list();

    }

}


class DoubleLinkedList{

    public static Node1 head = new Node1(0,"");

    public static void add(Node1 node) {
        Node1 temp=head;
        while (temp.next != null) {
            temp=temp.next;
        }
        temp.next=node;
        node.pre=temp;
    }


    /**
     * 双向链表的顺序添加
     * @param node1
     */
    public static void addOrderByNo(Node1 node1) {
        Node1 temp=head;
        boolean flag=false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node1.no) {
                break;
            }
            if (temp.next.no == node1.no) {
                flag=true;
            }
            temp=temp.next;
        }
        if (flag) {
            System.out.println("节点已经存在");
        }else {
            //将node放在temp的后边，temp、node、temp.next
            node1.next=temp.next;
            temp.next=node1;
            temp.next.pre=node1;
            node1.pre=temp;
        }
    }




    public static void delete(int no) {
        Node1 temp=head;
        while (temp.next != null) {
            if (temp.no == no) {
                temp.next.pre=temp.pre;
                temp.pre.next=temp.next;
            }
            temp = temp.next;
        }
    }




    public static void list() {
        Node1 temp=head.next;
        while (temp != null) {
            System.out.println(temp);
            temp=temp.next;
        }

    }



}

class Node1{

    public int no;
    public String name;
    public Node1 pre;
    public Node1 next;


    public Node1(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}