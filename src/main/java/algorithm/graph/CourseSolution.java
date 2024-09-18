package algorithm.graph;
import java.util.*;

/**
 * 207. 课程表
 */
public class CourseSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int finishedNum = 0;
        Map<Integer,Integer> reliables= new HashMap<>();
        Map<Integer,List<Integer>> solves = new HashMap<>();
        //initialize the course reliables and solves map
        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            reliables.put(course,reliables.getOrDefault(course,0)+1);
            if(!solves.containsKey(preCourse)){
                solves.put(preCourse,new ArrayList<>());
            }
            solves.get(preCourse).add(course);
        }
        //initialize the finished Courses
        LinkedList<Integer> finishedCourses = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(!reliables.containsKey(i)){
                finishedCourses.add(i);
                finishedNum++;
            }
        }
        //bfs
        while(!finishedCourses.isEmpty()){
            int cur = finishedCourses.removeFirst();
            if(solves.containsKey(cur)){
                List<Integer> solve = solves.get(cur);
                for(Integer n:solve){
                    reliables.put(n,reliables.get(n)-1);
                    if(reliables.get(n)==0){
                        finishedCourses.add(n);
                        finishedNum++;
                    }
                }
            }
        }
        //output the result
        if(finishedNum==numCourses){
            return true;
        }
        return false;
    }
}
