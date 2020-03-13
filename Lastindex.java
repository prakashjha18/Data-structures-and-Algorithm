import java.util.*;
public class Lastindex {
    public static int find(int[] arr, int data, int vidx){

        if(vidx == arr.length){
            return -1;
        }
        int liisa = find(arr,data,vidx+1);
        if(liisa != -1){
            return liisa;
        }
        else{
            if(arr[vidx]==data) {
                return vidx;
            }
            else{
                return -1;
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {5,9,23,9,2};
        System.out.println(find(arr,9,0));
    }
}
