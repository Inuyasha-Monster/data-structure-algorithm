package circleSingleLinkedList;

/**
 * @author djl
 * @create 2020/12/7 21:50
 */
public class Node {
    public int id;
    public String name;
    public Node next;

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
