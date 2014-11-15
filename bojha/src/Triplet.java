

public class Triplet {
	public int solution(int[] A) {
		int depth = getPits(A);
		System.out.println(depth);
		
		return depth;
	}
	
	private int getPits(int[] a) {
		int depth = -1;
		for (int i = 0; i < a.length - 2; i++) {
			for (int j = i +1; j < a.length -1 && j > i;j++) {
				for (int k = i + 2; k <a.length && k > j; k++) {
					if (a[i] > a[j] && a[j] < a[k]) {
						int c = Math.min(a[i] - a[j], a[k] - a[j]);
						if (c > depth) {
							depth = c;
							System.out.println("i = " + i + " " + a[i]+ ", j = "+ j+ " " + a[j] + " , k =" + k + " " + a[k] + " " + depth);
						}
					}
				}
			}
		}
		
		return depth;
	}

	public static void main(String...strings) {
		Triplet solution = new Triplet();
		solution.solution(new int[]{0, 1, 3, -2, 0, 1, 0, -3, 2, 3});
	}
}
