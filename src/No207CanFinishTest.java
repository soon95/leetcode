import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. 课程表
 * https://leetcode.cn/problems/course-schedule/description/?envType=featured-list&envId=2cktkvj
 */
public class No207CanFinishTest {

    public boolean canFinish(int numCourses, int[][] prerequisites) {


        boolean[][] matrix=new boolean[numCourses][numCourses];

        for (int i = 0; i < prerequisites.length; i++) {

            matrix[prerequisites[i][1]][prerequisites[i][0]]=true;
        }


        Map<Integer,Integer> preNeed=new HashMap<>();

        for (int courseNum = 0; courseNum < numCourses; courseNum++) {

            int temp=0;
            for (int i = 0; i < numCourses; i++) {

                if (matrix[i][courseNum]){
                    temp++;
                }
            }
            preNeed.put(courseNum,temp);
        }

        while (!preNeed.isEmpty()){

            List<Integer> canProcessCourses=new ArrayList<>();

            preNeed.forEach((key,value)->{
                if (value==0){
                    canProcessCourses.add(key);
                }
            });


            if (canProcessCourses.size()==0){
                return false;
            }

            canProcessCourses.forEach(course->{

                preNeed.remove(course);

                for (int i = 0; i < numCourses; i++) {

                    if (matrix[course][i]) {

                        Integer need = preNeed.get(i);
                        need-=1;

                        preNeed.put(i,need);
                    }
                }

            });

        }

        return true;
    }


    public static void main(String[] args) {

//        int numCourses = 2;
//        int[][] prerequisites = new int[][]{{1,0}};
//        int[][] prerequisites = new int[][]{{1,0},{0,1}};

        int numCourses = 5;
        int[][] prerequisites = new int[][]{{1,4},{2,4},{3,1},{3,2}};



        No207CanFinishTest test = new No207CanFinishTest();
        System.out.println(test.canFinish(numCourses, prerequisites));


    }

}
