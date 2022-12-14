//UC1 Ability to find frequency of words in a sentence like "To be or not to be"
//UC2 Ability to find frequency of words in a large paragraph phrase
//UC3 Remove avoidable word from the phrase
package com.hashtable.binarytree.problem;
class MyMapNode {
    String key;
    int data;
    MyMapNode next;
    MyMapNode(String key, int data)
    {
        this.key = key;
        this.data = data;
        this.next = null;
    }
}
public class HashTable {
    MyMapNode head = null;
    MyMapNode tail = null;
    public void insert(String data, int count)
    {
        MyMapNode newNode = new MyMapNode(data, count);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.next = null;
        }
        tail = newNode;
    }

    public void remove()
    {
        MyMapNode current = head;
        MyMapNode previous=null;

        while (!current.key.equalsIgnoreCase("avoidable")) {
            previous = current;
            current = current.next;
        }
        if (previous==null)
        {
            return;
        }
        previous.next = current.next;

    }
    public void display()
    {
        MyMapNode current = head;
        if (head == null) {
            return;
        }
        else
        {
            while (current != null)
            {
                System.out.println(current.key + "=" + current.data);
                current = current.next;
            }
        }
    }

    public static void hashtable(String sentence, HashTable hashTable)
    {
        String[] Sentence = sentence.toLowerCase().split(" ");

        int[] temp = new int[Sentence.length];
        int visited = -1;
        for (int i = 0; i < Sentence.length; i++) {
            int count = 1;
            for (int j = i + 1; j < Sentence.length; j++)
            {
                if (Sentence[i].equals(Sentence[j]))
                {
                    count++;
                    temp[j] = visited;
                }
            }
            if (temp[i] != visited)
                temp[i] = count;
        }
        for (int i = 0; i < temp.length; i++)
        {
            if (temp[i] != visited)
            {
                hashTable.insert(Sentence[i], temp[i]);
            }
        }
    }
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations\"";
        hashtable(sentence,hashTable);
        hashTable.display();
        hashTable.remove();
        hashTable.display();
    }
}