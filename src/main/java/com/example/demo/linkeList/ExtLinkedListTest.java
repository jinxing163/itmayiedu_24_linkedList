package com.example.demo.linkeList;

/**
 * @author JinXing
 * @date 2018/5/29 14:38
 */
public class ExtLinkedListTest {

    // 第一个元素
    private Node first;
    // 最后一个元素
    private Node last;
    // 实际存放在长度
    private int size;

    class Node {
        // 上一个节点
        Node prev;
        // 节点内容
        Object object;
        // 下一个节点
        Node next;
    }

    public void add(Object e) {
        // 创建新的节点
        Node node = new Node();
        // 节点内容
        node.object = e;
        if (first == null) {
            // // 上一个节点
            // node.prev = null;
            // // 下一个节点
            // node.next = null;
            // 第一个元素和最后一个元素都是为node
            first = node;
        } else {
            // 存放上一个节点内容
            node.prev = last;
            // 设置上一个节点的next为当前节点
            last.next = node;
        }
        last = node;
        size++;
    }

    public void add(int index, Object e) {
        // 1.循环遍历到当前index位置Node
        // 2.新增当前节点
        Node newNode = new Node();
        newNode.object = e;
        // 获取原来的节点
        ExtLinkedListTest.Node olNode = getNode(index);
        // 获取原来上一个节点
        ExtLinkedListTest.Node olNodePrev = olNode.prev;

        // 4.新增节点的上一个还是当前Node节点的上一个节点,下一个就是原来的节点
        // 原来上一个节点变为当前节点
        olNode.prev = newNode;
        if (olNodePrev == null)
            first = newNode;
        else
            // 原来上一个节点的下一个节点变为当前节点
            olNodePrev.next = newNode;

        // 新节点的下一个节点为原来节点
        newNode.next = olNode;
        size++;
    }

    public Object get(int index) {
        ExtLinkedListTest.Node node = getNode(index);
        return(Object) node.object;
    }

    public Node getNode(int index) {
        Node node = null;
        if (first != null) {
            node = first;
            for (int i = 0; i<index; i++) {
                node = node.next;
            }
        }
        return node;
    }

    public void remove(int index) {
        checkElementIndex(index);
        ExtLinkedListTest.Node node = getNode(index);
        if (node != null) {
            ExtLinkedListTest.Node prevNode = node.prev;
            ExtLinkedListTest.Node nextNode = node.next;
            // 设置上一个节点的next为当前删除节点的next
            if (prevNode != null) {
                prevNode.next = nextNode;
            }

            // 判断是否是最后一个节点
            if (nextNode != null) {
                nextNode.prev = prevNode;
            }

        }
        size--;
    }

    public static void main(String[] args) {
        ExtLinkedListTest linkeList = new ExtLinkedListTest();
        linkeList.add("张三");
        linkeList.add("李四");
        linkeList.add("wawngma");
        linkeList.add("wangai");
        linkeList.add(2, "ll");
        for (int i = 0; i<linkeList.size; i++) {
            System.out.println(linkeList.get(i));
        }
    }

    private boolean isElementIndex(int index) {
        return index>= 0 &&index<size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("越界啦!");
    }


}
