/**
 * 
 */
package lambda.sample;

import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class Lesson1Mine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Create a string that consists of the first letter of each word in the
	 * list of Strings provided.
	 * 
	 * @param args string array.
	 * @return string containing the first letters of each string.
	 */
	public String getFirstLetters(List<String> args) {
		StringBuilder myString = new StringBuilder();
		args.forEach(s -> myString.append(s.charAt(0)));
		return myString.toString();
	}
	
	/**
	 * Remove the words that have odd length s from the list.
	 * @param args list of string.
	 * @return list of string without odd length word.
	 */
	public List<String> removeDuplicate(List<String> args) {
		 args.removeIf(s -> s.length()%2==1);
		 return args;
	}
	
	/**
	 * Replace every word in the list with its upper case equivalent.
	 * @param args  list of String.
	 * @return list of String with all letters replaced with upper case.
	 */
	public List<String> replaceAllWithUpper(List<String> args){
		args.replaceAll(String::toUpperCase);
		return args;
	}
}
