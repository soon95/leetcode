/**
 * @auther Leon Song
 * @date 2019-06-15 11:56
 */
public class NO394_DecodeStringTest {

    public static void main(String[] args) {
        //
        String s="3[a2[c]]";
        //
        System.out.println(decodeString(s));

    }

    public static String decodeString(String s){

        StringBuffer sb;

        boolean flag=true;

        while (flag){
            flag=false;
            sb=new StringBuffer();
            int index=0;
            while (index<s.length()){
                if (s.charAt(index)>='1'&&s.charAt(index)<='9'){
                    int left=index;
                    while (s.charAt(index)!='['){
                        index++;
                    }
                    int right=index;

                    int times=Integer.parseInt(s.substring(left, right));

                    int count=0;
                    left=++index;
                    right=++index;
                    while (index<s.length()){
                        if (s.charAt(index)=='[') {
                            count++;
                        } else if (s.charAt(index)==']'){
                            if (count>0){
                                count--;
                            } else {
                                right=index;
                                break;
                            }
                        }
                        index++;
                    }
                    String subStr=s.substring(left, right);
                    for (int i = 0; i < times; i++) {
                        sb.append(subStr);
                    }
                    flag=true;
                } else{
                    sb.append(s.charAt(index));
                }
                index++;
            }
            s=sb.toString();
        }
        return s;
    }


}
