package algorithm.amazon;

import java.util.*;

public class Example {
    //    Input format: an array of arrays, of which each index can be 0 or 1.
//    An index corresponds to the physical location which is either occupied by a robot (1) or empty (0)
//    Ex:
//    Grid: [1,0,0,1],[0,1,1,0] is a valid time series
//    series for 2 robots because
//    the first robot moved from index 0 to index 1 and robot 2 moved from index 3 to index 2)
//    Grid: [[1,0,0,0,1],[1,0,1,0,0]] is not valid because the second robot started at index 4 but did not have a valid position on the next
    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 0, 0, 1), Arrays.asList(0, 1, 1, 0));
        list = Arrays.asList(Arrays.asList(1, 0, 0, 0, 1), Arrays.asList(1, 0, 1, 0, 0));
        System.out.println(helperWithHash(list));
    }

    /**
     * time complexity: O(n2)
     * space complexity: O(1)
     *
     * @param list input list
     * @return whether the list is a valid location for robot
     */
    public static boolean helper(List<List<Integer>> list) {
        int numRobots = 0;
        for (int i = 0; i < list.get(0).size(); i++) {
            if (list.get(0).get(i) == 1) {
                numRobots++;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            int cur = -1;
            int rowRobots = 0;
            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j) == 1) {
                    rowRobots++;
                    if (j >= 1 && list.get(i + 1).get(j - 1) == 1 && j - 1 > cur) {
                        cur = j - 1;
                    } else if (list.get(i + 1).get(j) == 1 && j > cur) {
                        cur = j;
                    } else if (j + 1 < list.get(i).size() && list.get(i + 1).get(j + 1) == 1) {
                        cur = j + 1;
                    } else {
                        return false;
                    }
                }
            }
            if (rowRobots != numRobots) {
                return false;
            }
        }
        return true;
    }

    /**
     * time complexity: O(n2)
     * space complexity: O(n)
     *
     * @param list input list
     * @return whether the list is a valid location for robot
     */
    public static boolean helperWithHash(List<List<Integer>> list) {
        if (list.isEmpty()) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        //initialize the map
        int counter = 0;
        for (int i = 0; i < list.get(0).size(); i++) {
            if (list.get(0).get(i) == 1) {
                map.put(counter++, i);
            }
        }
        //move the robot for each array
        for (int i = 1; i < list.size(); i++) {
            counter = 0;
            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j) == 1) {
                    if (!map.containsKey(counter)) {
                        return false;
                    }
                    if (Math.abs(j - map.get(counter)) > 1) {
                        return false;
                    } else {
                        map.put(counter, j);
                        counter++;
                    }
                }
            }
        }
        return true;
    }
}
