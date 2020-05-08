package linkedlist;

/**
 * @author kaixuan
 * @version 1.0
 * @date 28/4/2020 下午1:06
 * <p>
 * 单链表 实现水浒传英雄排行榜
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node(1, "宋江");
        Node node2 = new Node(2, "卢俊义");
        Node node3 = new Node(3, "吴用");
        Node node4 = new Node(4, "林冲");

        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node4);

        System.out.println(SingleLinkedList.printFromBackToFront(singleLinkedList.getHead()));

    }

}


class SingleLinkedList {
    //先初始化一个头结点
    private Node head = new Node(0, "");

    public Node getHead() {
        return head;
    }


    /**
     * 从尾到头打印单链表(百度笔试题)
     * 方式1：先将单链表翻转，再遍历即可，不过这样会破坏单链表的结构（不可取）
     * 方式2：利用栈这个数据结构，先进后出
     * 方式3：递归
     */
    public static Node printFromBackToFront(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node node = printFromBackToFront(head.next);

        return node;
    }


    /**
     * 单链表的反转(腾讯笔试题)
     * 思路：先定义一个新的节点，reverseNode，
     * 每遍历一个节点，就把该节点指向reverseNode的前端
     * 最后把原来链表的head.next=reverseNode.next
     */
    public static void reverseList(Node head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助变量的指针,帮助遍历链表
        Node temp = head.next;
        //指向当前节点temp的下一个节点
        Node next = null;
        Node reverseNode = new Node(0, "");
        while (temp != null) {
            //将下个节点先保存起来
            next = temp.next;
            //将temp的下一个节点指向reverseNode的最前端
            temp.next = reverseNode.next;
            //将temp连接到新的链表
            reverseNode.next = temp;
            temp = next;
        }
        head.next = reverseNode.next;
        System.out.println(head);
    }


    /**
     * 得到倒数第K个节点(新浪笔试题)
     * 思路：先得到链表的长度，链表长度减K就是节点的位置。
     *
     * @param k
     * @param head
     * @return
     */
    public Node kNode(int k, Node head) {
        //先得到单链表长度
        int nodeLength = SingleLinkedList.nodeLength(head);
        //链表长度-K得到倒数第K个节点的位置
        int length = nodeLength - k;

        Node temp = head.next;
        for (int i = 0; i < length; i++) {
            temp = temp.next;
        }
        return temp;

    }


    /**
     * 得到单链表节点的个数
     */
    public static int nodeLength(Node node) {
        Node temp = node;
        int length = 0;
        while (true) {
            if (temp.next == null) {
                break;
            }
            length++;
            temp = temp.next;
        }
        return length;
    }


    public void add(Node node) {
        //创建一个辅助变量
        Node temp = head;
        while (true) {
            //找到了链表的最后
            if (temp.next == null) {
                break;
            }
            //循环结束，temp就只指向了链表的最后
            temp = temp.next;
        }
        //将节点加入到变量的后边
        temp.next = node;
    }

    /**
     * 按照node.no的顺序来添加
     *
     * @param node
     */
    public void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }

            //如果temp.next.no>node.no，就在temp的后面插入
            if (temp.next.no > node.no) {
                break;
            }
            //说明添加的节点已经存在
            if (temp.next.no == node.no) {
                flag = true;
            }
            temp = temp.next;

        }

        if (flag) {
            System.out.println("节点已经存在");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void update(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == node.no) {
                temp.next.name = node.name;
            }
            temp = temp.next;
        }
    }


    public void delete(int no) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //应为头结点不能动，所以需要一个辅助变量来遍历
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移，
            temp = temp.next;
        }
    }


}


class Node {
    public int no;
    public String name;
    //指向下一个节点
    public Node next;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
