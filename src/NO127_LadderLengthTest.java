import java.util.*;

/**
 * @auther Leon Song
 * @date 2019-06-22 18:44
 */
public class NO127_LadderLengthTest {
    public static void main(String[] args) {
        //
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        //
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    /**
     * 深度遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int dis = 0;
        if (beginWord.equals(endWord)) {
            return 1;
        } else if (!wordList.contains(endWord)) {
            return dis;
        }
        boolean[] isVisited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.add(endWord);
        isVisited[wordList.indexOf(endWord)] = true;

        while (!queue.isEmpty()) {

            dis++;
            int size = queue.size();

            while (size-- > 0) {// 逐层遍历

                String cur = queue.poll();
                if (isNext(beginWord, cur)) {
                    return ++dis;
                }

                for (int i = 0; i < wordList.size(); i++) {
                    String str = wordList.get(i);
                    if (isNext(cur, str) && !isVisited[i]) {
                        isVisited[i] = true;
                        queue.add(str);
                    }
                }
            }
        }

        return 0;
    }


    /**
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength_bfs(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0)
            return 0;
        //hashset的好处：去重也完成了
        //开始端
        HashSet<String> start = new HashSet<>();
        //结束端
        HashSet<String> end = new HashSet<>();
        //所有字符串的字典
        HashSet<String> dic = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        if (!dic.contains(endWord))
            return 0;
        //经历过上面的一系列判定，到这里的时候，若是有路径，则最小是2，所以以2开始
        return bfs(start, end, dic, 2);
    }

    private static int bfs(HashSet<String> begin, HashSet<String> end, HashSet<String> dic, int l) {
        //双端查找的时候，若是有任意一段出现了“断裂”，也就是说明不存在能够连上的路径，则直接返回0
        if (begin.size() == 0)
            return 0;
        if (begin.size() > end.size())//双端查找，为了优化时间，永远用少的去找多的，比如开始的时候塞进了1000个，而结尾只有3个，则肯定是从少的那一端开始走比较好
        {
            return bfs(end, begin, dic, l);
        }
        //BFS的标记行为，即使用过的不重复使用
        dic.removeAll(begin);
        //收集下一层临近点
        HashSet<String> next = new HashSet<>();
        for (String s : begin) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                //变化
                for (char c = 'a'; c <= 'z'; c++) {
                    if (tmp == c)
                        continue;
                    arr[i] = c;
                    String nstr = new String(arr);
                    //只改变一个字母，如果字典里有，则可以转换
                    if (dic.contains(nstr)) {
                        //如果恰好end里也有，则一次转换成功
                        if (end.contains(nstr))
                            return l;
                        else
                            next.add(nstr);
                    }
                }//第一个字母全换了一遍还是没有，换下一个字母
                //复原
                arr[i] = tmp;
            }
        }
        return bfs(next, end, dic, l + 1);
    }


    private static boolean isNext(String a, String b) {
        int len = a.length();
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr1[i] != arr2[i]) {
                count++;
            }
        }

        return count == 1;
    }
}
