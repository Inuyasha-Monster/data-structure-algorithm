package doubleLinkedList;

/**
 * @author djl
 * @create 2020/12/7 21:51
 */
public class DoubleLinkedList {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        Node node1 = new Node();
        node1.id = 1;
        node1.name = "djl";
        doubleLinkedList.add(node1);

        Node node2 = new Node();
        node2.id = 2;
        node2.name = "wangjie";
        doubleLinkedList.add(node2);

        doubleLinkedList.show();

        System.out.println("update");
        Node node = new Node();
        node.id = 2; //3;
        node.name = "憨憨";
        doubleLinkedList.update(node);
        doubleLinkedList.show();

        System.out.println("delete");
        doubleLinkedList.delete(2);
        doubleLinkedList.show();

        System.out.println("get");
        String name = doubleLinkedList.get(1);
        if (name != null) {
            System.out.println("name = " + name);
        } else {
            System.out.println("get null");
        }

        System.out.println("addOrderById");
        Node node3 = new Node();
        node3.id = 0;
        node3.name = "djl-0";
        doubleLinkedList.addOrderById(node3);

        Node node4 = new Node();
        node4.id = -1;
        node4.name = "djl-plus";
        doubleLinkedList.addOrderById(node4);

        doubleLinkedList.show();
    }

    private Node head = new Node();

    public void addOrderById(Node node) {
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.id > node.id) {
                Node temp = cur.next;
                cur.next = node;
                node.pre = cur;
                node.next = temp;
                temp.pre = node;
                break;
            }
            cur = cur.next;
        }
        cur.next = node;
        node.pre = cur;
    }

    public void add(Node node) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        node.pre = cur;
    }

    public void show() {
        Node cur = head;
        while (cur.next != null) {
            System.out.println(cur.next);
            cur = cur.next;
        }
    }

    public void update(Node node) {
        Node cur = head;
        boolean exist = false;
        while (cur.next != null) {
            if (cur.next.id == node.id) {
                cur.next.name = node.name;
                exist = true;
                break;
            }
            cur = cur.next;
        }
        if (!exist) {
            System.out.println("数据不存在");
        }
    }

    public void delete(int id) {
        Node cur = head;
        boolean exist = false;
        while (cur.next != null) {
            if (cur.next.id == id) {
                if (cur.next.next != null) {
                    cur.next.next.pre = cur;
                }
                // 越过需要删除的节点
                cur.next = cur.next.next;
                exist = true;
                break;
            }
            cur = cur.next;
        }
        if (!exist) {
            System.out.println("数据不存在");
        }
    }

    public String get(int id) {
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.id == id) {
                return cur.next.name;
            }
            cur = cur.next;
        }
        return null;
    }
}
