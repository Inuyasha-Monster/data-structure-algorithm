package circleSingleLinkedList;

/**
 * @author djl
 * @create 2020/12/8 9:36
 * 单向环形链表也就是首尾相连
 */
public class CircleSingleLinkedList {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        Node node = new Node();
        node.id = 0;
        circleSingleLinkedList.add(node);

        Node node1 = new Node();
        node1.id = 1;
        circleSingleLinkedList.add(node1);


        Node node2 = new Node();
        node2.id = 2;
        node2.name = "node2";
        circleSingleLinkedList.add(node2);

        circleSingleLinkedList.show();

        System.out.println("update");
        Node nodeUpdated = new Node();
        nodeUpdated.id = 2;
        nodeUpdated.name = "node2Updated";
        circleSingleLinkedList.update(nodeUpdated);
        circleSingleLinkedList.show();

        System.out.println("delete");
        circleSingleLinkedList.delete(1);
        circleSingleLinkedList.show();

        System.out.println("get");
        final String name = circleSingleLinkedList.get(2);
        System.out.println("name = " + name);

//        Node{id=0, name='null'}
//        Node{id=2, name='node2Updated'}
        System.out.println("insertOrderById");
        Node insert = new Node();
        insert.id = 1;
        insert.name = "insert";
        circleSingleLinkedList.insertOrderById(insert);
        circleSingleLinkedList.show();

        System.out.println("insertOrderById test");
        Node insert2 = new Node();
        insert2.id = 0;
        insert2.name = "insert2";
        circleSingleLinkedList.insertOrderById(insert2);
        circleSingleLinkedList.show();
    }

    private Node firstNode = null;

    public String get(int id) {
        Node curNode = firstNode;
        if (curNode == null) {
            System.out.println("空环形链表");
            return null;
        }
        while (curNode != null) {
            if (curNode.id == id) {
                return curNode.name;
            }
            if (curNode.next == firstNode) {
                break;
            }
            curNode = curNode.next;
        }
        return null;
    }

    public void show() {
        Node curNode = firstNode;
        if (curNode == null) {
            System.out.println("空环形链表");
            return;
        }
        while (curNode != null) {
            System.out.println(curNode);
            if (curNode.next == firstNode) {
                break;
            }
            curNode = curNode.next;
        }
    }

    public void insertOrderById(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("node is null");
        }
        Node curNode = firstNode;
        if (curNode == null) {
            System.out.println("空环形链表");
            return;
        }
        // 首先找打尾部节点temp
        Node temp = firstNode;
        while (temp != null) {
            if (temp.next == firstNode) {
                break;
            }
            temp = temp.next;
        }

        boolean exists = false;
        while (curNode != null) {
            if (curNode.id > node.id) {
                temp.next = node;
                node.next = curNode;
                exists = true;
                break;
            }
            if (curNode.next == firstNode) {
                break;
            }
            // 前一个节点后移
            curNode = curNode.next;
            // 后一个节点后移
            temp = temp.next;
        }

        if (exists == false) {
            // 如果最后没有找到位置插入直接放置在尾部
            curNode.next = node;
            node.next = firstNode;
        }
    }

    public void delete(int id) {
        Node curNode = firstNode;
        if (curNode == null) {
            System.out.println("空环形链表");
            return;
        }
        // 首先找打尾部节点temp
        Node temp = firstNode;
        while (temp != null) {
            if (temp.next == firstNode) {
                break;
            }
            temp = temp.next;
        }

        // 如果要删除环形单链表,需要首先找到需要删除节点的前一个节点 curNode->头节点 temp->尾部节点 形成一前一后一起推进的方式遍历
        while (curNode != null) {
            // 找到需要删除的节点
            if (curNode.id == id) {
                // 取消删除节点的链条
                temp.next = curNode.next;
                // 判断如果删除的是头节点需要重置头节点(这里很重要)
                if (curNode == firstNode) {
                    firstNode = temp.next;
                }
                break;
            }
            if (curNode.next == firstNode) {
                // 表示找了一圈了都没找到需要删除的节点
                break;
            }
            // 前一个节点后移
            curNode = curNode.next;
            // 后一个节点后移
            temp = temp.next;
        }
    }

    public void update(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("node is null");
        }
        Node curNode = firstNode;
        if (curNode == null) {
            System.out.println("空环形链表");
            return;
        }
        while (curNode != null) {
            if (curNode.id == node.id) {
                curNode.name = node.name;
                break;
            }
            if (curNode.next == firstNode) {
                break;
            }
            curNode = curNode.next;
        }
    }

    public void add(Node node) {
        if (firstNode == null) {
            firstNode = node;
            firstNode.next = firstNode; // 首尾相连
            return;
        }
        Node curNode = firstNode;
        while (curNode.next != null) {
            // 如果当前节点的下一个节点就是头节点则表示遍历尾部了则退出循环
            if (curNode.next == firstNode) {
                break;
            }
            curNode = curNode.next;
        }
        curNode.next = node;
        node.next = firstNode;
    }
}
