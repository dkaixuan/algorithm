package stack;

import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020年5月7日 上午10:23
 * 链表模拟栈 头插 头删
 */
public class StackDemo2 {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        singleLinkedList.push(node1);
        singleLinkedList.push(node2);
        singleLinkedList.push(node3);
        singleLinkedList.push(node4);
        singleLinkedList.push(node5);
        singleLinkedList.pop();
        singleLinkedList.list();
    }



}

class SingleLinkedList{


    private Node head = new Node(0);


    public void push(Node node) {
        Node temp=head;
        if (temp.next == null) {
            temp.next=node;
        }else {
            node.next=temp.next;
            temp.next=node;
        }

    }


    public void pop() {
        Node temp=head;
        temp.next=temp.next.next;
    }

    public void list() {
        Node temp=head.next;
        if (temp == null) {
            throw new RuntimeException("链表为空");
        }

        while (true) {
            if (temp== null) {
                break;
            }
            System.out.println(temp);

            temp=temp.next;
        }
    }



}





class Node{

    public int no;
    public Node next;

    public Node(int no) {
        this.no = no;
    }


    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}

