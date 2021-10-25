/**
 * Class representing each entry of a dictionary, with key/value pairs.
 * Optimized for English words/definitions.
 * @author Will Brown
 * @version 1.0
 * Fall 2021
 */
public class Entry implements Comparable<Entry> {
	
	private String key;
	private String value;

	/**
	 * Creates an entry with the corresponding key and value.
	 * @param key the object search key of the new entry
	 * @param value the value associated with the search key
	 */
	public Entry(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int compareTo(Entry o) {
		/* Case is ignored on initial evaluation so that uppercase letters
		 * can be sorted alongside lowercase letters. */
		
		// If keys are equal, check case
		if (key.equalsIgnoreCase(o.getKey()))
			return key.compareTo(o.getKey());
		// If one of the keys has a leading apostrophe, remove it for comparison
		else if (key.charAt(0) == '\'' && o.getKey().charAt(0) != '\'')
			return key.substring(1).compareToIgnoreCase(o.getKey());
		else if (o.getKey().charAt(0) == '\'' && key.charAt(0) != '\'')
			return key.compareToIgnoreCase(o.getKey().substring(1));
		else
			return key.compareToIgnoreCase(o.getKey());
	}

}
