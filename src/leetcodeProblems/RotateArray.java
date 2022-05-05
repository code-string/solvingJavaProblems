package leetcodeProblems;

public class RotateArray {
    public static void rotate(int[] array, int steps){
//        Big O(time) O(n), Big O(space) O(n)
        if(steps > array.length)
            steps = steps % array.length;
        int[] result = new int[array.length];
        for(int i = 0; i < steps; i++){
            result[steps-i-1] = array[array.length-1-i];
        }
        int j=0;
        for(int i=steps; i< array.length; i++){
            result[i] = array[j];
            j++;
        }
        System.arraycopy(result, 0, array, 0, array.length);

    }

//    public static void bubbleRotate(int[] array, int step){
//
//    }
}
