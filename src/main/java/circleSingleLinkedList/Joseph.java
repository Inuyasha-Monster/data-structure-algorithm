package circleSingleLinkedList;

/**
 * @author djl
 * @create 2020/12/8 11:18
 * 约瑟夫问题:一群孩子(数量:num)形成一个环状的链表,指定某个孩子n开始计数count次,等到count达到的那个孩子出圈,接着由出圈孩子的下一个孩子
 * 开始重复计数直到环形上只有一个孩子的时候游戏结束,求依次出圈的孩子的序号(孩子的序号是从1->num)
 * 思考:
 * n的范围是1到num
 * count的范围大于1
 * 出圈:针对环形单链表的删除操作,需要当前节点的前一个结点指针辅助,因为是单链表的关系
 * <p>
 * 例如: 1->2->3->4->5->6 num=6 指定2孩子开始计数3出圈,依次出圈的结果为:
 * 4->1->5->3->6->2 也就是说:2孩子获得了游戏的胜利
 */
public class Joseph {

    public static void main(String[] args) {
        Joseph joseph = new Joseph();
//        joseph.createJosephCircle(5);
//        joseph.show();

        // 1->2->3->4->5->6
        // 出圈: 4->1->5->3->6->2
        joseph.outCircle(6, 2, 3);
    }

    private Boy first = null;

    /**
     * 按照指定的位置以及指定的计数开始出圈
     * 注意方法破坏了原先的环状结构
     *
     * @param point
     * @param count
     */
    public void outCircle(int num, int point, int count) {

        // 按照指定数量构建约瑟夫环
        createJosephCircle(num);
        if (first == null) {
            System.out.println("创建环失败");
            return;
        }

        // 检查
        if (point < 1 || point > num) {
            System.out.println("porint error:" + point);
            return;
        }
        if (count <= 1) {
            System.out.println("count 错误 = " + count);
            return;
        }

        // 1.出圈:针对环形单链表的删除操作,需要当前节点的前一个结点指针辅助,因为是单链表的关系
        Boy temp = first;
        while (temp.next != null) {
            if (temp.next == first) {
                break;
            }
            temp = temp.next;
        }
        // temp此时是尾部节点跟随first节点,cur初始的时候指向first节点
        Boy cur = first;
        // 2.使temp,cur指针移动到point处,让cur指向point所在的boy,例如:point=2 表示从第2个孩子开始数
        for (int i = 1; i < point; i++) {
            cur = cur.next;
            temp = temp.next;
        }

        // 3.从cur的地方开始计数count次(temp依然跟随)之后对应的cur出圈直到环上只有一个元素为止
        while (true) {
            // 表示环状只有一个节点
            if (cur.next == cur) {
                System.out.println("最后出圈:" + cur.id);
                break;
            }
            // 按照计数移动cur到需要出圈的位置,temp就是出圈位置的前一个位置
            for (int i = 0; i < count - 1; i++) {
                cur = cur.next;
                temp = temp.next;
            }
            // 当前cur指向的节点出圈
            System.out.println("出圈:" + cur.id);
            // 出圈操作
            temp.next = cur.next;
            // 出圈之后cur后移
            cur = cur.next;
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("空");
            return;
        }
        Boy cur = first;
        while (cur != null) {
            System.out.println(cur);
            if (cur.next == first) {
                break;
            }
            cur = cur.next;
        }
    }

    //构建一个指定孩子数量的环形单链表
    public void createJosephCircle(int num) {
        if (num <= 1) {
            System.out.println("num 值错误");
            return;
        }
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy();
            boy.id = i;
            if (first == null) {
                first = boy;
                boy.next = first;
                continue;
            }
            // 依次添加到尾部
            Boy cur = first;
            while (cur.next != null) {
                if (cur.next == first) {
                    break;
                }
                cur = cur.next;
            }
            cur.next = boy;
            boy.next = first;
        }
    }
}
