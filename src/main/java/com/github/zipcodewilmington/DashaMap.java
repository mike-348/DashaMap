package com.github.zipcodewilmington;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap implements HashMapX {
    //an array which are the slots
    //each array slot contains a linked list


    //When you create the constructor for each class, you need to create an array of Node objects. Each Node should look
    //Node:
    //k: String
    //v: Integer
    //next: Node
    class Node {
        String k;
        Integer v;
        Node next;

        public Node(String k, Integer v) {
            this.k = k;
            this.v = v;
        }
    }

    private Node[] map;
    private Integer count;
    public DashaMap() {
        map = new Node[26];
        count = 0;
    }

    private String HashFunctionOne(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        return null;
    }

    @Override
    public void set(String key, Integer value) {
        String first = HashFunctionOne(key);
        char character = first.charAt(0);
        int position = character - 'a';
        Node result = find(map[position], key);
        if (result == null) {
            //Insert the new node inside
            Node newNode = new Node(key, value);
            if (map[position] == null){
                map[position] = newNode;
            } else{
                Node current = map[position];
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            count++;
        } else{
            result.v = value;
        }
    }

    @Override
    public void delete(String key) {
        String first = HashFunctionOne(key);
        char character = first.charAt(0);
        int position = character - 'a';
        Node head = map[position];
        //what if the linked list we hash to is already empty?
        if (head == null) {
            return;
        }
        boolean deleted = false;
        if (head.k == key) {
            map[position] = head.next;
            head.next = null;
            deleted = true;
        }
        //general node that is not head
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.k == key) {
                //do the delete process
                prev.next = curr.next;
                curr.next = null;
                deleted = true;
                break;
            }
        }
        if (deleted) {
            count--;
        }
    }

    @Override
    public Integer get(String key) {
        String first = HashFunctionOne(key);
        char character = first.charAt(0);
        int position = character - 'a';
        Node result = find(map[position], key);
        if (result == null) {
            return null;
        }
        return result.v;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Integer size() {
        return count;
    }

    @Override
    public Integer bucketSize(String key) {
        String first = HashFunctionOne(key);
        char character = first.charAt(0);
        int position = character - 'a';
        Node head = map[position];
        if (head == null) {
            return 0;
        }
        int bSize = 0;
        Node current = head;
        while (current != null) {
            bSize++;
            current = current.next;
        }
        return bSize;
    }


    public Node find(Node head, String key) {
        Node current = head;
        while (current != null) {
            if (current.k.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

}
