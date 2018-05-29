package com.example.demo.linkeList;

/**
 * 链表：元素在内存中不是顺序存储的，而是通过存在元素中的指针联系到一起，每个结点包括两个部分：
 * 一个是存储 数据元素的数据域，另一个是存储下一个结点地址的指针。
 *
 * 如果要访问链表中一个元素，需要从第一个元素开始，一直找到需要的元素位置。
 * 但是增加和删除一个元素对于链表数据结构就非常简单了，只要修改元素中的指针就可以了。
 * 如果应用需要经常插入和删除元素你就需要用链表。
 *
 * @author JinXing
 * @date 2018/5/29 14:52
 */
public class ExtLinkedList {

    // 第一个元素
    private Node first;
    // 最后一个元素
    private Node last;
    // 实际存放在长度
    private int size;

    private static class Node {
        // 上一个节点
        Node prev;
        // 节点内容
        Object object;
        // 下一个节点
        Node next;
    }

    public boolean add(Object e) {

        //创建新节点
        Node node=new Node();
        node.object=e;
        addNode(node);

        return true;
    }

    private void addNode(Node node) {
        //第一个节点无值,第一个节点为当前节点
        if(first ==null){
            first=node;
        }else{
            //当前节点的上一个节点为最后一个节点
            node.prev=last;
            //当前节点为最后一个节点的下一个节点
            last.next=node;
        }
        //当前节点为最后一个节点
        last=node;
        size++;
    }

    public boolean add(int index,Object e) {
        checkElementIndex(index);
        //获取当前下标的老节点
        Node oldNode = node(index);
        //新节点
        Node newNode=new Node();
        newNode.object=e;

        //老节点上一个节点
        Node prev = oldNode.prev;
        //老节点为第一个节点
        if(prev ==null){
            first=newNode;
        }else{
            //原来上节点的下节点为新节点
            prev.next=newNode;
        }

        //原来节点的上节点为新节点
        oldNode.prev=newNode;
        //新节点的下一个节点为老节点
        newNode.next=oldNode;

        size++;
        return true;
    }

    //删除下标
    public boolean remove(int index) {
        checkElementIndex(index);
        Node node = node(index);
        unlink(node);
        return false;
    }

    //删除对象
    public boolean removeObject(Object e) {
        if(e !=null){
            Node node = node(e);
            unlink(node);
            return true;
        }
        return false;
    }

    //节点关系分离
    Object unlink(Node x) {

        //当前对象
        final Object element = x.object;
        //当前节点的下一个节点
        final Node next = x.next;
        //当前节点的上一个节点
        final Node prev = x.prev;

        //如果当前节点为第一个节点
        if(prev ==null){
            first=next;
        }else{
            //prev的下一个节点为next
            prev.next=next;
            //当前节点的上一个节点置空
            x.prev=null;

        }

        //当前节点为最后一个节点
        if(next ==null){
            last=prev;
        }else{
            //next的上一个节点为prev
            next.prev=prev;
            //当前节点的下一个节点置空
            x.next=null;
        }

        //当前节点的值置空
        x.object=null;
        --size;

        return element;

    }

    public Object get(int index) {
        checkElementIndex(index);
        return node(index).object;
    }

    //获取节点的值
    Node node(int index) {
        Node node=null;
        if(first!=null){
            node=first;
            for (int i = 0; i < index ; i++) {
                node=node.next;
            }
        }
        return node;
    }

    //获取节点的值
    Node node(Object o) {
        for (Node x = first; x != null; x = x.next) {
            if (o.equals(x.object)) {
                return x;
            }
        }
        return null;
    }

    private void checkElementIndex(int index){
        if(index <0 || index >=size){
            throw new IndexOutOfBoundsException("数组下标越界");
        }
    }

    public int size(){
        return size;
    }


}
