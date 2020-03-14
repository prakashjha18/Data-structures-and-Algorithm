public class Allindices {
    public static int[] allind(int[] arr, int data, int vidx, int csf){
        if(vidx==arr.length){
            return new int[csf];
        }
        int[] res=null;
        if(arr[vidx] ==  data){
            res = allind(arr, data, vidx+1, csf+1);
            res[csf]=vidx;
        }
        else {
            res = allind(arr, data, vidx+1,csf);
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr = {5,9,23,9,2};
        int[] res = allind(arr,9,0,0);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
