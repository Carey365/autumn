package algorithm.list;

import java.util.*;

public class LRU {
    ListNode dummyHead;
    ListNode dummyTail;
    Map<Integer, ListNode> map;
    int size;
    int capacity;

    private class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;

        ListNode() {
        }

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummyHead = new ListNode();
        this.dummyTail = new ListNode();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        moveToHead(key);
        return map.get(key).value;
    }

    public void add(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(key);
        } else if (size >= capacity) {
            removeTail();
        }
        addToHead(key, value);
    }


    private void removeTail() {
        ListNode tail = dummyTail.pre;
        ListNode newTail = tail.pre;
        newTail.next = dummyTail;
        dummyTail.pre = newTail;
        map.remove(tail.key);
        size--;
    }

    private void removeNode(int key) {
        ListNode node = map.get(key);
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.next = next;
        next.pre = pre;
        map.remove(key);
        size--;
    }

    private void addToHead(int key, int value) {
        ListNode head = dummyHead.next;
        ListNode newHead = new ListNode(key, value);
        map.put(key, newHead);
        dummyHead.next = newHead;
        newHead.pre = dummyHead;
        newHead.next = head;
        head.pre = newHead;
        size++;
    }

    private void moveToHead(int key) {
        ListNode node = map.get(key);
        removeNode(key);
        addToHead(key, node.value);
    }


}
