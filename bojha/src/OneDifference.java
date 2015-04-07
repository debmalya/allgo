/*
 * implement a function fn(left, right), when given two strings, return true if and only if the two strings are one edit apart. 
 * An edit can be a modification, addition or removal of a single character.
 */
public class OneDifference {
	public boolean fn1(String left, String right) {

		if (Math.abs(left.length() - right.length()) > 1) {
			return false;
		}

		if (left.length() > right.length()) {
			return left.replace(right, "").trim().length() == 1;
		} else {
			return right.replace(left, "").trim().length() == 1;
		}
		
	}

	public boolean fn(String left, String right) {

		if (Math.abs(left.length() - right.length()) > 1) {
			return false;
		}

		left = left.trim();
		right = right.trim();

		int diff = 0;
		for (int i = 0; i < left.length() && i < right.length(); i++) {
			if (left.charAt(i) != right.charAt(i)) {
				diff++;
			}
			if (diff > 1) {
				return false;
			}
		}
		return true;
	}

}
