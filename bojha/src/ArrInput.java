import java.io.CharArrayReader;
import java.io.IOException;


public class ArrInput {
	public static void main(String[] args) {
		String object = "abcdefgh";
		int objectLength = object.length();
		char[] c = new char[objectLength];
		object.getChars(0, objectLength, c, 0);
		CharArrayReader input1 = new CharArrayReader(c);
		CharArrayReader input2 = new CharArrayReader(c, 0, 14);
		int i;
		int j;
		try {
			while ((i=input1.read()) == (j=input2.read())) {
				System.out.println((char)i);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
