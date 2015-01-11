package CountingElement;

public class FrogJump {
	public int solution(int X,int Y,int D) {
		int d = Y - X;
		int r = d / D;
		int z = d % D;
		
		if (z > 0) {
			r++;
		}
		
		
		
		return r;
	}
}
