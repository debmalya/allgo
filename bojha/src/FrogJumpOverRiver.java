
public class FrogJumpOverRiver {
	public int solution(int X, int[] A) {
        // write your code in Java SE 8
        char[] v = new char[X];
        
        int n = A.length;
        for (int i = 0; i < n; i++) {
            v[A[i]] = '1';
            if (String.valueOf(v).length() == X){
                return i;
            }
        }
        return -1;
	}
}
