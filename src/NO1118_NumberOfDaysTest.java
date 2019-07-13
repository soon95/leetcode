/**
 * @author Leon Song
 * @date 2019-07-13
 */
public class NO1118_NumberOfDaysTest {
    public static void main(String[] args) {
        //
        int year = 2000;
        int month = 2;
        //
        System.out.println(numberOfDays(year, month));
    }

    public static int numberOfDays(int year, int month) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        return 29;
                    } else {
                        return 28;
                    }
                } else {
                    if (year % 4 == 0) {
                        return 29;
                    } else {
                        return 28;
                    }
                }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
        }
        return 0;
    }
}
