public class WolfOnlineJudge {
	public double[] score(String[] solved) {
		int n = solved.length;
		int m = solved[0].length();

		double[] r = new double[n];
		boolean[][] p = new boolean[n][m];
		double[] v = new double[m];

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (solved[j].charAt(i) == 'Y') {
					p[j][i] = true;
					v[i]++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (p[i][j]) {
					if (v[j] > 0) {
						r[i] += 64 / v[j];
					}
				}
			}
		}

		return r;
	}
}