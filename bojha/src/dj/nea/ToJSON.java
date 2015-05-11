/**
 * 
 */
package dj.nea;

/**
 * @author debmalyajash
 * This will convert
 * 1. Object to JSON String.
 * 2. XML to JSON String.
 */
public interface ToJSON {
	/**
	 * Convert object to JSON string
	 * @param toBeConverted Object to be converted to JSON.
	 * @return JSON String
	 */
	String toJSON(Object toBeConverted);
	
	/**
	 * Convert XML String to JSON
	 * @param xmlString to be converted to JSON.
	 * @return JSON String.
	 */
	String toJSON(String xmlString);
}
