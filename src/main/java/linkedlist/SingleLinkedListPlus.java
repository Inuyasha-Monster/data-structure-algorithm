package linkedlist;

import java.util.Stack;

/**
 * @author djl
 * @create 2020/12/7 14:59
 */
public class SingleLinkedListPlus {
    /**
     * 获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
     *
     * @return
     */
    public static int getLength(SingleLinkedList linkedList) {
        HeroNode temp = linkedList.getHeadNode();
        int count = 0;
        while (temp.getNext() != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    // 查找单链表中的倒数第 k 个结点 【新浪面试题】
    public static HeroNode get(int k, SingleLinkedList linkedList) {

        if (k <= 0) {
            System.out.println("错误 k = " + k);
            throw new RuntimeException("k 错误");
        }

        // 思路:遍历一次获取总的长度length,然后length-k就是结果
        HeroNode temp = linkedList.getHeadNode().getNext();
        if (temp == null) {
            System.out.println("链表为空");
            return null;
        }
        int counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.getNext();
        }
        if (k > counter) {
            System.out.println("错误 k = " + k + ", count:" + counter);
            return null;
        }
        // 例如 一共5 倒数第2个 也就是正数第3个
        HeroNode cur = linkedList.getHeadNode();
        for (int i = 0; i < counter - k + 1; i++) {
            cur = cur.getNext();
        }
        return cur;
    }

    // 单链表的反转【腾讯面试题，有点难度】
    public static void reverse(SingleLinkedList linkedList) {
        // 思考: 可以采用遍历一个元素,就把这个元素插入到另外一个链表头部,最后将原始链表头部指向新的链表即可
        // 第二种方式采取数据结构:栈 解决也行
        // 我这里完成第一种方式
        HeroNode temp = linkedList.getHeadNode().getNext();
        if (temp == null || temp.getNext() == null) {
            System.out.println("链表为空或者只有一个元素不用反转");
            return;
        }
        HeroNode newHead = new HeroNode();
        // 遍历原始链表取数据插入到新的链表头部
        while (temp != null) {
            // 暂存当前节点的下一个节点后面 temp = next; 赋值保持原始链表持续遍历
            final HeroNode next = temp.getNext();
            // 将temp插入链表头部
            insertHead(newHead, temp);
            temp = next;
        }
        // 将原始头指针指向新的头指针的后续
        linkedList.getHeadNode().setNext(newHead.getNext());
    }

    private static void insertHead(HeroNode head, HeroNode temp) {
        // 清空原始链表关系
        temp.setNext(null);
        HeroNode first = head.getNext();
        if (first == null) {
            head.setNext(temp);
            return;
        }

        // 举例: 1 2 3 , 插入4 , 4 1 2 3

        // 将插入节点后续设置为原始头指针的下一个节点
        temp.setNext(head.getNext());
        // 将头指针设置为插入节点
        head.setNext(temp);
    }

    // 利用栈的特性反转单链表
    public static void reverseByStack(HeroNode head) {
        // 思路:遍历单链表压栈,然后出栈
        HeroNode temp = head.getNext();
        if (temp == null || temp.getNext() == null) {
            System.out.println("链表为空或者只有一个元素不用反转");
            return;
        }
        // head->1->2->3->4
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null) {
            final HeroNode next = temp.getNext();
            temp.setNext(null);
            stack.push(temp);
            temp = next;
        }
        // newHead->4->3->2->1
        HeroNode newHead = new HeroNode();
        while (!stack.isEmpty()) {
            final HeroNode node = stack.pop();
            if (newHead.getNext() == null) {
                newHead.setNext(node);
                continue;
            }
            // 依次加入新的链表尾部
            HeroNode loop = newHead.getNext();
            while (loop != null) {
                if (loop.getNext() == null) {
                    loop.setNext(node);
                    break;
                }
                loop = loop.getNext();
            }
        }
        head.setNext(newHead.getNext());
    }
}
