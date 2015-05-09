/**
 * 
 */
package dj.nea;

/**
 * @author debmalyajash
 * This will contain the header information for NEA data.
 * Data elements are title,source,description,category,issueDatentime
 */
public class NEAHeader {
	private String title;
	private String source;
	private String description;
	private String category;
	private String issueDatentime;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the issueDatentime
	 */
	public String getIssueDatentime() {
		return issueDatentime;
	}
	/**
	 * @param issueDatentime the issueDatentime to set
	 */
	public void setIssueDatentime(String issueDatentime) {
		this.issueDatentime = issueDatentime;
	}
	
}
