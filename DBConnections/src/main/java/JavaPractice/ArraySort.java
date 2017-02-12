package JavaPractice;

import java.util.Arrays;

/**
 * Created by Alex on 13.02.2017.
 */
public class ArraySort {
    public static void main(String[] args) {
        int [] arr = {5, 4, 7, 1, 9, 1, 2, 8, 8, 3, 6, 0, 0, 120, 1, 155, 578, 4, 44, 57, 89, 56, 41, 21, 22, 32, 33, 34,35};
        ArraySort arraySort = new ArraySort();
        arraySort.sort(arr);

        System.out.println(Arrays.toString(arr));
        }


    public int [] sort(int [] arr){
        for(int y = 0; y < arr.length - 1; y++){
            for(int i = 0; i < arr.length - 1; i++){
                if(arr[i] > arr[i + 1]){
                    int a = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] = a;
                }
            }
        }
               return arr;
    }
}
