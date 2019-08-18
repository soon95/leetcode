package tenxun_8_17;

/**
 * @author Leon Song
 * @date 2019-08-17
 */
public class Test5 {
    public static int relax;

    public static void main(String[] args) {
        //
        int days = 4;
        int[] works = {1, 1, 0, 0};
        int[] practice = {0, 0, 1, 1};
        System.out.println(minRelax(days, works, practice));
        //
//        Scanner input=new Scanner(System.in);
//        int days=input.nextInt();
//        int[] works=new int[days];
//        int[] practice=new int[days];
//        for (int i = 0; i < days; i++) {
//            works[i]=input.nextInt();
//        }
//        for (int i = 0; i < days; i++) {
//            practice[i]=input.nextInt();
//        }
//        System.out.println(minRelax(days, works, practice));
    }

    public static int minRelax(int days, int[] works, int[] practice) {
        int[] plan = new int[days];
        relax = 0;
        int today = 0;

        if (works[today] == 1) {
            plan[today] = 1;
            dfs(plan, works, practice, today + 1, days);
        }
        if (practice[today] == 1) {
            plan[today] = -1;
            dfs(plan, works, practice, today + 1, days);
        }

        if (works[today] != 1 && practice[today] != 1) {
            plan[today] = 0;
            dfs(plan, works, practice, today + 1, days);
        }

        return relax;
    }

    public static void dfs(int[] plan, int[] works, int[] practice, int today, int days) {
        if (today == days) {
            int count = 0;
            for (int x : plan) {
                if (x == 0) {
                    count++;
                }
            }
            relax = Math.max(relax, count);
            return;
        }

        if (works[today] == 1 && plan[today - 1] != 1) {
            plan[today] = 1;
            dfs(plan, works, practice, today + 1, days);
        }

        if (practice[today] == 1 && plan[today - 1] != -1) {
            plan[today] = -1;
            dfs(plan, works, practice, today + 1, days);
        }

        if (!(works[today] == 1 && plan[today - 1] != 1) && !(practice[today] == 1 && plan[today - 1] != -1)) {
            plan[today] = 0;
            dfs(plan, works, practice, today + 1, days);
        }
    }
}
