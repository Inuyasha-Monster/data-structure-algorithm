package linkedlist;

/**
 * @author djl
 * @create 2020/12/7 11:13
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.show();

        final HeroNode heroNode = new HeroNode();
        heroNode.setNo("1");
        heroNode.setName("张三");
        heroNode.setNickName("张三");
        singleLinkedList.addNode(heroNode);
        singleLinkedList.addNode(heroNode); // 添加相同的元素测试
        singleLinkedList.show();

        System.out.println("添加王五测试");
        final HeroNode heroNode2 = new HeroNode();
        heroNode2.setNo("2");
        heroNode2.setName("王五");
        heroNode2.setNickName("王五1");
        singleLinkedList.addNode(heroNode2);
        singleLinkedList.show();

        System.out.println("测试更新");
        HeroNode updateHero = new HeroNode();
        updateHero.setNo("2");
        updateHero.setName("xx");
        updateHero.setNickName("xx1");
        singleLinkedList.updateNode(updateHero);
        singleLinkedList.show();

        System.out.println();
        final HeroNode heroNode3 = new HeroNode();
        heroNode3.setNo("3");
        heroNode3.setName("sdasda");
        heroNode3.setNickName("asdasdadsadsd");
        singleLinkedList.addNode(heroNode3);
        singleLinkedList.show();

        System.out.println();
        final HeroNode heroNode4 = new HeroNode();
        heroNode4.setNo("4");
        heroNode4.setName("sdasda");
        heroNode4.setNickName("asdasdadsadsd");
        singleLinkedList.add(heroNode4);
        singleLinkedList.show();

        System.out.println("测试删除1和3");
        singleLinkedList.deleteNode("3");
        singleLinkedList.deleteNode("1");
        singleLinkedList.show();

        System.out.println("测试按id正向顺序插入");
        final HeroNode heroNode1 = new HeroNode();
        heroNode1.setIdx(2);
        heroNode1.setName("djl");
        heroNode1.setNickName("djl");
        heroNode1.setNo("djl");
        singleLinkedList.insert(heroNode1);
        singleLinkedList.show();

        System.out.println("插入id=1的node");
        HeroNode temp = new HeroNode();
        temp.setIdx(1);
        temp.setName("fuck");
        singleLinkedList.insert(temp);
        singleLinkedList.show();

        System.out.println("测试根据no查询name");
        String no = "4";
        final String name = singleLinkedList.getName(no);
        if (name != null) {
            System.out.println("name = " + name);
        } else {
            System.out.println("no:" + no + " 没找数据");
        }

        System.out.println("测试获取链表有效数据个数");

        final int length = SingleLinkedListPlus.getLength(singleLinkedList);
        System.out.println("length = " + length);

//        HeroNode{idx=0, no='2', name='xx', nickName='xx1'}
//        HeroNode{idx=0, no='4', name='sdasda', nickName='asdasdadsadsd'}
//        HeroNode{idx=1, no='null', name='fuck', nickName='null'}
//        HeroNode{idx=2, no='djl', name='djl', nickName='djl'}

        System.out.println("测试:查找单链表中的倒数第 k 个结点 ");

        final HeroNode result = SingleLinkedListPlus.get(4, singleLinkedList);
        System.out.println("result = " + result);


        System.out.println("单链表的反转【腾讯面试题，有点难度】");
        SingleLinkedListPlus.reverse(singleLinkedList);
        singleLinkedList.show();

        System.out.println("单链表的反转通过栈的方式");
        SingleLinkedListPlus.reverseByStack(singleLinkedList.getHeadNode());
        singleLinkedList.show();


        System.out.println("测试2个有序链表合并为一个有序链表");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        final HeroNode node11 = new HeroNode();
        node11.setIdx(1);
        final HeroNode node12 = new HeroNode();
        node12.setIdx(3);
        final HeroNode node13 = new HeroNode();
        node13.setIdx(5);
        singleLinkedList1.add(node11);
        singleLinkedList1.add(node12);
        singleLinkedList1.add(node13);

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        final HeroNode node21 = new HeroNode();
        node21.setIdx(2);
        final HeroNode node22 = new HeroNode();
        node22.setIdx(4);
        final HeroNode node23 = new HeroNode();
        node23.setIdx(6);
        singleLinkedList2.add(node21);
        singleLinkedList2.add(node22);
        singleLinkedList2.add(node23);

        singleLinkedList1.show();
        System.out.println();
        singleLinkedList2.show();

        System.out.println("反转...");
        SingleLinkedListPlus.MergeLinkedList(singleLinkedList1.getHeadNode(), singleLinkedList2.getHeadNode());
        singleLinkedList1.show();
        System.out.println();
        singleLinkedList2.show();
    }

    // 定义链表头节点
    private HeroNode headNode = new HeroNode();

    public HeroNode getHeadNode() {
        return headNode;
    }

    public String getName(String no) {
        if (no == null && no.trim().isEmpty()) {
            return null;
        }
        HeroNode temp = this.headNode.getNext();
        while (temp != null) {
            if (temp.getNo() != null && temp.getNo().equals(no)) {
                return temp.getName();
            }
            temp = temp.getNext();
        }
        return null;
    }

    // 打印链表
    private void show() {
        HeroNode temp = headNode.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    // 直接添加到尾部
    public void add(HeroNode node) {
        HeroNode temp = headNode;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                break;
            }
            temp = temp.getNext();
        }
    }

    // 添加节点到链表尾部(需要判断是否存在相同节点编号)
    private void addNode(HeroNode node) {
        HeroNode temp = headNode;
        // 遍历到链表尾部
        while (true) {
            // 找到尾部节点
            if (temp.getNext() == null) {
                temp.setNext(node);
                break;
            }

            if (temp.getNext().getNo() == node.getNo()) {
                System.out.println("已经存在相同元素:" + node.getNo());
                return;
            }

            temp = temp.getNext();
        }
    }

    // 修改某个节点数据(需要判断是否存在此节点以及链表为空)
    private void updateNode(HeroNode node) {
        HeroNode temp = headNode.getNext();
        if (temp == null) {
            System.out.println("链表空");
            return;
        }
        boolean exists = false;
        // 遍历到链表尾部寻找需要修改的节点是否存在
        while (temp != null) {
            if (temp.getNo() == node.getNo()) {
                // 找到节点直接退出循环
                exists = true;
                break;
            }
            temp = temp.getNext();
        }
        // 判断找到节点修改数据
        if (exists) {
            temp.setName(node.getName());
            temp.setNickName(node.getNickName());
            System.out.println("找到节点修改完成");
            return;
        }
        System.out.println("没找到修改节点");
    }

    // 删除某一个元素(需要一个辅助变量来判断)
    private void deleteNode(String no) {
        HeroNode first = headNode.getNext();
        if (first == null) {
            System.out.println("链表空");
            return;
        }
        HeroNode cur = this.headNode;
        while (cur.getNext() != null) {
            // 当前节点的下一个节点如果符合删除要求
            if (cur.getNext().getNo().equals(no)) {
                // 设置当前节点的下一个节点 = 当前节点的下下一个节点 被跳过的节点就从链表当中移除了 jvm负责回收
                cur.setNext(cur.getNext().getNext());
                break;
            }
            cur = cur.getNext();
        }
    }

    // 插入一个节点,要求:插入节点的序号在链表当中是正序放置
    public void insert(HeroNode node) {
        HeroNode temp = this.headNode;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                return;
            }
            if (temp.getNext().getIdx() > node.getIdx()) {
                node.setNext(temp.getNext());
                temp.setNext(node);
                break;
            }
            temp = temp.getNext();
        }
    }
}
