import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Leon Song
 */
public class NO78_SubsetsTest {

    public static void main(String[] args) {
        //
        int[] nums={1,2,3};
        //
        List<List<Integer>> ans=subsets(nums);

        for (List<Integer> list:ans) {
            System.out.println(list.toString());
        }
    }

    /**
     * 迭代版
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums){
        int len=nums.length;

        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        ans.add(cur);


        for (int num:nums){
            int size=ans.size();
            for (int i = 0; i < size; i++) {
                cur=new ArrayList<>(ans.get(i));
                cur.add(num);
                ans.add(cur);
            }

        }

        return ans;
    }

    /**
     * 递归版
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets_dfs(int[] nums){
        int len=nums.length;
        boolean[] visited=new boolean[len];

        List<List<Integer>> ans=new ArrayList<>();
        Set<Integer> cur=new HashSet<>();
        Set<Set<Integer>> res=new HashSet<>();
        res.add(cur);

        int size=0;

        dfs(res, visited, cur, nums, size);

        for (Set<Integer> set:res){
            ans.add(new ArrayList<>(set));
        }

        return ans;
    }

    private static void dfs(Set<Set<Integer>> ans,boolean[] visited,Set<Integer> cur,int[] nums,int size){
        if (size==nums.length){
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!visited[i]){
                Set<Integer> temp=new HashSet<>(cur);
                temp.add(nums[i]);
                ans.add(temp);
                visited[i]=true;
                dfs(ans, visited, temp, nums, size+1);
                visited[i]=false;
            }

        }



    }
}
