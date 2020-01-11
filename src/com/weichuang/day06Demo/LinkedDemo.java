package com.weichuang.day06Demo;

public class LinkedDemo {
    public static void main(String[] args) {
        NodeManager nm = new NodeManager();
        nm.add(5);
        nm.add(4);
        nm.add(3);
        nm.add(2);
        nm.add(1);
       /* nm.show();
        System.out.println("--------------------");
        System.out.println(nm.find(55));
        System.out.println("--------------------");
        nm.delete(2);
        nm.show();*/
        System.out.println("--------------------");
        nm.insert(2 , 88);
        nm.show();
        System.out.println("--------------------");
        boolean isSuccess = nm.update(3 , 188);
    }

}
class NodeManager{
    private Node root;
    private int currentIndex;
    public void add(int data){
        if(null != root){
            this.root.addNode(data);
        }else{
            this.root = new Node(data);
        }
    }

    /**
     * 打印显示所有结点
     */
    public void show() {
        if(null != this.root){
            System.out.print(this.root.getData() +"->");
            this.root.showNode();
        }
    }

    public boolean find(int data) {
        if(null != this.root){
            if(this.root.getData() == data) return true;
            else return this.root.findNode(data);
        }
        return false;
    }

    public void delete(int data) {
        if(null != this.root){
            if(this.root.getData() == data){
                this.root = this.root.next;
            }else{
                this.root.deleteNode(data);
            }
        }
    }

    /**
     * 插入节点方法
     * @param index
     * @param data
     */
    public void insert(int index, int data) {
        if(0 == index){
            Node newNode = new Node(data);
            newNode.next = this.root;
            this.root = newNode;
        }else{
            this.root.insertNode(index , data);
        }
    }

    /**
     * 更新操作
     * @param index
     * @param newData
     * @return
     */
    public boolean update(int index, int newData) {

        return false;
    }

    private class Node{
        private int data;
        private Node next;

        public Node() {}

        public Node(int data) {
            this.data = data;
        }

        /**
         * 添加结点方法
         * @return
         */
        public void addNode(int data){
            if(null != this.next){
                this.next.addNode(data);
            }else{
                this.next = new Node(data);
            }
        }

        /**
         * 查询之后的每一个子结点
         */
        public void showNode() {
            if(null != this.next){
                System.out.print(this.next.data + "->");
                this.next.showNode();
            }
        }

        /**
         * 查找一个子节点是否存在
         * @param data ： 节点数据
         * @return : 返回是否查找到
         */
        public boolean findNode(int data) {
            if(null != this.next){
                if(this.next.data == data) return true;
                else return this.next.findNode(data);
            }
            return false;
        }

        /**
         * 删除一个节点
         * @param data
         */
        public void deleteNode(int data) {
            if(null != this.next){
                if(this.next.data == data){
                    this.next = this.next.next;
                }else{
                    this.next.deleteNode(data);
                }
            }
        }

        /**
         * 头插法插入节点
         */
        public void insertNode(int index , int data) {
            currentIndex ++;
            System.out.println(currentIndex);
            if(currentIndex == index){
                Node newNode = new Node(data);
                newNode.next = this.next;
                this.next = newNode;
            }else{
                this.next.insertNode(index , data);
            }
        }
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }



    }
}