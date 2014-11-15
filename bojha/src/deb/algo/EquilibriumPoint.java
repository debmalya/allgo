package deb.algo;
// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class EquilibriumPoint {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        int sum = 0;
        
        for (int i = 0; i < len;i++){
            sum += A[i];
        }
        
        int sum_left = A[0];
        int sum_right = 0;
        for (int i = 1; i < len; i++){
            sum_right = sum - sum_left - A[i];
            
            if (sum_right == sum_left){
                return i;
            }
            sum_left += A[i];
            
        }
        return -1;
    }
}
