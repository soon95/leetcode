/**
 * @author Leon Song
 * @date 2019-07-13
 */
public class NO1119_RemoveVowelsTest {
    public static void main(String[] args) {
        //
        String str = "aeiou";
        //
        System.out.println(removeVowels(str));
    }

    public static String removeVowels(String str) {
        String regex = "[aeiou]";
        return str.replaceAll(regex, "");
    }
}
