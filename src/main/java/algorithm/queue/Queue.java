package algorithm.queue;

import java.util.LinkedList;

/**
 * 队列
 */
public class Queue {
    LinkedList<Integer> list = new LinkedList<>();

    public void add(int num) {
        list.add(num);
    }

    public int pop(int num) {
        return list.removeFirst();
    }

    public int peek() {
        return list.getFirst();
    }
}
