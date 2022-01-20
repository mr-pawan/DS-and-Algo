import java.util.*;

public class CoinChangeProblem{
    public static int coinChangePermutationInfinite(int[]arr, int idx, int tar, String ans){
        //base case
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }

        //recurssive case
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar-arr[i] >= 0){
                count += coinChangePermutationInfinite(arr, 0, tar-arr[i], ans + " " + arr[i]);
            }
        }

        return count;
    }

    public static int coinChangePermutationOneAtTime(int[]arr, int idx, int tar, String ans,boolean[] coins){
        //base case
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }

        //recurssive case
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar-arr[i] >= 0 && !coins[arr[i]]){
                coins[arr[i]] = true;
                count += coinChangePermutationOneAtTime(arr,0, tar-arr[i], ans + " " + arr[i], coins);
            }
        }
        return count;
    }

    public static int coinChangeCombinationInfinite(int[]arr, int idx, int tar, String ans){
        //base case 
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }
        //recurssive case
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar-arr[i] >= 0){
                count += coinChangeCombinationInfinite(arr, i, tar-arr[i], ans + " " + arr[i]);
            }
        }
        return count;
    }

    public static int coinChangeCombinationOneAtTime(int[]arr, int idx, int tar, String ans){
        //base case 
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }
        //recurssive case;
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar-arr[i] >= 0){
                count += coinChangeCombinationOneAtTime(arr, i+1, tar-arr[i], ans + " " + arr[i]);
            }
        }
        return count;
    }
    public static int getMax(int[]arr){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public static void main(String[] args){
        int[]arr = {2, 3, 5, 7};
        int tar = 10;

        boolean[] coins = new boolean[getMax(arr)+1];
        // System.out.println("count = " + coinChangePermutationInfinite(arr, 0, tar, ""));
        // System.out.println("count = " + coinChangePermutationOneAtTime(arr, 0, tar, "", coins));
        // System.out.println("count = " + coinChangeCombinationInfinite(arr, 0, tar, ""));
        System.out.println("count = " + coinChangeCombinationOneAtTime(arr, 0, tar, ""));
        
    }
}