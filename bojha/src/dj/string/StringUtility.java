package dj.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtility {

	public StringUtility() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * To determine if a string has all unique characters. What if we can not
	 * use additional data structures.
	 * 
	 * @param str
	 *            to be checked for unique characters.
	 * @return true in contain unique characters false otherwise.
	 */
	public boolean containsUniqueCharacter(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Passed a null string");
		}

		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (i != j) {

					if (str.charAt(i) == str.charAt(j)) {
						return false;
					}

					if (toLowerCase(str.charAt(i)) == toLowerCase(str.charAt(j))) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Write a code to reverse a C-Style String. (C-String means that "abcd' is
	 * represented as five characters, including null characters.
	 * 
	 * @param string
	 *            to be reversed.
	 * @return reversed string.
	 */
	public String reverse0(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Passed null string");
		}

		str = str.replace("\n", "");
		char[] reversed = new char[str.length()];
		for (int i = str.length() - 1; i > -1; i--) {
			reversed[str.length() - i - 1] = str.charAt(i);
		}
		return String.valueOf(reversed);
	}

	/**
	 * Write a code to reverse a C-Style String. (C-String means that "abcd' is
	 * represented as five characters, including null characters.
	 * 
	 * @param string
	 *            to be reversed.
	 * @return reversed string.
	 */
	public String reverse(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Passed null string");
		}

		str = str.replace("\n", "");
		char[] reversed = new char[str.length()];
		int j = str.length() - 1;
		for (int i = 0; i < j; i++, j--) {
			char temp = str.charAt(j);
			reversed[j] = str.charAt(i);
			reversed[i] = temp;
		}
		return String.valueOf(reversed);
	}

	/**
	 * Design an algorithm to remove duplicate characters in a String. Without
	 * using any additional buffer. NOTE: one or two additional variables are
	 * fine.
	 * 
	 * @param str
	 *            from where duplicate characters will be removed.
	 * @return string without duplicate characters.
	 */
	public String removeDuplicate(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Passed a null string");
		}

		StringBuilder withoutDuplicate = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			boolean isDuplicate = false;
			for (int j = 0; j < str.length(); j++) {

				if (i != j) {

					if (toLowerCase(str.charAt(i)) == toLowerCase(str.charAt(j))) {
						isDuplicate = true;
						break;
					}
				}
			}
			if (!isDuplicate
					|| withoutDuplicate.indexOf(String.valueOf(str.charAt(i))) == -1) {
				withoutDuplicate.append(str.charAt(i));
			}

		}
		return withoutDuplicate.toString();
	}

	/**
	 * Convert to lower case without using library methods.
	 */
	public String toLowerCase(String str) {
		char[] values = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				values[i] = (char) (str.charAt(i) + 'a' - 'A');
			} else {
				values[i] = str.charAt(i);
			}
		}
		return String.valueOf(values);
	}

	/**
	 * To convert it into lower case.
	 * 
	 * @param c
	 *            to be converted in lower case.
	 * @return lower case character.
	 */
	public char toLowerCase(char c) {
		if (c >= 'A' && c <= 'Z') {
			return (char) (c + 'a' - 'A');
		}
		return c;
	}

	/**
	 * Write a method to decide if two strings are anagram or not.
	 * 
	 * @param str
	 *            first string.
	 * @param str2
	 *            second string.
	 * @return true if they are anagram, false otherwise.
	 */
	public boolean isAnagram(String str, String str2) {
		if (str.length() != str2.length()) {
			return false;
		}
		Set<Character> characters = new HashSet<Character>(str.length());
		for (int i = 0; i < str.length(); i++) {
			characters.add(str.charAt(i));
		}

		for (int i = 0; i < str2.length(); i++) {
			if (characters.add(str2.charAt(i)))
				return false;
		}
		return true;
	}

	/**
	 * To check whether the string is palindromic or not.
	 * 
	 * @param str
	 *            to be checked.
	 * @return true if palindrom, false otherwise.
	 */
	public boolean isPalindrom(String str) {
		int len = str.length();
		for (int i = 0; i < len / 2; i++)
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		return true;
	}

	/**
	 * Return first duplicate character of a string. If there is no duplicate
	 * character return ' '.
	 * 
	 * @p
	 */
	public char getFristDuplicateCharacter(String value) {
		if (value != null) {
			Set<Character> characters = new HashSet<Character>();

			for (int i = 0; i < value.length(); i++) {
				char eachChar = value.charAt(i);
				if (!characters.add(value.charAt(i))) {
					return eachChar;
				}
			}
		}

		return ' ';
	}

	/**
	 * Return first unique character of a string. If there is no duplicate
	 * character return ' '.
	 * 
	 * @p
	 */
	public Character getFristUniqueCharacter(String value) {
		List<Character> uniqueuCharacters = new ArrayList<Character>();
		if (value != null) {
//			value = value.toLowerCase();
			Set<Character> characters = new HashSet<Character>();
			uniqueuCharacters = new ArrayList<Character>();

			for (int i = 0; i < value.length(); i++) {
				Character eachChar = value.charAt(i);
				if (characters.add(eachChar)) {
					// character first found
					uniqueuCharacters.add(eachChar);
				} else {
					// duplicate character
					uniqueuCharacters.remove(eachChar);
				}
			}
			
		}

		if (!uniqueuCharacters.isEmpty()) {
			return uniqueuCharacters.get(0);
		} else {
			return null;
		}
	}

	/**
	 * A set of alphabet is given by abcdefghijklmnopqrstuvwxyz.
	 * 
	 * 2 sets of alphabets mean 2 or more alphabets.
	 * 
	 * 
	 * Find the missing alphabet(s). You may need to output them by the order
	 * a-z. It is possible that the missing alphabets are more than one.
	 * 
	 * 
	 * If the String contains all of the letters in the alphabet, return "-1"
	 * 
	 * 
	 * Example
	 * 
	 * 
	 * Given String(S): 'abcdefghijklmnopqrstuvwxy' Output String : 'z'
	 * 
	 * 
	 * Given String(S): 'aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyy'
	 * Output String : 'zz'
	 * 
	 * 
	 * Given String(S): 'abbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxy'
	 * Output String : 'ayzz'
	 * 
	 * @param S
	 * @return
	 */
	public String missingAlphabet(String S) {
		String s = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder r = new StringBuilder();
		int[] c = new int[26];

		int maxCount = 0;
		boolean isMissing = false;

		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (S.indexOf(currentChar) == -1) {
				c[i] = 0;
				isMissing = true;
			} else {
				Integer count = S.length()
						- S.replace(String.valueOf(currentChar), "").length();
				c[i] = count;
				maxCount = Math.max(count, maxCount);
			}
		}

		if (!isMissing) {
			return "-1";
		} else {

			for (int i = 0; i < 26; i++) {
				int count = c[i];
				while (count < maxCount) {
					r.append(s.charAt(i));
					count++;
				}
			}

			return r.toString();
		}
	}

	/**
	 * A set of alphabet is given by abcdefghijklmnopqrstuvwxyz.
	 * 
	 * 2 sets of alphabets mean 2 or more alphabets.
	 * 
	 * 
	 * Find the missing alphabet(s). You may need to output them by the order
	 * a-z. It is possible that the missing alphabets are more than one.
	 * 
	 * 
	 * If the String contains all of the letters in the alphabet, return "-1"
	 * 
	 * 
	 * Example
	 * 
	 * 
	 * Given String(S): 'abcdefghijklmnopqrstuvwxy' Output String : 'z'
	 * 
	 * 
	 * Given String(S): 'aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyy'
	 * Output String : 'zz'
	 * 
	 * 
	 * Given String(S): 'abbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxy'
	 * Output String : 'ayzz'
	 * 
	 * @param S
	 * @return
	 */
	public String missingAlphabet0(String S) {
		String s = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder r = new StringBuilder();

		LinkedHashMap<Character, Integer> characterCount = new LinkedHashMap<Character, Integer>();

		int maxCount = 0;
		boolean isMissing = false;

		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (S.indexOf(currentChar) == -1) {
				characterCount.put(currentChar, 0);
				isMissing = true;
			} else {
				Integer count = S.length()
						- S.replace(String.valueOf(currentChar), "").length();
				characterCount.put(currentChar, count);
				maxCount = Math.max(count, maxCount);
			}
		}

		if (!isMissing) {
			return "-1";
		} else {
			Set<Entry<Character, Integer>> chSet = characterCount.entrySet();
			Iterator<Entry<Character, Integer>> chI = chSet.iterator();

			while (chI.hasNext()) {
				Entry<Character, Integer> nextEntry = chI.next();
				int count = nextEntry.getValue();
				while (count < maxCount) {
					r.append(nextEntry.getKey());
					count++;
				}
			}
			return r.toString();
		}

	}

	/**
	 * @param input1
	 *            String.
	 * @return frequency of each letter in the word.
	 */
	public static float[] countFrequency(String input1) {
		int size = input1.length();
		float[] frequency = new float[size];

		for (int i = 0; i < input1.length(); i++) {
			int count = 1;
			for (int j = i + 1; j < size; j++) {
				if (input1.charAt(j) == input1.charAt(i)) {
					count++;
				}
			}
			frequency[i] = (float) count / size;
		}
		return frequency;
	}

	/**
	 * Given a string, check if its characters can be rearranged to form a
	 * palindrome. Where a palindrome is a string that reads the same
	 * left-to-right and right-to-left.
	 * 
	 * 
	 * Example
	 * 
	 * 
	 * "trueistrue" -> false; "abcab" -> true because "abcba" is a palindrome
	 * 
	 * Input 1 (s) → string : Output → boolean :
	 */
	boolean isPalindrome(String s) {
		int l = s.length();
		int p, c = 0;
		while (s.length() > 0) {
			p = s.length();
			s = s.replace(String.valueOf(s.charAt(0)), "");
			if (p - s.length() % 2 == 1) {
				c++;
				if (c > 1) {
					return false;
				}
			}
		}

		if (l % 2 == 0 && c == 1) {
			return false;
		}
		return true;
	}

	/**
	 * Input string will be like DEB:<string>:<messageId> DEB:<int>:<messageId>
	 * 
	 */
	public boolean isInt(String input) {

		Matcher matcherForInt = Pattern.compile("DEB:[0-9]+:(.+)").matcher(
				input);
		Matcher matcherForAny = Pattern.compile("DEB:[0-9][a-z][A-Z]+:(.+)")
				.matcher(input);
		boolean isInt = matcherForInt.find();
		boolean isAll = matcherForAny.find();

		// System.out.println(matcherForInt.group());

		return isInt && !isAll;
	}

}
