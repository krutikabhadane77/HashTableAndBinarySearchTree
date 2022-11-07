//UC3 Ability to create a BST ny adding 56 and then adding 30 & 70
package com.hashtable.binarytree.problem;

class Node<T> {

    T data;
    Node left, right;

    Node(T data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinarySearchTree<T extends Comparable<T>> {
    Node root=null;

    void inorder()
    {
        inorderUtil(this.root);
    }
    void inorderUtil(Node node)
    {
        if (node == null)
            return;

        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    }
    public void insert(T data)
    {
        this.root = this.insertNode(this.root,data);
    }
    public Node insertNode(Node node, T data)
    {
        if (node == null) {
            this.root = new Node(data);
            return this.root;
        }
        if (data.compareTo((T)node.data)<=0) {
            node.left = this.insertNode(node.left, data);
        }
        else {
            node.right = this.insertNode(node.right, data);
        }
        return node;
    }


    public static void main(String[] args)
    {
        BinarySearchTree BST = new BinarySearchTree();

        BST.insert(56);
        BST.insert(30);
        BST.insert(70);
        BST.inorder();
    }
}
