import java.util.*;
public class Firstindex {
    public static int find(int[] arr, int data, int vidx){
        if(vidx == arr.length){
            return -1;
        }

        if(arr[vidx]==data) {
            return vidx;
        }
        else{
            int fisa = find(arr,data,vidx+1);
            return fisa;
        }
    }
    public static void main(String[] args){
        int[] arr = {5,9,23,9,2};
        System.out.println(find(arr,9,0));
    }
}
