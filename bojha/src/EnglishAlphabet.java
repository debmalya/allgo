/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class EnglishAlphabet {
	/**
	 * Given a square matrix of alphabets which contain English letters in arbitrary manner. While searching a word in it, you can go left to right 
	 * horizontally, vertically downwards or diagonally towards left (both upwards and downwards).
	 * 
	 * You have to find the number of matches of a given word in the matrix.
	 * 
	 * @param input1 - size of the square matrix. 1<=N<=50
	 * @param input2  - An array of String {N String containing N upper case alphabets separated by #}
	 * @param input3 - Word to be searched.
	 * @return - Number of occurrences of the word in the matrix (an integer).
	 */
	public static int word_count(int input1, String[] input2, String input3) {
		int r = 0;
		StringBuilder diagonal1 = new StringBuilder("");
		StringBuilder diagonal2 = new StringBuilder("");
		StringBuilder[] input = new StringBuilder[input2.length];
		StringBuilder[] column = new StringBuilder[input2.length];
		
		
		
		for (int i = 0; i < input2.length; i++) {
			input[i]=new StringBuilder();
			input2[i]=input2[i].replace("#", "");
			input[i].append(input2[i]);

			r += getOccurenceCount(input2[i],input3);
			 
			
			r += getOccurenceCount(input[i].reverse().toString(),input3);
			diagonal1.append(input2[i].charAt(i));
			diagonal2.append(input2[i].charAt(input1 - i - 1));
			
			for (int j = 0; j < input1; j++) {
				if (column[j] == null) {
					column[j] = new StringBuilder();					
				}
				column[j].append(input2[i].charAt(j));
			}
		}
		System.out.println(diagonal1.toString()+" "+diagonal1.reverse().toString());
		System.out.println(diagonal1.toString()+" "+diagonal1.reverse().toString());
		r += getOccurenceCount(diagonal1.toString(),input3);		
		r += getOccurenceCount(diagonal1.reverse().toString(),input3);
		r += getOccurenceCount(diagonal2.toString(),input3);		
		r += getOccurenceCount(diagonal2.reverse().toString(),input3);		
		
		for (int i = 0; i < input1; i++) {
			
			
			r += getOccurenceCount(column[i].toString(),input3);
			r += getOccurenceCount(column[i].reverse().toString(),input3);
			
		}
		return r;
	}

	/**
	 * @param string
	 * @param input3
	 * @return
	 */
	private static int getOccurenceCount(String string, String input3) {	
		return (string.length() - string.replace(input3, "").length())/input3.length();
		
	}
}
