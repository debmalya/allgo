/**
 * 
 */
package daily.work;

/**
 * @author debmalyajash
 *
 */
public class LPA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 256; i++) {
			String qualification = Integer.toHexString(i);
			if (qualification.length() < 2) {
				qualification = "0" + qualification;
			}

			
			boolean acceptance = false;
			String receivedQualification = qualification;
			int modified = Integer.parseInt(qualification,16);
			if (modified >= 193 && modified <= 255) {
				acceptance = true;
				int b= modified - 193;
				qualification = Integer.toHexString(b);
				if (qualification.length() < 2) {
					qualification = "0"+qualification;
				}
			}
			System.out.println(i+" "+receivedQualification+" modified "+qualification + " acceptance ?" + acceptance);
		}

	}

}
