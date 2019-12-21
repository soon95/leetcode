import java.util.Stack;

/**
 * @author: Leon Song
 * @date: 2019/12/21
 */
public class NO71_SimplifyPathTest {
    public static void main(String[] args) {
        //
        String path = "/../";
        //
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> router = new Stack<>();
        router.push("root");

        String[] paths = path.split("/");
        for (String str : paths) {
            if (str.length() != 0) {
                if (".".equals(str)) {
                    continue;
                } else if ("..".equals(str)) {
                    if (router.size() > 1) {
                        router.pop();
                    } else {
                        continue;
                    }
                } else {
                    router.push(str);
                }
            }
        }
        if (router.size() == 1) {
            return "/";
        }

        StringBuffer sb = new StringBuffer();
        while (router.size() > 1) {
            sb.insert(0, router.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}
