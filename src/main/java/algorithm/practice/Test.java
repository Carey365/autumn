package algorithm.practice;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(30, 20, 25);
        int res = findMinWeight(weights, 4);
        System.out.println(res);
    }

    public static int findMinWeight(List<Integer> weights, int d) {
        // Write your code here
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < weights.size(); i++) {
            queue.offer(weights.get(i));
        }
        for (int i = 0; i < d; i++) {
            int num = queue.poll();
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num / 2 + 1;
            }
            queue.offer(num);
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ans += queue.poll();
        }
        return ans;
    }
}
