import java.util.*;
public class Subseqstr {
    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> br = new ArrayList<String>();
            br.add("");
            return br;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rr = gss(ros);
        ArrayList<String> mr = new ArrayList<String>();
        for(String rstr : rr) {
            mr.add(rstr);
            mr.add(ch+rstr);
        }
        return mr;
    }
    public static void main(String[] args){
        System.out.println(gss("abc"));
    }
}
