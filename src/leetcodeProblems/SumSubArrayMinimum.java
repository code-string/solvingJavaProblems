package leetcodeProblems;

import java.util.Arrays;
import java.util.Stack;

public class SumSubArrayMinimum {
    /**
     * 3,1,2,4
     * --3,1
     * Problem: Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
     * */
    public static int sumSubArrayMins(int[] array){
        int MOD = 1000000007;
        int sumMin = 0;
        for(int i=0; i< array.length; i++){
            for(int start=0, end = i; start < array.length && end < array.length; start++, end++){
                int[] result = subArray(array, start, end);
                int min = findMin(result);
                sumMin += min;
            }
        }

        return sumMin % MOD;
    }

    public static int findMin(int[] array){
        if(array == null || array.length == 0)
            return 0;

        Arrays.sort(array);
        return array[0];
    }
    public static int[] subArray(int[] array, int start, int end){

        int[] subArray = new int[end-start + 1];
        for(int i= 0; i < subArray.length; i++){
            subArray[i] = array[start+i];
        }
        return subArray;
    }


}
