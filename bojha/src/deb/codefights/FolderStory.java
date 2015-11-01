/**
 * 
 */
package deb.codefights;

/**
 * @author debmalyajash
 *
 */
public class FolderStory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Math.round(0.4));

	}

	/**
	 * To create a new folder in the existing folder, you right-click a blank
	 * area and select the "New Folder" option.
	 * 
	 * The name of the folder you're creating is auto-generated like this:
	 * 
	 * if there is no file or folder with the name "New folder" in the current
	 * directory, the new folder's name is "New folder"; if there is a
	 * "New folder" file but no "New folder (1)" in the current directory, the
	 * new folder's name is "New folder (1)"; if there is also a
	 * "New folder (1)" file but no "New folder (2)" in the current directory,
	 * the new folder's name is "New folder (2)" and so on. Given the names of
	 * the files in the current directory, find the auto-generated name of a
	 * newly created folder.
	 * 
	 * Example:
	 * 
	 * New_Folder([]) = "New Folder" New_Folder(["New Folder"]) =
	 * "New Folder (1)" New_Folder(["New Folder", "New Folder (1)"]) =
	 * "New Folder (2)"
	 * 
	 * @param files
	 * @return
	 */
	String New_Folder(String[] files) {
		int c = 0;
		String n = "";
		for (String e : files) {
			n = "New Folder" + (c > 0 ? " (" + c + ")" : "");
			if (e.equals(n))
				c++;
			else
				return n;
		}
		return "New Folder" + (c > 0 ? " (" + c + ")" : "");
	}

	double perfectCity(double[] departure, double[] destination) {
	    return 0.00d;
	}	
}
