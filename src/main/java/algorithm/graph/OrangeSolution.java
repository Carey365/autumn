package algorithm.graph;

import java.util.*;

/**
 * 994. 腐烂的橘子
 */
public class OrangeSolution {
    int goodNum = 0;
    public int orangesRotting(int[][] grid) {
        int counter = 0;
        LinkedList<int[]> list = new LinkedList<>();
        // initialize
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    goodNum++;
                }
            }
        }
        if (goodNum == 0) {
            return 0;
        }
        // rotting
        while (!list.isEmpty()) {
            int size = list.size();
            while (size > 0) {
                int[] cur = list.removeFirst();
                int i = cur[0];
                int j = cur[1];
                rot(list, i + 1, j, grid);
                rot(list, i - 1, j, grid);
                rot(list, i, j + 1, grid);
                rot(list, i, j - 1, grid);
                size--;
            }
            counter++;
            if (goodNum == 0) {
                break;
            }
        }
        if (goodNum > 0) {
            return -1;
        }
        return counter;
    }

    public void rot(LinkedList<int[]> list, int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        list.add(new int[] { i, j });
        goodNum--;
    }
}
