import java.util.*;
public class Keypadcombn {
    static String[] codes={".","abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};
    public static ArrayList<String> getKPC(String str){
        if(str.length()==0){
            ArrayList<String> br = new ArrayList<String>();
            br.add("");
            return br;
        }
        char ch=str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rr= getKPC(ros);
        ArrayList<String> mr=new ArrayList<String>();
        for(String rstr:rr){
            String code =  codes[ch-'0'];
            for(int i=0;i<code.length();i++){
                char chcode = code.charAt(i);
                System.out.print(chcode+rstr+"  ");
                mr.add(chcode+rstr);
            }
        }
        return mr;
    }
    public static void main(String[] args){
        System.out.println(getKPC("17"));
    }
}
